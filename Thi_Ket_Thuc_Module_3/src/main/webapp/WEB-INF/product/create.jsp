<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Tạo tài khoản</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <style>
        sup {
            color: red;
        }
    </style>
    <jsp:include page="/WEB-INF/layout/meta_css.jsp"></jsp:include>
</head>

<body>

<!-- Begin page -->
<div id="wrapper">


    <!-- Topbar Start -->
    <jsp:include page="/WEB-INF/layout/navbar-custom.jsp"></jsp:include>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <jsp:include page="/WEB-INF/layout/left-side-menu.jsp"></jsp:include>

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid" style="margin-top: 25px">


                <div class="row">
                    <c:if test="${!requestScope.errors.isEmpty()&&requestScope.errors!=null }">
                        <c:forEach items="${requestScope.errors}" var="item">
                            <div class="alert alert-warning" role="alert">
                                <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span
                                            class="mdi mdi-close" aria-hidden="true"></span></button>
                                    <div class="icon"><span class="mdi mdi-close-circle-o"></span></div>
                                    <div class="message">
                                        <span>Error!</span>
                                            ${item}
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>


                    <c:if test="${requestScope.message!=null}">
                        <div class="alert alert-success alert-dismissible" role="alert">
                            <button class="close" type="button" data-dismiss="alert" aria-label="Close"><span
                                    class="mdi mdi-close" aria-hidden="true"></span></button>
                            <div class="icon"><span class="mdi mdi-check"></span></div>
                            <div class="message">
                                <strong><i class="fa-brands fa-creative-commons-nd"></i></strong>
                                    ${requestScope.message}
                            </div>
                        </div>
                    </c:if>


                    <div class="col-md-8">
                        <div class="card card-user">
                            <div class="card-header">
                                <h5 class="card-title">Thêm sản phẩm mới</h5>
                            </div>
                            <div class="card-body">
                                <form method="post">
                                    <div class="row">
                                        <div class="col-md-4 pr-1">
                                            <div class="form-group">
                                                <label>Tên sản phẩm <sup>*</sup></label>
                                                <input type="text" class="form-control" name="name">
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-1">
                                            <div class="form-group">
                                                <label>Giá sản phẩm <sup>*</sup></label>
                                                <input type="number" min="100000" step="10000" class="form-control"
                                                       name="price"> (vnđ)
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label>Số lượng <sup>*</sup></label>
                                                <input type="number" class="form-control" min="1" name="quantity">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label>Màu sắc <sup>*</sup></label>
                                                <input type="text" class="form-control" min="1" name="color">
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-1">
                                            <div class="form-group">
                                                <label  class="form-label">Category</label>
                                                <select name="category_id">
                                                    <c:forEach items="${listCategory}" var="category">
                                                        <option value="${category.getCategory_id()}">${category.getCategory_name()}</option>
                                                    </c:forEach>
                                                </select>

                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Mô tả</label>
                                                <textarea class="form-control textarea" placeholder="Mô tả sản phẩm"
                                                          name="describes"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row col-md-7">
                                        <div class="update ml-auto mr-auto" style="float: left">
                                            <button type="submit" class="btn btn-primary btn-round">Thêm sản phẩm
                                            </button>
                                        </div>
                                        <div class="update ml-auto mr-auto" style="float: right">
                                            <button type="submit" class="btn btn-primary btn-round"><a href="/product">Hủy</a></button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>


                </div>

            </div>

        </div>
    </div>
</div>
<footer class="footer">
    <div class="container-fluid">
    </div>
</footer>


<jsp:include page="/WEB-INF/layout/script.jsp"></jsp:include>

</body>

</html>
