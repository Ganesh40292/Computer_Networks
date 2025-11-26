package datagram_server;

import java.net.*;
import java.util.*;

public class Datagram_Server
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        DatagramSocket serverSocket = new DatagramSocket(9000);
        byte[] receiveData = new byte[1024];
        byte[] sendData;

        System.out.println("****** SERVER TERMINAL ******");

        DatagramPacket receivePacket =
                new DatagramPacket(receiveData, receiveData.length);

        serverSocket.receive(receivePacket);

        String clientMsg =
            new String(receivePacket.getData(), 0, receivePacket.getLength());

        System.out.println("Client connected: " + clientMsg);

        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();

        while (true)
        {
            System.out.print("Server message: ");
            String message = sc.nextLine();

            sendData = message.getBytes();

            DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);
        }
    }
}
