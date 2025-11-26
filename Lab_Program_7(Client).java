package client;

import java.net.*;
import java.io.*;
import java.util.*;

public class Client
{
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(System.in);

        Socket ClientSocket = new Socket("127.0.0.1", 4000);

        System.out.println("*** Client side ***");

        System.out.print("Enter the filename to transfer: ");
        String fname = in.nextLine();

        OutputStream ostream = ClientSocket.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);

        InputStream istream = ClientSocket.getInputStream();
        BufferedReader SocketRead = new BufferedReader(new InputStreamReader(istream));

        System.out.println("Contents of the file " + fname + " are:");

        String str;
        while ((str = SocketRead.readLine()) != null)
        {
            System.out.println(str);
        }

        pwrite.close();
        SocketRead.close();
        ClientSocket.close();
    }
}
