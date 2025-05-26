<%@include file="/common/taglib.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <title>Lịch sử thuê xe - EBicycleRent</title>
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

        <!-- Section Lịch sử -->
        <section class="dashboard-actions">
            <h2 style="text-align:center;">Lịch sử thuê xe</h2>
            <div class="actions-grid">
                <c:forEach items="${listDatXe}" var="datXe">
                    <div class="action-card">
                        <i class="fas fa-history"></i>

                        <!-- Loại xe -->
                        <c:forEach items="${listXeDap}" var="xeDap">
                            <c:if test="${datXe.xeID == xeDap.xeID}">
                                <h3>${xeDap.loaiXe}</h3>
                            </c:if>
                        </c:forEach>

                        <p><strong>Ngày thuê:</strong> ${datXe.ngay}</p>

                        <!-- Tên trạm bắt đầu và kết thúc -->
                        <p><strong>Trạm:</strong> 
                            <c:forEach items="${listTramXe}" var="tramXe">
                                <c:if test="${datXe.tramXeBatDau == tramXe.tramXeID}">
                                    ${tramXe.tenTram}
                                </c:if>
                            </c:forEach>
                            →
                            <c:forEach items="${listTramXe}" var="tramXe">
                                <c:if test="${datXe.tramXeKetThuc == tramXe.tramXeID}">
                                    ${tramXe.tenTram}
                                </c:if>
                            </c:forEach>
                        </p>

                        <p><strong>Thời gian:</strong> ${datXe.thoiGianChoThue}</p>
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
