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
@WebServlet(urlPatterns = {"/topup"})
public class TopupControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/topup.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        TaiKhoan tkSession = (TaiKhoan) session.getAttribute("TAIKHOAN");

        Integer soDu = Integer.parseInt(req.getParameter("soDu"));

        TaiKhoanDAO tkdao = new TaiKhoanDAO();
        tkdao.update(tkSession.getTKID(), tkSession.getMatKhau(), tkSession.getVaiTro(), tkSession.getSdt(), tkSession.getSoDu() + soDu);

        resp.sendRedirect(req.getContextPath() + "/profile");
    }

}
