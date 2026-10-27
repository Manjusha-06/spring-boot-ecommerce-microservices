package com.klef.ms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;

}
