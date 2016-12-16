package BookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Anurag
 */
public class EditRecord extends HttpServlet {

    Connection conn = null;
    Statement st = null;
    ResultSet res = null;
    String query;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String query;
if(request.getParameter("edit")!=null){
        try {

            String id = request.getParameter("b_id");
            Class.forName("com.mysql.jdbc.Driver");

            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "root");
            st = conn.createStatement();
           
            
            query = "select * from books where b_id=" + id;
            res = st.executeQuery(query);

        } catch (Exception e) {
            System.err.println(e);

        } finally {

            request.setAttribute("EditData", res);
            RequestDispatcher rd = request.getRequestDispatcher("/editdata.jsp");

            rd.forward(request, response);
            out.close();
        }
}
        if (request.getParameter("delete") != null) {
            try {

                String id = request.getParameter("b_id");
                Class.forName("com.mysql.jdbc.Driver");

                conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "root");
                st = conn.createStatement();
                System.out.println("**********************************" + id);

                query = "delete from books where b_id='" + id + "'";
                int i = st.executeUpdate(query);

            } catch (Exception e) {
                System.err.println(e);

            } finally {

                //  request.setAttribute("EditData", res);
                RequestDispatcher rd = request.getRequestDispatcher("DisplayData");

                rd.forward(request, response);
                out.close();
            }

        }
    }

}
