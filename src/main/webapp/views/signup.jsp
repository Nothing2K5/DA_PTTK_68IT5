<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Đăng ký - EBicycleRent</title>
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

        <div class="form-container">
            <h2>Đăng ký tài khoản</h2>
            <form action="<c:url value='/signup'/>" method="post">
                <div class="form-group">
                    <label for="fullname">Họ và tên</label>
                    <input type="text" id="hoTen" name="hoTen" required>
                </div>      
                <div class="form-group">
                    <label for="phone">Số điện thoại</label>
                    <input type="tel" id="sdt" name="sdt" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="password">Mật khẩu</label>
                    <input type="password" id="matKhau" name="matKhau" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">Xác nhận mật khẩu</label>
                    <input type="password" id="re_matKhau" name="re_matKhau" required>
                </div>
                <div class="form-group">
                    <button type="submit">Đăng ký</button>
                </div>
                <div class="form-footer">
                    Đã có tài khoản? <a href="<c:url value='/login'/>">Đăng nhập</a>
                </div>
            </form>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
