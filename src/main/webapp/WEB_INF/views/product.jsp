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
                        <form action="/products/name" method="GET">
                            <input type="text" placeholder="Tìm kiếm sản phẩm..." name="name">
                            <button type="submit">
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
    </header>

    <div class="container mt-4">
        <h2>Lọc Sản Phẩm</h2>
        <div class="filter">
            <form action="/products/filter" method="GET">
                <div class="inner-wrap form-group">
                    
                    <div>
                        <label for="minprice">Giá tối thiểu:</label>
                        <input class="form-control" type="number" id="minprice" name="minprice" placeholder="0">
                    </div>
                    <div>
                        <label for="maxprice">Giá tối đa:</label>
                        <input class="form-control" type="number" id="maxprice" name="maxprice" placeholder="1000000">
                    </div>

                    <div>
                        <label for="sizeFilter">Kích thước:</label>
	                    <select class="form-control"  id="sizeFilter" name="size">
	                        <option value="">Tất cả</option>
	                        <option value="S">S</option>
	                        <option value="M">M</option>
	                        <option value="XL">XL</option>
	                        <option value="XXL">XXL</option>
	                    </select>
                    </div>
                    <div>
                        <input class="btn" type="submit" value="Lọc" id="productFilter">
                    </div>
                    
                </div>

            </form>
        </div>
    </div>
	
	<div class="container products">
	        <div class="row mt-3">
				<c:forEach var="product" items="${products}">
					<div class="col-md-4 product-item text-center">
						<a href="#"><img src="${product.image_url}" alt="${product.product_name}" class="img-fluid"></a>
						<a href="#"><h6>${product.product_name}</h6></a>
						<p>Giá: ${product.price}</p>
						<p>					<button class="btn addtocart" data-id="${product.product_id}">
																        Thêm vào giỏ hàng
																</button></p>
					</div>
				</c:forEach>
	        </div>
	    </div>

    <script src="assets/js/jquery-3.7.1.min.js"></script>
    <script>
        $('#productFiler').click(
            $.ajax({
                type: "GET",
                url: "http://localhost:8081/products/filters/",

            })
        );
    </script>

</body>

</html>