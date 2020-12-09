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
                  dataOrder.setId(rs.getInt("id"));
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

    public boolean delete(String id) {
        if(kon.getConn()== null){
            return false;
        }else{
            Statement stmt = null;
            try {
                stmt = kon.getConn().createStatement();
                int terhapus = stmt.executeUpdate("DELETE FROM histori_order WHERE id = '" + id + "'");
                stmt.close();
                kon.getConn().close();
                if (terhapus > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    public boolean insert(histori_order orderBaru) {
        if (kon.getConn() == null) {
            return false;
        } else {
            Statement stmt = null;
            try {
                stmt = kon.getConn().createStatement();
                int tertambah = stmt.executeUpdate("INSERT INTO histori_order (vendor, nama_makanan, jumlah) "
                        + "VALUES('" + orderBaru.getVendor() + "','" + orderBaru.getNama_makanan() + "'"
                        + ",'" + orderBaru.getJumlah() + "')");
                stmt.close();
                kon.getConn().close();
                if (tertambah > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                return false;
            }
        }
    }

    public boolean edit(histori_order order) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
