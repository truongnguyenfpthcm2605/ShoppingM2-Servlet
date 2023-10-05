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
            <h2>Đổi mật khẩu</h2>
            <i>${message}</i>
            <form action="./change-pass" method="POST">
              <div class="group-input">
                <label for="password">Mật khẩu *</label>
                <input type="password" id="password" name="password">
              </div>
              <div class="group-input">
                <label for="password">Xác nhận mật khẩu *</label>
                <input type="password" id="password" name="verify-password">
              </div>
              <button type="submit" class="site-btn login-btn">Đổi mật khẩu</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- Register Form Section End -->

  <%@ include file="/common/footer.jsp"%>
</body>
</html>
