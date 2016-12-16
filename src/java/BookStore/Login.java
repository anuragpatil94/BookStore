package BookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AnuragPC
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("txt_username");
        String password = request.getParameter("txt_password");

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from customers where username=? and password=?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "odysseys");
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next() && username!=null && password!=null) {
                response.sendRedirect("books.html");
            }
            else if((username.equals("admin") && password.equals("admin123"))&&username!=null&&password!=null){
                response.sendRedirect("admin-book.html");
            } 
            
            else {
                  response.sendRedirect("not-login.html");
            }

        } catch (Exception e) {
            out.println(e);
        }
    }

}
