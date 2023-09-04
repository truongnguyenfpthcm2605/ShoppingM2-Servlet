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
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Edit Product</h6>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="mb-3 row">
                                    <div class="form-group col-6">
                                        <label for="title">Title:</label>
                                        <input type="text" class="form-control" id="title">
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="price">Price:</label>
                                        <input type="number" class="form-control" id="price">
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="form-group col-6">
                                        <label for="discount">Discount:</label>
                                        <input type="number" class="form-control" id="discount">
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="quantity">Quantity:</label>
                                        <input type="number" class="form-control" id="quantity">
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="form-group col-6">
                                        <label for="categories">Category:</label>
                                        <select class="form-control" id="categories">
                                            <option selected>Open this select menu</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="form-group col-6">
                                        <label for="stockquantity">Stock Quantity:</label>
                                        <input type="number" class="form-control" id="stockquantity" readonly>
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="buyquantity">Buy quantity:</label>
                                        <input type="number" class="form-control" id="buyquantity" readonly>
                                    </div>
                                </div>
                                <div class="mb-3 row">
                                    <div class="form-group col-6">
                                        <label for="createDate">Create Date:</label>
                                        <input type="date" class="form-control" id="createDate" readonly>
                                    </div>
                                    <div class="form-group col-6">
                                        <label for="createUpdate">Update Date:</label>
                                        <input type="number" class="form-control" id="createUpdate" readonly>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="img">Image:</label>
                                    <input type="text" class="form-control" id="img">
                                </div>
                                <div class="form-group mb-3">
                                    <label for="desc">Description:</label>
                                    <textarea class="form-control"
                                              id="desc"
                                              style="height: 100px"></textarea>
                                </div>
                            </form>
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
</body>
</html>
