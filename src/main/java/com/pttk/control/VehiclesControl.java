package com.pttk.control;

import com.pttk.dao.XeDapDAO;
import com.pttk.entity.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/vehicles"})
public class VehiclesControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {     
        String tramXeID = req.getParameter("tramXeID");

        XeDapDAO xddao = new XeDapDAO();
        List<XeDap> listXeDap = new ArrayList<>();
        if (tramXeID != null) {
            listXeDap = xddao.findByTramXe(tramXeID);
        } else {
            listXeDap = xddao.findAll();
        }
        req.setAttribute("listXeDap", listXeDap);

        RequestDispatcher rd = req.getRequestDispatcher("/views/vehicles.jsp");
        rd.forward(req, resp);
    }

}
