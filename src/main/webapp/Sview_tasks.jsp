
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <style>
        :root {
            --primary-color: #4361ee;
            --secondary-color: #3a0ca3;
            --text-color: #2b2d42;
            --light-color: #f8f9fa;
            --border-color: #dee2e6;
            --shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            --radius: 8px;
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
            margin-bottom: 2rem;
            text-align: center;
        }

        h1 {
            color: var(--secondary-color);
            margin: 0 0 1rem 0;
        }

        .users-container {
            background: white;
            border-radius: var(--radius);
            box-shadow: var(--shadow);
            padding: 2rem;
            overflow-x: auto;
        }


        .users-table {
            width: 100%;
            border-collapse: collapse;
        }

        .users-table th {
            background-color: var(--primary-color);
            color: white;
            padding: 1rem;
            text-align: left;
        }

        .users-table td {
            padding: 0.75rem 1rem;
            border-bottom: 1px solid var(--border-color);
        }

        .users-table tr:hover {
            background-color: rgba(67, 97, 238, 0.05);
        }

        .no-users {
            text-align: center;
            color: #666;
            padding: 2rem;
            font-style: italic;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Task Management</h1>
    </div>

    <div class="users-container">
        <%-- Display users with proper HTML escaping --%>
        <c:choose>
            <c:when test="${not empty tasks}">
                ${tasks}
            </c:when>
            <c:otherwise>
                <div class="no-users">No tasks found</div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>