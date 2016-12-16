package BookStore;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "UserDisplayData", urlPatterns = {"/UserDisplayData"})
public class UserDisplayData extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String query;
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
      //  PreparedStatement ps=null;
        List lst=new ArrayList();
                try{
            PrintWriter out=response.getWriter();
             Class.forName("com.mysql.jdbc.Driver");
            conn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql:///bookstore", "root", "odysseys");
            st=conn.createStatement();
                query="select * from books";
                rs=st.executeQuery(query);
                while(rs.next()){
                    lst.add(rs.getString("b_id"));
                    lst.add(rs.getString("b_name"));
                    lst.add(rs.getString("author"));
                    lst.add(rs.getString("genre"));
                    lst.add(rs.getString("price"));
                }
            rs.close();
            
        }
        catch(Exception e){
            RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
                    rd.forward(request, response); 
        }
                finally{
                    request.setAttribute("BooksData", lst);
                    
                    RequestDispatcher rd=request.getRequestDispatcher("/user_record.jsp");
                    rd.forward(request, response);
                    lst.clear();
                }
        
        
        
    }

}
