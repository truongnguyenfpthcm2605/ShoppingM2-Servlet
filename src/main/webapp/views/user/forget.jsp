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
            <h2>Quên mật khẩu</h2>
            <i>${error}</i>
            <form action="./forget" method="POST">
              <div class="group-input">
                <label for="email">Email *</label>
                <input type="email" id="email" name="email">
              </div>
              <button type="submit" class="site-btn login-btn">Gửi mã xác thực</button>
            </form>
            <div class="switch-login">
              <a href="./login" class="or-login">Đăng nhập</a>
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
