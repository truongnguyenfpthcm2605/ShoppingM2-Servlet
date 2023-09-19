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
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Edit Account</h6>
                        </div>
                        <div class="card-body">
                            <form action="/admin/accounts" method="POST">
                                <div class="row">
                                    <div class="col-6">

                                    </div>
                                    <div class="col-6">
                                        <div class="form-group mb-3">
                                            <label for="email">Email:</label>
                                            <input type="text" class="form-control" id="email" name="email" value="${account.email}">
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="password">Password:</label>
                                            <input name="password" value="${account.password}" type="password" class="form-control" id="password">
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="fullname">Fullname:</label>
                                            <input name="fullname" value="${account.fullname}" type="text" class="form-control" id="fullname">
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="phoneNumbers">Phone Number:</label>
                                            <input name="phoneNumbers" value="${account.phoneNumbers}" type="text" class="form-control" id="phoneNumbers">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="form-group mb-3 col-6">
                                        <label for="gender">Gender:</label>
                                        <div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="male" checked>
                                                <label class="form-check-label" for="male">Male</label>
                                            </div>
                                            <div class="form-check form-check-inline">
                                                <input class="form-check-input" type="radio" name="gender" id="female" value="${!account.gender}">
                                                <label class="form-check-label" for="female">Female</label>
                                            </div>
                                        </div>
                                    </div>
<%--                                    <div class="form-group mb-3 col-6">--%>
<%--                                        <label for="roleSet">Role:</label>--%>
<%--                                        <select id="roleSet" class="form-control" name="roleSet" value="${account.roleSet.id}">--%>
<%--                                            <option>Select Role</option>--%>
<%--                                            <option value="admin">ADMIN</option>--%>
<%--                                            <option value="user">USER</option>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>
                                </div>
                                <div class="row">
                                    <div class="form-group mb-3 col-6">
                                        <label for="createDate">Create Date:</label>
                                        <input name="createDate" value="${account.createDate}" type="date" class="form-control" id="createDate" readonly>
                                    </div>
                                    <div class="form-group mb-3 col-6">
                                        <label for="createUpdate">Update Date:</label>
                                        <input name="createUpdate" value="${account.createUpdate}" type="date" class="form-control" id="createUpdate" readonly>
                                    </div>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="img">Image:</label>
                                    <input name="img" value="${account.img}" type="text" class="form-control" id="img"/>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="address">Address:</label>
                                    <textarea class="form-control"
                                              name="address"
                                              id="address"
                                              style="height: 100px">${account.address}</textarea>
                                </div>
                                <div class="form-group mb-3">
                                    <label for="token">Token:</label>
                                    <textarea class="form-control"
                                              name="token"
                                              id="token"
                                              style="height: 100px">${account.token}</textarea>
                                </div>
                                <input type="hidden" id="isEdit" name="isEdit" value="${isEdit}" class="form-control">
                                <button class="btn btn-success" type="submit">Save</button>
                                <a class="btn btn-info">Clear</a>
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
