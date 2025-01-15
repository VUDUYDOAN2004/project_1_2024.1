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

    <div class="cart-section"> 
        <div class="container"> 
            <div class="row"> 
                <div class="col-9"> 
                    <div class="table-cart"> 
                        <h2>Giỏ hàng của bạn</h2> 
						<c:set var="totalAmount" value="0" />
                        <c:forEach var="cartitem" items="${cartitems}">						
							<div class="cart-item">
							    <div class="left-item">
							        <div class="img-item">
							            <img src="/images/${cartitem.product.image_url}" alt="">
							        </div>
							    </div>
							    <div class="right-item">
							        <div class="item-info">
							            <div class="small-text">${cartitem.product.product_name}</div>
							            <div class="item-size">
							                <span>${cartitem.size.size_name}</span>
							            </div>
							        </div>
							        <div class="item-quantity">
							            <input type="number" value="${cartitem.quantity}" min="1" class="cart-item-quantity" data-cartitem-id="${cartitem.cart_item_id}">
							        </div>
							        <div class="item-price">
							            <p>
							                <span class="price">Đơn giá: ${cartitem.product.price}₫</span>
							            </p>
							        </div>
							        <div class="item-total-price">
							            <div class="price-item">
							                <span class="text">Thành tiền:</span>
							                <span class="price">${cartitem.quantity * cartitem.product.price}₫</span>
							            </div>
							            <div class="remove">
							                <a href="/" class="remove-icon" data-cartitem-id="${cartitem.cart_item_id}">
							                    <img src="//theme.hstatic.net/1000096703/1000836887/14/ic_close.png?v=364">
							                </a>
							            </div>
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
                        <form action="/cart/checkout" method="GET">
                            <button type="submit" class="btn">THANH TOÁN</button>
                        </form>
                    </div> 
                </div> 
            </div> 
        </div> 
    </div> 

    <script src="/js/jquery-3.7.1.min.js"></script>
	<script>
		$(document).ready(function () {
		    // Xử lý sự kiện click vào nút xóa giỏ hàng
		    $('.remove-icon').on('click', function (e) {
		        e.preventDefault(); // Ngăn hành vi mặc định của nút

		        const button = $(this); // Lấy nút hiện tại
		        const cartItemId = button.data('cartitem-id'); // Lấy ID của cart item từ data-cartitem-id

		        // Xác nhận với người dùng trước khi xóa
		        if (!confirm('Bạn có chắc chắn muốn xóa sản phẩm này khỏi giỏ hàng?')) {
		            return;
		        }

		        // Gửi yêu cầu AJAX tới server để xóa món hàng khỏi giỏ
		        $.ajax({
		            url: '/cart/remove', 
		            type: 'POST', 
					contentType: 'application/x-www-form-urlencoded',
		            data: {
		                cart_item_id: cartItemId // Gửi ID của món hàng cần xóa
		            },
		            success: function (response) {
		                // Nếu xóa thành công, cập nhật giao diện
		                button.closest('.cart-item').remove(); // Xóa phần tử giỏ hàng khỏi giao diện
		                
		                // Có thể cập nhật lại tổng giá trị giỏ hàng hoặc các thông tin khác nếu cần
		            },
		            error: function (xhr, status, error) {
		                console.error('Lỗi khi xóa sản phẩm:', error);
		                alert('Có lỗi xảy ra khi xóa sản phẩm. Vui lòng thử lại.');
		            }
		        });
		    });

		    // Xử lý sự kiện thay đổi số lượng sản phẩm trong giỏ hàng
		    $('.cart-item-quantity').on('change', function () {
		        var quantity = $(this).val(); // Lấy số lượng mới từ input
		        var cartItemId = $(this).data('cartitem-id'); // Lấy ID của cart item từ data-cartitem-id

		        // Kiểm tra xem số lượng có hợp lệ không
		        if (quantity < 1) {
		            alert('Số lượng phải lớn hơn hoặc bằng 1');
		            return;
		        }

		        // Gửi yêu cầu AJAX tới server để cập nhật lại số lượng
		        $.ajax({
		            url: '/cart/update', // URL để cập nhật số lượng
		            type: 'POST',
		            data: {
		                cart_item_id: cartItemId,
		                quantity: quantity // Gửi số lượng mới
		            },
		            success: function (response) {
		                // Nếu cập nhật thành công, cập nhật lại tổng giá trị cho món hàng đó
		                //var totalPrice = response.totalPrice; // Dữ liệu trả về có thể chứa tổng giá trị mới
		                //$('#total-price-' + cartItemId).text(totalPrice + '₫'); // Cập nhật lại thành tiền cho món hàng
						$.ajax({
						                    url: '/cart', // Gọi lại API GET /cart để lấy giỏ hàng mới
						                    type: 'GET',
						                    success: function(cartResponse) {
						                        // Cập nhật lại giao diện giỏ hàng với dữ liệu mới
						                        //...
						                        location.reload(); // Reload the page to update the cart
						                    },
						                    error: function() {
						                        alert("Có lỗi khi lấy giỏ hàng!");
						                    }
						                });
		                // Có thể cập nhật lại tổng giỏ hàng ở đây nếu cần
		            },
		            error: function (xhr, status, error) {
		                console.error('Lỗi khi cập nhật giỏ hàng:', error);
		                alert('Có lỗi xảy ra khi cập nhật giỏ hàng. Vui lòng thử lại.');
		            }
		        });
		    });
		});
	</script>
</body> 

</html>