<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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


	                   <div class="search-bar position-relative">
	                       <form action="/products/name" method="GET" id="productNameForm">
	                           <input type="text" placeholder="Tìm kiếm sản phẩm..." name="name"
							   value="${name != null ? name : ''}">
	                           <button type="submit" id="btnSearchProduct">
	                               <i class="fas fa-search"></i>
	                           </button>
	                       </form>
	                   </div>


	                   <div class="inner-menu">
	                       <ul>
	                           <li><a href="/">Trang chủ</a></li>
	                           <li><a href="/products">Sản phẩm</a></li>
	                           <li><a href="/cart">Giỏ hàng</a></li>
	                       </ul>
	                   </div>

	                   <div class="login-link">
	                       <a href="login.html" class="btn-login">Đăng nhập</a>
	                   </div>
	               </div>
	           </div>
	       </div>
	       <div class="container">
	           <div class="header-category">
	               <div class="inner-wrap small-text">
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO BÓNG ĐÁ">QUẦN ÁO BÓNG ĐÁ</a>
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO THỦ MÔN">QUẦN ÁO THỦ MÔN</a>
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO BÓNG ĐÁ THEO MÀU">QUẦN ÁO BÓNG ĐÁ THEO MÀU</a>
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO BÓNG CHUYỀN">QUẦN ÁO BÓNG CHUYỀN</a>
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO BÓNG RỔ">QUẦN ÁO BÓNG RỔ</a>
	                   <a class="category-item" href="/products/category?category=QUẦN ÁO CẦU LÔNG">QUẦN ÁO CẦU LÔNG</a>
	                   <a class="category-item" href="/products/category?category=THỜI TRANG THỂ THAO">THỜI TRANG THỂ THAO</a>
	                   <a class="category-item" href="/products/category?category=PHỤ KIỆN">PHỤ KIỆN</a>
	               </div>
	           </div>
	       </div>
	   </header>
	
	
    
    <!-- <div class="banner text-center">
        <img src="assets/images/banner.jpg" alt="Banner Shop" class="img-fluid">
    </div> -->
	
    <div class="container products">
        <div class="row mt-3">
			<c:forEach var="product" items="${products}">
				<div class="col-md-4 product-item text-center">
					<a href="#"><img src="/images/${product.image_url}" alt="${product.product_name}" class="img-fluid"></a>
					<a href="#"><h6>${product.product_name}</h6></a>
					<select class="form-control"  id="sizeFilter" name="size">
										        
										        <option value="S">Size S</option>
										        <option value="M">Size M</option>
										        <option value="XL"> Size XL</option>
										        <option value="XXL">Size XXL</option>
					</select>
					<p>Giá: ${product.price} đ </p>
					<p>					<button class="btn addtocart" data-id="${product.product_id}">
										        Thêm vào giỏ hàng
										</button></p>
					
				</div>
			</c:forEach>
        </div>
    </div>

    <!-- Footer -->
    <footer>
        
    </footer>

   

</body>

</html>