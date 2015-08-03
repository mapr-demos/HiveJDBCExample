import java.sql.*;

/**
 * Created by vince on 8/3/15.
 */
public class HiveJDBCExample {
    private static String connectionString = "jdbc:hive2://172.16.2.98:10000/default;saslQop=auth-conf;auth=maprsasl";
    private static String driverName = "org.apache.hive.jdbc.HiveDriver";
    private static String queryString = "select count(*) from pokes";
    private static Connection con;
    private static ResultSet resultSet;
    private static Statement sqlStatement;
    public static void main(String[] args)
    {
        System.out.println("Loaded the driver successfully. Trying to establish connection");
        try
        {
            Class.forName(driverName);
            con = DriverManager.getConnection(connectionString);
            System.out.println("Created connection. Preparing statement");
            sqlStatement = con.createStatement();
            System.out.println("Executing "+queryString);
            resultSet = sqlStatement.executeQuery(queryString);
            while(resultSet.next())
            {
                System.out.println("Result set "+resultSet.getString(1));
            }
            con.close();
        }
        catch(SQLException sqle)
        {
            System.out.println("Got sql exception");
            sqle.printStackTrace();
        }
        catch(Exception e)
        {
            System.out.println("Got exception");
            e.printStackTrace();
        }
    }
}
