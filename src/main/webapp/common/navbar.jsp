<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navbar -->
<nav class="navbar">
    <div class="logo">
        <img src="images/logo-bike.png" alt="Logo" />
        <span>EBicycleRent</span>
    </div>

    <ul class="nav-links">               
        <c:if test="${sessionScope.TAIKHOAN != null && sessionScope.TAIKHOAN.vaiTro eq 'Khách hàng'}">
            <li><a href="<c:url value='/home'/>"><i class="fas fa-home"></i> Trang chủ</a></li>
            <li><a href="<c:url value='/stations'/>"><i class="fas fa-map-marker-alt"></i> Trạm xe</a></li>                 
            <li><a href="<c:url value='/topup'/>"><i class="fas fa-wallet"></i> Nạp tiền</a></li>
            <li><a href="<c:url value='/profile'/>"><i class="fas fa-user"></i> Hồ sơ</a></li>                   
            <li><a href="notifications.html"><i class="fas fa-bell"></i> Thông báo</a></li>                   
        </c:if>
        <c:if test="${sessionScope.TAIKHOAN != null && sessionScope.TAIKHOAN.vaiTro eq 'Quản lý'}">
            <li><a href="<c:url value='/home'/>"><i class="fas fa-home"></i> Trang chủ</a></li>
            <li><a href="<c:url value='/stations'/>"><i class="fas fa-map-marker-alt"></i> Danh sách trạm xe</a></li>                 
            <li><a href="<c:url value='/vehicles'/>"><i class="fas fa-wallet"></i> Danh sách xe</a></li>
            <li><a href="<c:url value='/profile'/>"><i class="fas fa-user"></i> Trang cá nhân</a></li>                                                
        </c:if>
    </ul>

    <!-- Group control area -->
    <div class="control-group">
        <!-- Dark mode icon -->
        <div class="mode-switch">
            <i class="fas fa-moon"></i>
        </div>

        <!-- Sidebar toggle only when logged in -->
        <c:if test="${sessionScope.TAIKHOAN != null}">
            <div class="sidebar-toggle">
                <i class="fas fa-bars"></i>
            </div>
        </c:if>

        <!-- Login/Logout button -->
        <c:choose>
            <c:when test="${sessionScope.TAIKHOAN != null}">
                <a href="<c:url value='/logout'/>" class="btn-auth"><i class="fas fa-sign-out-alt"></i> Đăng xuất</a>
            </c:when>
            <c:otherwise>
                <a href="<c:url value='/login'/>" class="btn-auth"><i class="fas fa-sign-in-alt"></i> Đăng nhập</a>
            </c:otherwise>
        </c:choose>
    </div>
</nav>       