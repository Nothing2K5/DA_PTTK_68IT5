<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Thuê xe - EBicycleRent</title>
        <link href="<c:url value='template/css/styles.css'/>" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>
        <!-- Navbar -->
        <nav class="navbar">
            <div class="logo">
                <img src="images/logo-bike.png" alt="Logo" />
                <span>EBicycleRent</span>
            </div>

            <ul class="nav-links">               
                <c:if test="${sessionScope.TAIKHOAN != null}">
                    <li><a href="<c:url value='/home'/>"><i class="fas fa-home"></i> Trang chủ</a></li>
                    <li><a href="<c:url value='/stations'/>"><i class="fas fa-map-marker-alt"></i> Trạm xe</a></li>                 
                    <li><a href="<c:url value='/topup'/>"><i class="fas fa-wallet"></i> Nạp tiền</a></li>
                    <li><a href="<c:url value='/profile'/>"><i class="fas fa-user"></i> Hồ sơ</a></li>                   
                    <li><a href="notifications.html"><i class="fas fa-bell"></i> Thông báo</a></li>                   
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


        <!-- Sidebar -->
        <c:if test="${sessionScope.TAIKHOAN != null}">
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

        <!-- Section Thuê xe -->
        <section class="dashboard-actions">
            <h2 style="text-align:center; margin-bottom: 1rem;">Chọn xe để thuê</h2>
            <div class="actions-grid">
                <div class="action-card">
                    <i class="fas fa-bicycle"></i>
                    <h3>Xe đạp</h3>
                    <p>Phù hợp di chuyển ngắn</p>
                    <c:if test="${checkXeDap == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp'/>">Thuê ngay</a>
                    </c:if>       
                </div>
                <div class="action-card">
                    <i class="fas fa-bolt"></i>
                    <h3>Xe đạp thể thao</h3>
                    <p>Hiệu suất cao, thoải mái</p>
                    <c:if test="${checkXeDapTheThao == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp thể thao'/>">Thuê ngay</a>
                    </c:if>

                </div>
                <div class="action-card">
                    <i class="fas fa-motorcycle"></i>
                    <h3>Xe đạp điện</h3>
                    <p>Thích hợp cho đi lại xa</p>
                    <c:if test="${checkXeDapDien == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp điện'/>">Thuê ngay</a>
                    </c:if>

                </div>
            </div>
        </section>

        <!-- Footer -->
        <footer>
            <div class="footer-content">
                <div>
                    <h4>Liên hệ</h4>
                    <p><i class="fas fa-phone"></i> 0123 456 789</p>
                    <p><i class="fas fa-envelope"></i> support@ebicyclerent.vn</p>
                </div>
                <div>
                    <h4>Địa điểm chính</h4>
                    <p><i class="fas fa-map-marker-alt"></i> 456 Đường X, Quận Y, TP.HCM</p>
                </div>
                <div>
                    <h4>Mạng xã hội</h4>
                    <p><i class="fab fa-facebook"></i> @ebicyclerent</p>
                    <p><i class="fab fa-instagram"></i> @ebicycle.vn</p>
                </div>
            </div>
            <p class="footer-bottom">&copy; 2025 EBicycleRent. All rights reserved.</p>
        </footer>

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
