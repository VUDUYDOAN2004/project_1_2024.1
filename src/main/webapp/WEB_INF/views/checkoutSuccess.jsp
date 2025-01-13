<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Thanh toán thành công</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.1/css/all.min.css" 
        integrity="sha512-5Hs3dF2AEPkpNAR7UiOHba+lRSJNeM2ECkwxUIxC1Q/FLycGTbNapWXB4tP889k5T5Ju8fs4b1P5z/iB4nMfSQ==" 
        crossorigin="anonymous" referrerpolicy="no-referrer" /> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" 
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="/css/reset.css">
    <link rel="stylesheet" href="/css/base.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <header class="header">
        <div class="header-top">PROJECT 1 SHOP BÁN ĐỒ THỂ THAO</div>
        <div class="header-main">
            <div class="container">
                <div class="inner-wrap">
                    <div class="inner-logo">
                        <a href="index.html"><img src="/images/logo.png" alt="Logo"></a>
                    </div>
                    <div class="inner-menu">
                        <ul>
                            <li><a href="/">Trang chủ</a></li>
                            <li><a href="/products">Sản phẩm</a></li>
                            <li><a href="/cart">Giỏ hàng</a></li>
                        </ul>
                    </div>
                    <div class="login-link">
                        <a href="/login" class="btn-login">Đăng nhập</a>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <div class="checkout-success">
            <h1>Thanh toán thành công!</h1>
            <p>Cảm ơn bạn đã mua hàng. Đơn hàng của bạn đã được xử lý thành công.</p>
            <a href="/" class="btn btn-primary">Quay lại trang chủ</a>
        </div>
    </div>
</body>
</html>
