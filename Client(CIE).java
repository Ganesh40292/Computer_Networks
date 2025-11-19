
package com;
import java.util.Random;

public class Client
{
    Random rand = new Random();

    public int firstPacket()
    {
        int seq = rand.nextInt(900) + 100;
        System.out.println("Client side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – nill");
        return seq;
    }

    public int[] subsequentPacket(int prevSeq, int receivedSeq)
    {
        int seq = prevSeq + 1;
        int ack = receivedSeq + 1;

        System.out.println("\nClient side packet sent");
        System.out.println("sequence number - " + seq);
        System.out.println("Ack number – " + ack);

        return new int[]{seq, ack};
    }
}
