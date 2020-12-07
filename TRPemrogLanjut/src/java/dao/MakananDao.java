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
                    dataMakanan.setId(rs.getInt("id"));
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

    public boolean delete(String id) {
        if (kon.getConn() == null) {
            return false;
        } else {
            Statement stmt = null;
            try {
                stmt = kon.getConn().createStatement();
                int terhapus = stmt.executeUpdate("DELETE FROM makanan WHERE id = '" + id + "'");
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

    public boolean insert(makanan makananBaru) {
        if (kon.getConn() == null) {
            return false;
        } else {
            Statement stmt = null;
            try {
                stmt = kon.getConn().createStatement();
                int tertambah = stmt.executeUpdate("INSERT INTO makanan (nama, stok, supplier) "
                        + "VALUES('" + makananBaru.getNama() + "','" + makananBaru.getStok() + "'"
                        + ",'" + makananBaru.getSupplier() + "')");
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

    public boolean edit(makanan makananBaru) {
        if (kon.getConn() == null) {
            return false;
        } else {
            Statement stmt = null;
            try {
                stmt = kon.getConn().createStatement();
                int terubah = stmt.executeUpdate("UPDATE makanan SET nama = '"
                        + makananBaru.getNama() + "', stok =  '"
                        + makananBaru.getStok() + "', supplier =  '"
                        + makananBaru.getSupplier() + "' WHERE id = '" + makananBaru.getId() + "'");
                stmt.close();
                kon.getConn().close();
                if (terubah > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException ex) {
                return false;
            }
        }
    }

}
