<%--
  Created by IntelliJ IDEA.
  User: truong
  Date: 9/6/2023
  Time: 9:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/_taglib.jsp" %>
<html>
<head>
    <title>Sản Phẩm Chi Tiết</title>
    <%@ include file="/common/head.jsp" %>
</head>
<body>
    <%@ include file="/common/header.jsp" %>
    <!-- Breadcrumb Section Begin -->
            <div class="breacrumb-section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="breadcrumb-text product-more">
                                <a href="/home" ><i class="fa fa-home"></i> Trang chủ</a>
                                <a href="/product">Sản phẩm</a>
                                <span>Sản phẩm chi tiết</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Breadcrumb Section Begin -->
            <!-- Product Shop Section Begin -->

           <section class="product-shop spad page-details">
            <div class="container">
                <div class="row">

                    <div class="col-lg-10" style="margin: 0 auto;">
                        <div class="row">
                            <div class="col-lg-6">
                                <div class="product-pic-zoom">
                                    <img class="product-big-img"
                                         src="/templates/user/img/products/${p.img}"
                                         alt="">

                                    <div class="zoom-icon">
                                        <i class="fa fa-search-plus"></i>
                                    </div>
                                </div>
                                <div class="product-thumbs">
                                    <div class="product-thumbs-track ps-slider owl-carousel">
                                        <c:forEach var="img" items="${images }">
                                            <div class="pt active"
                                                 data-imgbigurl="/templates/user/img/detailproduct/${img}">
                                                <img
                                                        src="/templates/user/img/detailproduct/${img}"
                                                        alt="">
                                            </div>
                                        </c:forEach>
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="product-details">
                                    <div class="pd-title">
                                        <span>${p.categories.title }</span>
                                        <h3>${p.title }</h3>
                                        <a href="#" class="heart-icon"><i class="icon_heart_alt"></i></a>
                                    </div>
                                    <div class="pd-rating">
                                        <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                            class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                            class="fa fa-star-o"></i> <span>(5)</span>
                                    </div>
                                    <div class="pd-desc">
                                        <p>HTMobile Mong muốn mang lại cho bạn một trải nghiệm mua
                                            sắm tuyệt vời nhất .Cảm ơn bạn đã ghé thăm của hàng của chúng
                                            tôi !</p>
                                        <h4>
                                            <fmt:formatNumber value="${p.discount}" type="currency" currencyCode="VND" pattern="#,##0 đ"/><br>

                                        </h4>
                                        <p>Lượt xem sản phẩm : ${p.views }</p>
                                    </div>

                                    <div class="pd-size-choose">
                                        <div class="sc-item">
                                            <input type="radio" id="sm-size"> <label for="sm-size"
                                                                                     style="width: 100px">64GB</label>
                                        </div>
                                        <div class="sc-item">
                                            <input type="radio" id="md-size"> <label for="md-size"
                                                                                     style="width: 100px">128GB</label>
                                        </div>
                                        <div class="sc-item">
                                            <input type="radio" id="lg-size"> <label for="lg-size"
                                                                                     style="width: 100px">256GB</label>
                                        </div>
                                        <div class="sc-item">
                                            <input type="radio" id="xl-size"> <label for="xl-size"
                                                                                     style="width: 100px">512GB</label>
                                        </div>
                                    </div>
                                    <div class="quantity">

                                        <a href="/cart/viewcart/${p.id }"  class="primary-btn pd-cart">Thêm Vào Giỏ Hàng <i style="font-size: 20px" class='bx bx-cart-add'></i></a>
                                    </div>

                                    <div class="pd-share">
                                        <div class="p-code">Hotline : 0999999999</div>
                                        <div class="pd-social">
                                            <a href="#"><i class="ti-facebook"></i></a> <a href="#"><i
                                                class="ti-twitter-alt"></i></a> <a href="#"><i
                                                class="ti-linkedin"></i></a>
                                        </div>
                                    </div>
                                    <div class="pd-share" style="margin-top:10px">
                                        <div class="p-code" style="color: #E57C23">
                                            Tồn Kho : ${p.stockquantity }
                                        </div>
                                        <div class="pd-social"  style="color: #7AA874">
                                            Đã Bán : ${p.buyquanity}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="product-tab">
                            <div class="tab-item">
                                <ul class="nav" role="tablist">
                                    <li><a class="active" data-toggle="tab" href="#tab-1"
                                           role="tab">MÔ TẢ SẢN PHẨM</a></li>
                                    <li><a data-toggle="tab" href="#tab-2" role="tab">CẤU
                                        HÌNH </a></li>
                                    <li><a data-toggle="tab" href="#tab-3" role="tab"> ĐÁNH
                                        GIÁ</a></li>
                                </ul>
                            </div>
                            <div class="tab-item-content">
                                <div class="tab-content">
                                    <div class="tab-pane fade-in active" id="tab-1" role="tabpanel">
                                        <div class="product-content">
                                            <div class="row">
                                                <div class="col-lg-7">
                                                    <h5>Thông Tin</h5>
                                                    <p>${p.description }</p>
                                                </div>
                                                <div class="col-lg-5">
                                                    <img src="img/product-single/tab-desc.jpg" alt="">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="tab-2" role="tabpanel">
                                        <div class="specification-table">
                                            <table>
                                                <tr>
                                                    <td class="p-catagory">Đánh Giá</td>
                                                    <td>
                                                        <div class="pd-rating">
                                                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star-o"></i> <span>(5)</span>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">Giá</td>
                                                    <td>
                                                        <div class="p-price">
                                                            <fmt:formatNumber value="${p.discount}" type="currency" currencyCode="VND" pattern="#,##0 đ"/>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">Vi xử lý</td>
                                                    <td>
                                                        <div class="cart-add">${p.chip }</div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">RAM</td>
                                                    <td>
                                                        <div class="p-stock">${p.ram }GB</div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">ROM</td>
                                                    <td>
                                                        <div class="p-weight">${p.rom}GB</div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">Màn Hình</td>
                                                    <td>
                                                        <div class="p-size">${p.screen }Inch</div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">Camera</td>
                                                    <td>
                                                        <div class="p-size">${p.camera}MP</div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td class="p-catagory">PIN</td>
                                                    <td><span>${p.pin } mAh</span></td>
                                                </tr>

                                            </table>
                                        </div>
                                    </div>
                                    <div class="tab-pane fade" id="tab-3" role="tabpanel">
                                        <div class="customer-review-option">
                                            <h4>2 Comments</h4>
                                            <div class="comment-option">
                                                <div class="co-item">
                                                    <div class="avatar-pic">
                                                        <img
                                                                src="/templates/user/img/product-single/avatar-1.jpg"
                                                                alt="">
                                                    </div>
                                                    <div class="avatar-text">
                                                        <div class="at-rating">
                                                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star-o"></i>
                                                        </div>
                                                        <h5>
                                                            Lê Võ Phú Thiện <span>30 May 2023</span>
                                                        </h5>
                                                        <div class="at-reply">Máy đẹp quá giao cho tôi 10 cái
                                                            tôi đặt rồi !</div>
                                                    </div>
                                                </div>
                                                <div class="co-item">
                                                    <div class="avatar-pic">
                                                        <img
                                                                src="/templates/user/img/product-single/hauvan.jpg"
                                                                alt="">
                                                    </div>
                                                    <div class="avatar-text">
                                                        <div class="at-rating">
                                                            <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                                class="fa fa-star-o"></i>
                                                        </div>
                                                        <h5>
                                                            Võ Văn Hậu <span>27 May 2023</span>
                                                        </h5>
                                                        <div class="at-reply">Máy ổn lắm!</div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="personal-rating">
                                                <h6>Lượt đánh giá</h6>
                                                <div class="rating">
                                                    <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                        class="fa fa-star"></i> <i class="fa fa-star"></i> <i
                                                        class="fa fa-star-o"></i>
                                                </div>
                                            </div>
                                            <div class="leave-comment">
                                                <h4>Bình Luận Sản Phẩm</h4>
                                                <form action="#" class="comment-form">
                                                    <div class="row">
                                                        <div class="col-lg-6">
                                                            <input type="text" placeholder="Tên bạn">
                                                        </div>
                                                        <div class="col-lg-6">
                                                            <input type="text" placeholder="Email">
                                                        </div>
                                                        <div class="col-lg-12">
                                                            <textarea placeholder="Nội dung"></textarea>
                                                            <button type="button" class="site-btn">Gửi Bình
                                                                Luận</button>
                                                        </div>
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </section>

            <!-- Product Shop Section End -->
            <!-- Related Products Section End -->
            <div class="related-products spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="section-title">
                                <h2>Sản Phẩm Đề Xuất</h2>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <c:forEach var="item" items="${products}">
                            <div class="col-lg-3 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img src="/templates/user/img/products/${item.img}" alt="">
                                        <div class="sale">Sale</div>
                                        <div class="icon">
                                            <i class="icon_heart_alt"></i>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#"><i class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a href="/detail?id=${item.id}">Xem Nhanh</a></li>
                                            <li class="w-icon"><a href="#"><i class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">Coat</div>
                                        <a href="/detail?id=${item.id}">
                                            <h5>${item.title}</h5>
                                        </a>
                                        <div class="product-price">
                                            <fmt:formatNumber value="${item.discount}" type="currency" currencyCode="VND" pattern="#,##0 đ"/><br>
                                            <span><fmt:formatNumber value="${item.price}" type="currency" currencyCode="VND" pattern="#,##0 đ"/></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
    <!-- Related Products Section End -->

    <%@ include file="/common/footer.jsp" %>
</body>
</html>
