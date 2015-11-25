package com.leave.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.leave.dto.LeaveManager;
import com.leave.util.HibernateUtil;

public class LeaveManagerDAO extends HibernateUtil {

	public LeaveManager add(LeaveManager leave) {
		Session session = HibernateUtil.createSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(leave);
		session.getTransaction().commit();
		return leave;
	}

	public LeaveManager delete(int Id) {
		Session session = HibernateUtil.createSessionFactory().getCurrentSession();
		session.beginTransaction();
		LeaveManager leave = (LeaveManager) session.load(LeaveManager.class, Id);
		if (null != leave) {
			session.delete(leave);
		}
		session.getTransaction().commit();
		return leave;
	}

	public List<LeaveManager> list() {

		Session session = HibernateUtil.createSessionFactory().getCurrentSession();
		session.beginTransaction();
		List<LeaveManager> leaves = null;
		try {

			leaves = (List<LeaveManager>) session.createQuery("from LeaveManager").list();

		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
		if (leaves != null) {
			return leaves;
		} else {
			return null;
		}
	}
}
