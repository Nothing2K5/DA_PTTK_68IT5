<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Thuê xe - EBicycleRent</title>
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

        <!-- Section Thuê xe -->
        <section class="dashboard-actions">
            <h2 style="text-align:center; margin-bottom: 1rem;">Chọn xe để thuê</h2>
            <div class="actions-grid">
                <div class="action-card">
                    <i class="fas fa-bicycle"></i>
                    <h3>Xe đạp</h3>
                    <p>Phù hợp di chuyển ngắn</p>
                    <c:if test="${checkXeDap == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp'/>">Thuê ngay</a>
                    </c:if>       
                </div>
                <div class="action-card">
                    <i class="fas fa-bolt"></i>
                    <h3>Xe đạp thể thao</h3>
                    <p>Hiệu suất cao, thoải mái</p>
                    <c:if test="${checkXeDapTheThao == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp thể thao'/>">Thuê ngay</a>
                    </c:if>

                </div>
                <div class="action-card">
                    <i class="fas fa-motorcycle"></i>
                    <h3>Xe đạp điện</h3>
                    <p>Thích hợp cho đi lại xa</p>
                    <c:if test="${checkXeDapDien == true}">
                        <a class="hero-btn" href="<c:url value='/rent?tramXeID=${param.tramXeID}&loaiXe=Xe đạp điện'/>">Thuê ngay</a>
                    </c:if>

                </div>
            </div>
        </section>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->
        
        <!-- Scripts -->
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
