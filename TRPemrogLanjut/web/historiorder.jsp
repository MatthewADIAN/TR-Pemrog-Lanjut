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
        <link href="//cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="style.css">
        <title>History Order</title>
    </head>
    <body>
    <center>
        <h1>History Order</h1>
        </center>
    <div class="container">
        <table border="1" cellspacing="0" id="myTable" class="table">
            <thead class="thead-dark">
            <tr>
                <th>Id</th>
                <th>Vendor</th>
                <th>Nama Makanan</th>
                <th>Jumlah</th>
                <th>Action</th>
            </tr>
                </thead>
                    </div>

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
                </td>
            </tr>
            <%}%>
</table>

        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
                        Tambahkan Data 
                    </button>

                    <!-- Modal -->
                    <form method="POST" action="tambahorder">
                        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Masukan barang</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <table>
                                            <tr>
                                                <td>ID</td>
                                                <td><input type="text" name="id"></td>
                                            </tr>
                                            <tr>
                                                <td>Vendor</td>
                                                <td><input type="text" name="vendor"></td>
                                            </tr>
                                            <tr>
                                                <td>Nama Makanan</td>
                                                <td><input type="text" name="nama_makanan"></td>
                                            </tr>
                                            <tr>
                                                <td>Jumlah</td>
                                                <td><input type="text" name="jumlah"></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                    <br><br>
                    <a class="btn btn-secondary" href="halamanutama.jsp" role="button">Kembali Ke Halaman Utama</a>
                </div>
                
                <div class="col-sm-6">
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#editModal">
                        Edit data
                    </button>

                    <!-- Modal -->
                    <form method="POST" action="editorder">
                        <div class="modal fade" id="editModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLabel">Masukan barang</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <table>
                                            <tr>
                                                <td>ID</td>
                                                <td><input type="text" name="id"></td>
                                            </tr>
                                            <tr>
                                                <td>Vendor</td>
                                                <td><input type="text" name="vendor"></td>
                                            </tr>
                                            <tr>
                                                <td>Nama Makanan</td>
                                                <td><input type="text" name="nama_makanan"></td>
                                            </tr>
                                            <tr>
                                                <td>Jumlah</td>
                                                <td><input type="text" name="jumlah"></td>
                                            </tr>
                                        </table>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <button type="submit" class="btn btn-primary">Save changes</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>

    </div>
         <!-- jQuery and JS bundle w/ Popper.js -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
            <!-- cdn datatables -->
        <script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <!-- eksternal js -->
        <script src="js/datatables.js" type="text/javascript"></script>
       
    </body>
</html>
