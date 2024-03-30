package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

	private int productId;
	private String trackingId;
	private String productType;
	private String name;
	private int qty;
	private double price;
}