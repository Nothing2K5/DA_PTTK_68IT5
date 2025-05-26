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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(urlPatterns = {"/current_rentals"})
public class Current_RentalsControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        DatXeDAO dxdao = new DatXeDAO();
        XeDapDAO xddao = new XeDapDAO();
        TramXeDAO txdao = new TramXeDAO();
        NguoiDungDAO nddao = new NguoiDungDAO();

        List<DatXe> listDX = dxdao.findDangChoThue(nddao.findOneByTKID(tkSession.getTKID()).getUserID());

        Map<String, XeDap> mapXD = new HashMap<>();
        Map<String, TramXe> mapTX = new HashMap<>();

        XeDap xd = new XeDap();

        for (DatXe dx : listDX) {
            xd = xddao.findOne(dx.getXeID());
            mapXD.put(dx.getDatXeID(), xd);
            TramXe tx = txdao.findOne(xd.getTramXeID());
            mapTX.put(dx.getDatXeID(), txdao.findOne(xd.getTramXeID()));
        }

        req.setAttribute("listDX", listDX);
        req.setAttribute("mapXD", mapXD);
        req.setAttribute("mapTX", mapTX);

        RequestDispatcher rd = req.getRequestDispatcher("/views/current_rentals.jsp");
        rd.forward(req, resp);
    }
}
