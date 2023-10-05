<%--
  Created by IntelliJ IDEA.
  User: BENTRE-PC
  Date: 8/31/2023
  Time: 7:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
                <div class="mail-service">
                    <i class=" fa fa-envelope"></i>
                    htmobile@gmail.com
                </div>
                <div class="phone-service">
                    <i class=" fa fa-phone"></i>
                    0999999999
                </div>
            </div>
            <div class="ht-right">
                <a href="./login" class="login-panel"><i class="fa fa-user"></i>Đăng Nhập</a>
                <div class="lan-selector">
                    <select class="language_drop" name="countries" id="countries" style="width:300px;">
                        <option value='yu' data-image="./templates/user/img/flag-2.jpg" data-imagecss="flag yu"
                                data-title="Bangladesh">Vietnam</option>
                        <option value='yt' data-image="./templates/user/img/flag-1.jpg" data-imagecss="flag yt"
                                data-title="English">English</option>
                    </select>
                </div>
                <div class="top-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"><i class="ti-twitter-alt"></i></a>
                    <a href="#"><i class="ti-linkedin"></i></a>
                    <a href="#"><i class="ti-pinterest"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="inner-header">
            <div class="row">
                <div class="col-lg-2 col-md-2">
                    <div class="logo">
                        <a href="./home">
                            <img src="./templates/user/img/logo.jpg" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-md-7">
                    <form action="/product" method="get" class="container">
                        <input type="text" value="${search}"  style="width: 80%;
                        box-shadow: rgba(100, 100, 111, 0.2) 0px 7px 29px 0px;
                        border-radius: 10px;line-height: 40px; margin: 0; border: solid 1px orange; outline: none" placeholder="Bạn đang tìm gì?" name="search">
                        <button type="submit" class="btn btn-warning" style="width: 15%; margin-left: 5px;
                         height: 40px"><i class="fa-solid fa-magnifying-glass"></i></button>
                    </form>
                </div>
                <div class="col-lg-3 text-right col-md-3">
                    <ul class="nav-right">
                        <li class="heart-icon">
                            <a href="#">
                                <i class="icon_heart_alt"></i>
                                <span>1</span>
                            </a>
                        </li>
                        <li class="cart-icon">
                            <a href="#">
                                <i class="icon_bag_alt"></i>
                                <span>3</span>
                            </a>
                            <div class="cart-hover">
                                <div class="select-items">
                                    <table>
                                        <tbody>
                                        <tr>
                                            <td class="si-pic"><img src="./templates/user/img/select-product-1.jpg" alt=""></td>
                                            <td class="si-text">
                                                <div class="product-selected">
                                                    <p>$60.00 x 1</p>
                                                    <h6>Iphone 14 Pro Max</h6>
                                                </div>
                                            </td>
                                            <td class="si-close">
                                                <i class="ti-close"></i>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td class="si-pic"><img src="./templates/user/img/select-product-2.jpg" alt=""></td>
                                            <td class="si-text">
                                                <div class="product-selected">
                                                    <p>$60.00 x 1</p>
                                                    <h6>Iphone 14 Pro Max</h6>
                                                </div>
                                            </td>
                                            <td class="si-close">
                                                <i class="ti-close"></i>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="select-total">
                                    <span>Tổng tiền :</span>
                                    <h5>$120.00</h5>
                                </div>
                                <div class="select-button">
                                    <a href="#" class="primary-btn view-card">Xem Giỏ Hàng</a>
                                    <a href="#" class="primary-btn checkout-btn">Đăng Xuất</a>
                                </div>
                            </div>
                        </li>
                        <li class="cart-price">$150.00</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="nav-item">
        <div class="container">

            <nav class="nav-menu mobile-menu">
                <ul>
                    <li class="active"><a href="./home">Trang Chủ</a></li>
                    <li><a href="./shop.html">Cửa Hàng</a></li>
                    <li><a href="#">Sưu Tập</a>
                        <ul class="dropdown">
                            <li><a href="#">Iphone</a></li>
                            <li><a href="#">Samsung</a></li>
                            <li><a href="#">Xiaomi</a></li>
                            <li><a href="#">Nokia</a></li>
                        </ul>
                    </li>
                    <li><a href="./blog.html">Tin Tức</a></li>
                    <li><a href="./contact">Liên Hệ</a></li>
                    <li><a href="#">Trang</a>
                        <ul class="dropdown">
                            <li><a href="./register">Đăng Ký</a></li>
                            <li><a href="./login">Đăng Nhập</a></li>
                            <li><a href="./check-out.html">Đăng Xuất</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
        </div>
    </div>
</header>
