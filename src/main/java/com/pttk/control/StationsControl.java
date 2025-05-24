package com.pttk.control;

import com.pttk.dao.TramXeDAO;
import com.pttk.entity.TramXe;
import java.io.IOException;
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
@WebServlet(urlPatterns = {"/stations"})
public class StationsControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        
        TramXeDAO txdao = new TramXeDAO();

        List<TramXe> listTramXe = txdao.findAll();
        req.setAttribute("listTramXe", listTramXe);

        RequestDispatcher rd = req.getRequestDispatcher("/views/stations.jsp");
        rd.forward(req, resp);
    }

}
