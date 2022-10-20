<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Vertical layout | Zircos - Responsive Bootstrap 4 Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="Responsive bootstrap 4 admin template" name="description">
    <meta content="Coderthemes" name="author">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <jsp:include page="/WEB-INF/layout/meta_css.jsp"></jsp:include>

</head>

<body>

<!-- Begin page -->
<div id="wrapper">
    <jsp:include page="/WEB-INF/layout/navbar-custom.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/layout/left-side-menu.jsp"></jsp:include>


    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <div class="row">
                    <div class="col-md-5">
                        <h1><a href="list.html"></a> Danh sách sản phẩm</h1>
                    </div>
                    <div class="col-lg-7">
                    </div>
                    <div class="col-lg-2 ">
                        <a href="/product?action=create" class="btn btn-primary" style="float: right; margin-top: 30px">Thêm sản phẩm mới</a>
                    </div>
                </div>
                <div class="row">
                    <table class="table table-hover">
                        <thead>
                        <tr class="text-white">
                            <th scope="col" class="text-center">Id</th>
                            <th scope="col" class="text-center">Tên sản phẩm</th>
                            <th scope="col" class="text-center">Giá</th>
                            <th scope="col" class="text-center">Số lượng</th>
                            <th scope="col" class="text-center">màu sắc</th>
                            <th scope="col" class="text-center">Mô tả</th>
                            <th scope="col" class="text-center">danh mục</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listProduct}" var="item">
                            <tr>
                                <th scope="col" class="text-center">${item.id}</th>
                                <td class="text-center"><a href="/product?action=update&id=${item.id}">${item.name}</a></td>
                                <td class="text-center col-md2"><fmt:formatNumber type="number" maxFractionDigits="3"
                                                      value="${item.price}"/> vnđ</td>
                                <td class="text-center">${item.quantity}</td>
                                <td class="text-center">${item.color}</td>
                                <td class="text-center">${item.describes}</td>
                                <td class="text-center">
                                    <c:forEach items="${applicationScope.listCategory}" var="category">
                                        <c:if test="${category.getCategory_id()==product.getCategory_id()}">
                                            ${category.getCategory_name()}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td class="text-center">
                                    <button type="button" class="btn btn-warning"><i class="far fa-trash-alt">

                                    </i> <a onclick="showMessager(${item.id})" methods="post">Xóa</a>
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

            </div>

        </div>
        <footer class="footer">
            <div class="container-fluid">
            </div>
        </footer>

    </div>
        <script>
            function showMessager(id) {
                if (confirm("Bạn có muốn xóa sản phẩm này không?") === true) {
                    window.location.href = "/product?action=delete&id=" + id;
                }
            }
        </script>
    <jsp:include page="/WEB-INF/layout/script.jsp"></jsp:include>

</body>

</html>
