
package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException,IOException{
    	
    	HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("login");
       
    }  
    
  }



