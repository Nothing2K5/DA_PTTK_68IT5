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
        <!-- navbar -->
        <%@ include file="/common/navbar.jsp"%>
        <!-- navbar -->

        <!-- sidebar -->
        <%@ include file="/common/sidebar.jsp"%>
        <!-- sidebar -->


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

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

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
        </script>
    </body>
</html>
