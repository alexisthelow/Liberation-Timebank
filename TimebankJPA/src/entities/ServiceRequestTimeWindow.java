package entities;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "service_request_time_window")
public class ServiceRequestTimeWindow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "service_request_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	private ServiceRequest serviceRequestTimeWindowParent;
	
	@Column(name = "begin_date")
	private Date beginDate;
	
	@Column(name = "begin_time")
	private Time beginTime;
	
	@Column(name = "end_date")
	private Date endDate;
	
	@Column(name = "end_time")
	private Time endTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceRequest getServiceRequestTimeWindowParent() {
		return serviceRequestTimeWindowParent;
	}

	public void setServiceRequestTimeWindowParent(ServiceRequest serviceRequestTimeWindowParent) {
		this.serviceRequestTimeWindowParent = serviceRequestTimeWindowParent;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Time getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Time beginTime) {
		this.beginTime = beginTime;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceRequestTimeWindow other = (ServiceRequestTimeWindow) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceRequestTimeWindow [id=").append(id).append(", beginDate=").append(beginDate)
				.append(", beginTime=").append(beginTime).append(", endDate=").append(endDate).append(", endTime=")
				.append(endTime).append("]");
		return builder.toString();
	}
	
}
