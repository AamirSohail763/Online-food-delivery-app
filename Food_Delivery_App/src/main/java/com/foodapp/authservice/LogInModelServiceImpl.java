package com.foodapp.authservice;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.authexceptions.AuthorizationException;
import com.foodapp.authmodels.LogInModel;
import com.foodapp.authmodels.SignUpModel;
import com.foodapp.authmodels.UserSession;
import com.foodapp.authrepository.LogInModelDAO;
import com.foodapp.authrepository.SignUpModelDAO;
import com.foodapp.authrepository.UserSessionDAO;

@Service
public class LogInModelServiceImpl implements LogInModelService {
	

	@Autowired
	private SignUpModelDAO signUpDAO;
	
	@Autowired
	private UserSessionDAO userSessionDAO;
	
	@Autowired
	private UserSessionService userLogInSession;
	
	@Autowired
	private LogInModelDAO loginDataDAO;
	
	@Override
	public String LogIn(LogInModel loginData) throws AuthorizationException {
		
		Optional<SignUpModel> opt = signUpDAO.findById(loginData.getUserId());
		
		if(!opt.isPresent())
		{
			throw new AuthorizationException("Invalid Login UserId");
		}
		
		SignUpModel newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		Optional<UserSession> currentUserOptional = userSessionDAO.findByUserId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new AuthorizationException("User Already LoggedIn with this UserId");
		}
		
		if((newSignUp.getUserId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomString.getRandomString();
			
			UserSession currentUserSession = new UserSession(newSignUp.getUserId(),key,LocalDateTime.now());
			userSessionDAO.save(currentUserSession);
			loginDataDAO.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			throw new AuthorizationException("Invalid UserName or Password..");
			
			
		
	}

	@Override
	public String LogOut(String key) throws AuthorizationException {
		
		Optional<UserSession> currentUserOptional = userSessionDAO.findByUUID(key);
		if(!currentUserOptional.isPresent())
		{
			throw new AuthorizationException("Invalid credentials...");
		}
		UserSession currentUserSession = userLogInSession.getUserSession(key);
		
		userSessionDAO.delete(currentUserSession);
		
		Optional<LogInModel> loginData = loginDataDAO.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		loginDataDAO.delete(loginData.get());
		
		
		return "Logged Out...";
	
	}

}
