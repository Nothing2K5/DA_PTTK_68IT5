package com.pttk.control;

import com.pttk.dao.DatXeDAO;
import com.pttk.dao.NguoiDungDAO;
import com.pttk.dao.TramXeDAO;
import com.pttk.dao.XeDapDAO;
import com.pttk.entity.DatXe;
import com.pttk.entity.TaiKhoan;
import com.pttk.entity.TramXe;
import com.pttk.entity.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/rental_history"})
public class Rental_HistoryControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        DatXeDAO dxdao = new DatXeDAO();
        TramXeDAO txdao = new TramXeDAO();
        XeDapDAO xddao = new XeDapDAO();
        NguoiDungDAO nddao = new NguoiDungDAO();

        List<DatXe> listDatXe = dxdao.findByNguoiDungAndTrangThai(nddao.findOneByTKID(tkSession.getTKID()).getUserID(), "Hoàn thành");
        List<TramXe> listTramXe = txdao.findAll();
        List<XeDap> listXeDap = xddao.findAll();

        req.setAttribute("listDatXe", listDatXe);
        req.setAttribute("listTramXe", listTramXe);
        req.setAttribute("listXeDap", listXeDap);

        RequestDispatcher rd = req.getRequestDispatcher("/views/rental_history.jsp");
        rd.forward(req, resp);
    }

}
