package service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharacterCheckTest {

	
	CharacterCheck cc = new CharacterCheck();
	
	@Test
	public void deadlineRedTest() { //期限までの日数
		      String d = cc.daysUpToDeadline("2023-11-03");
		      assertEquals("red", d);
	}
	
	@Test
	public void deadlineBlueTest() { //期限までの日数
		      String d = cc.daysUpToDeadline("2023-12-30");
		      assertEquals("blue", d);
	}
		
	@Test
	public void MinPassLengthCheckTest(){
		boolean n = cc.passLengthCheck("aaaabbbb");
		assertEquals(true, n);
	} 
	
	@Test
	public void MaxPassLengthCheckTest(){
		boolean n = cc.passLengthCheck("aaaabbbbccccdddd");
		assertEquals(true, n);
	}
	
	@Test
	public void ShortPassLengthCheckTest(){
		boolean n = cc.passLengthCheck("aaa");
		assertEquals(false, n);
	}
	
	@Test
	public void LongPassLengthCheckTest(){
		boolean n = cc.passLengthCheck("aaaabbbbccccdddde");
		assertEquals(false, n);
	}
	
	@Test //パスワードに全角かながないか確認
	public void passPatternMissCheckTest() {
		boolean n = cc.passPatternCheck("あaaAA");
		assertEquals(false, n);
	}
	
	@Test
	public void passPatternCheckTest() {
		boolean n = cc.passPatternCheck("aaAA00");
		assertEquals(true, n);
	}
	
	@Test
	public void dateReplacementTest() {
		String date = cc.dateReplacement("2023-12-25");
		assertEquals("2023年12月25日", date);
	}
	
	
	

}

