
package controller.privateservlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.CharacterCheck;
import service.SQLQuery;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{

    	int taskNo = Integer.parseInt(request.getParameter("taskNo"));
    	
    	SQLQuery sq = new SQLQuery();
    	request.setAttribute("todo", sq.updateTaskListSQL(taskNo));
    	request.setAttribute("taskNo",taskNo); 
    	    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/edit.jsp");
        dispatcher.forward(request, response);
       
    }   
    
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{  
    	
    	// jspから情報を取得
    	int taskNo = Integer.parseInt(request.getParameter("taskNo"));
        String task = request.getParameter("task");
        String importance = request.getParameter("importance");
        String date = request.getParameter("date");
        String deadline = request.getParameter("deadline");
        
        //使用クラスのインスタンス化
        SQLQuery sq = new SQLQuery();
        CharacterCheck cc = new CharacterCheck();
        
        request.setAttribute("taskNo",taskNo);  
        
        if(cc.UpdateTaskNullCheck(task , importance , date , deadline)) { //項目にnullがあったら
        	
        	request.setAttribute("todo", sq.updateTaskListSQL(taskNo));
 			request.setAttribute("error","未入力の項目があります");
 	        request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request, response);
        	
        } else {
        	
        	sq.updateSQL(date , deadline , task , importance , taskNo );	
            
             request.setAttribute("message","タスクの更新ができました");
	         RequestDispatcher dispatcher = request.getRequestDispatcher("/list");
	         dispatcher.forward(request, response);
	         
	 	}       	
     }
 }



