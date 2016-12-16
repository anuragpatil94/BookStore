package BookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anurag
 */
public class UpdateData extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id, bname, author, genre, price;
        String query;
        Connection conn;
        PreparedStatement ps;
        

        ResultSet res;
        try {
            id = request.getParameter("b_id");
            bname = request.getParameter("b_name");
            author = request.getParameter("author");
            genre = request.getParameter("genre");
            price = request.getParameter("price");
            System.out.println("****************Hello**********************");
            System.out.println("" + bname);
            Class.forName("com.mysql.jdbc.Driver");

            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "odysseys");

            query = "update books set b_name='" + bname + "',author='" + author + "',genre='" + genre + "',price='" + price + "' where b_id='" + id + "'";
            ps = (PreparedStatement) conn.prepareStatement(query);
            int i = ps.executeUpdate(query);
            

        } catch (Exception e) {
            System.out.println(e);

        } finally {
            RequestDispatcher rd = request.getRequestDispatcher("/successful-edit.jsp");
            rd.forward(request, response);

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
