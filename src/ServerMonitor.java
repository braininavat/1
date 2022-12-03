import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerMonitor implements IMonitor{
    private InetAddress pingchecker = null;

    public ServerMonitor(String ip) {
        try {
            pingchecker = InetAddress.getByName(ip);
        } catch (UnknownHostException e) {
            System.out.println("Unknown Host");
        }
    }

    @Override
    public void check(){
        boolean isAlive = false;
        String status = "failed";
        try
        {
            isAlive = pingchecker.isReachable(1000);
        }
        catch(IOException e)
        {
        }
        if(isAlive)
        {
            status = "Ok";
        }
        System.out.println("Server Status : " +status);
    }
}
