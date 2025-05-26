<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Xe đang thuê - EBicycleRent</title>
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
        
        <!-- Section Xe đang thuê -->
        <section class="dashboard-actions">
            <h2 style="text-align:center;">Xe bạn đang thuê</h2>
            <div class="actions-grid">
                <c:forEach var="datXe" items="${listDX}">
                    <c:set var="xeDap" value="${mapXD[datXe.datXeID]}" />
                    <c:set var="tramXe" value="${mapTX[datXe.datXeID]}" />

                    <div class="action-card">
                        <i class="fas fa-bicycle"></i>
                        <h3>${xeDap.loaiXe}</h3>
                        <p><strong>Bắt đầu:</strong> ${datXe.thoiGianBatDau} ngày ${datXe.ngay}</p>
                        <p><strong>Vị trí:</strong> ${tramXe.tenTram} (${tramXe.diaChi})</p>
                        <form action="<c:url value='/return?datXeID=${datXe.datXeID}'/>">
                            <input type="hidden" name="datXeID" value="${datXe.datXeID}" />
                            <button type="submit" class="hero-btn">Trả xe</button>
                        </form>
                    </div>
                </c:forEach>
            </div>
        </section>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
