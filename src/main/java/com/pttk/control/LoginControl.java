package com.pttk.control;

import com.pttk.dao.TaiKhoanDAO;
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

/**
 *
 * @author HOANGHA
 */
@WebServlet(urlPatterns = {"/login"})
public class LoginControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        
        String sdt = req.getParameter("sdt");
        String matKhau = req.getParameter("matKhau");
        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        TaiKhoan tk = tkdao.login(sdt, matKhau);
        if (tk == null) {
            req.setAttribute("message", "Sai số điện thoại hoặc mật khẩu");
            RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
            rd.forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            session.setAttribute("TAIKHOAN", tk);
            session.setMaxInactiveInterval(1000);
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

}
