package data;

import java.util.List;

import entities.MessageThread;
import entities.Reply;

public interface MessageDAO {
	
	//create
	
	public MessageThread createMessageThread(int userId, int[] recipientIds, String messageThreadJson, String replyJson);
	public Reply createReply(int userId, int threadId, String replyJson);
	
	//read
	
	public MessageThread showMessageThread(int threadId);
	public List<MessageThread> getUserMessageThreads(int userId);
	public List<Reply> showMessageThreadReplies(int threadId);
	public Reply showReply(int replyId);
	
	//update
	
	public MessageThread updateMessageThread(int actingUserId, int threadId, String threadJson);
	public Reply updateReply(int actingUserId, int replyId, String replyJson);
	
	//destroy
	
		//TODO -- user should be able to hide own messages

}
