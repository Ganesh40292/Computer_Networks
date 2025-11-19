
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

