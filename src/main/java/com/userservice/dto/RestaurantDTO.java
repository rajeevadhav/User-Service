package com.userservice.dto;

import lombok.Data;

/**
 * @author Rajiv Adhav
 *
 */
@Data
public class RestaurantDTO {

	private int id;
	private String name;
	private String location;
	private String owner;
	private int restaurantUserId;
}
