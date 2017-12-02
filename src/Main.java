import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test1";

    static final String USER = "sa";
    static final String PASSWORD = "";

    static final String CREATE_TABLE_SQL = "CREATE TABLE REGISTRATION " +
            "(id INTEGER not NULL, " +
            "first VARCHAR(255), " +
            "last VARCHAR(255), " +
            "age INTEGER, " +
            "PRIMARY KEY ( id ))";

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            System.out.println("Creating table in given database...");
            stmt = conn.createStatement();
            stmt.executeUpdate(CREATE_TABLE_SQL);
            System.out.println("Created table in given database...");
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            } catch(SQLException se2) {
            }
            try {
                if(conn!=null) {
                    conn.close();
                }
            } catch(SQLException se){
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");

    }
}
