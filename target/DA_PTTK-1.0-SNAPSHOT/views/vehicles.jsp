<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Danh sách xe - EBicycleRent</title>
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

        <div class="vehicles-container">
            <h2>Danh sách xe</h2>
            <table class="vehicle-table">
                <thead>
                    <tr>
                        <th>Mã xe</th>
                        <th>Mã trạm</th>
                        <th>Loại xe</th>
                        <th>Trạng thái</th>                    
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listXeDap}" var="xeDap">
                        <tr>
                            <td>${xeDap.xeID}</td>
                            <td>${xeDap.tramXeID}</td>
                            <td>${xeDap.loaiXe}</td>                         
                            <td>${xeDap.trangThaiXe}</td>
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
