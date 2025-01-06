<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Giỏ hàng</title>
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
              <input type="text" placeholder="Tìm kiếm sản phẩm..." name="name">
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
          <a class="category-item" href="/products/category?category=QUẦN ÁO BÓNG ĐÁ THEO MÀU">QUẦN ÁO BÓNG ĐÁ THEO
            MÀU</a>
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
            <div class="cart-item" th:each="item, iterStat : ${cart.cartItems}">
              <div class="left-item">
                <div class="img-item">
                  <img th:src="${item.product.image_url}" alt="">
                </div>
              </div>
              <div class="right-item">
                <div class="item-info">
                  <div class="small-text" th:text="${item.product.product_name}"></div>
                  <div class="item-size">
                    <span th:text="'Size: ' + ${item.sizeId}"></span>
                  </div>
                </div>
                <div class="item-quantity">
                  <form th:action="@{/cart/update}" method="post">
                    <input type="hidden" name="cartItemId" th:value="${item.cartItemId}">
                    <input type="number" name="quantity" th:value="${item.quantity}" min="1"
                      class="cart-item-quantity">
                    <button type="submit">Cập nhật</button>
                  </form>
                </div>
                <div class="item-price">
                  <p>
                    <span class="price" th:text="${item.product.price} + '₫'"></span>
                  </p>
                </div>
                <div class="item-total-price">
                  <div class="price-item">
                    <span class="text">Thành tiền:</span>
                    <span class="price" th:text="${item.product.price * item.quantity} + '₫'"></span>
                  </div>
                  <div class="remove">
                    <form th:action="@{/cart/remove}" method="post">
                      <input type="hidden" name="cartItemId" th:value="${item.cartItemId}">
                      <button type="submit" class="cart">
                        <img src="//theme.hstatic.net/1000096703/1000836887/14/ic_close.png?v=364">
                      </button>
                    </form>
                  </div>
                </div>
              </div>
            </div>

          </div>
        </div>
        <div class="col-3 fixed-thanhtoan">
          <div class="order-summary-block">
            <h2>Thông tin đơn hàng</h2>
            <div class="summary-total">
              <p>Tổng tiền: <span class="final-price"
                  th:text="${#numbers.formatDecimal(cart.totalAmount, 0, 'COMMA', 0, 'POINT')} + '₫'"></span>
              </p>
            </div>
            <a class="btn" th:href="@{/order/checkout(cartId=${cart.cartId})}">THANH TOÁN</a>
          </div>
        </div>
      </div>

    </div>

  </div>






  <footer>
    <div class="container">
      </div>
  </footer>
  <script>
    // Tính toán tổng tiền trong giỏ hàng
    function calculateTotalAmount() {
      let total = 0;
      const checkedItems = document.querySelectorAll('input[type="checkbox"]:checked');
      checkedItems.forEach(item => {
        const price = parseFloat(item.parentElement.nextElementSibling.nextElementSibling.textContent);
        const quantity = parseInt(item.parentElement.nextElementSibling.nextElementSibling.nextElementSibling.textContent);
        total += price * quantity;
      });
      document.getElementById('totalAmount').textContent = total;
    }

    // Gọi hàm tính toán tổng tiền khi trang được tải
    window.onload = calculateTotalAmount;
  </script>
</body>

</html>