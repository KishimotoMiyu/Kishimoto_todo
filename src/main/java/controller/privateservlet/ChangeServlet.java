
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

@WebServlet("/change")
public class ChangeServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException{
		response.sendRedirect("login");
	}
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{  
    	
    	HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId"); 
		String my = request.getParameter("my");
		String change = request.getParameter("change");
		SQLQuery sq = new SQLQuery();
		CharacterCheck cc = new CharacterCheck();
		
		if( my.equals("userName") || my.equals("password") ) {
			if( change.isEmpty() ) {
				
				request.setAttribute("message", "未入力では登録できません");
				request.setAttribute("my", my);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/" + my + "Change.jsp");
		        dispatcher.forward(request, response);	
			}
		}
		
		if( my.equals("password") ) {
			
			boolean passLength = cc.passLengthCheck(change); //パスワードの文字数チェック
	        boolean passPattern = cc.passPatternCheck(change); //パスワードの全角かなチェック
	        
			if( !passLength || !passPattern ) { 
				
				request.setAttribute("message", "パスワードは8文字以上16文字以下の英数字で入力してください。");
				request.setAttribute("my", "password");
		        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/passwordchange.jsp");
		        dispatcher.forward(request, response);
			
			}
		}
		
		sq.changeUserSQL(my , change,userId);
		
		if( my.equals("userName") || my.equals("password") ) {
			session.setAttribute(my , change);
		}
		
		response.sendRedirect("mypage");

	}
}



