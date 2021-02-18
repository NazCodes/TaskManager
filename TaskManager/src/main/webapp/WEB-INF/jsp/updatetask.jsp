<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Task</title>
</head>
<body>
<form action='updatetaskpassed' method='POST'>  
        <div class="container">
        	<label>Update Email : </label>   
            <input type="text" placeholder="Enter Email" name="email" required>   
            <label>Update TaskName : </label>   
            <input type="text" placeholder="Enter Task Name" name="taskName" required>  
            <label>Update TaskDescription : </label>   
            <textarea placeholder="Enter Task Description" name ="taskDescription" rows="4" cols="50" required>
            </textarea>
            <label>Update StartDate : </label>   
            <input type="date" placeholder="mm-dd-yyyy" value="" min="01-01-2021" max="12-31-2021" name="startDate" required>
            <label>Update EndDate : </label>   
            <input type="date" placeholder="mm-dd-yyyy" value="" min="01-01-2021" max="12-31-2021" name="endDate" required>
            <label>Update Severity : </label>
            <select name="severity" required>
            <option value="high">High</option>
            <option value="medium">Medium</option>
            <option value="low">Low</option>
            </select>
            <br>
            <button type="submit">Update Task</button>     
        </div>   
    </form>     
</body>
</html>