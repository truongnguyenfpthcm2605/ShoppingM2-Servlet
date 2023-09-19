<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
                            <h6 class="m-0 font-weight-bold text-primary">List of products</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>ID</th>
                                            <th>Image</th>
                                            <th>Name</th>
                                            <th>Price</th>
                                            <th>Quantity</th>
                                            <th>Create Date</th>
                                            <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${products}" var="product">
                                            <tr>
                                                <td>${product.id}</td>
                                                <td>
<%--                                                    <img src="${product.img}" class="img-fluid"--%>
<%--                                                         alt="author-profile">--%>
                                                    ${product.img}
                                                </td>
                                                <th>${product.title}</th>
                                                <td>${product.price}</td>
                                                <td>${product.stockquantity}</td>
                                                <td>${product.createDate}</td>
                                                <td>
                                                    <div class="flex align-items-center justify-content-between">
                                                        <a href="<c:url value='/admin/products?action=edit&id=${product.id}'/>"
                                                           class="btn text-info">
                                                            <i class="fas fa-fw fa-pen"></i>
                                                        </a>
                                                        <a href="<c:url value='/admin/products?action=delete&id=${product.id}'/>"
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
