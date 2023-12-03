
package controller.publicservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Login;
import service.SQLQuery;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
       dispatcher.forward(request, response);
       
    }  
    
    public void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{ 	
		    	
			String userId = request.getParameter("userId");
	        String password = request.getParameter("password");
	        SQLQuery sq = new SQLQuery();
				       
	        // test1234
	        
	        Login login = new Login(userId,password);
	        String [] user = sq.loginCheckSQL(login);
	        
	        if ( user[0] == null ) {
	        	sq.passmissSQL(userId);
            	request.setAttribute("message","ユーザーIDかパスワードが間違っています。");
    	    	request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response); 
    	    	
	        } else {
	        	
	        	String userName = user[0];
                String profile  = user[1];
                String birthday = user[2];
                String count    = user[3];
                int passMissCount = Integer.parseInt(count);
                
                if( passMissCount >= 3 ){ //パスワードをミスした回数が３回以上なら
                	request.setAttribute("message","パスワードを３回以上間違えたのでアカウントがロックされています。<br> "
                			+ "ロック解除及びパスワード変更は<a href='unlock'>こちら</a>");
                     request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
                } 
				                    
                HttpSession session = request.getSession();
                session.setAttribute("userId", userId);
                session.setAttribute("userName", userName);
                session.setAttribute("profile", profile);
                session.setAttribute("birthday", birthday);
                response.sendRedirect("list");
	
	        }            
		 }
    }


