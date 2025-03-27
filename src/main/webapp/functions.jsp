<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>My Profile</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        .profile-container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        .profile-container h1 {
            text-align: center;
        }
        .profile-field {
            margin-bottom: 15px;
        }
        .profile-field label {
            font-weight: bold;
        }
        .profile-field span {
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="profile-container">
        <h1>My Profile</h1>
        <div class="profile-field">
            <label>Username:</label>
            <span>${sessionScope.username}</span>
        </div>
        <div class="profile-field">
            <label>Email:</label>
            <span>${sessionScope.email}</span>
        </div>
        <div class="profile-field">
            <label>Full Name:</label>
            <span>${sessionScope.fullName}</span>
        </div>
        <div class="profile-field">
            <label>Role:</label>
            <span>${sessionScope.role}</span>
        </div>
        <div style="text-align: center;">
            <a href="editProfile.jsp">Edit Profile</a> | <a href="logout.jsp">Logout</a>
        </div>
    </div>
</body>
</html>