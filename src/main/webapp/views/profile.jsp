<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Thông tin cá nhân - EBicycleRent</title>
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
        
        <div class="profile-container">
            <h2>Thông tin cá nhân</h2>
            <form action="<c:url value='/profile'/>" method="post">
                <div class="form-group">
                    <label for="fullname">Họ và tên</label>
                    <input type="text" id="hoTen" name="hoTen" value="${thongTin.hoTen}" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="${thongTin.email}" required>
                </div>
                <div class="form-group">
                    <label for="phone">Số điện thoại</label>
                    <input type="tel" id="sdt" name="sdt" value="${taiKhoan.sdt}" required>
                </div>
                <div class="form-group">
                    <label for="price">Số dư</label>
                    <input type="text" id="soDu" name="soDu" value="${taiKhoan.soDu}" readonly>
                </div>
                <div class="form-group">
                    <label for="password">Đổi mật khẩu (nếu muốn)</label>
                    <input type="password" id="matKhau" name="matKhau">
                </div>
                <div class="form-actions">
                    <button type="submit" class="save-btn">Lưu thay đổi</button>
                    <button type="button" class="delete-btn">Xóa tài khoản</button>
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
