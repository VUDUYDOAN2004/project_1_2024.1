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
                            <li><a href="/orders">Đơn hàng</a></li>
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

    <div class="order-section"> 
        <div class="container"> 
            <div class="row"> 
                <div class="col-9"> 
                    <div class="table-cart"> 
                        <h2>Chi tiết đơn hàng </h2> 
						<c:set var="totalAmount" value="0" />
                        <c:forEach var="orderitem" items="${orderitems}">						
							<div class="order-item">
							    <div class="left-item">
							        <div class="img-item">
							            <img src="/images/${orderitem.product.image_url}" alt="">
							        </div>
							    </div>
							    <div class="right-item">
							        <div class="item-info">
							            <div class="small-text">${orderitem.product.product_name}</div>
							            <div class="item-size">
							                <span>${orderitem.size.size_name}</span>
							            </div>
							        </div>
							        <div class="item-quantity">
							            <p>
							                <span class="quantity">Số lượng: ${orderitem.product.quantity}₫</span>
							            </p>
							        </div>
							        <div class="item-price">
							            <p>
							                <span class="price">Đơn giá: ${orderitem.product.price}₫</span>
							            </p>
							        </div>
							        
							        
							    </div>
							</div>
							<c:set var="totalAmount" value="${totalAmount + (cartitem.quantity * cartitem.product.price)}" />
						</c:forEach>
                    </div> 
                </div> 
                <div class="col-3 fixed-thanhtoan"> 
                    <div class="order-summary-block"> 
                        <h2>Thông tin đơn hàng</h2> 
                        <div class="summary-total"> 
                            <p>Tổng tiền: <span class="final-price">${totalAmount}₫</span> 
                            </p> 
                        </div> 
                        
                    </div> 
                </div> 
            </div> 
        </div> 
    </div> 

</body> 

</html>