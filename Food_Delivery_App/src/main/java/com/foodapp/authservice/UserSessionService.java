package com.foodapp.authservice;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authmodels.SignUpModel;
import com.foodapp.authmodels.UserSession;

public interface UserSessionService {
	
	public UserSession getUserSession(String key) throws AuthorizationException;
	
	public Integer getUserSessionId(String key) throws AuthorizationException;
	
	public SignUpModel getSignUpDetails(String key) throws AuthorizationException;
	

}
