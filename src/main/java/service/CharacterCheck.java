package service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.dao.TaskDAO;

public class CharacterCheck{
	
	public boolean passLengthCheck(String pass){
		if(pass.length() >= 8 &&  pass.length() <= 16) {
			return true;
		} else {
			return false;
		}
	} 
	
	public boolean passPatternCheck(String pass){
		int i = pass.length();
		Pattern pattern = Pattern.compile("[0-9a-zA-Z]{" + i + "}"); //パターンを指定するクラス
        Matcher matcher = pattern.matcher(pass);		  //パターンにマッチしているかを確認するクラス
        return matcher.find();
	} 
	
	//期限までの日数を取得するメソッド
	public String daysUpToDeadline(String deadline){								
		LocalDate now = LocalDate.now(); 											//今日の日付を取得
		LocalDate endDays = LocalDate.parse(deadline,DateTimeFormatter.ISO_DATE);   //deadlineをLocalDate型へ変換
		long longDays = ChronoUnit.DAYS.between(now , endDays);            		    //今日から期日までの日数
		String daysStr = String.valueOf(longDays); 									//今日から期日までの日数をString型へ変換
		int days = Integer.parseInt(daysStr);									    //今日から期日までの日数をint型へ変換
		String daysClass = "";
		
		if( days > 3){
			daysClass = "blue";
		}else if( days >= 0 ){
			daysClass = "yellow";
		}else{
			daysClass = "red";
		}
		return daysClass;
	}
	
	//新規登録の際のnullチェック
	public boolean NewUserNullCheck(String userId ,String userName , String birthday){	
		if( userId.isEmpty() || userName.isEmpty() || birthday.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	//更新の際のnullチェック
	public boolean UpdateTaskNullCheck( String task , String importance , String date , String deadline) {
		if ( task.isEmpty() || importance.isEmpty() || date.isEmpty() || deadline.isEmpty()){
		   return true;
		} else {
			return false;
		}
	}
	
	//タスク新規登録の際のnullチェック
		public boolean NewTaskNullCheck( String task , String importance , String deadline) {
			if ( task.isEmpty() || importance.isEmpty() || deadline.isEmpty()){
			   return true;
			} else {
				return false;
			}
		}
		
	
	//アカウントが存在するかどうかのチェック
	public boolean UserExistenceCheck(String userId , String userName , String birthday){
		String sql = "SELECT COUNT(*) AS count FROM User WHERE userId = '" + userId + "' AND userName = '" + userName + "' AND Birthday = '" + birthday + "' ;";
		TaskDAO dao = new TaskDAO();
		int count = 0;
		
		try {
			count = dao.UserExistenceCheckDAO(sql);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if( count == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	// 2023-12-12 →　2023年12月12日にするメソッド
	public String dateReplacement(String date) {
		  String year = date.replaceFirst( "-", "年" );
		  String month = year.replaceFirst( "-", "月" );
		  String day = month+"日";
		  return day;
	}
	
}
	
	
	
	
