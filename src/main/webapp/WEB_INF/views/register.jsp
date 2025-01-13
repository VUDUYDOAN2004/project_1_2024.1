<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css"
          integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
          integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/styles.css">
    <style>
        body {
            background-color: #2a8da1;
        }
        .register-container {
            max-width: 500px;
            margin: 50px auto;
            padding: 30px;
            background: #ffffff;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border: var(--color-one) solid 30px;
        }
        .form-control:focus {
            box-shadow: none;
            border-color: var(--color-one);
        }
        .btn-primary {
            background-color: var(--color-one);
            border-color: var(--color-one);
        }
    </style>
</head>
<body>
    <header class="header">
        <div class="header-top">PROJECT 1 SHOP BÁN ĐỒ THỂ THAO</div>
    </header>
    <div class="register-container">
        <h3 class="text-center mb-4">Đăng ký</h3>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success" role="alert">
                ${successMessage}
            </div>
        </c:if>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorMessage}
            </div>
        </c:if>
        <form action="/register" method="post">
            <div class="mb-3">
                <label for="user_name" class="form-label">Tên đăng nhập</label>
                <input type="text" class="form-control" id="user_name" placeholder="Nhập tên đăng nhập" name="user_name" required>
            </div>
            <div class="mb-3">
                <label for="password_hash" class="form-label">Mật khẩu</label>
                <input type="password" class="form-control" id="password_hash" placeholder="Nhập mật khẩu" name="password_hash" required>
            </div>
            <div class="mb-3">
                <label for="full_name" class="form-label">Họ và tên</label>
                <input type="text" class="form-control" id="full_name" placeholder="Nhập họ và tên" name="full_name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" placeholder="Nhập email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="phone_number" class="form-label">Số điện thoại</label>
                <input type="text" class="form-control" id="phone_number" placeholder="Nhập số điện thoại" name="phone_number">
            </div>
            <div class="mb-3">
                <label for="address" class="form-label">Địa chỉ</label>
                <input type="text" class="form-control" id="address" placeholder="Nhập địa chỉ" name="address">
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
        </form>
        <div class="text-center mt-3">
            Đã có tài khoản? <a href="/login">Đăng nhập</a>
        </div>
    </div>
</body>
</html>