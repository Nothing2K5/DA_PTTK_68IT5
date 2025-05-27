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
        <style>
            /* Ẩn ban đầu */
            .edit-form-row {
                background-color: #f9f9f9;
                transition: all 0.3s ease;
            }

            /* Định dạng các ô trong hàng form sửa */
            .edit-form-row input[type="text"],
            .edit-form-row input[type="number"] {
                width: 100%;
                padding: 5px 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }

            /* Căn chỉnh và bo góc các nút */
            .edit-form-row button {
                padding: 6px 10px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                white-space: nowrap;
                font-size: 14px;
            }

            /* Nút xác nhận */
            .edit-form-row .confirm-btn {
                background-color: #28a745;
                color: white;
                margin-right: 5px;
            }

            .edit-form-row .confirm-btn:hover {
                background-color: #218838;
            }

            /* Nút hủy */
            .edit-form-row .cancel-btn {
                background-color: #dc3545;
                color: white;
            }

            .edit-form-row .cancel-btn:hover {
                background-color: #c82333;
            }

            /* Cho input và nút nằm gọn trong ô */
            .edit-form-row td {
                padding: 6px 8px;
                vertical-align: middle;
            }

            /* Đảm bảo bố cục không vỡ */
            .edit-form {
                display: flex;
                flex-wrap: wrap;
                gap: 8px;
                align-items: center;
            }

            .edit-form td {
                flex: 1 1 auto;
                min-width: 100px;
            }


        </style>
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
            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Quản lý'}">
                <div style="margin-bottom: 15px; text-align: right;" class="add-btn" onclick="openAddStationModal()">
                    <i class="fas fa-plus-circle"></i> Thêm trạm xe
                </div>
            </c:if>
            <table class="station-table">
                <thead>
                    <tr>
                        <th>Mã trạm</th>
                        <th>Tên trạm</th>
                        <th>Địa chỉ</th>
                        <th>Tổng số chỗ</th>
                        <th>Số xe khả dụng</th>
                        <th>Số chỗ trống</th>
                        <th>Thao tác</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listTramXe}" var="tramXe">
                        <tr id="data-${tramXe.tramXeID}" class="data-form-row">
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
                            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Khách hàng'}">
                                <td><a class="btn-rent" href="<c:url value='/rent?tramXeID=${tramXe.tramXeID}'/>">Thuê xe</a></td>
                            </c:if>
                            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Quản lý'}">
                                <td>
                                    <div class="thao-tac-buttons" style="display: flex">
                                    <button type="button" onclick="handleEdit('${tramXe.tramXeID}')" class="edit-btn">
                                        <i class="fas fa-edit"></i>Sửa
                                    </button>

                                    <form action="<c:url value='/admin_stations' />" method="post" style="display:inline-block;"
                                          onsubmit="return confirm('Bạn có chắc muốn xóa trạm này?');">
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="hidden" name="tramXeID" value="${tramXe.tramXeID}" />
                                        <button type="submit" class="delete-btn"><i class="fas fa-trash"></i> Xóa</button>
                                    </form>
                                </div>
                                </td>
                            </c:if>                     
                        </tr>
                        <!-- Hidden edit form row -->
                        <tr class="edit-form-row" id="edit-${tramXe.tramXeID}" style="display: none;">
                    <form action="<c:url value='/admin_stations' />" method="post" class="edit-form" style="display: flex; gap: 10px; align-items: center; flex-wrap: wrap;">
                        <td>${tramXe.tramXeID}</td>

                        <input type="hidden" name="action" value="update" />
                        <input type="hidden" name="tramXeID" value="${tramXe.tramXeID}" />
                        <td>         <input type="text" name="tenTram" value="${tramXe.tenTram}" placeholder="Tên trạm" required /></td>
                        <td>  <input type="text" name="diaChi" value="${tramXe.diaChi}" placeholder="Địa chỉ" required /></td>
                        <td>    <input type="number" name="tongChoDo" value="${tramXe.tongChoDo}" min="0" placeholder="Tổng chỗ đỗ" required /></td>
                        <td>   <input type="number" name="soXeKhaDung" value="${tramXe.soXeKhaDung}" min="0" placeholder="Số xe khả dụng" required /></td>
                        <td>   <input type="number" name="soChoTrong" value="${tramXe.soChoTrong}" min="0" placeholder="Số chỗ trống" required /></td>
                        <td>   
                            <button type="submit" class="confirm-btn"><i class="fas fa-check"></i> Xác nhận</button>
                            <button type="button" class="cancel-btn" onclick="huyEdit('${tramXe.tramXeID}')"><i class="fas fa-times"></i> Hủy</button>
                        </td>
                    </form>
                    </tr>


                </c:forEach>     
                <!-- Modal thêm trạm xe -->
                <div id="addStationModal" class="add-station-modal">
                    <div class="add-station-modal-content">
                        <span class="add-station-close" onclick="closeAddStationModal()">&times;</span>
                        <h3>Thêm trạm xe mới</h3>
                        <form action="<c:url value='/admin_stations' />" method="post">
                            <input type="hidden" name="action" value="add" />

                            <label>Tên trạm:</label>
                            <input type="text" name="tenTram" required />

                            <label>Địa chỉ:</label>
                            <input type="text" name="diaChi" required />

                            <label>Tổng số chỗ đỗ:</label>
                            <input type="number" name="tongChoDo" min="1" required />

                            <div class="add-station-actions">
                                <button type="submit" class="add-station-submit-btn">Thêm</button>
                                <button type="button" class="add-station-cancel-btn" onclick="closeAddStationModal()">Hủy</button>
                            </div>
                        </form>
                    </div>
                </div>

                </tbody>
            </table>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Scripts -->
        <script>
            function openAddStationModal() {
                document.getElementById("addStationModal").style.display = "block";
            }

            function closeAddStationModal() {
                document.getElementById("addStationModal").style.display = "none";
            }

            // Đóng modal khi bấm ra ngoài
            window.onclick = function (event) {
                const modal = document.getElementById("addStationModal");
                if (event.target === modal) {
                    modal.style.display = "none";
                }
            };
            function handleEdit(tramXeID) {
                document.querySelectorAll(".data-form-row").forEach(row => {
                    row.style.display = "table-row";
                });
                // Ẩn tất cả các form đang hiển thị (nếu có)
                document.querySelectorAll(".edit-form-row").forEach(row => {
                    row.style.display = "none";
                });

                // Hiển thị form chỉnh sửa tương ứng
                const formRow = document.getElementById("edit-" + tramXeID);
                const dataRow = document.getElementById("data-" + tramXeID);
                if (formRow) {
                    formRow.style.display = "table-row";
                    dataRow.style.display = "none";
                }
            }

            function huyEdit(tramXeID) {
                document.querySelectorAll(".data-form-row").forEach(row => {
                    row.style.display = "table-row";
                });
                const formRow = document.getElementById("edit-" + tramXeID);
                const dataRow = document.getElementById("data-" + tramXeID);
                if (formRow) {
                    formRow.style.display = "none";
                    dataRow.style.display = "table-row";
                }
            }
        </script>
        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>