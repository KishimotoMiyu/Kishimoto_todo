package service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import model.Login;
import model.Task;
import model.dao.TaskDAO;
import util.Hash;

public class SQLQuery{
	
	TaskDAO dao = new TaskDAO();
	
	
	//ユーザー関係
	
	//ログインチェック
	public String [] loginCheckSQL( Login login ) {
		   String userId = login.getUserId();
	       String password = login.getPassword();
		   String hashedPassword = null ;
		
		try {
		    hashedPassword = Hash.generateHash(password);
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		String sql = "SELECT * FROM User WHERE userId='" + userId + "' AND password='" + hashedPassword + "'";
		String [] user = dao.loginDAO(sql);
		
		return user;
		
	}
	
	//アカウントロックをする際に入力項目が正しいか確認するための処理
	public boolean accountCheckSQL(String userId,String userName,String birthday) {
		
		boolean rs = false ;
		String sql = "SELECT * FROM User WHERE userId='" + userId + "' AND userName='" + userName + "' AND Birthday= '" + birthday + "' ";
		
		try {
			rs = dao.executeQuery(sql);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		 
		return rs; //あってたらtrue,間違ってたらfalse
	}
		
	// アカウントロック解除時のパスワードの更新
	public void newUpdatePasswordSQL(String userId , String password ) {
		
		try {			
			String hashPassword = Hash.generateHash(password);
 			String sql = "UPDATE User SET `password` = '" + hashPassword + "' , count = 0 WHERE userId = '" + userId + "'";
 			dao.IUDDAO(sql);
			
		} catch ( SQLException | ClassNotFoundException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	//パスワードミスしたカウントを増やす
	public void passmissSQL(String userId ) {
		
		String sql =  "SELECT count FROM User WHERE userId= '" + userId + "'";
	    int count = 0;
	    
	    try {
	    	count = dao.UserExistenceCheckDAO(sql);
	    	count ++ ;
	    	sql =  "UPDATE User SET count = " + count + "  WHERE userId = '" + userId + "' ;";
	    	dao.IUDDAO(sql);
	    }catch (SQLException | ClassNotFoundException e) {
	    	e.printStackTrace();
	    }
	}
	
	//ログイン成功時にパスワードをミスした回数のカウントを0に戻す
	public void zeroSQL(String userId) {
		
		try {
			dao.IUDDAO("UPDATE `User` SET  count = 0 WHERE userId = '" + userId + "'");
		} catch( SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//ユーザー情報変更
    public void changeUserSQL( String my , String change , String userId) {  	
    	String sql =  "UPDATE User SET " + my + " = '" + change + "' WHERE userId = '" + userId + "';";
    	try {
    		dao.IUDDAO(sql);
    	}catch (SQLException | ClassNotFoundException e) {
    		e.printStackTrace();
    	}
    }
    
    //ユーザー新規登録
  	public void newUserSQL(String userId , String userName , String hashPassword , String profile , String birthday) throws SQLException , ClassNotFoundException {
  		
  		try {
  			
  			String sql = "INSERT INTO User ( userId , userName , password  ,  profile , Birthday ,count) VALUES"
  					   + " ('" + userId + "' , '" + userName + "' , '" + hashPassword + "' , '" + profile + "' , '" + birthday + "' , 0)";
  			dao.IUDDAO(sql);
  			
  		} catch ( SQLException | ClassNotFoundException e) {
  			e.printStackTrace();
  		}
  	}
  	

    //タスク関係
	
	//一覧表示
	public List <Task> listSQL(String userId) {
		List <Task> todo = null;
	    
		try {
			todo = dao.listDAO("SELECT * FROM Task WHERE userId = '" + userId + "'");	
		}catch( SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return todo;
	}
	
	//タスク更新画面に推移する時に現在の入力情報を持っていく処理
		public List <Task> updateTaskListSQL(int taskNo) {
			
			List <Task> todo = null;
		    
			try {
				todo = dao.listDAO("SELECT * FROM Task WHERE taskNo = " + taskNo);	
			}catch( SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			return todo;
			
		}
	
	
	//並び替えて一覧表示
	public List <Task> sortSQL(String userId , String sort ) {
		String sql = "";
		List <Task> todo = null ;
		
	    if(sort.equals("lineasc")) {
	    	sql = "deadline ASC";
	    } else if(sort.equals("linedesc")) {
	    	sql = "deadline DESC";
	    } else if(sort.equals("dateasc")) {
	    	sql ="date ASC";
	    } else if(sort.equals("datedesc")) {
	    	sql = "date DESC";
	    } else if(sort.equals("imasc")) {
	    	sql = "CASE importance WHEN 'high' THEN 1 WHEN 'normal' THEN 2 WHEN 'low' THEN 3 ELSE 4 END";
	    } else if(sort.equals("imdesc")) {
	    	sql = "CASE importance WHEN 'low' THEN 1 WHEN 'normal' THEN 2 WHEN 'high' THEN 3 ELSE 4 END";
	    }
	    
		try {
			todo = dao.listDAO("SELECT * FROM Task WHERE userId = '" + userId + "' ORDER BY " + sql);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return todo;
		
	}
	
	//タスク新規登録
		public void newSQL(String userId , String task , String importance ,String deadline) {
			
			try {
				String sql = "INSERT INTO Task  (`userId`,`date`,`task`,`importance`,`deadline`,`completion` ) VALUES"
						   + " ('" + userId + "', CURRENT_DATE , '" + task + "' , '" + importance  + "' , '" + deadline + "' ,false);";
				dao.IUDDAO(sql);
			} catch ( SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	
	//タスクのアップデート
	public void updateSQL(String date , String deadline , String task , String importance , int taskNo) {
		
		try {
			dao.IUDDAO("UPDATE Task SET `date` = '" + date + "' , `deadline` = '" + deadline + "'  , "
					+ "`task` = '" + task + "' , importance = '" + importance + "'  WHERE `taskNo` = " + taskNo + ";");
		} catch( SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	//タスク削除
	public void deleteSQL(int taskNo ) {
	
		try {
			dao.IUDDAO("DELETE FROM Task WHERE taskNo = " + taskNo );
	 	} catch( SQLException | ClassNotFoundException e) {
	 		e.printStackTrace();
	 	}
		
	}

}
	
	
	
	
	

