
package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.SQLQuery;

@WebServlet("/list")
public class ListServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
             
    	HttpSession session = request.getSession(false);
		String userId = (String)session.getAttribute("userId"); 
		
		SQLQuery sq = new SQLQuery();
		sq.zeroSQL(userId);
    	request.setAttribute("todo", sq.listSQL(userId));
  
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
  	         dispatcher.forward(request, response);
    	
      }      

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
    	
    		   String message = (String)request.getAttribute("message");
    		   
    	       if( message.isEmpty() ){ 
    	           message = "todoを管理しましょう"; 
    	       } 
    	       
    	       HttpSession session = request.getSession();
    	       String userId = (String) session.getAttribute("userId");
    	       SQLQuery sq = new SQLQuery();
    	       
    	       request.setAttribute("todo", sq.listSQL(userId));
    	       request.setAttribute("message",message); 
    	       
    	        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
    	        dispatcher.forward(request, response);
    	}
}

