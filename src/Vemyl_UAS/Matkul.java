/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vemyl_UAS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Matkul {
    public static void main(String args[])throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Vemyl_UAS", "root", "");
        
        PreparedStatement smt=con.prepareStatement("insert into matakuliah(Kd_mk,nm_matkul,sks)"+"values(?,?,?)");
        Scanner sc=new Scanner(System.in);
            System.out.print("Masukan Kode Mata Kuliah :");
        int kd_mk=sc.nextInt();
            System.out.print("Masukan Nama Mata Kuliah :");
        String nm_matkul=sc.next();
            System.out.print("Masukan SKS :");
        int sks=sc.nextInt();
             smt.setInt(1, kd_mk);
             smt.setString(2, nm_matkul);
             smt.setInt(3, sks);
             smt.executeUpdate();
                System.out.println("Data berhasil ditambah");
             con.close();
    }   
    
}
