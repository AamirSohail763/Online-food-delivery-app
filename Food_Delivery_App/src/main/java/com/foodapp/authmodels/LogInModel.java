package com.foodapp.authmodels;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class LogInModel {
	
	@Id
	@NotNull
	private Integer userId;
	
	private String userName;
	private String password;

}
