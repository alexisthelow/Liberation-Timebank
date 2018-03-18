package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.UserDAO;
import entities.User;

@RestController
public class UserController implements UserControllerInterface {
	
	@Autowired
	UserDAO userDAO;
	
	

	@Override
	@RequestMapping(path = "/user/register", method = RequestMethod.POST)
	public User register(HttpSession session, HttpServletResponse res, String userJson) {
		
		try {
			newUser = mapper.readValue(userJson, User.class);
			//first check if there is already someone with that email
			String query = "SELECT u FROM User u WHERE email = :email";
			List<User> duplicateCheck = em.createq
			User checkForDuplicate = 
			
		}
		catch (Exception e) {
			
		}
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public User login(HttpSession session, HttpServletResponse res, String userJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public Boolean logout(HttpSession session, HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public String unauthorized(HttpServletResponse res) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public User showUser(HttpSession session, HttpServletResponse res, int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public Set<User> getUsersByTimebank(HttpSession session, HttpServletResponse res, int timebankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public Set<User> getActiveUsersByTimebank(HttpSession session, HttpServletResponse res, int timebankId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public User updateUser(HttpSession session, HttpServletResponse res, int userId, String userJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public Boolean updatePassword(HttpSession session, HttpServletResponse res, String userJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public Boolean recoverPassword(HttpServletResponse res, String userJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "", method = RequestMethod.)
	public User deactivateAccount(HttpSession session, HttpServletResponse res, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
