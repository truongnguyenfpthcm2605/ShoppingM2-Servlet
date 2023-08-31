<%--
  Created by IntelliJ IDEA.
  User: BENTRE-PC
  Date: 8/31/2023
  Time: 8:31 PM
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
            <span>Login</span>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Breadcrumb Form Section Begin -->

  <!-- Register Section Begin -->
  <div class="register-login-section spad">
    <div class="container">
      <div class="row">
        <div class="col-lg-6 offset-lg-3">
          <div class="login-form">
            <h2>Đăng Nhập</h2>
            <form action="#">
              <div class="group-input">
                <label for="username">Email *</label>
                <input type="email" id="username">
              </div>
              <div class="group-input">
                <label for="pass">Mật khẩu *</label>
                <input type="password" id="pass">
              </div>
              <div class="group-input gi-check">
                <div class="gi-more">
                  <label for="save-pass">
                    Lưu mật khẩu?
                    <input type="checkbox" id="save-pass">
                    <span class="checkmark"></span>
                  </label>
                  <a href="#" class="forget-pass">Quên mật khẩu?</a>
                </div>
              </div>
              <button type="submit" class="site-btn login-btn">Đăng Nhập</button>
            </form>
            <div class="switch-login">
              <a href="./register" class="or-login">Hoặc Tạo Tài Khoản Tại Đây</a>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Register Form Section End -->

  <%@ include file="/common/footer.jsp"%>
</body>
</html>
