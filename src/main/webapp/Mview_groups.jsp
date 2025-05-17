<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Groups List</title>
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
            display: inline-flex;
            align-items: center;
            gap: 0.5rem;
        }

        .add-btn:hover {
            background-color: var(--secondary-color);
        }

        .groups-list {
            background: white;
            border-radius: 8px;
            box-shadow: var(--shadow);
            padding: 1.5rem;
        }

        /* Style for the ${groups} content - adjust based on your actual output */
        .group-item {
            padding: 1rem;
            border-bottom: 1px solid var(--border-color);
        }

        .group-item:last-child {
            border-bottom: none;
        }

        .heart-icon {
            color: #ff6b6b;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>Groups</h1>
        <a href="add_groups.jsp?manager_id=${manager_id}" class="add-btn">
            Add Group <span class="heart-icon">❤️</span>
        </a>
    </div>

    <div class="groups-list">
        ${groups}
    </div>
</div>
</body>
</html>