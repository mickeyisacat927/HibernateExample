package main.java.com.mkyong.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "DBUSER")
public class DBUser implements java.io.Serializable{
	@Id
	@Column(name="USER_ID",unique=true,nullable = false, precision = 5, scale = 0)
	private int userId;
	@Column
	private String username;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	
	
	
	
	
	

		
}
