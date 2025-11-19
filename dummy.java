
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



package com;
public class MainSimulation
{
    public static void main(String[] args)
    {
        Client client = new Client();
        Server server = new Server();

        int cseq = client.firstPacket();

        int[] s1 = server.firstPacket(cseq);
        int sseq = s1[0];

        int[] c2 = client.subsequentPacket(cseq, sseq);
        cseq = c2[0];

        int[] s2 = server.subsequentPacket(sseq, cseq);
        sseq = s2[0];

        int[] c3 = client.subsequentPacket(cseq, sseq);
        cseq = c3[0];

        int[] s3 = server.subsequentPacket(sseq, cseq);
        sseq = s3[0];

        int[] c4 = client.subsequentPacket(cseq, sseq);
        cseq = c4[0];

        server.subsequentPacket(sseq, cseq);
    }
}

