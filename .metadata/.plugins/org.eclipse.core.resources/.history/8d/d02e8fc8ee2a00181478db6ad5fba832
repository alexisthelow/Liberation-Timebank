package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import entities.Timebank;

public interface TimebankControllerInterface {
	
	//create
	public Timebank createTimebank(HttpSession session, HttpServletResponse res, @RequestBody String timebankJson);
	
	//read
	
	public Timebank showTimebank(HttpSession session, HttpServletResponse res, @PathVariable int timebankId);
	public Double showUserTimebankHours(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId);
	public Set<Timebank> getAllTimebanks(HttpSession session, HttpServletResponse res);
	
	//update
	
	public Timebank updateTimebank(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @RequestBody String timebankJson);
	public Double updateUserTimebankHours(HttpSession session, HttpServletResponse res, @PathVariable int timebankId, @PathVariable int userId, @RequestBody String hourDifference);
	
	//destroy

	//TODO -- deactivate timebank?
	
}
