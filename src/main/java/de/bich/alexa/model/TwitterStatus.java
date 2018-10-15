package de.bich.alexa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="twitterstatus")
public class TwitterStatus {

	@GeneratedValue
	@Id
	private Long id;
	
	@Column(length=1024)
	private String text;
	
	@Column
	private String username;
	
	@Column(name="twitteruserid")
	private long twitterUserId;
	
	@Column(unique=true,name="twitterstatusid")
	private long twitterStatusId;
	
	@Column(name="statustimestamp")
	@Temporal(TemporalType.DATE)
	private java.util.Date statusTimeStamp;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getTwitterStatusId() {
		return twitterStatusId;
	}

	public void setTwitterStatusId(long twitterStatusId) {
		this.twitterStatusId = twitterStatusId;
	}

	public java.util.Date getStatusTimeStamp() {
		return statusTimeStamp;
	}

	public void setStatusTimeStamp(java.util.Date statusTimeStamp) {
		this.statusTimeStamp = statusTimeStamp;
	}

	public long getTwitterUserId() {
		return twitterUserId;
	}

	public void setTwitterUserId(long twitterUserId) {
		this.twitterUserId = twitterUserId;
	}
	
}

