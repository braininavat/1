import java.net.Socket;

public class TcMonitor implements IMonitor{
    private final String ip;
    private final int port = 8080;
    private String status = "failed";

    TcMonitor(String ip_input){
        ip = ip_input;
    }

    @Override
    public void check() {
        status = "failed";
        try
        {
            Socket socket = new Socket(ip,port);
            status = "Ok";
            socket.close();
        }
        catch(Exception e){

        }
        System.out.println("Tomcat Status : " + status);
    }
}
