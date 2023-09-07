<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang Chủ</title>
    <%@include file="/common/head.jsp"%>
</head>
<body>

<!-- Header Section Begin -->
<%@ include file="/common/header.jsp"%>

<!-- Hero Section Begin -->
<section class="hero-section">
    <div class="hero-items owl-carousel">
        <div class="single-hero-items set-bg" data-setbg="./templates/user/img/hero-1.jpg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-5">
                        <span>SALE ĐẬM</span>
                        <h1>Black friday</h1>
                        <p>Black Friday 2023 là vào ngày 24/11/2023 sắp tới và CellphoneS trân trọng mang đến Quý Khách Hàng ngàn deal cháy sàn từ CellphoneS. Bạn đã có danh sách những thứ nên mua cho gia đình mình chưa?</p>
                        <a href="#" class="primary-btn">Mua Ngay</a>
                    </div>
                </div>
                <div class="off-card">
                    <h2>Sale <span>50%</span></h2>
                </div>
            </div>
        </div>

        <div class="single-hero-items set-bg" data-setbg="./templates/user/img/banner4.jpg">

        </div>
    </div>
</section>
<!-- Hero Section End -->

<!-- Banner Section Begin -->
<div class="banner-section spad">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-4">
                <div class="single-banner">
                    <img src="./templates/user/img/banner-1.jpg" alt="">
                    <div class="inner-text">
                        <h4>IPHONE</h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-banner">
                    <img src="./templates/user/img/banner-2.jpg" alt="">
                    <div class="inner-text">
                        <h4>SAMSUNG</h4>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="single-banner">
                    <img src="./templates/user/img/banner-1.jpg" alt="">
                    <div class="inner-text">
                        <h4>XIAOMI</h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Banner Section End -->

<!-- Women Banner Section Begin -->
<section class="women-banner spad">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-3">
                <div class="product-large set-bg" data-setbg="./templates/user/img/products/women-large.jpg">
                    <h2>XIAOMI</h2>
                    <a href="#">Khám Phá</a>
                </div>
            </div>
            <div class="col-lg-8 offset-lg-1">
                <div class="filter-control">
                    <ul>
                        <li class="active">Hàng SALE</li>
                        <li>Hàng Cũ 99%</li>
                        <li>Linh Kiện</li>
                        <li>Loa Bluetooth</li>
                    </ul>
                </div>
                <div class="product-slider owl-carousel">
                    <%@ include file="/common/productList.jsp"%>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Women Banner Section End -->

<!-- Deal Of The Week Section Begin-->
<section class="deal-of-week set-bg spad" data-setbg="./templates/user/img/time-bg.jpg">
    <div class="container">
        <div class="col-lg-6 text-center">
            <div class="section-title">
                <h2>Khuyến Mãi Lớn Trong Tuần</h2>
                <p>Black Friday 2023 CellPhoneS: BLACK FIRE–DAY, SALES “CHÁY” SÀN </p>
                <div class="product-price">
                    $35.00
                    <span>/ Sản Phẩm</span>
                </div>
            </div>
            <div class="countdown-timer" id="countdown">
                <div class="cd-item">
                    <span>56</span>
                    <p>Ngày</p>
                </div>
                <div class="cd-item">
                    <span>12</span>
                    <p>Giờ</p>
                </div>
                <div class="cd-item">
                    <span>40</span>
                    <p>Phút</p>
                </div>
                <div class="cd-item">
                    <span>52</span>
                    <p>Giấy</p>
                </div>
            </div>
            <a href="#" class="primary-btn">Mua Ngay</a>
        </div>
    </div>
</section>
<!-- Deal Of The Week Section End -->

<!-- Man Banner Section Begin -->
<section class="man-banner spad">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="filter-control">
                    <ul>
                        <li class="active">Iphone Chính Hãng</li>
                        <li>Iphone 99%</li>
                        <li>Linh Kiện Cũ</li>
                        <li>Apple AirPods</li>
                    </ul>
                </div>
                <div class="product-slider owl-carousel">
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="./templates/user/img/products/man-1.jpg" alt="">
                            <div class="sale">Sale</div>
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                            <ul>
                                <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                <li class="quick-view"><a href="#">Xem Nhanh</a></li>
                                <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                            </ul>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">8GB Ram / 256 GB</div>
                            <a href="#">
                                <h5>Iphone 14 Pro Max</h5>
                            </a>
                            <div class="product-price">
                                $14.00
                                <span>$35.00</span>
                            </div>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="./templates/user/img/products/man-1.jpg" alt="">
                            <div class="sale">Sale</div>
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                            <ul>
                                <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                <li class="quick-view"><a href="#">Xem Nhanh</a></li>
                                <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                            </ul>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">8GB Ram / 256 GB</div>
                            <a href="#">
                                <h5>Iphone 14 Pro Max</h5>
                            </a>
                            <div class="product-price">
                                $13.00
                            </div>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="./templates/user/img/products/man-1.jpg" alt="">
                            <div class="sale">Sale</div>
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                            <ul>
                                <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                <li class="quick-view"><a href="#">Xem Nhanh</a></li>
                                <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                            </ul>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">8GB Ram / 256 GB</div>
                            <a href="#">
                                <h5>Iphone 14 Pro Max</h5>
                            </a>
                            <div class="product-price">
                                $34.00
                            </div>
                        </div>
                    </div>
                    <div class="product-item">
                        <div class="pi-pic">
                            <img src="./templates/user/img/products/man-1.jpg" alt="">
                            <div class="sale">Sale</div>
                            <div class="icon">
                                <i class="icon_heart_alt"></i>
                            </div>
                            <ul>
                                <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                <li class="quick-view"><a href="#">Xem Nhanh</a></li>
                                <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                            </ul>
                        </div>
                        <div class="pi-text">
                            <div class="catagory-name">8GB Ram / 256 GB</div>
                            <div class="sale">Sale</div>
                            <a href="#">
                                <h5>Iphone 14 Pro Max</h5>
                            </a>
                            <div class="product-price">
                                $34.00
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 offset-lg-1">
                <div class="product-large set-bg m-large" data-setbg="./templates/user/img/select-product-2.jpg">
                    <h2>IPHONE</h2>
                    <a href="#">Khám Phá</a>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Man Banner Section End -->



