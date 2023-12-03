<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>TODOアプリアカウント新規作成画面</title>
	<link rel="stylesheet" href="css/todocreateuser.css">
	<% 
		String message = (String)request.getAttribute("message");
		if(message == null){message = "下記項目を入力してください";}
	%>
	</head>
	<body>
		<main>
			<div class="createform">
			
				<h1>アカウント新規登録</h1>
				<p>${message}</p>
				
			    <form action="createUser" method="post">		    
				    <label>ユーザーID</label><br>
				    <input class="inputtext" type="text" name="userId" value=${userId} ><br>
				    
				    <label>ユーザーネーム</label><br>
				    <input class="inputtext" type="text" name="userName" value=${userName}><br>
				    
				    <label>パスワード</label><br>
				    <input class="inputtext" type="password" name="password"><br>
				    
				     <label>生年月日<span>※半角数字で入力してください</span></label><br>
				    <input class="inputtext hide-spin" type="number" name="birthday" placeholder="20230101" value=${birthday}><br>
				    
				    <label>プロフィール</label><br>
				    <textarea name="profile" value=${profile}></textarea><br>
				    
				    <input class="submit" type="submit" value="ユーザー登録をする">
				     <a href="login">ログイン画面に戻る</a>
			    </form>  
			</div>
		</main>
	</body>
</html>