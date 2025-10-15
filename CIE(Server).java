
package server.cie;
import java.io.*;
import java.net.*;

public class ServerCIE 
{
    public static void main(String[] args) 
    {
        try (ServerSocket serverSocket = new ServerSocket(12345)) 
        {
            System.out.println("Server is waiting for client connection...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connected.");

            // Read number from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = in.readLine();
            int number = Integer.parseInt(input);

            // Calculate cube
            int cube = number * number * number;

            // Send cube back to client
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(cube);

            // Close everything
            in.close();
            out.close();
            socket.close();
            System.out.println("Connection closed.");
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
