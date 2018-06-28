package main.java.hibernate.samples.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.mkyong.user.DBUser;
import main.java.hibernate.samples.dao.UserDao;

@RestController
public class UserRestfulController {
	
	@Autowired
	UserDao dao;
	
	@RequestMapping("user")
	public String SaveUser(int ID, String name) {
		DBUser user = new DBUser();
		user.setUserId(ID);
		user.setUsername(name);
		
//		UserDao dao = new UserDao();
		dao.SaveUser(user);
		
		return "OK";
	}
}
