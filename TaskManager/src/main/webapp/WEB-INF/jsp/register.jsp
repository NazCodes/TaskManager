<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<form action='registertaskuserpassed' method = 'POST'>  
        <div class="container">
        	<label>Email : </label>   
            <input type="text" placeholder="Register Email" name="userEmail" required>     
            <label>Username : </label>   
            <input type="text" placeholder="Register Username" name="userName" required>  
            <label>Password : </label>   
            <input type="password" placeholder="Register Password" name="password" required>  
            <button type="submit">Register</button>     
        </div>   
    </form>     
</body>
</html>