<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Sidebar -->
<c:if test="${sessionScope.TAIKHOAN != null && sessionScope.TAIKHOAN.vaiTro eq 'Khách hàng'}">
    <div class="sidebar" id="sidebar">
        <div class="sidebar-header">
            <h3><i class="fas fa-tachometer-alt"></i> Chức năng</h3>
            <div class="sidebar-close">
                <i class="fas fa-times"></i>
            </div>
        </div>
        <div class="sidebar-content">
            <div class="sidebar-menu">
                <a href="<c:url value='/profile'/>" class="sidebar-item">
                    <i class="fas fa-user-circle"></i>
                    <span>Hồ sơ cá nhân</span>
                </a>
                <a href="<c:url value='/topup'/>" class="sidebar-item">
                    <i class="fas fa-wallet"></i>
                    <span>Nạp tiền</span>
                </a>
                <a href="<c:url value='/stations'/>" class="sidebar-item">
                    <i class="fas fa-map-marker-alt"></i>
                    <span>Danh sách trạm</span>
                </a>
                <a href="<c:url value='/station_search'/>" class="sidebar-item">
                    <i class="fas fa-search-location"></i>
                    <span>Tìm trạm xe</span>
                </a>
                <a href="<c:url value='/vehicles'/>" class="sidebar-item">
                    <i class="fas fa-motorcycle"></i>
                    <span>Xe có sẵn</span>
                </a>
                <a href="<c:url value='/current_rentals'/>" class="sidebar-item">
                    <i class="fas fa-clock"></i>
                    <span>Xe đang thuê</span>
                </a>
                <a href="<c:url value='/rental_history'/>" class="sidebar-item">
                    <i class="fas fa-history"></i>
                    <span>Lịch sử thuê</span>
                </a>
                <a href="<c:url value='/rent'/>" class="sidebar-item">
                    <i class="fas fa-bicycle"></i>
                    <span>Thuê xe</span>
                </a>
                <a href="<c:url value='/return'/>" class="sidebar-item">
                    <i class="fas fa-undo-alt"></i>
                    <span>Trả xe</span>
                </a>                                           
                <a href="promotions.html" class="sidebar-item">
                    <i class="fas fa-tags"></i>
                    <span>Ưu đãi</span>
                </a>                              
                <a href="notifications.html" class="sidebar-item">
                    <i class="fas fa-bell"></i>
                    <span>Thông báo</span>
                </a>
            </div>
        </div>
    </div>

    <!-- Sidebar Overlay -->
    <div class="sidebar-overlay" id="sidebarOverlay"></div>
</c:if>

<c:if test="${sessionScope.TAIKHOAN != null && sessionScope.TAIKHOAN.vaiTro eq 'Quản lý'}">
    <div class="sidebar" id="sidebar">
        <div class="sidebar-header">
            <h3><i class="fas fa-tachometer-alt"></i> Chức năng</h3>
            <div class="sidebar-close">
                <i class="fas fa-times"></i>
            </div>
        </div>
        <div class="sidebar-content">
            <div class="sidebar-menu">
                <a href="<c:url value='/profile'/>" class="sidebar-item">
                    <i class="fas fa-user-circle"></i>
                    <span>Trang cá nhân</span>
                </a>
                <a href="<c:url value='/stations'/>" class="sidebar-item">
                    <i class="fas fa-map-marker-alt"></i>
                    <span>Danh sách trạm</span>
                </a>
                <a href="<c:url value='/station_search'/>" class="sidebar-item">
                    <i class="fas fa-search-location"></i>
                    <span>Tìm trạm xe</span>
                </a>
                <a href="<c:url value='/vehicles'/>" class="sidebar-item">
                    <i class="fas fa-motorcycle"></i>
                    <span>Xe có sẵn</span>
                </a>                                           
            </div>
        </div>
    </div>

    <!-- Sidebar Overlay -->
    <div class="sidebar-overlay" id="sidebarOverlay"></div>
</c:if>