<!-- Latest Blog Section Begin -->
<section class="latest-blog spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="section-title">
                    <h2>Các Tin Tức Công Nghệ</h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="single-latest-blog">
                    <img src="./templates/user/img/latest-1.jpg" alt="">
                    <div class="latest-text">
                        <div class="tag-list">
                            <div class="tag-item">
                                <i class="fa fa-calendar-o"></i>
                                29/02/2023
                            </div>
                            <div class="tag-item">
                                <i class="fa fa-comment-o"></i>
                                95
                            </div>
                        </div>
                        <a href="#">
                            <h4>Cách kiểm tra MacBook cũ để tránh ‘’tiền mất tật mang’’</h4>
                        </a>
                        <p>MacBook được ví như ông hoàng trong giới công nghệ, tuy nhiên, để có thể sở hữu nó, người dùng phải bỏ ra khối ‘’hầu bao’’ kha khá. Vậy với nguồn tài chính có hạn, chúng ta có thể sở hữu MacBook không? </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-latest-blog">
                    <img src="./templates/user/img/latest-2.jpg" alt="">
                    <div class="latest-text">
                        <div class="tag-list">
                            <div class="tag-item">
                                <i class="fa fa-calendar-o"></i>
                                29/02/2023
                            </div>
                            <div class="tag-item">
                                <i class="fa fa-comment-o"></i>
                                65
                            </div>
                        </div>
                        <a href="#">
                            <h4>Cách cài Win cho MacBook dễ dàng với Boot Camp</h4>
                        </a>
                        <p>HIện nay, nhiều người dùng sở hữu máy MacBook nhưng lại loay hoay không biết sử dụng hệ điều hành MacOS như thế nào. Hoặc có người vẫn muốn giữ lại máy nhưng yêu cầu ‘’thay’’ bằng hệ điều hành Windows cho thuận tiện </p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="single-latest-blog">
                    <img src="./templates/user/img/latest-3.jpg" alt="">
                    <div class="latest-text">
                        <div class="tag-list">
                            <div class="tag-item">
                                <i class="fa fa-calendar-o"></i>
                                29/02/2023
                            </div>
                            <div class="tag-item">
                                <i class="fa fa-comment-o"></i>
                                85
                            </div>
                        </div>
                        <a href="#">
                            <h4>Tìm hiểu ngay cách đổi hình nền MacBook đơn giản mà bạn không nên bỏ qua</h4>
                        </a>
                        <p>Hiện nay, MacBook là một thương hiệu laptop được nhiều người sử dụng bởi chất lượng màn hình đẹp và rõ nét. Vậy bạn đã biết đâu là cách đổi hình nền MacBook để thay áo mới cho máy mỗi khi cần thiết hay chưa? </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="benefit-items">
            <div class="row">
                <div class="col-lg-4">
                    <div class="single-benefit">
                        <div class="sb-icon">
                            <img src="./templates/user/img/icon-1.png" alt="">
                        </div>
                        <div class="sb-text">
                            <h6>Miễn Phí Ship</h6>
                            <p>Tất cả sản sẩn lớn hơn 99$</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-benefit">
                        <div class="sb-icon">
                            <img src="./templates/user/img/icon-2.png" alt="">
                        </div>
                        <div class="sb-text">
                            <h6>Thời Gian Vận Chuyển Nhanh</h6>
                            <p>Nếu không có vấn đề</p>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="single-benefit">
                        <div class="sb-icon">
                            <img src="./templates/user/img/icon-1.png" alt="">
                        </div>
                        <div class="sb-text">
                            <h6>Thanh Toán An Toàn</h6>
                            <p>An toàn 100% bảo mật</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Latest Blog Section End -->

<hr>

<!-- Footer Section Begin -->
<%@ include file="/common/footer.jsp"%>

</body>

</html>
