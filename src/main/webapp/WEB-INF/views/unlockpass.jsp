
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <link rel="stylesheet" href="css/change.css">
	  <title>パスワード再設定</title>
	   <% String userId = (String)request.getAttribute("userId");
	       String message = (String)request.getAttribute("message"); 
		   if(message == null){
		   	message = "パスワードを再設定してください";
		   }
	    %>
	</head>
	<body>
		<main>
			<div class="changeform">
				<p><%= message %></p>
			    <form action="unlockpassUpdate" method="post">
				    <input type="hidden" name="userId" value=<%= userId %>>
				    <input type="password" name="password">   
				    <input id="submit" type="submit" value="アカウントロックを解除する">
			    </form>  
			</div>
		</main>
	</body>
</html>
