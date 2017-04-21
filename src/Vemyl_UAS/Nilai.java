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
public class Nilai {
     public static void main(String args[])throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Vemyl_UAS", "root", "");
        
        PreparedStatement smt=con.prepareStatement("insert into nilai(NIM,Kd_mk,Nilai)"+"values(?,?,?)");
        Scanner sc=new Scanner(System.in);
            System.out.print("Masukan NIM :");
        int nim=sc.nextInt();
            System.out.print("Masukan Kd_mk :");
        int kd_mk=sc.nextInt();
            System.out.print("Masukan Nilai :");
        int nilai=sc.nextInt();
            smt.setInt(1, nim);
            smt.setInt(2, kd_mk);
            smt.setInt(3, nilai);
            smt.executeUpdate();
                System.out.println("Data berhasil ditambah");
            con.close();
    }
}
