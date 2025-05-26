package com.pttk.control;

import com.pttk.dao.DatXeDAO;
import com.pttk.dao.NguoiDungDAO;
import com.pttk.dao.TramXeDAO;
import com.pttk.dao.XeDapDAO;
import com.pttk.entity.NguoiDung;
import com.pttk.entity.TaiKhoan;
import com.pttk.entity.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HOANGHA
 */
@WebServlet(urlPatterns = {"/rent"})
public class RentControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tramXeID = req.getParameter("tramXeID");
        String loaiXe = req.getParameter("loaiXe");

        String view = "";

        if (tramXeID != null && loaiXe != null) {
            XeDapDAO xddao = new XeDapDAO();
            TramXeDAO txdao = new TramXeDAO();

            List<XeDap> listXeDap = xddao.findByTramXeAndLoaiXe(tramXeID, loaiXe);
            XeDap xeDap = new XeDap();

            for (XeDap xd : listXeDap) {
                if (xd.getTrangThaiXe().equals("Trống")) {
                    xeDap = xd;
                    break;
                }
            }

            req.setAttribute("xeDap", xeDap);
            req.setAttribute("tramXe", txdao.findOne(tramXeID));

            view = "/views/rent_bicycle.jsp";
        } else if (tramXeID != null) {
            XeDapDAO xddao = new XeDapDAO();

            req.setAttribute("checkXeDap", xddao.checkByTramXeAndLoaiXeAndTrangThai(tramXeID, "Xe đạp", "Trống"));
            req.setAttribute("checkXeDapTheThao", xddao.checkByTramXeAndLoaiXeAndTrangThai(tramXeID, "Xe đạp thể thao", "Trống"));
            req.setAttribute("checkXeDapDien", xddao.checkByTramXeAndLoaiXeAndTrangThai(tramXeID, "Xe đạp điện", "Trống"));

            view = "/views/rent.jsp";
        } else {
            view = "/views/rent.jsp";
        }

        RequestDispatcher rd = req.getRequestDispatcher(view);
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        NguoiDungDAO nddao = new NguoiDungDAO();
        DatXeDAO dxdao = new DatXeDAO();
        XeDapDAO xddao = new XeDapDAO();

        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        NguoiDung nd = nddao.findOneByTKID(tkSession.getTKID());

        String xeID = req.getParameter("xeID");
        String tramXeID = req.getParameter("tramXeID");
        String loaiXe = req.getParameter("loaiXe");
        String userID = nd.getUserID();

        Date ngay = Date.valueOf(LocalDate.now());
        String thoiGianBatDau = Time.valueOf(LocalTime.now()).toString();
        String thoiGianKetThuc = "00:00:00";
        String thoiGianChoThue = "00:00:00";

        String trangThai = "Đã đặt";
        int chiPhi = 0;

        String datXeID = dxdao.add(userID, xeID, tramXeID, "", ngay, thoiGianBatDau, thoiGianKetThuc, thoiGianChoThue, trangThai, chiPhi);
        xddao.update(xeID, tramXeID, loaiXe, "Đang sử dụng");

        resp.sendRedirect(req.getContextPath() + "/current_rentals");
    }

}
