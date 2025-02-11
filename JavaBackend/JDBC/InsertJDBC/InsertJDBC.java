import java.sql.*;
class InsertJDBC{
    public static void main(String[] args) {
        try{
            Class.forName("org.sqlite.JDBC");
        
            String url= "jdbc:sqlite:mydb.db";
            String username= "root";
            String password= "root";
            Connection con=DriverManager.getConnection(url);
            System.out.println("connection created...");
            // create a query 
            // String q= "create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null , tCity varchar(400))";
            String q= "CREATE TABLE table1 (tId INTEGER PRIMARY KEY AUTOINCREMENT, tName TEXT NOT NULL, tCity TEXT)";

            
            // create statement 
            Statement stmt= con.createStatement();
            stmt.executeUpdate(q); //if amy error this statement will fail and catch block will be executed
            System.out.println("table created in database");
            con.close();
            
        }catch(Exception e){
           e.printStackTrace();
        }
    }
}