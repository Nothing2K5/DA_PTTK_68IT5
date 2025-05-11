/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.dragon.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dragon.model.ConnectSQLModel;

/**
 *
 * @author HOANGHA
 */
@WebServlet(name = "ConnectSQLController", urlPatterns = {"/ConnectSQLController"})
public class ConnectSQLController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String notification = "";
        ConnectSQLModel name = new ConnectSQLModel();
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionURL = "jdbc:sqlserver://DESKTOP-B11V993:1433; databaseName=NCKH; encrypt = false";
            conn = DriverManager.getConnection(connectionURL, "sa", "@2005");
            name.setName(conn.toString());
            notification = "CONNECTION SUCCESS";
        } catch (Exception ex) {
            notification = "CONNECTION FAIL";
        }
        
        request.setAttribute("notification", notification);
        request.setAttribute("name", name.getName());
        RequestDispatcher rd = request.getRequestDispatcher("/views/home.jsp");
        rd.forward(request, response);
    }
}
