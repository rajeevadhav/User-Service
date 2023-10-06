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
public class RestaurantListDTO {

	private List<RestaurantDTO> restaurantDTOs;
}
