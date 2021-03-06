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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service_offer_schedule")
public class ServiceOfferSchedule {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JsonIgnore
	@Fetch(FetchMode.JOIN)
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "service_offer_id")
	private ServiceOffer serviceOfferScheduleParent;
	
	@Column(name = "begin_date")
	private Date serviceOfferBeginDate;
	
	@Column(name = "end_date")
	private Date serviceOfferEndDate;
	
	@Column(name = "day_1_time_begin")
	private Time dayOneTimeBegin;
	
	@Column(name = "day_1_time_end")
	private Time dayOneTimeEnd;
	
	@Column(name = "day_2_time_begin")
	private Time dayTwoTimeBegin;
	
	@Column(name = "day_2_time_end")
	private Time dayTwoTimeEnd;

	@Column(name = "day_3_time_begin")
	private Time dayThreeTimeBegin;
	
	@Column(name = "day_3_time_end")
	private Time dayThreeTimeEnd;
	
	@Column(name = "day_4_time_begin")
	private Time dayFourTimeBegin;
	
	@Column(name = "day_4_time_end")
	private Time dayFourTimeEnd;
	
	@Column(name = "day_5_time_begin")
	private Time dayFiveTimeBegin;
	
	@Column(name = "day_5_time_end")
	private Time dayFiveTimeEnd;
	
	@Column(name = "day_6_time_begin")
	private Time daySixTimeBegin;
	
	@Column(name = "day_6_time_end")
	private Time daySixTimeEnd;
	
	@Column(name = "day_7_time_begin")
	private Time daySevenTimeBegin;
	
	@Column(name = "day_7_time_end")
	private Time daySevenTimeEnd;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceOffer getServiceOfferScheduleParent() {
		return serviceOfferScheduleParent;
	}

	public void setServiceOfferScheduleParent(ServiceOffer serviceOfferScheduleParent) {
		this.serviceOfferScheduleParent = serviceOfferScheduleParent;
	}

	public Date getServiceOfferBeginDate() {
		return serviceOfferBeginDate;
	}

	public void setServiceOfferBeginDate(Date serviceOfferBeginDate) {
		this.serviceOfferBeginDate = serviceOfferBeginDate;
	}

	public Date getServiceOfferEndDate() {
		return serviceOfferEndDate;
	}

	public void setServiceOfferEndDate(Date serviceOfferEndDate) {
		this.serviceOfferEndDate = serviceOfferEndDate;
	}

	public Time getDayOneTimeBegin() {
		return dayOneTimeBegin;
	}

	public void setDayOneTimeBegin(Time dayOneTimeBegin) {
		this.dayOneTimeBegin = dayOneTimeBegin;
	}

	public Time getDayOneTimeEnd() {
		return dayOneTimeEnd;
	}

	public void setDayOneTimeEnd(Time dayOneTimeEnd) {
		this.dayOneTimeEnd = dayOneTimeEnd;
	}

	public Time getDayTwoTimeBegin() {
		return dayTwoTimeBegin;
	}

	public void setDayTwoTimeBegin(Time dayTwoTimeBegin) {
		this.dayTwoTimeBegin = dayTwoTimeBegin;
	}

	public Time getDayTwoTimeEnd() {
		return dayTwoTimeEnd;
	}

	public void setDayTwoTimeEnd(Time dayTwoTimeEnd) {
		this.dayTwoTimeEnd = dayTwoTimeEnd;
	}

	public Time getDayThreeTimeBegin() {
		return dayThreeTimeBegin;
	}

	public void setDayThreeTimeBegin(Time dayThreeTimeBegin) {
		this.dayThreeTimeBegin = dayThreeTimeBegin;
	}

	public Time getDayThreeTimeEnd() {
		return dayThreeTimeEnd;
	}

	public void setDayThreeTimeEnd(Time dayThreeTimeEnd) {
		this.dayThreeTimeEnd = dayThreeTimeEnd;
	}

	public Time getDayFourTimeBegin() {
		return dayFourTimeBegin;
	}

	public void setDayFourTimeBegin(Time dayFourTimeBegin) {
		this.dayFourTimeBegin = dayFourTimeBegin;
	}

	public Time getDayFourTimeEnd() {
		return dayFourTimeEnd;
	}

	public void setDayFourTimeEnd(Time dayFourTimeEnd) {
		this.dayFourTimeEnd = dayFourTimeEnd;
	}

	public Time getDayFiveTimeBegin() {
		return dayFiveTimeBegin;
	}

	public void setDayFiveTimeBegin(Time dayFiveTimeBegin) {
		this.dayFiveTimeBegin = dayFiveTimeBegin;
	}

	public Time getDayFiveTimeEnd() {
		return dayFiveTimeEnd;
	}

	public void setDayFiveTimeEnd(Time dayFiveTimeEnd) {
		this.dayFiveTimeEnd = dayFiveTimeEnd;
	}

	public Time getDaySixTimeBegin() {
		return daySixTimeBegin;
	}

	public void setDaySixTimeBegin(Time daySixTimeBegin) {
		this.daySixTimeBegin = daySixTimeBegin;
	}

	public Time getDaySixTimeEnd() {
		return daySixTimeEnd;
	}

	public void setDaySixTimeEnd(Time daySixTimeEnd) {
		this.daySixTimeEnd = daySixTimeEnd;
	}

	public Time getDaySevenTimeBegin() {
		return daySevenTimeBegin;
	}

	public void setDaySevenTimeBegin(Time daySevenTimeBegin) {
		this.daySevenTimeBegin = daySevenTimeBegin;
	}

	public Time getDaySevenTimeEnd() {
		return daySevenTimeEnd;
	}

	public void setDaySevenTimeEnd(Time daySevenTimeEnd) {
		this.daySevenTimeEnd = daySevenTimeEnd;
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
		ServiceOfferSchedule other = (ServiceOfferSchedule) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ServiceOfferSchedule [id=").append(id).append("]");
		return builder.toString();
	}
	
}