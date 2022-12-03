import java.sql.*;

public class DBMonitor implements IMonitor{

    private final String url;
    private final String user = "testuser";
    private final String password = "1234";

    private String result;
    private Connection cn = null;
    /*
    private Statement st;
    private ResultSet rs;
    */

    DBMonitor(String ip)
    {
        url = "jdbc:postgresql://" + ip + "/postgres";
    }
    @Override
    public void check() {
        result = "failed";
        try
        {
            cn = DriverManager.getConnection(url,user,password);
            cn.close();
            result = "Ok";
        }
        catch (SQLException e)
        {
            System.out.println("User : " + user +  ", pwd : " + password);
        }
        System.out.println("DB status : " + result);

    }
}
