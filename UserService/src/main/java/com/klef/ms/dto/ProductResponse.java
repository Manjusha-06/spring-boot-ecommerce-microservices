package com.klef.ms.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
//we are using productresponse because this is kind of response no need of
//productrequest so only creating productresponse

public class ProductResponse 
{
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Integer quantity;
}