package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataConnect {
    private static Connection con;
    public DataConnect(){
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Finance", "root", "spectorsiva");
                System.out.println("Connection Done");


        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
    public static Connection getCon() {
        DataConnect con1=new DataConnect();
        return con;
    }


}
