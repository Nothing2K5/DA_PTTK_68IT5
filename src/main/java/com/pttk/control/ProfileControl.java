package com.pttk.control;

import com.pttk.dao.NguoiDungDAO;
import com.pttk.dao.QuanLyDAO;
import com.pttk.dao.TaiKhoanDAO;
import com.pttk.entity.NguoiDung;
import com.pttk.entity.QuanLy;
import com.pttk.entity.TaiKhoan;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 *
 * @author HOANGHA
 */
@WebServlet(urlPatterns = {"/profile"})
public class ProfileControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        NguoiDungDAO nddao = new NguoiDungDAO();
        QuanLyDAO qldao = new QuanLyDAO();

        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");
        if (tkSession == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        if (action != null && action.equals("delete")) {
            tkdao.delete(tkSession.getTKID());
            session.removeAttribute("TAIKHOAN");
            resp.sendRedirect(req.getContextPath() + "/home");

        } else {
            if (tkSession.getVaiTro().equals("Khách hàng")) {
                NguoiDung nd = nddao.findOne(nddao.findOneByTKID(tkSession.getTKID()).getUserID());
                req.setAttribute("thongTin", nd);
            } else if (tkSession.getVaiTro().equals("Quản lý")) {
                QuanLy ql = qldao.findOne(qldao.findOneByTKID(tkSession.getTKID()).getQlid());
                req.setAttribute("thongTin", ql);
            }

            TaiKhoan tk = tkdao.findOne(tkSession.getTKID());
            req.setAttribute("taiKhoan", tk);
        }

        RequestDispatcher rd = req.getRequestDispatcher("/views/profile.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String hoTen = req.getParameter("hoTen");
        String email = req.getParameter("email");
        String sdt = req.getParameter("sdt");
        String matKhau = req.getParameter("matKhau");

        NguoiDungDAO nddao = new NguoiDungDAO();
        QuanLyDAO qldao = new QuanLyDAO();
        TaiKhoanDAO tkdao = new TaiKhoanDAO();

        HttpSession session = req.getSession();
        TaiKhoan tk = (TaiKhoan) session.getAttribute("TAIKHOAN");

        if (matKhau != null && !(matKhau.isEmpty()) && !(matKhau.equals(tk.getMatKhau()))) {

        } else {
            matKhau = tk.getMatKhau();
        }

        boolean checktk = tkdao.update(tk.getTKID(), matKhau, tk.getVaiTro(), sdt, tk.getSoDu());

        if (tk.getVaiTro().equals("Khách hàng")) {
            NguoiDung nd = nddao.findOne(nddao.findOneByTKID(tk.getTKID()).getUserID());
            boolean checknd = nddao.update(nd.getUserID(), nd.getTkid(), hoTen, email);
        } else if (tk.getVaiTro().equals("Quản lý")) {
            QuanLy ql = qldao.findOne(qldao.findOneByTKID(tk.getTKID()).getQlid());
            boolean checkql = qldao.update(ql.getQlid(), ql.getTkid(), hoTen, email);
        }

        resp.sendRedirect(req.getContextPath() + "/profile");
    }

}
