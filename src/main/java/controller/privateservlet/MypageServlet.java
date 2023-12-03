
package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mypage")
public class MypageServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
	       RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mypage.jsp");
	       dispatcher.forward(request, response);
    }   
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{  
    	
			String message = "";
		    String my  = request.getParameter("my"); //何を変更したいか
		    
		    if( my.equals("userName")) {
		    	message = "ユーザーネーム";		    		
		    } else if( my.equals("profile")) {
		    	message = "プロフィール";
		    } else if( my.equals("password")) {
		    	request.setAttribute("message","パスワード");
		    }
		    
		    request.setAttribute("message","新しい" + message + "を入力してください");
		    request.setAttribute("my",my);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/" + my + "Change.jsp");
	        dispatcher.forward(request, response);
	        
		}
    }




