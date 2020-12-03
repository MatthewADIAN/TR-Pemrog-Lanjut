/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.histori_order;
import util.Koneksi;

/**
 *
 * @author YOGA
 */
public class HistoriOrderDao {
    Koneksi kon = new Koneksi();
    
    public List<histori_order> getAll(){
        if (kon.getConn() == null) {
            return null;
        } else {
            Statement stmt = null;
            ResultSet rs = null;
            List<histori_order> listorder = null;
            try {
                stmt = kon.getConn().createStatement();
                rs = stmt.executeQuery("SELECT * FROM histori_order");
                listorder = new ArrayList<>();
                while (rs.next()){
                  histori_order dataOrder = new histori_order();
                  dataOrder.setVendor(rs.getString("vendor"));
                  dataOrder.setNama_makanan(rs.getString("nama_makanan"));
                  dataOrder.setJumlah(rs.getInt("jumlah"));
                  listorder.add(dataOrder);
                }
                stmt.close();
                rs.close();
                kon.getConn().close();
            } catch (SQLException ex) {
               Logger.getLogger(HistoriOrderDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listorder;
        }
    }
}
