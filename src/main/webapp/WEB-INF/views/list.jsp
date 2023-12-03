
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.* , java.util.ArrayList, model.Task , java.util.List ,model.Task ,service.CharacterCheck" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
	  <link rel="stylesheet" href="css/list.css">
	  <title>Todoリスト</title>
	  <%
		String userId =  (String)session.getAttribute("userId"); 
		String daysClass = null ;
		List <Task> todo = (List)request.getAttribute("todo");
		String message = (String)request.getAttribute("message");
		CharacterCheck cc = new CharacterCheck();
		if(message == null){
			message = "";}
		%>
	</head>	
	<body>
		<main>
		    <div class="nav_header">
			    <p>${userName}さんのTODOリスト</p>
				<nav>
					<ul>
						<li><a href ="new">新規作成</a></li>
						<li><a href="mypage">マイページ</a></li>
						<li><a href="logout">ログアウト</a></li>
					</ul>	
				</nav>
		    </div>
			
		    <p class="message"><%= message %></p>
		    
		   <table>
			  <thead>
			    <tr>
			      <th scope="col">タスク名</th>
			      <form  action="sort" method="get">
				      <th scope="col">作成日 
					      <button name="sort" type="submit" value="dateasc" >
						      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-up" viewBox="0 0 16 16">
			  				  	<path fill-rule="evenodd" d="M7.646 4.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1-.708.708L8 5.707l-5.646 5.647a.5.5 0 0 1-.708-.708l6-6z"/>
			  				  </svg>
		  				  </button>
		  				  <button name="sort" type="submit" value="linedesc">
			  				  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-down" viewBox="0 0 16 16">
			 				  	<path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
			 				  </svg>
		  				  </button>
	  				  </th>
				      <th scope="col">期限 
					      <button name="sort" type="submit" value="lineasc" >
						      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-up" viewBox="0 0 16 16">
			  				  	<path fill-rule="evenodd" d="M7.646 4.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1-.708.708L8 5.707l-5.646 5.647a.5.5 0 0 1-.708-.708l6-6z"/>
			  				  </svg>
		  				  </button>
		  				  <button name="sort" type="submit" value="linedesc">
			  				  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-down" viewBox="0 0 16 16">
			 				  	<path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
							  </svg>
		  				  </button>
	  				  </th>
				      <th scope="col">重要度 
					      <button name="sort" type="submit" value="imasc" >
						      <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-up" viewBox="0 0 16 16">
			  				  	<path fill-rule="evenodd" d="M7.646 4.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1-.708.708L8 5.707l-5.646 5.647a.5.5 0 0 1-.708-.708l6-6z"/>
			  				  </svg>
		  				  </button>
	  				  	  <button name="sort" type="submit" value="imdesc">
	  				  	    	<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-chevron-down" viewBox="0 0 16 16">
	 				  				<path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
					  			</svg>
	  				 	  </button>
	  				 </th>
			      </form>
			      <th scope="col"></th>
			      <th scope="col"></th>
			    </tr>
			  </thead>
			  <tbody>
			        <%
			        	for(Task columns  : todo) {  
			        %>
				    <tr class='<%= cc.daysUpToDeadline(columns.getDeadline()) %>'>
				      <th  class="task" scope="row"><%= columns.getTask() %>︎</th>
				      <td><span><%= cc.dateReplacement(columns.getDate()) %></td>
				      <td><span><%= cc.dateReplacement(columns.getDeadline()) %></td>
				      <td>︎<%= columns.getImportance() %></td>
				      <td><button><a href='update?taskNo=<%= columns.getTaskNo() %>'>編集</a></button></td>
				      <td>︎<button><a href='delete?taskNo=<%= columns.getTaskNo() %>'>削除</a></button></td>
				    </tr>
				    <% 
				       } //for文ここまで
				    %>
		     	 </tbody>	
	   		 </table>
		</main>
	<!-- <h1 id="testdesu">Todoリスト</h1> JS接続確認
	<script src="js/list.js"></script> 
	-->
	</body>
</html>
