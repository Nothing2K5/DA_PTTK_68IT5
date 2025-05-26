<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông báo - EBicycleRent</title>
        <link href="<c:url value='template/css/styles.css'/>" rel="stylesheet" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>
    <body>
        <!-- navbar -->
        <%@ include file="/common/navbar.jsp"%>
        <!-- navbar -->

        <!-- sidebar -->
        <%@ include file="/common/sidebar.jsp"%>
        <!-- sidebar -->

        <div class="notifications-container">
            <h2>Thông báo từ hệ thống</h2>

            <div class="notifications">
                <p><strong>🔋 Tài khoản sắp hết tiền:</strong> Số dư hiện tại của bạn dưới 20.000 VNĐ.</p>
                <time>07/05/2025 10:32</time>
            </div>

            <div class="notifications warning">
                <p><strong>⚠️ Trạm B đã hết xe:</strong> Vui lòng chọn trạm khác gần bạn.</p>
                <time>07/05/2025 09:50</time>
            </div>

            <div class="notifications danger">
                <p><strong>⏱️ Bạn đã thuê xe quá thời gian tối đa:</strong> Vui lòng trả xe sớm để tránh phụ phí.</p>
                <time>06/05/2025 18:20</time>
            </div>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>