<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="navbar-custom">
    <ul class="list-unstyled topnav-menu float-right mb-0">
        <li class="dropdown notification-list">
            <%
                String username = "";
                if (session.getAttribute("username") != null) {
                    username = (String) session.getAttribute("username");
                    System.out.println("JSP username: " + username);
                }

            %>
            <a class="nav-link dropdown-toggle nav-user mr-0 waves-effect" data-toggle="dropdown" href="#"
               role="button" aria-haspopup="false" aria-expanded="false">
                <img src="/assets/images/avatardefault.png" alt="user-image" class="rounded-circle">
                <span class="d-none d-sm-inline-block ml-1"><%=username%></span>
            </a>
            <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                <!-- item-->
                <div class="dropdown-header noti-title">
                    <h6 class="text-overflow m-0">Welcome !</h6>
                </div>
                <!-- item-->
                <div class="dropdown-divider"></div>
                <!-- item-->
                <a href="/logout" class="dropdown-item notify-item">
                    <i class="mdi mdi-logout-variant"></i>
                    <span>Logout</span>
                </a>
            </div>

        </li>
    </ul>
</div>
