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
import model.makanan;
import util.Koneksi;

/**
 *
 * @author USER
 */
public class MakananDao {
    Koneksi kon = new Koneksi();

    public List<makanan> getAll() {

        if (kon.getConn() == null) {
            return null;
        } else {
            Statement stmt = null;
            ResultSet rs = null;
            List<makanan> listMakanan = null;
            try {
                stmt = kon.getConn().createStatement();
                rs = stmt.executeQuery("SELECT * FROM makanan");
                listMakanan = new ArrayList<>();
                while (rs.next()) {
                    makanan dataMakanan = new makanan();
                    dataMakanan.setNama(rs.getString("nama"));
                    dataMakanan.setStok(rs.getInt("stok"));
                    dataMakanan.setSupplier(rs.getString("supplier"));
                    listMakanan.add(dataMakanan);
                }
                stmt.close();
                rs.close();
                kon.getConn().close();
            } catch (SQLException ex) {
                Logger.getLogger(MakananDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            return listMakanan;
        }

    }
}
