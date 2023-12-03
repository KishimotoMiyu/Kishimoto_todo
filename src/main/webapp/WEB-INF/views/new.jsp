
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		  <meta charset="UTF-8">
		  <meta http-equiv="X-UA-Compatible" content="IE=edge">
		  <meta name="viewport" content="width=device-width, initial-scale=1.0">
		  <link rel="stylesheet" href="css/new.css"> 
		  <title>Todoリスト新規作成画面</title>
	</head>
	<body>
		<main>
			<div class="editform">
				 <h1>Todoの新規作成</h1>
			    <form action="new" method="post">
				    <label for="deadline">期限　</label>
				    <input  class="inputtext" type="date" name="deadline"><br>
				    <label for="task">タスク</label>
				    <input  class="inputtext" type="textarea" name="task"><br>
				    <label for="importance">重要度</label>
				    <select name="importance" class="inputtext">
					    <option value="low">low</option>
					    <option value="normal">normal</option>
					    <option value="high">high</option>
				    </select> <br>
				    <input id="submit" type="submit" value="保存する">
				    <p class="error">${error}</p>
				    <p><a href='list'>変更せずに戻る</a></p>
			    </form>
			</div>
		</main>
	</body>
</html>
