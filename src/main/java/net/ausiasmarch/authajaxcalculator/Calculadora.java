/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package net.ausiasmarch.authajaxcalculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Elliot
 */
public class Calculadora extends HttpServlet {

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
        response.setContentType("application/json;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Gson gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
            
            String op = request.getParameter("op");
            HttpSession session = request.getSession();
            
            switch (op) {
                case "login":
                    String userBody = request.getReader().lines().collect(Collectors.joining());
                    Usuario user = new Gson().fromJson(userBody, Usuario.class);

                    String pass= user.getPass();

                    if (pass.equals("ausias")) {
                        session.setAttribute("user", user);
                        out.print(gson.toJson(user));
                    } else {
                        out.print(gson.toJson("Datos incorrectos!"));
                    }
                    break;
                case "logout":
                    session.invalidate();
                    out.print(gson.toJson("Cerrando sesión!"));
                    break;
                case "calcular":
                    if (session.getAttribute("user") != null) {
                        String calcBody = request.getReader().lines().collect(Collectors.joining());
                        Operacion operacion = new Gson().fromJson(calcBody, Operacion.class);
                        
                        String tipoOperacion = operacion.getOperacion();
                        int op1 = operacion.getOp1();
                        int op2 = operacion.getOp2();
                        int resultado = 0;

                        switch (tipoOperacion) {
                            case "suma":
                                resultado = op1 + op2;
                                break;
                            case "resta":
                                resultado = op1 - op2;
                                break;
                            case "multi":
                                resultado = op1 * op2;
                                break;
                            case "divi":
                                resultado = op1 / op2;
                                break;
                        }

                        out.print(gson.toJson(resultado));
                    } else {
                        out.print(gson.toJson("No hay sesión iniciada!"));
                    }
                    break;
                case "getdata":
                    if (session.getAttribute("user") != null) {
                        List<String> list = new ArrayList<>();
                        for (int i = 1; i <= 10; i++) {
                            list.add("Elemento " + i);
                        }
                        Collections.shuffle(list);
                        out.print(gson.toJson(list));
                    } else {
                        out.print(gson.toJson("No hay sesión iniciada!"));
                    }
                    break;
            }
        }
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
        processRequest(request, response);
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
