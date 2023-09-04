<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file = "/common/_taglib.jsp" %>

<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Admin</title>
  <!-- plugins:css -->
  <%@ include file = "/common/admin/_head.jsp" %>
</head>
<body id="page-top">
<!-- Page Wrapper -->
<div id="wrapper">

  <!-- Sidebar -->
  <%@ include file = "/common/admin/_sidebar.jsp" %>
  <!-- End of Sidebar -->

  <!-- Content Wrapper -->
  <div id="content-wrapper" class="d-flex flex-column">
    <!-- Main Content -->
    <div id="content">
      <!-- Topbar -->
      <%@ include file = "/common/admin/_topbar.jsp" %>
      <!-- End of Topbar -->

      <!-- Begin Page Content -->
      <div class="container-fluid">

        <!-- 404 Error Text -->
        <div class="text-center">
          <div class="error mx-auto" data-text="404">404</div>
          <p class="lead text-gray-800 mb-5">Page Not Found</p>
          <p class="text-gray-500 mb-0">It looks like you found a glitch in the matrix...</p>
          <a href="<c:url value='/admin'/>">&larr; Back to Dashboard</a>
        </div>

      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- End of Main Content -->

    <!-- Footer -->
    <%@ include file = "/common/admin/_footer.jsp" %>
    <!-- End of Footer -->
  </div>
  <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
  <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<%@ include file = "/common/admin/_logout_modal.jsp" %>

<%@ include file = "/common/admin/_script.jsp" %>

</body>
</html>
