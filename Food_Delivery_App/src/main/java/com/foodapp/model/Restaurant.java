package com.foodapp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Restaurant {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer restaurantId;
	private String restaurantName;
	private String managerName;
	private String contactNumber;
	
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(targetEntity = Item.class,cascade = CascadeType.ALL)
	private List<Item> itemList = new ArrayList<>();
}