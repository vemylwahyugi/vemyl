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
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class UAS {

    
    public static void main(String[] args) {
      try{
          Class.forName("com.mysql.jdbc.Driver");
      }catch(Exception ex){
        System.err.println("Error :"+ex);
        System.exit(1);
      }
        Connection koneksi=null;
      try{
          koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/Vemyl_UAS", "root", "");
          System.out.println("Koneksi Sukses");
      }catch (Exception ex){
        System.out.println("error :"+ex);
        System.exit(1);
      }
        ResultSet hasilQuery=null;
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select * from mahasiswa");
      }catch(Exception ex){
        System.err.println("Error 3:"+ex);
        System.exit(1);
      }
        System.out.println("NIM"+"     "+"Nama"+"       "+"TTL");
      try {
          while (hasilQuery.next()){
              
          int nim=hasilQuery.getInt("NIM");
          String nama=hasilQuery.getString("Nama");
          Date tgl_lahir=hasilQuery.getDate("Tgl_lahir");
          
            System.out.println(nim+"   "+nama+"   "+tgl_lahir);
        }
      }catch(Exception ex){
            System.out.println("error 4:"+ex);
            System.exit(1);
      }
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select * from matakuliah");
      }catch(Exception ex){
            System.err.println("Error 3:"+ex);
            System.exit(1);
      }
            System.out.println();
            System.out.println("Kd_mk"+"    "+"Nama_Matkul"+"   "+"SKS");
      try {
          while (hasilQuery.next()){
          int kd_mk=hasilQuery.getInt("Kd_mk");
          String nama_matkul=hasilQuery.getString("nm_matkul");
          int sks=hasilQuery.getInt("SKS");
          
            System.out.println(kd_mk+"         "+nama_matkul+"         "+sks);
        }
      }catch(Exception ex){
            System.out.println("error 5:"+ex);
            System.exit(1);
      }
      try{
          Statement stm=koneksi.createStatement();
          hasilQuery=stm.executeQuery("Select nim,kd_mk,nilai,case when nilai >=80 then 'A' "
                  + "when nilai >=70 then 'B' when nilai >=60 then 'C' when nilai >=50 "
                  + "then 'D' when nilai <50 then 'E' when nilai is null then '(null)' "
                  + "end as huruf from nilai");
      }catch(Exception ex){
            System.err.println("Error :"+ex);
            System.exit(1);
      }
            System.out.println();
            System.out.println("NIM"+"        "+"Kd_mk"+"      "+"Nilai"+"  "+"Huruf");
      try {
          while (hasilQuery.next()){
          int nim=hasilQuery.getInt("NIM");
          int kd_mk=hasilQuery.getInt("Kd_mk");
          int nilai=hasilQuery.getInt("Nilai");
          String huruf=hasilQuery.getString("Huruf");
          
            System.out.println(nim+"         "+kd_mk+"         "+nilai+"      "+huruf);
        }
      }catch(Exception ex){
            System.out.println("error 6:"+ex);
            System.exit(1);
      }
    }
    
}
