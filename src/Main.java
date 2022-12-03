import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        ArrayList<IMonitor> monitors = new ArrayList<IMonitor>();
        int input;

        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------");
        System.out.println(" 서버 Ip 입력");
        System.out.println("-------------------------------");
        System.out.print(" 입력 : ");
        final String ip = sc.next();

        IMonitor sm = new ServerMonitor(ip);
        IMonitor tm = new TcMonitor(ip);
        IMonitor dm = new DBMonitor(ip);
        monitors.add(sm);
        monitors.add(tm);
        monitors.add(dm);

        System.out.println("-------------------------------");
        System.out.println(" 0 : 1초 주기로 확인");
        System.out.println(" 1 : 1번만 확인");
        System.out.println("-------------------------------");
        System.out.print(" 입력 : ");
        final int interval = sc.nextInt();

        System.out.println("-------------------------------");
        System.out.println(" 0 : 서버 핑 체크");
        System.out.println(" 1 : Tomcat 체크");
        System.out.println(" 2 : DB 체크");
        System.out.println(" 3 : 종료");
        System.out.println("-------------------------------");
        System.out.print(" 입력 : ");

        if(interval == 0)
        {
            input = sc.nextInt();
            while(true)
            {
                if (monitors.size() > input)
                {
                    monitors.get(input).check();
                }
                else if (monitors.size() == input)
                {
                    System.exit(0);
                }
                Thread.sleep(1000);
            }
        }
        else
        {
            while (true) {
                input = sc.nextInt();

                if (monitors.size() > input)
                {
                    monitors.get(input).check();
                }
                else if (monitors.size() == input)
                {
                    System.exit(0);
                }
            }
        }
    }
}