package controllers;

import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import entities.MessageThread;
import entities.Reply;

public interface MessagingControllerInterface {
	
	//create
	
	public MessageThread createMessageThread(HttpSession session, HttpServletResponse res, @RequestBody String messageJson);
	public Reply createReply(HttpSession session, HttpServletResponse res, @PathVariable int threadId, @RequestBody String replyJson);

	//read

	public MessageThread showMessageThread(HttpSession session, HttpServletResponse res, @PathVariable int threadId);
	public Reply showReply(HttpSession session, HttpServletResponse res, @PathVariable int threadId, @PathVariable int replyId);
	
	public MessageThread showUserMessageThreads(HttpSession session, HttpServletResponse res);
	
	public Set<Reply> showMessageThreadReplies(HttpSession session, HttpServletResponse res, @PathVariable int threadId);
	
	//update
	
	public MessageThread addUserToMessageThread();
	public MessageThread removeUserFromMessageThread();
	
	//destroy
	
	//TODO -- user can hide / delete own messages
}
