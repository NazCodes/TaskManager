<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='deletetaskpassed' method='POST'>  
        <div class="container">
        	<label>Delete Task : </label>   
            <input type="text" placeholder="Enter Task To Delete" name="taskName" required>   
            <br>
            <button type="submit">Delete Task</button>     
        </div>   
    </form>     
</body>
</html>