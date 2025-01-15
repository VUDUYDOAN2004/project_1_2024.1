<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Theo dõi đơn hàng</title>
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
                            <li><a href="/orders">Theo dõi đơn hàng</a></li>
                        </ul>
                    </div>
                    <div class="login-link">
                        <c:choose>
                            <c:when test="${not empty sessionScope.user}">
                                <a href="<c:url value='/logout' />" class="btn-logout">Đăng xuất</a>
                            </c:when>
                            <c:otherwise>
                                 <a href="/logout" class="btn-logout">Đăng xuất</a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <div class="container">
        <h1>Theo dõi đơn hàng</h1>
        <c:forEach var="order" items="${orders}">
            <div class="order">
                <h2>Đơn hàng #${order.orderId}</h2>
                <p>Ngày đặt hàng: ${order.orderDate}</p>
                <p>Tổng tiền: ${order.totalAmount}₫</p>
                <a href="/orders/${order.orderId}" class="btn btn-info">Chi tiết</a>
            </div>
        </c:forEach>
    </div>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
