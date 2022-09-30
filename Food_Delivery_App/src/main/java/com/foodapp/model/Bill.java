package com.foodapp.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer billId;
	private LocalDateTime datetime;
	private Double totalAmount;
	private Integer totalItem;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private OrderDetails order;
	
}
