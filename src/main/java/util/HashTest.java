package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class HashTest {
	
	String p = "";

	@Test
	public void notGenerateHashTest() { 
			
			try{ 
		    	 p = Hash.generateHash("test1234");
		     } catch (Exception e){
		    	 e.printStackTrace();
		     }
		      assertNotEquals("test1234", p);
	}
	
	@Test
	public void generateHashTest() { 
			
			try{ 
		    	 p = Hash.generateHash("test1234");
		     } catch (Exception e){
		    	 e.printStackTrace();
		     }
		      assertEquals("937e8d5fbb48bd4949536cd65b8d35c426b80d2f830c5c308e2cdec422ae2244", p);
	}
	
}



//SELECT 商品名 FROM 注文履歴 WHERE 日付 = 2022-01 ORDER BY 商品名