<%--
  Created by IntelliJ IDEA.
  User: truong
  Date: 9/6/2023
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản Phẩm </title>
    <%@include file="/common/head.jsp" %>
</head>
<body>

<!-- Header Section Begin -->
<%@ include file="/common/header.jsp" %>

<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="/index"><i class="fa fa-home"></i> Trang Chủ</a> <span>Cửa
							Hàng</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Section Begin -->

<!-- Product Shop Section Begin -->
<section class="product-shop spad">
    <div class="container">
        <div class="row">
            <div
                    class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
                <div class="filter-widget">
                    <h4 class="fw-title">Thể Loại</h4>
                    <ul class="filter-catagories">
                        <li><a href="#">Iphone</a></li>
                        <li><a href="#">Samsung</a></li>
                        <li><a href="#">Xiaomi</a></li>
                    </ul>
                </div>
                <div class="filter-widget">
                    <h4 class="fw-title">Thương Hiệu</h4>
                    <div class="fw-brand-check">
                        <div class="bc-item">
                            <label for="bc-calvin"> Iphone <input type="checkbox"
                                                                  id="bc-calvin"> <span class="checkmark"></span>
                            </label>
                        </div>
                        <div class="bc-item">
                            <label for="bc-diesel"> Samsung <input type="checkbox"
                                                                   id="bc-diesel"> <span class="checkmark"></span>
                            </label>
                        </div>
                        <div class="bc-item">
                            <label for="bc-polo"> Xiaomi <input type="checkbox"
                                                                id="bc-polo"> <span class="checkmark"></span>
                            </label>
                        </div>

                    </div>
                </div>
                <div class="filter-widget">
                    <h4 class="fw-title">Giá Sản Phẩm</h4>
                    <div class="filter-range-wrap">
                        <div class="range-slider">
                            <div class="price-input">
                                <input type="text" id="minamount"> <input type="text"
                                                                          id="maxamount">
                            </div>
                        </div>
                        <div
                                class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                data-min="33" data-max="98">
                            <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                            <span tabindex="0"
                                  class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            <span tabindex="0"
                                  class="ui-slider-handle ui-corner-all ui-state-default"></span>
                        </div>
                    </div>
                    <a href="#" class="filter-btn">Giới Hạn Giá</a>
                </div>

                <div class="filter-widget">
                    <h4 class="fw-title">RAM / ROM</h4>
                    <div class="fw-size-choose">
                        <div class="sc-item">
                            <input type="radio" id="s-size"> <label for="s-size">4/64GB</label>
                        </div>
                        <div class="sc-item">
                            <input type="radio" id="m-size"> <label for="m-size">8/128GB</label>
                        </div>
                        <br>
                        <div class="sc-item">
                            <input type="radio" id="l-size"> <label for="l-size">8/512GB</label>
                        </div>
                        <div class="sc-item">
                            <input type="radio" id="xs-size"> <label for="xs-size">16/1TB</label>
                        </div>
                    </div>
                </div>
                <div class="filter-widget">
                    <h4 class="fw-title">Tags</h4>
                    <div class="fw-tags">
                        <a href="#">Iphone 14 Pro Max</a> <a href="#">Iphone 12 Pro
                        Max</a> <a href="#">Iphone 13 Pro Max</a> <a href="#">Samsung
                        S23 Ultra</a> <a href="#">Samsung S21 Ultra</a> <a href="#">Samsung
                        S22 Ultra</a> <a href="#">Xiaomi 12T Pro</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-9 order-1 order-lg-2">
                <div class="product-show-option">
                    <div class="row">
                        <div class="col-lg-7 col-md-7">
                            <div class="select-option">
                                <form action="/product/sort" method="post">
                                    <select name="sort" class=" sorting"
                                            onchange="this.form.submit()">
                                        <option value="0"  ${check==0?'selected':'' }>Mới Nhất</option>
                                        <option value="1"  ${check==1?'selected':'' }>Giá Thấp Đến Cao</option>
                                        <option value="2" ${check==2?'selected':'' }>Giá Cao Đến Thấp</option>
                                    </select>
                                </form>
                                <select class="sorting">
                                    <option value="">Hiển Thị : ${pageProduct.size} Sản
                                        Phẩm
                                    </option>
                                </select>
                            </div>
                        </div>
                        <div class="col-lg-5 col-md-5 text-right">
                            <p>Trang ${pageProduct.number +1}, Tổng
                                ${pageProduct.totalElements} Sản phẩm</p>
                        </div>

                    </div>
                </div>
                <div class="product-list">
                    <div class="row">
                        <c:forEach items="${pageProduct.content }" var="item">
                            <div class="col-lg-4 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img
                                                src="${pageContext.request.contextPath}/img/products/${item.imgproduct }"
                                                height="60%" alt=""> <input type="hidden"
                                                                            class="cartid" value="${item.id }">
                                        <div class="icon">
                                            <a href=""><i class="icon_heart_alt"></i></a>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#" class="addcart"><i
                                                    class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a
                                                    href="/product/detail?id=${item.id }">Xem Nhanh</a></li>
                                            <li class="w-icon"><a href="#"><i
                                                    class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">${item.ram }GBRAM/
                                                ${item.rom }GB
                                        </div>
                                        <a href="/product/detail?id=${item.id }">
                                            <h5>${item.title }</h5>
                                        </a>
                                        <div class="product-price">
                                            <fmt:formatNumber value="${item.price }" type="currency"
                                                              currencyCode="VND"/>
                                            <span><fmt:formatNumber value="${item.pricecost}"
                                                                    type="currency" currencyCode="VND"/></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>

                    </div>
                    <div
                            style="margin: 10px auto; display: flex; justify-content: center;"
                            class="container">
                        <a style="margin: 5px" class="btn btn-dark"
                           href="/product/page?p=0">First</a> <a style="margin: 5px"
                                                                 class="btn btn-dark"
                                                                 href="/product/page?p=${pageProduct.number - 1 > 0 ?pageProduct.number - 1 : 0}">
                        <i class='bx bx-left-arrow-alt'></i>Previous
                    </a> <a style="margin: 5px" class="btn btn-dark"
                            href="/product/page?p=${pageProduct.number + 1 < pageProduct.totalPages ? pageProduct.number + 1 : pageProduct.totalPages - 1}">Next
                        <i class='bx bx-right-arrow-alt'></i>
                    </a> <a style="margin: 5px" class="btn btn-dark"
                            href="/product/page?p=${pageProduct.totalPages - 1}">Last</a>

                    </div>
                </div>

            </div>
        </div>
    </div>
</section>
<%@ include file="/common/footer.jsp" %>
<!-- Product Shop Section End -->

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(".addcart").click(function (event) {
        event.preventDefault();
        var id = $(this).closest('.product-item').find('.cartid').val();
        $.ajax({
            url: "/cart/add/" + id,
            type: 'GET',
            success: function (data) {
                alert(data);
            },
            error: function (xhr, status, error) {
                alert("Không thể thêm")
            }
        });
    });
</script>


</body>
</html>
