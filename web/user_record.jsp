<%-- 
    Document   : user_record
    Created on : Apr 19, 2015, 6:56:32 PM
    Author     : AnuragPC
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>(User)Book-List</title>
        <link rel="stylesheet" type="text/css" href="home.css">
    </head>
    <body>
        <script type="text/javascript">
//            function Addcart(id) {
//                url = "Addtocart";
//                window.location.href = "http://localhost:8084/BookStore/" + url + "?id=" + id;
//
//            }
        </script>
        <div class="wrapper">
            <div id="cssmenu">
                <ul>
                    <li><a href="admin-book.html">Home</a></li>
                    <li><a href="#"></a></li>
                    <li><a href="#"></a></li>
                </ul>
            </div>

            <div class="dr-box"> 
                <table>
                    <tr>
                        <th>Book ID</th>
                        <th>Name</th>
                        <th>Author</th>
                        <th>Genre</th>
                        <th>Price</th>
                    </tr>
                    <% Iterator itr; %>
                    <% List data = (List) request.getAttribute("BooksData");
                        for (itr = data.iterator(); itr.hasNext();) {
                    %>
                    <tr>
                        <% String s = (String) itr.next();%>
                        <td> <%=s%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>
                        <td>
                            <form action="Addtocart" method="get">
                                <input class="dr-input" type="submit" value="ADD to Cart" name="add" >
                            </form>
                        </td>
                        <% }%>
                    </tr> 


            </div>
        </form>  
        <div class="box">
            <a href="cart.jsp"> <input class="button" type="submit"  value="Cart" /></a>
        </div>
    </div>
</body>
</html>
