<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">List of accounts</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Fullname</th>
                                            <th>Email</th>
                                            <th>Create Date</th>
                                            <th>Gender</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${accounts}" var="account">
                                            <tr>
                                                <td>${account.fullname}</td>
                                                <td>${account.email}</td>
                                                <td>${account.createDate}</td>
                                                <td>${account.gender}</td>
                                                <td>
                                                    <div class="flex align-items-center justify-content-between">
                                                        <a href="<c:url value='/admin/accounts?action=edit&email=${account.email}'/>"
                                                           class="btn text-info">
                                                            <i class="fas fa-fw fa-pen"></i>
                                                        </a>
                                                        <a href="<c:url value='/admin/accounts?action=delete&email=${account.email}'/>"
                                                           class="btn text-danger">
                                                            <i class="fas fa-fw fa-trash"></i>
                                                        </a>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
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

    <!-- Page level custom scripts -->
    <script src="<c:url value='/templates/admin/js/demo/datatables-demo.js'/>"></script>
</body>
</html>
