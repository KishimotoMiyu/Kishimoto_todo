package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLQueryTest {

	SQLQuery sq = new SQLQuery();
	
	@Test
	public void accountCheckSQLTrueTest(){
		
		boolean t = sq.accountCheckSQL( "testsan" , "テスト" , "19960715");
		assertEquals(true , t) ;
		
	}
	
	@Test
	public void accountCheckSQLFalseTest(){
		
		boolean t = sq.accountCheckSQL( "nottestsan" , "テスト" , "19960715");
		assertEquals(false , t) ;
		
	}
	
	//public boolean accountCheckSQL(String userId,String userName,String birthday) {
//	try{ 
//   	 p = Hash.generateHash("test1234");
//    } catch (Exception e){
//   	 e.printStackTrace();
//    }
//     assertEquals("937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244", p);
	

}
