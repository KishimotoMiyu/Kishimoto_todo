
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>アカウントロック解除画面</title>
	  <link rel="stylesheet" href="css/todocreateuser.css"> 
	   <% 
	       String message = (String)request.getAttribute("message"); 
		   if(message == null){
		   	message = "下記の項目を入力してください";
		   }
	    %>
	</head>
	<body>
		<main>
			<div class="createform">
				<p><%= message %></p> <!-- 17行目で格納したメッセージを表示する　表示の際は＝が必要 -->
			    <h1>アカウントロック解除画面です</h1>
		
			    <form action="unlock" method="post">
				    <div class="form">
					    <label for="userid">ユーザーID :</label><br>
					    <input class="inputtext" type="text" name="userId"><br>
					    
					    <label for="userName">ユーザーネーム :</label><br>
					    <input class="inputtext" type="text" name="userName"><br>
					    
					     <label for="birthday">誕生日 :</label><br>
					    <input class="inputtext hide-spin" type="number" name="birthday" placeholder="20230101"><br>
					    
					    <input class="submit" type="submit" value="次へ">
					    <a href="login">ログイン画面に戻る</a>
				    </div>
			    </form> 	
			</div>
		</main>
	    </body>
</html>
