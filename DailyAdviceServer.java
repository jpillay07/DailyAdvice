import java.io.*;
import java.net.*;

public class DailyAdviceServer {
    
    String[] adviceList = {"Take Smaller Bites", "Go for the tight jeans", "One Word: Innapropriate", "Just for today, be honest", "rethink that haircut"};

    public static void main(String[] args){
        DailyAdviceServer adviceServer = new DailyAdviceServer();
        adviceServer.go();

    }

    public void go(){
        try{
            ServerSocket serverSock = new ServerSocket(4242);

            while(true){
                Socket sock = serverSock.accept();

                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();

                writer.println(advice);
                writer.close();
                System.out.println(advice);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    private String getAdvice(){
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }
}
