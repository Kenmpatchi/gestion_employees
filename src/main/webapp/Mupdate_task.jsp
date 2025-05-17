<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Course</title>
    <style>
        :root {
            --primary-color: #4a6fa5;
            --secondary-color: #166088;
            --background-color: #f8f9fa;
            --text-color: #333;
            --border-color: #ddd;
            --hover-color: #0e4d7a;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: var(--background-color);
            color: var(--text-color);
            margin: 0;
            padding: 20px;
            line-height: 1.6;
        }

        .form-container {
            max-width: 800px;
            margin: 30px auto;
            padding: 30px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: var(--secondary-color);
            margin-bottom: 30px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-weight: 600;
            color: var(--secondary-color);
        }

        .form-group input[type="text"],
        .form-group textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid var(--border-color);
            border-radius: 4px;
            font-size: 16px;
            transition: border 0.3s ease;
        }

        .form-group textarea {
            min-height: 150px;
            resize: vertical;
        }

        .form-group input[type="text"]:focus,
        .form-group textarea:focus {
            border-color: var(--primary-color);
            outline: none;
            box-shadow: 0 0 0 2px rgba(74, 111, 165, 0.2);
        }

        .submit-btn {
            background-color: var(--primary-color);
            color: white;
            border: none;
            padding: 12px 24px;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
            display: block;
            width: 100%;
            margin-top: 20px;
        }

        .submit-btn:hover {
            background-color: var(--hover-color);
        }

        .hidden-field {
            display: none;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1>Update Course Information</h1>

    <form action="updateTask" method="get">
        <div class="form-group">
            <label for="name">Task Name:</label>
            <input type="text" id="name" name="name" placeholder="Enter task name">
        </div>

        <div class="form-group">
            <label for="title">task Title:</label>
            <input type="text" id="title" name="title" placeholder="Enter task title">
        </div>

        <div class="form-group">
            <label for="description">task Description:</label>
            <input type="text" id="description" name="description" placeholder="Enter course description">
        </div>

        <div class="form-group">
            <label for="main_content">task Content:</label>
            <textarea id="main_content" name="main_content" placeholder="Enter the detailed task content"></textarea>
        </div>

        <input type="hidden" name="task_id" value="<%=request.getParameter("task_id")%>" class="hidden-field">

        <button type="submit" class="submit-btn">Update Course</button>
    </form>
</div>
</body>
</html>