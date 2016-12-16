package BookStore;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anurag
 */
public class Registration extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String username = request.getParameter("txt_username");
        String password = request.getParameter("txt_password");
        String fname = request.getParameter("txt_fname");
        String lname = request.getParameter("txt_lname");
        String dob = request.getParameter("txt_dob");
        String gender = request.getParameter("Gender");
        String address = request.getParameter("txt_address");
        String city = request.getParameter("txt_city");
        String state = request.getParameter("txt_state");
        String phone = request.getParameter("txt_phone");

        Connection conn = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "root");
            ps = (PreparedStatement) conn.prepareStatement("insert into customers values(?,?,?,?,?,?,?,?,?,?)");

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fname);
            ps.setString(4, lname);
            ps.setString(5, dob);
            ps.setString(6, gender);
            ps.setString(7, address);
            ps.setString(8, city);
            ps.setString(9, state);
            ps.setString(10, phone);
            int i = ps.executeUpdate();
//            ResultSet res = ps.getGeneratedKeys();
//            while (res.next()) {
//                System.out.println("Generated key: " + res.getInt(1));
//            }

            if (i > 0) {
                response.sendRedirect("successful-register.html");
            } else {
                response.sendRedirect("not-successful-register.html");
            }
        } catch (Exception e) {
            out.println(e);
        }

    }

}
