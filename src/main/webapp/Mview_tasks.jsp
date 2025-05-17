<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>tasks List</title>
    <style>
        :root {
            --primary-color: #4361ee;
            --secondary-color: #3a0ca3;
            --text-color: #2b2d42;
            --light-color: #f8f9fa;
            --border-color: #dee2e6;
            --shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        body {
            font-family: 'Segoe UI', system-ui, sans-serif;
            background-color: #f5f7ff;
            color: var(--text-color);
            margin: 0;
            padding: 2rem;
            line-height: 1.6;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
        }

        .header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 2rem;
        }

        h1 {
            color: var(--secondary-color);
            margin: 0;
        }

        .add-btn {
            background-color: var(--primary-color);
            color: white;
            padding: 0.75rem 1.5rem;
            text-decoration: none;
            border-radius: 6px;
            font-weight: 600;
            transition: background-color 0.3s;
        }

        .add-btn:hover {
            background-color: var(--secondary-color);
        }

        .courses-list {
            background: white;
            border-radius: 8px;
            box-shadow: var(--shadow);
            padding: 1.5rem;
        }

        /* Style for the ${tasks} content - adjust based on your actual output */
        .course-item {
            padding: 1rem;
            border-bottom: 1px solid var(--border-color);
        }

        .course-item:last-child {
            border-bottom: none;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Tasks</h1>
        <a href="AddTask.jsp?group_id=${param.group_id}" class="add-btn">Add New Task</a>
    </div>

    <div class="courses-list">
        ${tasks}
    </div>
</div>
</body>
</html>