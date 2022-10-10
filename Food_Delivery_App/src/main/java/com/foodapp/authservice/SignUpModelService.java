package com.foodapp.authservice;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authmodels.SignUpModel;

public interface SignUpModelService {
	
	public SignUpModel newSignUp(SignUpModel signUp) throws AuthorizationException;;
	
	public SignUpModel updateSignUp(SignUpModel signUp, String key) throws AuthorizationException;;

}
