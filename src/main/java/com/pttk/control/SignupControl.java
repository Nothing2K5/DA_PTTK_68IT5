/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pttk.control;

import com.pttk.dao.NguoiDungDAO;
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

/**
 *
 * @author HOANGHA
 */
@WebServlet(urlPatterns = {"/signup"})
public class SignupControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/views/signup.jsp");
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
        String re_matKhau = req.getParameter("re_matKhau");
        if (!matKhau.equals(re_matKhau)) {
            req.setAttribute("message", "NOTE: password and rePassword are not the same");
            RequestDispatcher rd = req.getRequestDispatcher("/views/signup.jsp");
            rd.forward(req, resp);
        } else {
            TaiKhoanDAO tkdao = new TaiKhoanDAO();
            TaiKhoan tk = tkdao.checkAccountExist(sdt);
            if (tk == null) {
                tkdao.signUp(hoTen, email, sdt, matKhau);
                if (tkdao.checkAccountExist(sdt) != null) {
                    req.setAttribute("message", "Success");
                } else {
                    req.setAttribute("message", "Failed");
                }
                resp.sendRedirect(req.getContextPath() + "/login");
            } else {
                req.setAttribute("message", "NOTE: userName or userID already exists");
                RequestDispatcher rd = req.getRequestDispatcher("/views/signup.jsp");
                rd.forward(req, resp);
            }
        }
    }

}
