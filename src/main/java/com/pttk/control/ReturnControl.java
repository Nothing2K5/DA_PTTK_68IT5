package com.pttk.control;

import com.pttk.dao.DatXeDAO;
import com.pttk.dao.NguoiDungDAO;
import com.pttk.dao.TramXeDAO;
import com.pttk.dao.XeDapDAO;
import com.pttk.entity.DatXe;
import com.pttk.entity.NguoiDung;
import com.pttk.entity.TaiKhoan;
import com.pttk.entity.TramXe;
import com.pttk.entity.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;
import java.time.Duration;
import java.time.LocalTime;
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
@WebServlet(urlPatterns = {"/return"})
public class ReturnControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String datXeID = req.getParameter("datXeID");

        NguoiDungDAO nddao = new NguoiDungDAO();
        DatXeDAO dxdao = new DatXeDAO();
        TramXeDAO txdao = new TramXeDAO();

        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        DatXe dx = dxdao.findOne(datXeID);
        NguoiDung nd = nddao.findOneByTKID(tkSession.getTKID());

        // Lấy thời gian hiện tại làm thời gian kết thúc
        LocalTime thoiGianKetThuc = LocalTime.now();
        LocalTime thoiGianBatDau = LocalTime.parse(dx.getThoiGianBatDau());

        // Tính thời gian thuê dưới dạng Duration
        Duration duration = Duration.between(thoiGianBatDau, thoiGianKetThuc);
        long hours = duration.toHours();
        int minutes = duration.toMinutesPart();
        int seconds = duration.toSecondsPart();

        // Chuyển thành định dạng hh:mm:ss
        String thoiGianThue = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        // Phí thuê: 2000đ/giờ (có thể làm tròn lên 1 giờ nếu muốn)
        double gioThue = duration.toMinutes() / 60.0;
        int phi = (int) Math.ceil(gioThue * 2000); // làm tròn lên

        if (dx.getThoiGianKetThuc().equals("00:00:00")) {
            dxdao.update(
                    datXeID,
                    nd.getUserID(),
                    dx.getXeID(),
                    dx.getTramXeBatDau(),
                    dx.getTramXeKetThuc(),
                    dx.getNgay(),
                    dx.getThoiGianBatDau(),
                    thoiGianKetThuc.toString(),
                    thoiGianThue, // dạng hh:mm:ss
                    "Hoàn thành",
                    phi
            );
        }

        req.setAttribute("listTramXe", txdao.findAll());
        req.setAttribute("datXe", dxdao.findOne(datXeID));

        RequestDispatcher rd = req.getRequestDispatcher("/views/return.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String datXeID = req.getParameter("datXeID");
        String tramXeKetThuc = req.getParameter("tramXeID");

        NguoiDungDAO nddao = new NguoiDungDAO();
        DatXeDAO dxdao = new DatXeDAO();
        XeDapDAO xddao = new XeDapDAO();

        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        DatXe dx = dxdao.findOne(datXeID);
        XeDap xd = xddao.findOne(dx.getXeID());
        NguoiDung nd = nddao.findOneByTKID(tkSession.getTKID());

        dxdao.update(
                datXeID,
                nd.getUserID(),
                dx.getXeID(),
                dx.getTramXeBatDau(),
                tramXeKetThuc,
                dx.getNgay(),
                dx.getThoiGianBatDau(),
                dx.getThoiGianKetThuc(),
                dx.getThoiGianChoThue(), // dạng hh:mm:ss
                "Hoàn thành",
                dx.getChiPhi()
        );

        xddao.update(xd.getXeID(), xd.getTramXeID(), xd.getLoaiXe(), "Trống");

        resp.sendRedirect(req.getContextPath() + "/rental_history");
    }

}
