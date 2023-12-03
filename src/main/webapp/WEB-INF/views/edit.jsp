
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.* , java.util.ArrayList, model.Task , java.util.List" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/edit.css"> 
	  <% List <Task> todo = (List)request.getAttribute("todo"); %>
	  <title>Todoリスト編集画面</title>
	</head>	
	<body>
	    <main>
	    	<div class="editform">
	    		<% for(Task columns  : todo) { %>
			   <h1>Todoの編集</h1>	    
			    <form action="update" method="post">
				    <input type="hidden" name="taskNo" value='<%= request.getAttribute("taskNo")%>'><br>
				    <label for="date">作成日</label>
				    <input type="date"  class="inputtext" name="date" value='<%= columns.getDate()%>'><br>
				    <label for="deadline">期限　</label>
				    <input type="date"  class="inputtext" name="deadline" value='<%=columns.getDeadline()%>'><br>
				    <label for="task">タスク</label>
				    <input type="textarea"  class="inputtext" name="task" value='<%=columns.getTask() %>'><br>
				    <label for="importance">重要度</label>
				    <select name="importance"  class="inputtext" value='<%=columns.getImportance() %>'>
					    <option value="low">low</option>
					    <option value="normal">normal</option>
					    <option value="high">high</option>
				    </select><br>
				    <input id="submit" type="submit" value="保存する">
				    
				    <p class="error">${error}</p>
				    
				    <p><a href='list?id=<%=request.getAttribute("userId")%>'>変更せずに戻る</a></p>
			    </form>
			    
			     <% 
			       } //for文ここまで
			    %>
	    	</div>
	    </main>
	 </body>
</html>
