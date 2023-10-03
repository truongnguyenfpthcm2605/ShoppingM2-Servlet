<%--
  Created by IntelliJ IDEA.
  User: BENTRE-PC
  Date: 9/21/2023
  Time: 6:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="/common/head.jsp"%>
</head>
<body>
<%@ include file="/common/header.jsp"%>

<!-- Breadcrumb Section Begin -->
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="#"><i class="fa fa-home"></i> Home</a>
                    <span>Edit-Profile</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">

            <form action="./edit-profile" method="POST" enctype="multipart/form-data"
            >
                <div class="row">
                <div class="col-lg-4">
                    <img id="userImage" src="./templates/user/img/account/${sessionScope.current.getImg() ? sessionScope.current.getImg() : 'null.png' }" width="100%" alt="">
                    <input type="file" id="imgInput" name="img">
                </div>

                <div class="col-lg-6">
                <div class="login-form">

                        <div class="form-group">
                            <label for="fullname">Họ Và Tên *</label>
                            <input type="text" class="form-control" name="fullname" value="${sessionScope.current.fullname}">
                        </div>
                        <div class="form-group">
                            <label >Địa chỉ *</label>
                            <input type="text" name="address" class="form-control" value="${sessionScope.current.address}">
                        </div>
                        <div class="form-group">
                            <label for="inputState">Giới tính</label>
                            <select id="inputState" class="form-control" name="gender">
                                <option ${sessionScope.current.gender ? 'selected' : ''} value="true">Nam</option>
                                <option ${!sessionScope.current.gender ? 'selected' : ''} value="false">Nữ</option>
                            </select>

                        </div>
                        <div class="form-group">
                            <label >Số điện thoại *</label>
                            <input type="number" name="phoneNumbers" class="form-control" value="${sessionScope.current.phoneNumbers}">
                        </div>
                        <button type="submit" class="site-btn register-btn">Thay đổi</button>
                </div>
                </div></div>
                    </form>




    </div>
</div>

<!-- Register Form Section End -->

<%@ include file="/common/footer.jsp"%>
</body>
</html>