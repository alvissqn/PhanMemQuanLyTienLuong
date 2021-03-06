/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

/**
 *
 * @author Administrator
 */
import java.sql.*;
import javax.swing.*;
import DAL.*;
/**
 *
 * @author Administrator
 */
public class Thuong_DS {
    static ConnectionDB kn = new ConnectionDB();
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = kn.getConnect();
    
    public static void themThuong(String maNV, String dt, String tienthuong)
    {
        String sql="INSERT INTO dbo.THUONG(MANV, DIPTHUONG, TIENTHUONG) values (?, ?, ?)";
        try {
            pst=conn.prepareStatement(sql);
            pst.setString(1, maNV);
            pst.setString(2, dt);
            pst.setString(3, tienthuong);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã thêm thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể thêm được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void suaThuong(String maNV, String dt, String tienthuong)
    {
        String sql = "UPDATE dbo.THUONG SET DIPTHUONG='"+dt+"', TIENTHUONG='"+tienthuong+"' where MANV='"+maNV+"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã sữa thành thàng công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể sữa được, xin kiểm tra lại", "Thông báo",1);
        }
    }
    public static void xoaThuong(String maNV)
    {
        String sql ="DELETE FROM dbo.THUONG WHERE MANV = '"+ maNV +"'";
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Đã xóa thành công", "Thông báo",1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Không thể xóa xin kiểm tra lại!", "Thông báo",1);
        }
    }
}
