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
public class ProductList {

	private List<Product> products;
	private int total;
	private int limit;
	private int skip;
}
