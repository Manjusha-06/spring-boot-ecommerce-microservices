package com.klef.ms.service;

import java.util.List;

import com.klef.ms.dto.OrderRequest;
import com.klef.ms.dto.OrderResponse;

public interface OrderService 
{
    OrderResponse saveOrder(OrderRequest request);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Long id);

    OrderResponse updateOrder(Long id, OrderRequest request);

    void deleteOrder(Long id);
    
    List<OrderResponse> getOrdersByUserId(Long userId);
}