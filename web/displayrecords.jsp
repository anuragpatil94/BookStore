<%-- 
    Document   : displayrecords
    Created on : Apr 19, 2015, 6:56:32 PM
    Author     : AnuragPC
--%>
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book List</title>
        <link rel="stylesheet" type="text/css" href="home.css">
    </head>
    <body>
        
        <div class="wrapper">
            <div id="cssmenu">
                <ul>
                    <li><a href="admin-book.html">Home</a></li>
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
                    <% Iterator itr;
                        List data = (List) request.getAttribute("BooksData");
                        for (itr = data.iterator(); itr.hasNext();) {
                    %>
                    <tr>
                        <% String s = (String) itr.next();%>
                        <td> <%=s%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>
                        <td> <%=itr.next()%> </td>

                        
                            <% }%>
                    </tr> 
                </table>
                <br><br>
                <div>
                    <form id="displayrecords" action="${pageContext.request.contextPath}/EditRecord"  method="get">  

                        <input style="width:50%;" class="textbox" type="text" placeholder="Enter Book ID" name="b_id" >                    
                  
                         
                        <input class="button" type="submit" value="Edit" name="edit" >
     
                        <input class="button" type="submit" value="Delete" name="delete"  >

                   </form>
                </div>


            </div>
        </div>
    </body>
</html>
