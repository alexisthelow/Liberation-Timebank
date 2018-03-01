package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import entities.User;

public interface UserControllerInterface {
	
	//create
	
	public User register(HttpServletResponse res, @RequestBody String userJson);
	
	//read
	
		//security
	
	public User login(HttpSession session, HttpServletResponse res, @RequestBody String userJson);
	public Boolean logout(HttpSession session, HttpServletResponse res);
	public String unauthorized(HttpServletResponse res);

		//display one
	
	public User showUser(HttpSession session, HttpServletResponse res, @PathVariable int userId);

		//display many
	
	public Set<User> getUsersByTimebank(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
	public Set<User> getActiveUsersByTimebank(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
	
	//update
	
	public User updateUser(HttpSession session, HttpServletResponse res, @PathVariable int userId, @RequestBody String userJson);
	public Boolean updatePassword(HttpSession session, HttpServletResponse res, @RequestBody String userJson);
	public Boolean recoverPassword(HttpServletResponse res, @RequestBody String userJson);
	
	//destroy
	
	public User deactivateAccount(HttpSession session, HttpServletResponse res, @PathVariable int userId);
	
	
}
