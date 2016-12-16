<%-- 
    Document   : editdata
    Created on : Apr 30, 2015, 12:52:11 PM
    Author     : Anurag
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>editdata</title>
        <link rel="stylesheet" type="text/css" href="home.css">
    </head>
    <body >
        <div class="wrapper">
            <div id="cssmenu">
                <ul>
                    <li><a href="DisplayData">Back</a></li>
                    
                    
                </ul>
            </div>
            <div class="box">
                <form action="UpdateData" method="get">
                    <table>

                        <% ResultSet res = (ResultSet) request.getAttribute("EditData"); %>
                        <%if (res.next()) {
                        %>
                        <tr>
                            <td>Book ID</td>
                            <td><input type="text" name="b_id"   value="<%= res.getString("b_id") %>"></td>
                        </tr>
                        <tr>
                            <td>Book Name</td>
                            <td><input type="text" name="b_name" value="<%= res.getString("b_name") %>"></td>
                        </tr>
                        <tr>
                            <td>Author</td>
                            <td><input type="text" name="author" value="<%= res.getString("author") %>"></td>
                        </tr>
                        <tr>
                            <td>Genre</td>
                            <td><input type="text" name="genre" value="<%=res.getString("genre")%>"></td>
                        </tr>
                        <tr>
                            <td>Price</td>
                            <td><input type="text" name="price" value="<%=res.getString("price")%>"></td>
                        </tr>
                        <tr>
                        <input class="button" type="submit" value="Update" name="update">
                        </tr>
                        <%}%>

                    </table>
                </form>
            </div>
        </div>
    </body>
</html>

