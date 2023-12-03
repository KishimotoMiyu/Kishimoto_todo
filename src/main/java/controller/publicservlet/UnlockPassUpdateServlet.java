
package controller.publicservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CharacterCheck;
import service.SQLQuery;


@WebServlet("/unlockpassUpdate")
public class UnlockPassUpdateServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{ 
		response.sendRedirect("login");
	}

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{  

    	SQLQuery sq = new SQLQuery();
    	CharacterCheck cc = new CharacterCheck();
    	
    	String password = request.getParameter("password");
    	String userId = request.getParameter("userId");
    	boolean passLength = cc.passLengthCheck(password);   //パスワードの文字数チェック
    	boolean passPattern = cc.passPatternCheck(password); //パスワードの全角かなチェック
        
        if ( passLength && passPattern ){
		 			
		 		 sq.newUpdatePasswordSQL(userId , password);
		         request.setAttribute("message","パスワードの更新とアカウントロック解除ができました");
		         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		         dispatcher.forward(request, response);
         
 		} else {
 			
 				request.setAttribute("message","passwordは8文字以上16文字以内の半角英数字で設定してください");
 			    request.setAttribute("userId", userId);
 			    request.getRequestDispatcher("/WEB-INF/views/unlockpass.jsp").forward(request, response);      
 		}
    }
}



