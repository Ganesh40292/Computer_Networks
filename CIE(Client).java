package client.cie;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientCIE {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int number = scanner.nextInt();

            // Send number to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(number);

            // Receive cube from server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = in.readLine();
            System.out.println("Cube of " + number + " is: " + response);

            // Close scanner and streams
            scanner.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

