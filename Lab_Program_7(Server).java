
package server;
import java.net.*;
import java.io.*;
public class Server 
{
    public static void main(String args[])throws Exception
    {
        ServerSocket ServSocket=new ServerSocket(4000);
        System.out.println("**** Server Slide ***");
        System.out.println("Server ready for connection");
        
        Socket connSock=ServSocket.accept();
        System.out.println("Connection is Successful and ready for file transfer");
        
        InputStream istream=connSock.getInputStream();
        BufferedReader fileRead=new BufferedReader(new InputStreamReader(istream));
        String fname =fileRead.readLine();
        File fileName=new File(fname);
        
        OutputStream ostream =connSock.getOutputStream();
        PrintWriter pwrite=new PrintWriter(ostream,true);
        
        if(fileName.exists())
        {
            BufferedReader ContentRead =new BufferedReader(new FileReader(fname));
            System.out.println("writing file Contents to the socket");
            String str;
            while((str=ContentRead.readLine())!=null)
            {
                    pwrite.println(str);
            }
            ContentRead.close();
        }
        else 
        {
            System.out.println("Requested file does not exists");
            String msg="Requested file does not exists at server side";
            pwrite.println(msg);
        }
        connSock.close();
        ServSocket.close();
        fileRead.close();
        pwrite.close();
    }
}
