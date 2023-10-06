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
public class Product {

	private Integer id;
	private String title;
	private String description;
	private Integer price;
	private double discountPercentage;
	private double rating;
	private Integer stock;
	private String brand;
	private String category;
	private String thumbnail;
	private List<String> images;
}
