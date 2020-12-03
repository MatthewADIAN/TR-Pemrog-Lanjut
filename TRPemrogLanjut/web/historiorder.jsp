<%-- 
    Document   : dosen
    Created on : Dec 3, 2020, 3:02:43 PM
    Author     : USER
--%>

<%@page import="dao.HistoriOrderDao"%>
<%@page import="java.util.List"%>
<%@page import="model.histori_order"%>
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
                <th>Id</th>
                <th>Vendor</th>
                <th>Nama Makanan</th>
                <th>Jumlah</th>
                <th>Action</th>
            </tr>
            <%
                List<histori_order> listHistori = new HistoriOrderDao().getAll();
                for (int i = 0; i < listHistori.size(); i++) {
            %>
            <tr>
                <td><%= listHistori.get(i).getId()%></td>
                <td><%= listHistori.get(i).getVendor()%></td>
                <td><%= listHistori.get(i).getNama_makanan()%></td>
                <td><%= listHistori.get(i).getJumlah()%></td>
                <td>
                    <a href="hapushistori?id=<%= listHistori.get(i).getId()%>">Hapus</a>
                    <a href="edithistori?id=<%= listHistori.get(i).getId()%>">Edit</a>
                </td>
            </tr>
            <%}%>

            
        </table>
    </body>
</html>
