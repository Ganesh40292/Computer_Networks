
package com;
import java.util.Random;

public class Server
{
    Random rand = new Random();

    public int[] firstPacket(int clientSeq)
    {
        int seq = rand.nextInt(900) + 100;
        int ack = clientSeq + 1;

        System.out.println("\nServer side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack);

        return new int[]{seq, ack};
    }

    public int[] subsequentPacket(int prevSeq, int receivedSeq)
    {
        int seq = prevSeq + 1;
        int ack = receivedSeq + 1;

        System.out.println("\nServer side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack);

        return new int[]{seq, ack};
    }
}

