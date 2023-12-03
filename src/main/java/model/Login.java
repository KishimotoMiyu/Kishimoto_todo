
package model ;
import java.io.Serializable;

public class Login implements Serializable {
	
	private String userId;
	private String password;
	
	public Login(){}
	
	public Login(String userId,String password) {
		this.userId = userId;
		this.password = password;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public String getPassword() {
		return this.password;
	}
	
}