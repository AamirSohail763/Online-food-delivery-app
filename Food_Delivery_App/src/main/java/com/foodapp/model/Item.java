package com.foodapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Item{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	private String itemName;
	private Integer quantity;
	private Double cost;
	
//	@Embedded
	@OneToOne(cascade = CascadeType.ALL)
	private Category category;
}