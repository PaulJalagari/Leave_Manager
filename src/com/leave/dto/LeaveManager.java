package com.leave.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity
@Table(name = "LeaveManager")
public class LeaveManager implements Serializable {

	private static final long serialVersionUID = -1883317581153939034L;

	private String NAME;
	private String Type_of_leave;
	private String Status;
	private String From_date;
	private String To_date;
	private int Id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Column(name = "NAME")
	public String getNAME() {
		return NAME;
	}

	public void setNAME(String NAME) {
		this.NAME = NAME;
	}

	@Column(name = "Type_of_leave")
	public String getType_of_leave() {
		return Type_of_leave;
	}

	public void setType_of_leave(String Type_of_leave) {
		this.Type_of_leave = Type_of_leave;
	}

	@Column(name = "From_date")
	public String getFrom_date() {
		return From_date;
	}

	public void setFrom_date(String From_date) {
		this.From_date = From_date;
	}

	@Column(name = "To_date")
	public String getTo_date() {
		return To_date;
	}

	public void setTo_date(String To_date) {
		this.To_date = To_date;
	}

	@Column(name = "Status")
	public String getStatus() {
		return Status;
	}

	public void setStatus(String Status) {
		this.Status = Status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdOn")
	private Date createdOn;

	public Date getCreatedOn() {

		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

}
