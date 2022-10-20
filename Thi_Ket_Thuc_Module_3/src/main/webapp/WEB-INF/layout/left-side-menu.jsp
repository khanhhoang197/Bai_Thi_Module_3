<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<div class="left-side-menu">

    <div class="slimscroll-menu">

        <div id="sidebar-menu">

            <ul style="margin-top: 160px" class="metismenu" id="side-menu">

                <li>
                    <a href="javascript: void(0);" class="waves-effect waves-light">
                        <i class="mdi mdi-layers"></i>
                        <span>  Quản lý </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <ul class="nav-second-level" aria-expanded="false">
                        <li><a href="/users">Danh sách người dùng</a></li>
                        <li><a href="/product">Danh sách sản phẩm</a></li>
                    </ul>
                </li>

                <li>
                    <a href="javascript: void(0);" class="waves-effect waves-light">
                        <i class="fa-solid fa-gear"></i>
                        <span> Cài đặt </span>
                        <span class="menu-arrow"></span>
                    </a>
                    <ul class="nav-second-level" aria-expanded="false">
                        <i class="fa-solid fa-right-to-bracket"></i>
                        <li><a href="/login">Đăng nhập</a></li>
                        <i class="fa-solid fa-right-from-bracket"></i>
                        <li><a href="/logout">Đăng xuất</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</div>