<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh sách trạm xe - EBicycleRent</title>
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

        <div class="stations-container">
            <h2>Danh sách trạm xe</h2>
            <table class="station-table">
                <thead>
                    <tr>
                        <th>Mã trạm</th>
                        <th>Tên trạm</th>
                        <th>Địa chỉ</th>
                        <th>Tổng số chỗ</th>
                        <th>Số xe khả dụng</th>
                        <th>Số chỗ trống</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listTramXe}" var="tramXe">
                        <tr>
                            <td>${tramXe.tramXeID}</td>
                            <td>${tramXe.tenTram}</td>
                            <td>${tramXe.diaChi}</td>
                            <td>${tramXe.tongChoDo}</td>
                            <td>
                                <a href="<c:url value='/vehicles?tramXeID=${tramXe.tramXeID}'/>">
                                    ${tramXe.soXeKhaDung}
                                </a>
                            </td>
                            <td>${tramXe.soChoTrong}</td>
                            <td><a class="btn-rent" href="<c:url value='/rent?tramXeID=${tramXe.tramXeID}'/>">Thuê xe</a></td>
                        </tr>
                    </c:forEach>                   
                </tbody>
            </table>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>