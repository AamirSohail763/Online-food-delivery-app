package com.foodapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	private String fullName;
	private Integer age;
	private String gender;
	private String mobileNumber;
	private String email;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart foodCart;
}

