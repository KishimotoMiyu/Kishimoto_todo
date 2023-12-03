
package controller.publicservlet;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SQLQuery;

@WebServlet("/unlock")
public class UnlockServlet extends HttpServlet{
	
	 public void doGet(HttpServletRequest request,
			    HttpServletResponse response) throws ServletException,IOException{
			       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/unlock.jsp");
			       dispatcher.forward(request, response);
	 }
	 
	 public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		
		    String userId = request.getParameter("userId");
		 	String userName = request.getParameter("userName");
	        String birthday = request.getParameter("birthday");
	        SQLQuery ts = new SQLQuery();
	        
	        if(ts.accountCheckSQL(userId,userName,birthday)) {
	        	
	        	 request.setAttribute("userId", userId);
			      RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/unlockpass.jsp");
			      dispatcher.forward(request, response);
	        	
	        } else {
	        	
	        	request.setAttribute("message", "入力項目に誤りがあり、アカウントロックを解除できませんでした");
			     RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/unlock.jsp");
			     dispatcher.forward(request, response);
	        	
	        }             
	 }
}
	 




