package main.java.hibernate.samples.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.mkyong.user.DBUser;

@Component
public class UserDao extends HibernateDaoSupport{
	
	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	public void init(SessionFactory factory) {
		setSessionFactory(sessionFactory);
	}
	
	@Transactional
	public void SaveUser(DBUser user) {
		getHibernateTemplate().save(user);
	}

}
