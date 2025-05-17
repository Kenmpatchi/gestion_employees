<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create Account | Course Management</title>
    <style>
        :root {
            --primary: #4361ee;
            --primary-dark: #3a0ca3;
            --text: #2b2d42;
            --light: #f8f9fa;
            --white: #ffffff;
            --error: #ef233c;
            --success: #4cc9f0;
        }

        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background-color: var(--light);
            color: var(--text);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 2rem;
        }

        .signup-container {
            background-color: var(--white);
            border-radius: 12px;
            box-shadow: 0 6px 18px rgba(0, 0, 0, 0.1);
            padding: 2.5rem;
            width: 100%;
            max-width: 500px;
        }

        .signup-header {
            margin-bottom: 2rem;
            text-align: center;
        }

        .signup-header h1 {
            color: var(--primary);
            font-size: 2rem;
            margin-bottom: 0.5rem;
        }

        .signup-form {
            display: flex;
            flex-direction: column;
            gap: 1.25rem;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            gap: 0.5rem;
        }

        .form-group label {
            font-weight: 600;
            color: var(--text);
            font-size: 0.9rem;
        }

        .form-group input {
            padding: 0.8rem;
            border: 1px solid #ddd;
            border-radius: 6px;
            font-size: 1rem;
            transition: all 0.3s ease;
        }

        .form-group input:focus {
            outline: none;
            border-color: var(--primary);
            box-shadow: 0 0 0 3px rgba(67, 97, 238, 0.2);
        }

        .form-row {
            display: flex;
            gap: 1rem;
        }

        .form-row .form-group {
            flex: 1;
        }

        .submit-btn {
            background-color: var(--primary);
            color: white;
            border: none;
            padding: 1rem;
            border-radius: 6px;
            font-size: 1rem;
            font-weight: 600;
            cursor: pointer;
            transition: background-color 0.3s ease;
            margin-top: 0.5rem;
        }

        .submit-btn:hover {
            background-color: var(--primary-dark);
        }

        .login-link {
            margin-top: 1.5rem;
            text-align: center;
            font-size: 0.9rem;
        }

        .login-link a {
            color: var(--primary);
            text-decoration: none;
            font-weight: 600;
            transition: color 0.3s ease;
        }

        .login-link a:hover {
            color: var(--primary-dark);
            text-decoration: underline;
        }

        @media (max-width: 480px) {
            .form-row {
                flex-direction: column;
                gap: 1.25rem;
            }

            .signup-container {
                padding: 1.5rem;
            }
        }
    </style>
</head>
<body>
<div class="signup-container">
    <div class="signup-header">
        <h1>Create Your Account</h1>
        <p>Join us to get started with course management</p>
    </div>

    <form action="account" method="get" class="signup-form">
        <div class="form-row">
            <div class="form-group">
                <label for="first_name">First Name</label>
                <input
                        type="text"
                        id="first_name"
                        name="first_name"
                        placeholder="John"
                        required
                >
            </div>

            <div class="form-group">
                <label for="last_name">Last Name</label>
                <input
                        type="text"
                        id="last_name"
                        name="last_name"
                        placeholder="Doe"
                        required
                >
            </div>
        </div>

        <div class="form-group">
            <label for="email">Email Address</label>
            <input
                    type="email"
                    id="email"
                    name="email"
                    placeholder="john@example.com"
                    required
            >
        </div>

        <div class="form-group">
            <label for="phone">Phone Number</label>
            <input
                    type="tel"
                    id="phone"
                    name="phone"
                    placeholder="1234567890"
                    pattern="[0-9]{8}"
                    title="10 digit phone number"
                    required
            >
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input
                    type="password"
                    id="password"
                    name="password"
                    placeholder="••••••••"
                    minlength="8"
                    required
            >
        </div>

        <div class="form-group">
            <label for="valpass">Confirm Password</label>
            <input
                    type="password"
                    id="valpass"
                    name="valpass"
                    placeholder="••••••••"
                    minlength="8"
                    required
            >
        </div>

        <input type="submit" class="submit-btn" value="sign up">
    </form>

    <div class="login-link">
        Already have an account? <a href="login.jsp">Sign in here</a>
    </div>
</div>
</body>
</html>