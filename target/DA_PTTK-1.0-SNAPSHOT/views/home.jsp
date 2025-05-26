<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Dashboard - EBicycleRent</title>
        <link href="<c:url value='template/css/styles.css'/>" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css"/>
    </head>
    <body>

        <!-- navbar -->
        <%@ include file="/common/navbar.jsp"%>
        <!-- navbar -->

        <!-- sidebar -->
        <%@ include file="/common/sidebar.jsp"%>
        <!-- sidebar -->

        <!-- Hero -->
        <header class="hero">
            <div class="hero-overlay-light">
                <div class="hero-text">
                    <h1>🚴‍♂️ Chào mừng đến với EBicycleRent</h1>
                    <p>Giải pháp thuê xe đạp điện thông minh, nhanh chóng và an toàn.</p>
                    <a href="<c:url value='/stations'/>" class="hero-btn">🚀 Thuê xe ngay</a>
                </div>
            </div>
        </header>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>