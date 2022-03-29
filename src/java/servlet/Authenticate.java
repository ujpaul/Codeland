/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.example.model.UserModel;
import example.helpers.HashPass;
import example.intaface.User;
import example.db.CoreDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Authenticate", urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {

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
         getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").include(request, response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(req, response);
        
         UserModel um = new UserModel();
         LinkedHashMap<Integer, UserModel> lhmpUser = new LinkedHashMap<Integer, UserModel>();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        um.setUsername(username);
        um.setUserPassword(username);
        HttpSession session = req.getSession();
       	
        lhmpUser = CoreDB.getInstance().getData();
        
        for (Map.Entry<Integer, UserModel> entry : lhmpUser.entrySet()) {               
                UserModel umData = entry.getValue();

                String unHashedPass = HashPass.getInstance().unHashedPass(umData.getUserPassword(),umData.getAge());

                if (username.equals(umData.getUsername()) && password.equals(unHashedPass)== true) {
                        session.setAttribute("username", umData.getUsername());
                        getServletContext().getRequestDispatcher("/WEB-INF/jsp/detail.jsp").include(req, response);				

                } else {

                        getServletContext().getRequestDispatcher("/WEB-INF/jsp/notfound.jsp").include(req, response);

                }
		}
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
