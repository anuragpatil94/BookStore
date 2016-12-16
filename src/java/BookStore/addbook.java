package BookStore;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AnuragPC
 */
public class addbook extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String b_name = request.getParameter("txt_bookname");
        String author = request.getParameter("txt_author");
        String price = request.getParameter("txt_price");
        String genre = request.getParameter("txt_genre");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "root");
            ps = (PreparedStatement) conn.prepareStatement("insert into books (b_name,author,genre,price) values "
                    + "('" + b_name + "','" + author + "','" + genre + "','" + price + "')");
            int i = ps.executeUpdate();
            if (i > 0 && b_name != null && author != null && genre != null && price != null) {
                response.sendRedirect("successful-added.html");
            } else {
                response.sendRedirect("not-successful-add.html");
            }

        } catch (Exception e) {
            out.println(e);
        }

    }

}
