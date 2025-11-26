package server;

import java.net.*;
import java.io.*;

public class Server
{
    public static void main(String args[]) throws Exception
    {
        ServerSocket ServSocket = new ServerSocket(4000);

        System.out.println("**** Server Side ****");
        System.out.println("Server ready for connection");

        Socket connSock = ServSocket.accept();

        System.out.println("Client connected");

        BufferedReader fileRead = new BufferedReader(new InputStreamReader(connSock.getInputStream()));
        String fname = fileRead.readLine();

        PrintWriter pwrite = new PrintWriter(connSock.getOutputStream(), true);

        File fileName = new File(fname);

        if (fileName.exists())
        {
            BufferedReader ContentRead = new BufferedReader(new FileReader(fileName));
            String str;

            while ((str = ContentRead.readLine()) != null)
            {
                pwrite.println(str);
            }

            ContentRead.close();
        }
        else
        {
            pwrite.println("Requested file does not exist on server");
        }

        pwrite.close();
        fileRead.close();
        connSock.close();
        ServSocket.close();
    }
}
