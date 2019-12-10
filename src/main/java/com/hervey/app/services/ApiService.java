package com.hervey.app.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.hervey.app.models.User;
import com.hervey.app.repositories.UserRepository;

@Service
public class ApiService {
	private final UserRepository userRepository;
	
	public ApiService (UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> fetchAllUsers(){
		return userRepository.findAll();
	}

	public String fetchUserNameFromUserID(Long userId) {
		User user = userRepository.findById(userId).orElse(null);
		return user.getUserName();
	}
	
	public Boolean isEmailAlreadyRegistered(User user) {
		System.out.println("email of user passed in:  " + user.getEmail());
		List<User> users = this.fetchAllUsers();
		for(User theUser : users) {
			System.out.println("theUser this iteration's email:  " + theUser.getEmail());
			if(user.getEmail().equals(theUser.getEmail())) {
				System.out.println("found existing email");
				return true;
			}
		}
		return false;
	}
	
	//register user with hashed password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	
	//authenticate user
	public Boolean authenticateUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if(user==null) {
			return false;
		}
		else {
			return BCrypt.checkpw(password, user.getPassword());
		}
	}
	
	//find user by email
	public User fetchByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//fetch user by id
	public User fetchById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public void incrementLoginCount(User user) {
		user.setNumLogins(user.getNumLogins()+1);
		userRepository.save(user);
	}
	
	public void userSave(User user) {
		userRepository.save(user);
	}
	
}
