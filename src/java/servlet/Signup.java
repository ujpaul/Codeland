/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.example.model.UserModel;
import example.controller.Admin;
import example.controller.Guest;
import example.helpers.HashPass;
import example.helpers.ValidatePassword;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author janvier
 */
@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
       // getServletContext().getRequestDispatcher("/index.jsp").include(request, response);
                Admin admin = new Admin();
		Guest guest = new Guest();
		LinkedHashMap<Integer, UserModel> lhmUsers = new LinkedHashMap<Integer, UserModel>();

		String username = req.getParameter("username");
		String password = req.getParameter("user_password");
		String confirmPassword = req.getParameter("retype_password");		
		String role = req.getParameter("roles");		
		int age = Integer.parseInt(req.getParameter("age"));
                boolean detectError = false;
                
                if(password.equals(confirmPassword) == false){
                    detectError = true;
                    req.setAttribute("error", "Password doesnot match");
                    
                }
	
                String hashedpassword = HashPass.getInstance().hashPassword(password, String.valueOf(age));                
                UserModel um = new UserModel();
                
		um.setUsername(username);
		um.setFname(req.getParameter("fname"));
		um.setLname(req.getParameter("lname"));
		um.setAge(age);
		um.setPhoneNumber(req.getParameter("phoneNumber"));		
		um.setUserPassword(hashedpassword);
                um.setUserRole(role);
		um.setGender(req.getParameter("gender"));
                
               try {
		    
                     if(um.getUserRole().equalsIgnoreCase("admin")){
                            if(ValidatePassword.getInstance().adminPassword(password) == true){
                                lhmUsers = admin.register(um);
                                getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").include(req, response);
                            }else{
                                req.setAttribute("error", "Password should be 10 characters");
                                detectError = true;                         
                            }
                     }else{
                         if(ValidatePassword.getInstance().guestPassword(password) == true){
                          lhmUsers = guest.register(um);  
                           getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp").include(req, response);
                         }else {                             
                             req.setAttribute("error", "Password should be only 5 characters");
                             detectError = true;
                         }
                     }
		} catch (Exception e) {
		    e.printStackTrace();
	        }
               if(detectError == true){
                    this.setSession(req, "username", username);
                    this.setSession(req, "fname", req.getParameter("fname"));                      
                    this.setSession(req, "lname", req.getParameter("lname"));
                    this.setSession(req, "phoneNumber", req.getParameter("phoneNumber"));
                    this.setSession(req, "gender", req.getParameter("gender"));
                    this.setSession(req, "age", req.getParameter("age"));
        
                    RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
                    rd.forward(req, response);
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
    protected void doPost(HttpServletRequest req, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(req, response);
        
	

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
    private void setSession(HttpServletRequest req, String key, String value){        
        req.setAttribute(key, value);
    }
}
