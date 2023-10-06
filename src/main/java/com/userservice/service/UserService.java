/**
 * 
 */
package com.userservice.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Rajiv Adhav
 *
 */
@Service
public interface UserService {

	ResponseEntity<Map<String, Object>> getAllUsers();

}
