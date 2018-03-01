package data;

import java.util.Set;

import entities.User;
import interfaces.Transaction;

public interface TransactionDAO {
	
	//create
	
	public Transaction createTransaction(User actingUser, Object parent, )
	
	//read
	
	//update
	
	public Transaction updateTransaction(User actingUser, Transaction managedTx, )
	
	//destroy

}
