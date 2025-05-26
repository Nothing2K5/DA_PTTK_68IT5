<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thuê xe - EBicycleRent</title>
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

        <div class="rent-container">
            <h2>Thông tin xe thuê</h2>
            <form action="<c:url value='/rent'/>" method="post">
                <div class="form-group">
                    <label>Mã xe</label>
                    <input type="text" id="xeID" name="xeID" value="${xeDap.xeID}" required>
                </div>
                <div class="form-group">
                    <label>Loại xe</label>
                    <input type="text" id="loaiXe" name="loaiXe" value="${xeDap.loaiXe}" readonly>
                </div>      
                <div class="form-group">
                    <label>Tên trạm</label>
                    <input type="text" id="tenTram" name="tenTram" value="${tramXe.tenTram}" required>
                    <input type="hidden" id="tramXeID" name="tramXeID" value="${tramXe.tramXeID}" required>
                </div>                                       
                <div class="form-actions">
                    <button type="submit" class="save-btn">Thuê xe</button>                    
                </div>
            </form>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
        <script>
            document.querySelector('.delete-btn')?.addEventListener('click', () => {
                if (confirm('Bạn có chắc chắn muốn xoá tài khoản? Hành động này không thể hoàn tác.')) {
                    window.location.href = '<c:url value="/profile?action=delete"/>';
                }
            });
        </script>

    </body>
</html>
