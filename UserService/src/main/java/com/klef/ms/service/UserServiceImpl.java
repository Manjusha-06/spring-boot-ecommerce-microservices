package com.klef.ms.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.ms.client.OrderClient;
import com.klef.ms.client.ProductClient;
import com.klef.ms.dto.OrderResponse;
import com.klef.ms.dto.ProductResponse;
import com.klef.ms.dto.UserRequest;
import com.klef.ms.dto.UserResponse;
import com.klef.ms.entity.User;
import com.klef.ms.exception.ResourceNotFoundException;
import com.klef.ms.repository.UserRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository repository;

	private final ProductClient productClient;
	private final OrderClient orderClient;

	@Override
	public UserResponse saveUser(UserRequest request) {
		User user = User.builder().name(request.getName()).email(request.getEmail()).password(request.getPassword())
				.contact(request.getContact()).role(request.getRole()).build();

		User savedUser = repository.save(user);

		return mapToResponse(savedUser);
	}

	@Override
	public List<UserResponse> getAllUsers() {
		return repository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
	}

	@Override
	public UserResponse getUserById(Long id) {

		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));

		return mapToResponse(user);
	}

	@Override
	public UserResponse updateUser(Long id, UserRequest request) {

		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));

		user.setName(request.getName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setContact(request.getContact());
		user.setRole(request.getRole());

		User updatedUser = repository.save(user);

		return mapToResponse(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {

		User user = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));

		repository.delete(user);
	}

	private UserResponse mapToResponse(User user) {
		return UserResponse.builder().id(user.getId()).name(user.getName()).email(user.getEmail())
				.contact(user.getContact()).role(user.getRole()).build();
	}

	@Override
	@CircuitBreaker(
			name = "ProductService", 
			fallbackMethod = "ProductServiceFallback"
		)
	
	public List<ProductResponse> displayAllProducts() {
		System.out.println("Product data received successfully:");
		return productClient.getAllProducts();
	}

	public List<ProductResponse> ProductServiceFallback(Throwable throwable)
	{
		System.out.println("----");
		System.out.println("Product Service is unavailable!");
		System.out.println("Circuit Breaker Fallback executed.");
		System.out.println("----");
		return Collections.emptyList();
	}

	
	@Override
	public List<OrderResponse> displayOrdersByUserId(Long userid) {
		return orderClient.displayorderbyuserid(userid);
	} 

}
