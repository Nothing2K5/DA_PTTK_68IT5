<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Trả xe - EBicycleRent</title>
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

        <div class="return-container">
            <h2>Trả xe & Thanh toán</h2>
            <div class="info">
                <p><strong>Mã xe:</strong> ${datXe.xeID}</p>
                <p><strong>Thời gian thuê:</strong> ${datXe.thoiGianChoThue}</p>
                <p><strong>Phí thuê (tạm tính):</strong> ${datXe.chiPhi} VNĐ</p>
            </div>
            <form action="<c:url value='/return?datXeID=${datXe.datXeID}'/>" method="post">
                <div class="form-group">
                    <label for="station">Chọn trạm trả xe</label>
                    <select id="tramXeID" name="tramXeID" required>
                        <option value="">-- Chọn trạm --</option>
                        <c:forEach items="${listTramXe}" var="tramXe">
                            <option value="${tramXe.tramXeID}">${tramXe.tenTram}</option>
                        </c:forEach>                                         
                    </select>
                </div>
                <div class="form-group">
                    <label for="payment">Phương thức thanh toán</label>
                    <select id="payment" name="payment" required>
                        <option value="wallet">Ví tài khoản</option>
                        <option value="bank">Ngân hàng</option>
                        <option value="momo">Ví MoMo</option>
                    </select>
                </div>
                <button type="submit">Trả xe & Thanh toán</button>
            </form>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
