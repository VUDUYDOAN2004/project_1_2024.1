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
                            <input type="text" placeholder="Tìm kiếm sản phẩm..." name="name"
							value="${name != null ? name : ''}">
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
                        <a href="/login" class="btn-login">Đăng nhập</a>
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
                        <input class="form-control" type="number" id="minprice" name="minprice" placeholder="0"
						 value="${minprice != null ? minprice : '0'}">
                    </div>
                    <div>
                        <label for="maxprice">Giá tối đa:</label>
                        <input class="form-control" type="number" id="maxprice" name="maxprice" placeholder=""
						value="${maxprice != null ? maxprice : ''}">
                    </div>

					<!-- <div>
					    <label for="sizeFilter">Kích thước:</label>
					    <select class="form-control"  id="sizeFilter" name="size">
					        <option value="">Tất cả</option>
					        <option value="S">S</option>
					        <option value="M">M</option>
					        <option value="XL">XL</option>
					        <option value="XXL">XXL</option>
					    </select>
					</div> -->
					<div>
						<label for="categoryFilter">Thể loại</label>
						<select class="form-control" id="categoryFilter" name="category">
						    <option value="" ${category == null || category == '' ? 'selected' : ''}>Tất cả</option>
						    <option value="QUẦN ÁO BÓNG ĐÁ" ${category == 'QUẦN ÁO BÓNG ĐÁ' ? 'selected' : ''}>QUẦN ÁO BÓNG ĐÁ</option>
						    <option value="QUẦN ÁO THỦ MÔN" ${category == 'QUẦN ÁO THỦ MÔN' ? 'selected' : ''}>QUẦN ÁO THỦ MÔN</option>
						    <option value="QUẦN ÁO BÓNG ĐÁ THEO MÀU" ${category == 'QUẦN ÁO BÓNG ĐÁ THEO MÀU' ? 'selected' : ''}>QUẦN ÁO BÓNG ĐÁ THEO MÀU</option>
						    <option value="QUẦN ÁO BÓNG CHUYỀN" ${category == 'QUẦN ÁO BÓNG CHUYỀN' ? 'selected' : ''}>QUẦN ÁO BÓNG CHUYỀN</option>
						    <option value="QUẦN ÁO BÓNG RỔ" ${category == 'QUẦN ÁO BÓNG RỔ' ? 'selected' : ''}>QUẦN ÁO BÓNG RỔ</option>
						    <option value="QUẦN ÁO CẦU LÔNG" ${category == 'QUẦN ÁO CẦU LÔNG' ? 'selected' : ''}>QUẦN ÁO CẦU LÔNG</option>
						    <option value="THỜI TRANG THỂ THAO" ${category == 'THỜI TRANG THỂ THAO' ? 'selected' : ''}>THỜI TRANG THỂ THAO</option>
						    <option value="PHỤ KIỆN" ${category == 'PHỤ KIỆN' ? 'selected' : ''}>PHỤ KIỆN</option>
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
									<a href="#"><img src="/images/${product.image_url}" alt="${product.product_name}"></a>
									<div class="pro_name"><a href="#"><h6>${product.product_name}</h6></a></div>
									<select class="form-control size-select" name="size">
														        
														        <option value="1">Size S</option>
														        <option value="2">Size M</option>
														        <option value="3"> Size L</option>
														        <option value="4">Size XL</option>
									</select>
									<!-- Input số lượng -->
									     <!--   <input type="number" class="form-control quantity-input" value="1" min="1" -->
									<p>Giá: ${product.price} đ </p>
									<p>					<button class="btn addtocart" data-id="${product.product_id}" data-cart-id="1">
														        Thêm vào giỏ hàng
														</button></p>
									
								</div>
							</c:forEach>
	        </div>
	    </div>

		<script src="/js/jquery-3.7.1.min.js"></script>
				<script>
					$(document).ready(function () {
					        // Xử lý sự kiện click vào nút "Thêm vào giỏ hàng"
					        $('.addtocart').on('click', function (e) {
					            e.preventDefault(); // Ngăn hành vi mặc định của nút

					            // Lấy thông tin sản phẩm
					            const productId = $(this).data('id'); // ID sản phẩm
					            const cartId = $(this).data('cart-id'); // ID giỏ hàng
					            const parent = $(this).closest('.product-item'); // Container của sản phẩm
					            const sizeId = parent.find('.size-select').val(); // ID size
					            

								

					            // Gửi yêu cầu AJAX tới server
					            $.ajax({
					                url: '/cart/add', // URL API
					                type: 'POST', // Phương thức POST
					                contentType: 'application/x-www-form-urlencoded', // Kiểu dữ liệu gửi đi
					                data: {
					                    cart_id: cartId,
					                    product_id: productId,
					                    size_id: sizeId,
					                    quantity: 1
					                },
					                success: function (response) {
										
										alert('Sản phẩm đã được thêm vào giỏ hàng!');
					                },
					                error: function (xhr, status, error) {
					                    console.error('Lỗi khi thêm vào giỏ hàng:', error);
					                    alert('Có lỗi xảy ra khi thêm vào giỏ hàng. Vui lòng thử lại.');
					                }
					            });
					        });
					    });

				</script>

</body>

</html>