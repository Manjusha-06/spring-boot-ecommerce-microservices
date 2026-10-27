package com.klef.ms.service;

import java.util.List;

import com.klef.ms.dto.OrderResponse;
import com.klef.ms.dto.ProductResponse;
import com.klef.ms.dto.UserRequest;
import com.klef.ms.dto.UserResponse;

public interface UserService {

	UserResponse saveUser(UserRequest request);

	List<UserResponse> getAllUsers();

	UserResponse getUserById(Long id);

	UserResponse updateUser(Long id, UserRequest request);

	void deleteUser(Long id);

	// Implementation from Product Service project
	List<ProductResponse> displayAllProducts();

	// Implementation from Order Service Project
	List<OrderResponse> displayOrdersByUserId(Long userid);

}