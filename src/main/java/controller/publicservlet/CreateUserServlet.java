
package controller.publicservlet;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CharacterCheck;
import service.SQLQuery;
import util.Hash;

@WebServlet("/createUser")
public class CreateUserServlet extends HttpServlet{
	
	 public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			    	    	
			       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/createUser.jsp");
			       dispatcher.forward(request, response);
	 }
	 
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		 
	    CharacterCheck cc = new CharacterCheck();
	    SQLQuery sq = new SQLQuery();
	
	    String userId = request.getParameter("userId");
	 	String userName = request.getParameter("userName");
	 	String password = request.getParameter("password");
        String birthday = request.getParameter("birthday");
        String profile = request.getParameter("profile");
        boolean Null = cc.NewUserNullCheck(userId,userName,birthday); //入力項目のNULLチェック
        boolean passLength = cc.passLengthCheck(password); //パスワードの文字数チェック
        boolean passPattern = cc.passPatternCheck(password); //パスワードの全角かなチェック
        
        if( Null ) { //nullチェック
  
        	 request.setAttribute("userId",userId);
	   		 request.setAttribute("userName",userName);
	   		 request.setAttribute("birthday",birthday);
	   		 request.setAttribute("profile",profile);
	   		 request.setAttribute("message","空白の項目があります");
	   	     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/createUser.jsp");
	   	     dispatcher.forward(request, response);
        	
        }
       
        if ( passLength && passPattern ){ //パスワードの文字数チェック
        	
					 try {
						 String hashPassword = Hash.generateHash(password);
						 sq.newUserSQL( userId , userName , hashPassword , profile , birthday);
						 request.setAttribute("message", "アカウントの新規作成が完了しました");					                
						 RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
						 dis.forward(request, response); 
						 
					 }catch (SQLException e) {
						 
				    	  request.setAttribute("message","既に使用済みのユーザーIDか、誤った入力項目がります。正しく入力してください");
					      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/createUser.jsp");
					      dispatcher.forward(request, response);
				          e.printStackTrace();		
				          
					 } catch ( ClassNotFoundException | NoSuchAlgorithmException e ) {
						 
						 e.printStackTrace();	
						 
					 }
					 
		 } else {
			 
			 request.setAttribute("userId",userId);
			 request.setAttribute("userName",userName);
			 request.setAttribute("birthday",birthday);
			 request.setAttribute("profile",profile);
			 request.setAttribute("message","passwordは8文字以上16文字以内の半角英数字で設定してください");
		     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/createUser.jsp");
		     dispatcher.forward(request, response);
		     
		 }
	 }
}




