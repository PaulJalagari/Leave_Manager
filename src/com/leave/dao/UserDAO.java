package com.leave.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.leave.dto.Users;
import com.leave.util.HibernateUtil;

public class UserDAO {

	public boolean find(String username, String password) {

		Session session = HibernateUtil.createSessionFactory().getCurrentSession();
		session.beginTransaction();

		String SQL_QUERY = " from Users u where u.username='" + username + "' and u.password='" + password + "'";
		System.out.println(SQL_QUERY);
		Query query = session.createQuery(SQL_QUERY);
		Iterator<Users> it = query.iterate();
		List<Users> list = query.list();
		session.getTransaction().commit();
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}
}
