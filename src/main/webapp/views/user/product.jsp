<%--
  Created by IntelliJ IDEA.
  User: truong
  Date: 9/6/2023
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/_taglib.jsp" %>
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
                    <a href="/home"><i class="fa fa-home"></i> Trang Chủ</a> <span>Cửa
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
                    <h4 class="fw-title">Thương Hiệu</h4>
                    <ul class="filter-catagories">
                       <c:forEach var="category" items="${categories}">
                           <li><a href="/product?category=${category.id}"> <img style="width: 10% ;margin-left: 5px" src="/templates/user/img/icon/${category.icon}" > ${category.title}</a></li>
                       </c:forEach>
                    </ul>
                </div>
                <div class="filter-widget">
                    <h4 class="fw-title">Giá Sản Phẩm</h4>
                    <form action="/product" method="get">
                        <div class="filter-range-wrap">
                            <div class="range-slider">
                                <div class="price-input">
                                    <input type="text" disabled id="minamount" name="minPrice" >
                                    <input type="text" disabled name="maxPrice" id="maxamount" >
                                </div>
                            </div>
                            <div
                                    class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                    data-min="1000000" data-max="50000000">
                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                <span tabindex="0"
                                      class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                <span tabindex="0"
                                      class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            </div>
                        </div>
                        <button class="filter-btn" style="outline: none; border: none">Giới Hạn Giá</button>
                    </form>
                </div>

                <div class="filter-widget">
                    <h4 class="fw-title">RAM </h4>
                    <div class="fw-size-choose">
                        <form action="/product" method="get">
                            <div class="sc-item">
                                <input type="radio" onclick="this.form.submit()" name="memory" value="4" id="s-size"> <label for="s-size">4GB</label>
                            </div>
                            <div class="sc-item">
                                <input type="radio" onclick="this.form.submit()" name="memory" value="6" id="m-size"> <label for="m-size">6GB</label>
                            </div>
                            <br>
                            <div class="sc-item">
                                <input type="radio" onclick="this.form.submit()" name="memory" value="8"  id="l-size"> <label for="l-size">8GB</label>
                            </div>
                            <div class="sc-item">
                                <input type="radio" onclick="this.form.submit()" name="memory" value="12" id="xs-size"> <label for="xs-size">12GB</label>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            <div class="col-lg-9 order-1 order-lg-2">
                <div class="product-show-option">
                    <div class="row">
                        <div class="col-lg-7 col-md-7">
                            <div class="select-option">
                                <form action="/product" method="get">
                                    <select name="sort" class=" sorting"
                                            onchange="this.form.submit()">
                                        <option value="0" ${sort == 0 ? 'selected' : ''}>Mới Nhất</option>
                                        <option value="1" ${sort == 1 ? 'selected' : ''}>Giá Thấp Đến Cao</option>
                                        <option value="2" ${sort == 2 ? 'selected' : ''}>Giá Cao Đến Thấp</option>
                                    </select>
                                </form>

                            </div>
                        </div>
                        <div class="col-lg-5 col-md-5 text-right">
                            <p>Trang ${curentpage == null ? 1 : curentpage}, Tổng
                                ${total} Sản phẩm</p>
                        </div>

                    </div>
                </div>
                <div class="product-list">
                    <div class="row">
                        <c:forEach items="${products}" var="item">
                            <div class="col-lg-4 col-sm-6">
                                <div class="product-item">
                                    <div class="pi-pic">
                                        <img
                                                src="/templates/user/img/products/${item.img}"
                                                height="60%" alt="">
                                        <input type="hidden" class="cartid" value="${item.id }">
                                        <div class="icon">
                                            <a href=""><i class="icon_heart_alt"></i></a>
                                        </div>
                                        <ul>
                                            <li class="w-icon active"><a href="#" class="addcart"><i
                                                    class="icon_bag_alt"></i></a></li>
                                            <li class="quick-view"><a
                                                    href="/detail?id=${item.id }">Xem Nhanh</a></li>
                                            <li class="w-icon"><a href="#"><i
                                                    class="fa fa-random"></i></a></li>
                                        </ul>
                                    </div>
                                    <div class="pi-text">
                                        <div class="catagory-name">${item.ram }GBRAM/
                                                ${item.rom }GB
                                        </div>
                                        <a href="/detail?id=${item.id }">
                                            <h5>${item.title }</h5>
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
                        <div class="controller" style="text-align: center;">
                                <div class="btn-group" role="group" aria-label="Basic example">
                                    <c:if test="${curentpage > 1 }">
                                        <a href="product?page=${curentpage-1}"
                                           class="btn btn-warning">Back</a>
                                    </c:if>
                                    <c:forEach varStatus="i" begin="1" end="${maxpage }">
                                        <a href="product?page=${i.index}"
                                           class="btn btn-warning ${curentpage==i.index ? 'active' : ''}">${i.index}</a>
                                    </c:forEach>

                                   <c:if test="${curentpage < maxpage}">
                                       <a href="product?page=${curentpage+1}"
                                          class="btn btn-warning "> Next</a>
                                   </c:if>

                                </div>
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
                alert("Không thể thêm" + status + error)
            }
        });
    });
</script>


</body>
</html>
