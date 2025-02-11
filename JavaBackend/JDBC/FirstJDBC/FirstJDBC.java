
import java.sql.*;
class FirstJDBC{
    public static void main(String[] args) {
        try{
            // load the driver 
            Class.forName("org.sqlite.JDBC");
            // creating a connection 
//             Removed localhost:3306 since SQLite does not use a server.
// Removed username and password, as SQLite does not require authentication.
//  Used "jdbc:sqlite:mydb.db", which correctly points to the database file.
            String url= "jdbc:sqlite:mydb.db";
            String username= "root";
            String password= "root";
            Connection con=DriverManager.getConnection(url);
if(con.isClosed()){
    System.out.println("connection closed");
}else{
    System.out.println("connection created...");
}
        }catch(Exception e){
e.printStackTrace();
        }
    }
}