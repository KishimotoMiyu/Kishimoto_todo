<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="UTF-8">
			<link href="css/todologin.css" rel="stylesheet">
			<title>TODOアプリログイン画面</title>
			<% 
			String message = (String)request.getAttribute("message");
			if(message == null){
				message = "";
			}
			%>
		</head>
		<body>	
			<main>
				<div class="login_form">
					<h1>ログイン</h1>
					<p><%= message %></p>
				    <form action="login" method="post">
					    <input class="input_text" type="text" name="userId" placeholder="ユーザーID">
					    <div class="pass_form">
						    <input class="input_text" id="password" type="password" name="password" placeholder="パスワード">
						    <button id="btn_passview">表示</button>
					    </div>
					    <input class="submit" type="submit" value="送信">
				    </form>
				    <p>アカウントをお持ちでない場合はこちらから<br><a href="createUser">アカウントを作成する</a></p>
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