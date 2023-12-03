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

@WebServlet("/sort")
public class SortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
				HttpSession session = request.getSession();
				
				String userId = (String)session.getAttribute("userId"); 
				String sort = request.getParameter("sort");
				
				SQLQuery sq = new SQLQuery();
				
				request.setAttribute("todo", sq.sortSQL(userId,sort));
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/list.jsp");
		        dispatcher.forward(request, response);
		        
			}
	}


