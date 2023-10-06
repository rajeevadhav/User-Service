/**
 * 
 */
package com.userservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Rajiv Adhav
 *
 */
@Entity
@Table(name = "restaurant_user")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	
	private String email;
	private String name;
	@Column(name = "phone_number")
	private String phoneNumber;
	
}
