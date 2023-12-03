package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.SQLQuery;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int taskNo = Integer.parseInt(request.getParameter("taskNo"));
		SQLQuery sq = new SQLQuery();
		sq.deleteSQL(taskNo);
		
		request.setAttribute("message","Taskを削除しました");
			
		RequestDispatcher r = request.getRequestDispatcher("/list");
	 	r.forward(request, response);
		           	
		}
		
	}


