/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.pttk.control;

import com.pttk.dao.TramXeDAO;
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
@WebServlet(urlPatterns = {"/admin_stations"})
public class AdminStationsControl extends HttpServlet {
    private TramXeDAO stationDAO;

    @Override
    public void init() throws ServletException {
        stationDAO = new TramXeDAO(); // đã viết sẵn DAO
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
                insertStation(request, response);
                break;
            case "update":
                updateStation(request, response);
                break;
            case "delete":
                deleteStation(request, response);
                break;
            default:
                response.sendRedirect("error.jsp");
        }
    }
    private void insertStation(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String tenTram = request.getParameter("tenTram");
    String diaChi = request.getParameter("diaChi");
    Integer tongChoDo = Integer.parseInt(request.getParameter("tongChoDo"));

    stationDAO.add(tenTram,diaChi,tongChoDo);
    response.sendRedirect(request.getContextPath() + "/stations");
}


    private void updateStation(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String tramXeID = request.getParameter("tramXeID");
    String tenTram = request.getParameter("tenTram");
    String diaChi = request.getParameter("diaChi");
    Integer tongChoDo = Integer.parseInt(request.getParameter("tongChoDo"));
    Integer soXeKhaDung = Integer.parseInt(request.getParameter("soXeKhaDung"));
    Integer soChoTrong = Integer.parseInt(request.getParameter("soChoTrong"));
    
    stationDAO.update(tramXeID, tenTram, diaChi, tongChoDo, soXeKhaDung, soChoTrong);
    response.sendRedirect(request.getContextPath() + "/stations");
}


    private void deleteStation(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
    String tramXeID = request.getParameter("tramXeID");
    stationDAO.delete(tramXeID);
    response.sendRedirect(request.getContextPath() + "/stations");
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
