/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pttk.control;

import com.pttk.dao.XeDapDAO;
import com.pttk.entity.XeDap;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
@WebServlet(urlPatterns = {"/admin_vehicles"})
public class AdminVehiclesControl extends HttpServlet {
    private XeDapDAO vehicleDAO;

    @Override
    public void init() throws ServletException {
        vehicleDAO = new XeDapDAO(); // đã viết sẵn DAO
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                insertVehicle(request, response);
                break;
            case "update":
                updateVehicle(request, response);
                break;
            case "delete":
                deleteVehicle(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }
    private void insertVehicle(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String tramXeID = request.getParameter("tramXeID");
    String loaiXe = request.getParameter("loaiXe");
    String trangThai = request.getParameter("trangThaiXe");

    vehicleDAO.add(tramXeID,loaiXe,trangThai);
    response.sendRedirect(request.getContextPath() + "/vehicles");
}


    private void updateVehicle(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String xeID = request.getParameter("xeID");
    String tramXeID = request.getParameter("tramXeID");
    String loaiXe = request.getParameter("loaiXe");
    String trangThai = request.getParameter("trangThaiXe");
    vehicleDAO.update(xeID, tramXeID, loaiXe, trangThai);
    response.sendRedirect(request.getContextPath() + "/vehicles");
}


    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String xeID = request.getParameter("xeID");
    vehicleDAO.delete(xeID);
    response.sendRedirect(request.getContextPath() + "/vehicles");
}


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
