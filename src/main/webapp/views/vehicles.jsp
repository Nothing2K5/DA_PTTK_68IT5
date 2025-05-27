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
        <style>
            .edit-form-row {
                background-color: #e8f4fd; /* nền xanh nhạt */
                transition: all 0.3s ease;
                font-size: 14px;
            }

            .edit-form-row td {
                padding: 10px;
                border-top: 1px solid #ccc;
            }

            .edit-form-row input[type="text"],
            .edit-form-row select {
                width: 100%;
                padding: 6px 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                font-family: inherit;
                font-size: 14px;
                box-sizing: border-box;
            }

            .edit-form-row .confirm-btn {
                background-color: #4caf50;
                color: white;
                border: none;
                padding: 6px 12px;
                border-radius: 4px;
                cursor: pointer;
            }

            .edit-form-row .confirm-btn:hover {
                background-color: #45a049;
            }

            .edit-form-row .cancel-edit-btn {
                background-color: #f44336;
                color: white;
                border: none;
                padding: 6px 12px;
                border-radius: 4px;
                cursor: pointer;
                margin-left: 8px;
            }

            .edit-form-row .cancel-edit-btn:hover {
                background-color: #d32f2f;
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
        <div class="vehicles-container">
            <h2>Danh sách xe</h2>
            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Quản lý'}">
                <div style="margin-bottom: 15px; text-align: right;" class="add-btn">
                    <i class="fas fa-plus-circle"></i> Thêm xe
                </div>
            </c:if>

            <table class="vehicle-table">
                <thead>
                    <tr>
                        <th>Mã xe</th>
                        <th>Mã trạm</th>
                        <th>Loại xe</th>
                        <th>Trạng thái</th>    
                            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Quản lý'}">
                            <th>Thao tác</th>
                            </c:if>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listXeDap}" var="xeDap">
                        <tr class="data-row" id="data-${xeDap.xeID}">
                            <td>${xeDap.xeID}</td>
                            <td>${xeDap.tramXeID}</td>
                            <td>${xeDap.loaiXe}</td>                         
                            <td>${xeDap.trangThaiXe}</td>
                            <c:if test="${sessionScope.TAIKHOAN.vaiTro == 'Quản lý'}">
                                <td style="display: flex">
                                    <button type="button" onclick="handleEdit('${xeDap.xeID}')" class="edit-btn" data-xe-id="${xeDap.xeID}">
                                        <i class="fas fa-edit"></i>Sửa
                                    </button>

                                    <form action="<c:url value='/admin_vehicles' />" method="post" style="display:inline-block;"
                                          onsubmit="return confirm('Bạn có chắc muốn xóa xe này?');">
                                        <input type="hidden" name="action" value="delete" />
                                        <input type="hidden" name="xeID" value="${xeDap.xeID}" />
                                        <button type="submit" class="delete-btn"><i class="fas fa-trash"></i> Xóa</button>
                                    </form>
                                </td>
                            </c:if>
                        </tr>

                        <!-- Hidden edit form row -->
                        <tr class="edit-form-row" style="display: none;" id="edit-${xeDap.xeID}">
                            <td>${xeDap.xeID}</td>
                            <td>
                                <form action="<c:url value='/admin_vehicles' />" method="post" class="edit-form">
                                    <input type="hidden" name="action" value="update" />
                                    <input type="hidden" name="xeID" value="${xeDap.xeID}" />
                                    <input type="text" name="tramXeID" value="${xeDap.tramXeID}" required>
                                    <td>
                                        <select name="loaiXe" required>
                                            <option value="Xe đạp" ${xeDap.loaiXe == 'Xe đạp' ? 'selected' : ''}>Xe đạp</option>
                                            <option value="Xe đạp điện" ${xeDap.loaiXe == 'Xe đạp điện' ? 'selected' : ''}>Xe đạp điện</option>
                                            <option value="Xe đạp thể thao" ${xeDap.loaiXe == 'Xe đạp thể thao' ? 'selected' : ''}>Xe đạp thể thao</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select name="trangThaiXe" required>
                                            <option value="Trống" ${xeDap.trangThaiXe == 'Trống' ? 'selected' : ''}>Trống</option>
                                            <option value="Đang sử dụng" ${xeDap.trangThaiXe == 'Đang sử dụng' ? 'selected' : ''}>Đang sử dụng</option>
                                        </select>
                                    </td>
                                    <td style="display: flex">
                                        <button type="submit" class="confirm-btn"><i class="fas fa-check"></i> Xác nhận</button>
                                        <button type="button" class="cancel-edit-btn" onclick="huyEdit('${xeDap.xeID}')"><i class="fas fa-times"></i> Hủy</button>
                                    </td>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- footer -->
        <%@ include file="/common/footer.jsp"%>
        <!-- footer -->

        <!-- Popup Modal Thêm Xe Đạp -->
        <div id="addBikeModal" class="modal" style="display: none">
            <div class="modal-content">
                <span class="close-x">&times;</span>
                <h3>Thêm xe đạp mới</h3>
                <form action="<c:url value='/admin_vehicles' />" method="post" id="addBikeForm">
                    <input type="hidden" name="action" value="add" />
                    <div class="form-group">
                        <label for="tramXeID">Mã trạm:</label>
                        <input type="text" name="tramXeID" id="tramXeID" required />
                    </div>
                    <div class="form-group">
                        <label for="loaiXe">Loại xe:</label>
                        <select name="loaiXe" id="loaiXe" required>
                            <option value="">-- Chọn loại xe --</option>
                            <option value="Xe đạp">Xe đạp</option>
                            <option value="Xe đạp điện">Xe đạp điện</option>
                            <option value="Xe đạp thể thao">Xe đạp thể thao</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="trangThaiXe">Trạng thái:</label>
                        <select name="trangThaiXe" id="trangThaiXe" required>
                            <option value="Trống">Trống</option>
                            <option value="Đang sử dụng">Đang sử dụng</option>
                        </select>
                    </div>
                    <div class="form-actions">
                        <button type="submit" class="add-btn edit-btn" style="padding: 10px 0 !important">Thêm</button>
                        <button type="button" class="cancel-btn delete-btn" style="padding: 10px 0 !important">Hủy</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Scripts -->
        <script>
            // Lấy các phần tử
            const addBtn = document.querySelector('.add-btn');
            const modal = document.getElementById('addBikeModal');
            const closeBtn = modal.querySelector('.close-x');
            const cancelBtn = modal.querySelector('.cancel-btn');
            const openAddBtn = document.querySelector('.vehicles-container .add-btn');


            // Mở modal khi click nút Thêm xe
            openAddBtn.addEventListener('click', function (event) {
                event.preventDefault(); // ngăn link chuyển trang
                modal.style.display = 'flex';
            });

            // Đóng modal khi click nút X
            closeBtn.addEventListener('click', function () {
                modal.style.display = 'none';
            });

            // Đóng modal khi click nút Hủy
            cancelBtn.addEventListener('click', function () {
                modal.style.display = 'none';
            });

            // Đóng modal khi click ra ngoài nội dung form
            window.addEventListener('click', function (event) {
                if (event.target === modal) {
                    modal.style.display = 'none';
                }
            });

            function handleEdit(id) {
                console.log(id);
                // Ẩn tất cả các dòng form sửa trước đó
                document.querySelectorAll('.edit-form-row').forEach(row => {
                    row.style.display = 'none';
                });

                // Hiện dòng form sửa ứng với mã xe
                const dataRow = document.getElementById("data-" + id);
                const editRow = document.getElementById("edit-" + id);

                console.log('Tìm thấy dòng:', editRow);

                if (editRow) {
                    editRow.style.display = 'table-row';
                    dataRow.style.display = 'none';
                }
            }
            function huyEdit(id) {
                // Hiện dòng form sửa ứng với mã xe
                const dataRow = document.getElementById("data-" + id);
                const editRow = document.getElementById("edit-" + id);

                if (editRow) {
                    editRow.style.display = 'none';
                    dataRow.style.display = 'table-row';
                }
            }



            // Khi người dùng nhấn nút "Hủy"
            document.querySelectorAll('.cancel-edit-btn').forEach(button => {
                button.addEventListener('click', function () {
                    const editRow = this.closest('.edit-form-row');
                    if (editRow) {
                        editRow.style.display = 'none';
                    }
                });
            });
        </script>

        <script src="<c:url value='template/js/scripts.js'/>"></script>
    </body>
</html>
