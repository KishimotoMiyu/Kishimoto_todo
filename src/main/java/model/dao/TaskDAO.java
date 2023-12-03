package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DBConnection;
import model.Task;

public class TaskDAO{
		
	
	//ログインロジック
	public String [] loginDAO(String sql) {
	
		String [] user = new String [4];
		
		try(Connection connection = DBConnection.getConnection(); //データベースに接続する
	            PreparedStatement statement = connection.prepareStatement(sql)){ //発行したいSQLを生成
	            	ResultSet res = statement.executeQuery();
	            	
	            	 while (res.next()){ 
			            	user[0] = res.getString("userName");
			            	user[1]= res.getString("profile");
							user[2] = res.getString("birthday");
							int count = res.getInt("count");
							user[3] = String.valueOf(count);
	            	 }
	            	 
		} catch (Exception e) {
			e.printStackTrace();
		}

		 return user;
		
	}
	
	//タスク一覧表示ロジック
	public List <Task> listDAO(String sql) throws SQLException, ClassNotFoundException {
			List <Task> todo = new ArrayList<>();
			try(Connection connection = DBConnection.getConnection(); //データベースに接続する
		            PreparedStatement statement = connection.prepareStatement(sql)){ //発行したいSQLを生成
		            	ResultSet res = statement.executeQuery();
				         
		            while (res.next()){ 
		            	int taskNo = res.getInt("taskNo");
		            	String userId = res.getString("userId");
						String task = res.getString("task");
						String importance = res.getString("importance");
						String date = res.getString("date");
						String deadline = res.getString("deadline");
						
						todo.add(new Task(taskNo, userId,  task, date, deadline, importance));
		            }
		     }	
		return todo;
	}

	// I 新規登録・ U 更新・D 削除 ロジック
	public void IUDDAO(String sql) throws SQLException,ClassNotFoundException{
    	try(Connection connection = DBConnection.getConnection();
   	        PreparedStatement statement = connection.prepareStatement(sql);){
            statement.executeUpdate();  
    	} 
	}
	
	//アカウントロック解除時のユーザー存在チェック または count(パスワードをミスした回数)の確認
		public int UserExistenceCheckDAO(String sql) throws SQLException,ClassNotFoundException{
			int i = 0;
	    	try(Connection connection = DBConnection.getConnection();
	   	        PreparedStatement statement = connection.prepareStatement(sql);){
	    		ResultSet res = statement.executeQuery();
	    		while (res.next()){ 
	            	i = res.getInt("count");
	    		} 
	         }
	    	return i;
		}
		
		//ログインチェックロジック
		public boolean executeQuery (String sql) throws SQLException{
			
			boolean rs = false ;
			
			try(Connection connection = DBConnection.getConnection();
		   	    PreparedStatement statement = connection.prepareStatement(sql);){
				ResultSet res = statement.executeQuery();
				rs = res.next();	
			} catch (SQLException | ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
			return rs;
			
			
						                
		}
}



            