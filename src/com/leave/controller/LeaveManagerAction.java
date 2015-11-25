package com.leave.controller;

import java.util.List;

import com.leave.controller.LeaveManagerDAO;
import com.leave.dto.LeaveManager;
import com.opensymphony.xwork2.ActionSupport;

public class LeaveManagerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LeaveManager leave;
	private List<LeaveManager> leaveList;
	private int Id;
	private LeaveManagerDAO leaveManagerDao;

	public LeaveManager getLeave() {
		return leave;
	}

	public void setLeave(LeaveManager leave) {
		this.leave = leave;
	}

	public LeaveManagerAction() {
		leaveManagerDao = new LeaveManagerDAO();
	}

	public String execute() {
		this.leaveList = leaveManagerDao.list();
		return SUCCESS;
	}

	public String add() {
		System.out.println(getLeave());
		try {
			LeaveManager leave = getLeave();
			leave.setCreatedOn(new java.util.Date());
			leaveManagerDao.add(leave);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.leaveList = leaveManagerDao.list();
		return SUCCESS;
	}

	public String list() {
		this.leaveList = leaveManagerDao.list();
		return SUCCESS;
	}

	public String update() {
		leaveManagerDao.update(getId());
		return SUCCESS;
	}

	public List<LeaveManager> getLeaveList() {
		return leaveList;
	}

	public void setLeaveList(List<LeaveManager> leaveList) {
		this.leaveList = leaveList;
	}

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

}
