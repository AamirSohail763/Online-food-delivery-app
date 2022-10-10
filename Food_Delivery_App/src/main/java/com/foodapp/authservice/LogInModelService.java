package com.foodapp.authservice;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authmodels.LogInModel;

public interface LogInModelService {
	
	public String LogIn(LogInModel login) throws AuthorizationException;
	
	public String LogOut(String key) throws AuthorizationException;

}
