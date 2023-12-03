
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
	  <meta charset="UTF-8">
	  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	  <title>パスワード変更</title>
	  <link rel="stylesheet" href="css/change.css">
	  <% 
	       String my = (String)request.getAttribute("my");
	       String message = (String)request.getAttribute("message"); 
		   if(message == null){
		   	message = "下記の項目を入力してください";
		   }
	  %>
	</head>
	<body>
		<main>
			<div class="changeform">
				<p><%= message %></p>
			    <form action="change" method="post">
				    <input type="hidden" name="my" value=<%= my %>>
				    <div class="pass_form">
					    <input id="password" type="password" name="change">
					    <button id="btn_passview">表示</button>
				    </div>
				    <input id="submit" type="submit" value="パスワードを変更する">
			    </form>  
			    <p><a href="mypage">マイページに戻る</a></p>		
			</div>
		</main>
		<script>
			   let btn = document.getElementById("btn_passview");
			   let pass = document.getElementById("password");

		        	btn.addEventListener("click", (e)=>{

		        		e.preventDefault();

		        		if( pass.type === 'password' ) {

		        			pass.type = 'text';
		        			btn.textContent = "非表示";

		        		} else {

		        			pass.type = 'password';
		        			btn.textContent = "表示";
		        			
		        		}	        
		        }); 
			</script>
	 </body>
</html>
