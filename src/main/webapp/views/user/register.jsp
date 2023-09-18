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
            <span>Register</span>
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
          <div class="register-form">
            <h2>Đăng Ký</h2>
            <h5>${message}</h5>
            <form action="./register" method="POST">
              <div class="form-group">
                <label >Email *</label>
                <input type="email" name="email" class="form-control" value="${email}">
              </div>
              <div class="form-group">
                <label for="pass">Họ Và Tên *</label>
                <input type="text" class="form-control" name="fullname" value="${fullname}">
              </div>
              <div class="form-group">
                <label for="inputState">Giới tính</label>
                <select id="inputState" class="form-control" name="gender">
                  <option selected value="true">Name</option>
                  <option value="false">Nữ</option>
                </select>
              </div>
              <div class="form-group">
                <label for="pass">Mật khẩu *</label>
                <input type="password" class="form-control" name="password" value="${password}">
              </div>
              <div class="form-group">
                <label for="con-pass">Xác nhận mật khẩu *</label>
                <input type="password" class="form-control" value="${password}">
              </div>
              <div class="form-group">
                <label for="token">Mã xác thực</label>
                <input type="text" class="form-control" name="token">
                <button formaction="./verify" class="site-btn register-btn">Lấy mã</button>
              </div>
              <button type="submit" class="site-btn register-btn">Đăng kÝ </button>
            </form>
            <div class="switch-login">
              <a href="./login" class="or-login">hoặc đăng nhập tại đây</a>
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
