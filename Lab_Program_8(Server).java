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
        byte[] sendData = new byte[1024];
        System.out.println("---Server side---");
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        serverSocket.receive(receivePacket);
        System.out.println(new String(receivePacket.getData()));
        InetAddress IPAddress = receivePacket.getAddress();
        int port = receivePacket.getPort();
        while (true) 
        {
            System.out.println("Type some message to display to client end");
            String message = sc.nextLine();
            sendData = message.getBytes();

            System.out.println("Message sent from the server: " + new String(sendData));

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

            serverSocket.send(sendPacket);

        }

    }

}
