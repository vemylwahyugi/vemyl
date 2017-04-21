/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vemyl_UAS;

/**
 *
 * @author USER
 */
import java.sql.*;
import java.util.*;
public class Mahasiswa {
    public static void main(String args[])throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Vemyl_UAS", "root", "");
        
        PreparedStatement smt=con.prepareStatement("insert into mahasiswa(NIM,Nama,Tgl_lahir)"+"values(?,?,?)");
        Scanner sc=new Scanner(System.in);
            System.out.print("Masukan NIM :");
        int nim=sc.nextInt();
            System.out.print("Masukan Nama :");
        String nama=sc.next();
            System.out.print("Masukan TTL :");
        String tgl_lahir=sc.next();
            smt.setInt(1, nim);
            smt.setString(2, nama);
            smt.setString(3, tgl_lahir);
            smt.executeUpdate();
                System.out.println("Data berhasil ditambah");
            con.close();
    }
    
    
}
