package interfaces;

import java.sql.Date;
import java.sql.Timestamp;

public interface Loan extends Transaction {
	
	public Integer getDaysRequested();
	public void setDaysRequested(Integer days);
	public Integer getDaysProvided();
	public void setDaysProvided(Integer days);
	public Timestamp getParentUserStart();
	public void setParentUserStart(Timestamp start);
	public Timestamp getOwnerStart();
	public void setOwnerStart(Timestamp start);
	public Date getBeginDate();
	public void setBeginDate(Date date);
	public Date getDueDate();
	public void setDueDate(Date date);
	public Integer getRenewCount();
	public void setRenewCount(Integer count);

}
