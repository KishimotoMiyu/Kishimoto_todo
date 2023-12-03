
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>プロフィール変更</title>
	  <link rel="stylesheet" href="css/change.css">
	  <% 
	       String my = (String)request.getAttribute("my");
	       String message = (String)request.getAttribute("message"); 
		   if(message == null){
		   	message = "下記の項目を入力してください";}
	   %>
	</head>
	<body>
		<main>
			<div class="changeform">
				<p><%= message %></p>
			    <form action="change" method="post">
				    <input type="hidden" name="my" value=<%= my %>>
				    <textarea name="change" placeholder="${profile}"></textarea><br>
				    <input id="profilesubmit" type="submit" value="プロフィールを変更する">
			    </form>  
			    <p><a href="mypage">マイページに戻る</a></p>
			</div>
		</main>
	</body>
</html>
