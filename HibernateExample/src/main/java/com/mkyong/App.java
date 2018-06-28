package main.java.com.mkyong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import main.java.com.mkyong.user.DBUser;
import main.java.hibernate.samples.dao.UserDao;

@SpringBootApplication
@ComponentScan(basePackages= {"main.java", "tst.yyy"})
public class App extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// TODO Auto-generated method stub
		return application.sources(App.class);
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
		
	}
	


}
