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

        <div class="topup-container">
            <h2>Nạp tiền vào tài khoản</h2>
            <form action="<c:url value='/topup'/>" method="post">
                <div class="form-group">
                    <label for="amount">Số tiền cần nạp (VNĐ)</label>
                    <input type="number" id="soDu" name="soDu" min="10000" step="1000" required>
                </div>
                <div class="form-group">
                    <label for="method">Phương thức thanh toán</label>
                    <select id="method" name="method" required>
                        <option value="">-- Chọn phương thức --</option>
                        <option value="bank">Chuyển khoản ngân hàng</option>
                        <option value="momo">Ví MoMo</option>
                        <option value="credit">Thẻ tín dụng/Ghi nợ</option>
                    </select>
                </div>
                <button type="submit">Nạp tiền</button>
            </form>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
