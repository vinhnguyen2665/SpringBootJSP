package com.vinhnq.dao.impl;

import com.vinhnq.common.CommonCode;
import com.vinhnq.common.CommonConst;
import com.vinhnq.dao.UserDAO;
import com.vinhnq.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value = "userDAO")
@Transactional(transactionManager = CommonConst.CONFIG.HibernateTransactionManager)
@EnableTransactionManagement
public class UserDAOImpl implements UserDAO {

	private static final Logger logger = LogManager.getLogger(UserDAOImpl.class);

	private final SessionFactory sessionFactory;

	public UserDAOImpl(@Qualifier(CommonConst.CONFIG.HibernateSessionFactory) SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public User loadUserByUsername(String username) {
		User users = null;
		String userNameParam = "";
		String emailParam = "";
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String content = "select u.* from user u "
					+ "where (:username is null OR u.user_name = :username) AND (:email is null OR u.email = :email)";
			Query<User> query = session.createSQLQuery(content).addEntity("u", User.class);
			if (CommonCode.isEmail(username)) {
				userNameParam = null;
				emailParam = username;
			} else {
				userNameParam = username;
				emailParam = null;
			}
			query.setParameter("username", userNameParam);
			query.setParameter("email", emailParam);
			List<User> result = query.list();
			if (result.size() > 0) {
				users = result.get(0);
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new RuntimeException();
		}
		return users;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> result = new ArrayList<>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			String content = "select u.* from user u";
			Query<User> query = session.createSQLQuery(content).addEntity("u", User.class);
			result = query.list();
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new RuntimeException();
		}
		return result;
	}

	@Override
	public boolean installUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			user.setCreateDate(Timestamp.from(new Date().toInstant()));
			session.save(user);
			session.flush();
			return true;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new RuntimeException();
		}
	}

	@Override
	public boolean updateUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.merge(user);
			session.flush();
			return true;
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
			throw new RuntimeException();
		}
	}


}
