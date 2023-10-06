/**
 * 
 */
package com.userservice.api;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.userservice.dto.Product;
import com.userservice.dto.ProductList;
import com.userservice.service.UserService;

/**
 * @author Rajiv Adhav
 *
 */
@RestController
public class UserApi {

	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getAllUsers")
	ResponseEntity<Map<String, Object>>	getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getAllProducts")
	ResponseEntity<List<Product>> getAllProducts() {
		ProductList productList = restTemplate.getForObject("https://dummyjson.com/products", ProductList.class);
		List<Product> products = productList.getProducts();
		List<Product> list = products.stream().filter(p -> p.getCategory().equalsIgnoreCase("smartphones")).toList();

		List<Product> collect = products.stream().filter(p -> p.getBrand().equalsIgnoreCase("Apple")).collect(Collectors.toList());

		Product collect2 = collect.stream()
		        .sorted((p1, p2)->p2.getPrice().compareTo(p1.getPrice())).skip(1).collect(Collectors.toList()).get(0);
		
		List<Product> collect3 = products.stream().sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())).collect(Collectors.toList());
//		Product collect3 = products.stream().sorted((p1, p2) -> p1.getPrice().compareTo(p2.getPrice())).skip(1).collect(Collectors.toList()).get(0);
		List<String> collect4 = products.stream().map(p->p.getCategory()).collect(Collectors.toList());
		return ResponseEntity.ok(collect3);
	}
	
	
}
