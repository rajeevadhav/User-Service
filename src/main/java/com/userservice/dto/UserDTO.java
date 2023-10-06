/**
 * 
 */
package com.userservice.dto;

import java.util.List;

import lombok.Data;

/**
 * @author Rajiv Adhav
 *
 */
@Data
public class UserDTO {

	private int id;
	private String name;
	private String email;
	private String phoneNumber;
	private List<RestaurantDTO> restaurantDetails;
}
