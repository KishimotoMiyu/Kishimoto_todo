
package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.CharacterCheck;
import service.SQLQuery;

@WebServlet("/new")
public class NewServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

       request.setAttribute("message","新規作成ページです");
       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/new.jsp");
       dispatcher.forward(request, response);
       
    }   
    
    public void doPost (HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {  
		
        String task = request.getParameter("task");
        String importance = request.getParameter("importance");
        String deadline = request.getParameter("deadline");
        
        HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); 
		CharacterCheck cc = new CharacterCheck();
		SQLQuery sq = new SQLQuery();
        
	        if (cc.NewTaskNullCheck(task , importance , deadline)){
	        	request.setAttribute("message","新規作成ページです");
	 			request.setAttribute("error","未入力の項目があります");
	 	        request.getRequestDispatcher("/WEB-INF/views/new.jsp").forward(request, response);
	 	        
	 		} else  {
	 		    
	 			sq.newSQL(userId, task , importance, deadline);
     			request.setAttribute("todo", sq.listSQL(userId));
     			response.sendRedirect("/list");
 		}
    }
}

