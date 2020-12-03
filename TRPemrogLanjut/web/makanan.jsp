<%-- 
    Document   : dosen
    Created on : Dec 3, 2020, 3:02:43 PM
    Author     : USER
--%>

<%@page import="dao.MakananDao"%>
<%@page import="java.util.List"%>
<%@page import="model.makanan"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Data Gudang Makanan</h1>
        <table border="1" cellspacing="0">
            <tr>
                <th>Nama</th>
                <th>Stok</th>
                <th>Supplier</th>
            </tr>
            <%
                List<makanan> listMakanan = new MakananDao().getAll();
                for (int i = 0; i < listMakanan.size(); i++) {
            %>
            <tr>
                <td><%= listMakanan.get(i).getNama()%></td>
                <td><%= listMakanan.get(i).getStok()%></td>
                <td><%= listMakanan.get(i).getSupplier()%></td>
            </tr>
            <%}%>

            
        </table>
    </body>
</html>
