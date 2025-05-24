<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tìm kiếm trạm xe - EBicycleRent</title>
        <link href="<c:url value='template/css/styles.css'/>" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="https://unpkg.com/leaflet/dist/leaflet.css" />
        <style>
            #map {
                height: 500px;
                width: 100%;
                margin-top: 20px;
                border-radius: 12px;
                box-shadow: 0 0 10px rgba(0,0,0,0.1);
            }

            body.dark-mode #map {
                filter: invert(90%) hue-rotate(180deg);
            }
        </style>
    </head>
    <body onload="initMap()">
        <!-- Navbar -->
        <nav class="navbar">
            <div class="logo">
                <img src="images/logo-bike.png" alt="Logo" />
                <span>EBicycleRent</span>
            </div>

            <ul class="nav-links">               
                <c:if test="${sessionScope.TAIKHOAN != null}">
                    <li><a href="<c:url value='/home'/>"><i class="fas fa-home"></i> Trang chủ</a></li>
                    <li><a href="<c:url value='/rent'/>"><i class="fas fa-bicycle"></i> Thuê xe</a></li>
                    <li><a href="<c:url value='/return'/>"><i class="fas fa-undo-alt"></i> Trả xe</a></li>
                    <li><a href="topup.html"><i class="fas fa-wallet"></i> Nạp tiền</a></li>
                    <li><a href="<c:url value='/profile'/>"><i class="fas fa-user"></i> Hồ sơ</a></li>
                    <li><a href="<c:url value='/stations'/>"><i class="fas fa-map-marker-alt"></i> Trạm xe</a></li>
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
                        <a href="<c:url value='/rent'/>" class="sidebar-item">
                            <i class="fas fa-bicycle"></i>
                            <span>Thuê xe</span>
                        </a>
                        <a href="<c:url value='/return'/>" class="sidebar-item">
                            <i class="fas fa-undo-alt"></i>
                            <span>Trả xe</span>
                        </a>
                        <a href="<c:url value='/current_rentals'/>" class="sidebar-item">
                            <i class="fas fa-clock"></i>
                            <span>Xe đang thuê</span>
                        </a>
                        <a href="<c:url value='/rental_history'/>" class="sidebar-item">
                            <i class="fas fa-history"></i>
                            <span>Lịch sử thuê</span>
                        </a>
                        <a href="promotions.html" class="sidebar-item">
                            <i class="fas fa-tags"></i>
                            <span>Ưu đãi</span>
                        </a>
                        <a href="<c:url value='/profile'/>" class="sidebar-item">
                            <i class="fas fa-user-circle"></i>
                            <span>Hồ sơ cá nhân</span>
                        </a>
                        <a href="topup.html" class="sidebar-item">
                            <i class="fas fa-wallet"></i>
                            <span>Nạp tiền</span>
                        </a>
                        <a href="<c:url value='/station_search'/>" class="sidebar-item">
                            <i class="fas fa-search-location"></i>
                            <span>Tìm trạm xe</span>
                        </a>
                        <a href="<c:url value='/stations'/>" class="sidebar-item">
                            <i class="fas fa-map-marker-alt"></i>
                            <span>Danh sách trạm</span>
                        </a>
                        <a href="<c:url value='/vehicles'/>" class="sidebar-item">
                            <i class="fas fa-motorcycle"></i>
                            <span>Xe có sẵn</span>
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


        <div class="search-container">
            <h2>Tìm kiếm trạm xe</h2>
            <form class="form-group">
                <input type="text" placeholder="Nhập tên khu vực hoặc quận/huyện...">
                <button type="submit">Tìm kiếm</button>
            </form>

            <div class="station-list">
                <div class="station-item">
                    <h4>Trạm A - Quận 1</h4>
                    <p>Số xe hiện có: 5</p>
                    <p>Số chỗ trống: 10</p>
                </div>
                <div class="station-item">
                    <h4>Trạm B - Quận 3</h4>
                    <p>Số xe hiện có: 2</p>
                    <p>Số chỗ trống: 8</p>
                </div>
            </div>

            <!-- Bản đồ trạm xe -->
            <div id="map"></div>
        </div>

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
        <script src="https://unpkg.com/leaflet/dist/leaflet.js"></script>
        <script>
        function initMap() {
            const vietnamBounds = [
                [8.0, 102.0], // Tọa độ Tây Nam Việt Nam
                [23.5, 110.0]   // Tọa độ Đông Bắc Việt Nam
            ];

            const map = L.map('map', {
                center: [16.047079, 108.206230], // Trung tâm VN (Đà Nẵng)
                zoom: 6,
                minZoom: 5,
                maxZoom: 16,
                maxBounds: vietnamBounds,
                maxBoundsViscosity: 1.0,
                zoomSnap: 0.25,
            });

            L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a>'
            }).addTo(map);

            // Trạm mẫu
            const stations = [
                {name: "Trạm Lê Duẩn - Đà Nẵng", lat: 16.06778, lng: 108.22083, quantity: 7},
                {name: "Trạm Nguyễn Huệ - Huế", lat: 16.46371, lng: 107.59087, quantity: 4},
                {name: "Trạm Nguyễn Văn Cừ - TP.HCM", lat: 10.762622, lng: 106.660172, quantity: 9},
                {name: "Trạm Cầu Giấy - Hà Nội", lat: 21.0358, lng: 105.7896, quantity: 5}
            ];

            stations.forEach(station => {
                const marker = L.marker([station.lat, station.lng]).addTo(map);
                marker.bindPopup(`<b>${station.name}</b><br>Xe có sẵn: ${station.quantity}`);
            });
        }


        document.querySelector('.mode-switch')?.addEventListener('click', () => {
            document.body.classList.toggle('dark-mode');
        });
        </script>
    </body>
</html>
