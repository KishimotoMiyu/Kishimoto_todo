package model.dao;

import static org.junit.Assert.*;

import org.junit.Test;


public class TaskDAOTest {
	
	TaskDAO td = new TaskDAO();

	@Test
	public void loginDAOTest() {
		
		String userId   = "testsan";
		String password = "937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244";
		String userName = "テスト";
		
		
		String sql = "SELECT * FROM User WHERE userId='" + userId + "' AND password='" + password + "'";
		String [] user = td.loginDAO(sql);
		
		assertEquals(userName,user[0]);
		
	}
	

}
