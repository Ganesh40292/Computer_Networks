package datagram_client;

import java.net.*;

public class Datagram_Client
{
    public static void main(String[] args) throws Exception
    {
        String line = "connected with client";

        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = line.getBytes();
        byte[] receiveData = new byte[1024];

        DatagramPacket sendPacket =
                new DatagramPacket(sendData, sendData.length, IPAddress, 9000);

        clientSocket.send(sendPacket);

        System.out.println("****** CLIENT TERMINAL ******");

        while (true)
        {
            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            clientSocket.receive(receivePacket);

            String message =
                new String(receivePacket.getData(), 0, receivePacket.getLength());

            System.out.println("Server: " + message);
        }
    }
}
