<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Group</title>
    <style>
        :root {
            --primary: #4361ee;
            --primary-dark: #3a56d4;
            --text: #2b2d42;
            --light: #f8f9fa;
            --border: #dee2e6;
            --shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            --radius: 8px;
        }

        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: #f5f7ff;
            color: var(--text);
            margin: 0;
            padding: 2rem;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        .form-card {
            background: white;
            padding: 2.5rem;
            border-radius: var(--radius);
            box-shadow: var(--shadow);
            width: 100%;
            max-width: 500px;
        }

        .form-title {
            margin-top: 0;
            margin-bottom: 2rem;
            color: var(--primary);
            text-align: center;
            font-size: 1.75rem;
        }

        .form-group {
            margin-bottom: 1.5rem;
        }

        .form-label {
            display: block;
            margin-bottom: 0.5rem;
            font-weight: 600;
            color: var(--text);
        }

        .form-input {
            width: 100%;
            padding: 0.75rem 1rem;
            border: 1px solid var(--border);
            border-radius: var(--radius);
            font-size: 1rem;
            transition: border-color 0.3s, box-shadow 0.3s;
        }

        .form-input:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.2);
        }

        .submit-btn {
            background-color: var(--primary);
            color: white;
            border: none;
            padding: 0.75rem 1.5rem;
            font-size: 1rem;
            font-weight: 600;
            border-radius: var(--radius);
            cursor: pointer;
            width: 100%;
            transition: background-color 0.3s;
        }

        .submit-btn:hover {
            background-color: var(--primary-dark);
        }

        .hidden-field {
            display: none;
        }
    </style>
</head>
<body>
<div class="form-card">
    <h1 class="form-title">Update Group Information</h1>

    <form action="update" method="get">
        <div class="form-group">
            <label for="name" class="form-label">Group Name</label>
            <input type="text" id="name" name="name" class="form-input" placeholder="Enter group name">
        </div>

        <div class="form-group">
            <label for="theme" class="form-label">Group Theme</label>
            <input type="text" id="theme" name="theme" class="form-input" placeholder="Enter group theme">
        </div>

        <input type="hidden" name="group_id" value="<%=request.getParameter("group_id")%>" class="hidden-field">
        <input type="hidden" name="manager_id" value="<%=request.getParameter("manager_id")%>" class="hidden-field">

        <button type="submit" class="submit-btn">Update Group</button>
    </form>
</div>
</body>
</html>