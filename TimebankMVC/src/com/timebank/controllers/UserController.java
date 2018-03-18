package com.timebank.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mchange.util.DuplicateElementException;
import com.timebank.data.UserDAO;

import entities.User;
import javassist.NotFoundException;

@RestController
public class UserController implements UserControllerInterface {
	
	@Autowired
	UserDAO userDAO;

	@Override
	@RequestMapping(path = "/user/register/{timebankId}/{addressId}", method = RequestMethod.POST)
	public User register(HttpSession session, HttpServletResponse res, @RequestBody String userJson, @PathVariable int timebankId, @PathVariable int addressId) {
		
		User registeringUser = null;
		try {
			registeringUser = userDAO.createUser(timebankId, addressId, userJson);
		}
		catch (DuplicateElementException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		return registeringUser;
	}

	@Override
	@RequestMapping(path = "/user/login", method = RequestMethod.POST)
	public User login(HttpSession session, HttpServletResponse res, @RequestBody String userJson) {
		User loggedIn = null;
		
		try {
			loggedIn = userDAO.login(userJson);
			session.setAttribute("activeUser", loggedIn);
		}
		catch (NotFoundException nfe) {
			System.err.println(nfe.getMessage());
			nfe.printStackTrace();
			res.setStatus(401);
		}

		return loggedIn;
	}

	@Override
	@RequestMapping(path = "/user/logout", method = RequestMethod.POST)
	public Boolean logout(HttpSession session, HttpServletResponse res) {
		session.removeAttribute("activeUser");
		return session.getAttribute("activeUser") == null;
	}

	@Override
	@RequestMapping(path = "/user/unauthorized", method = RequestMethod.GET)
	public String unauthorized(HttpServletResponse res) {
		res.setStatus(401);
		return "Unauthorized";
	}

	@Override
	@RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
	public User showUser(HttpSession session, HttpServletResponse res, @PathVariable int userId) {
		return userDAO.showUser(userId);
	}

	@Override
	@RequestMapping(path = "/user/timebank/{timebankId}", method = RequestMethod.GET)
	public List<User> getUsersByTimebank(HttpSession session, HttpServletResponse res, @PathVariable int timebankId) {
		return userDAO.getUsersByTimebank(timebankId);
	}

	@Override
	@RequestMapping(path = "/user/{userId}/{addressId}", method = RequestMethod.PUT)
	public User updateUser(HttpSession session, HttpServletResponse res, @PathVariable int userId, @PathVariable int addressId, @RequestBody String userJson) {
		User actingUser = (User) session.getAttribute("activeUser");
		userDAO.updateUser(actingUser.getId(), userId, addressId, userJson);
		return null; 
	}

	@Override
	@RequestMapping(path = "/user/{userId}/pass", method = RequestMethod.PUT)
	public Boolean updatePassword(HttpSession session, HttpServletResponse res, String userJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(path = "/user/{userId}/deactivate", method = RequestMethod.PUT)
	public User deactivateAccount(HttpSession session, HttpServletResponse res, int userId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}