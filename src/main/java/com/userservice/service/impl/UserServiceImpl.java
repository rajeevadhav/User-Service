/**
 * 
 */
package com.userservice.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.constants.UrlConstants;
import com.userservice.dto.RestaurantDTO;
import com.userservice.dto.RestaurantListDTO;
import com.userservice.dto.UserDTO;
import com.userservice.entity.User;
import com.userservice.repository.UserRepository;
import com.userservice.service.UserService;

/**
 * @author Rajiv Adhav
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public ResponseEntity<Map<String, Object>> getAllUsers() {
		Map<String, Object> map = new HashMap<>();
		List<UserDTO> userDtos = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);

			ResponseEntity<List<RestaurantDTO>> response = restTemplate.exchange(
					UrlConstants.RESTAURANT_SERVICE_URL + userDTO.getId(), HttpMethod.GET, null,
					new ParameterizedTypeReference<List<RestaurantDTO>>() {
					});
			
			userDTO.setRestaurantDetails(response.getBody());
			userDtos.add(userDTO);
		}
		map.put("Data", userDtos);
		map.put("Status", HttpStatus.FOUND);
		return ResponseEntity.ok(map);
	}
}
