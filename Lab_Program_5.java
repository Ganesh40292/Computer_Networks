package swp;

public class SWP
{
    private int windowSize;
    private int[] frames;
    private boolean[] ack;

    public SWP(int windowSize, int frameCount)
    {
        this.windowSize = windowSize;
        this.frames = new int[frameCount];
        this.ack = new boolean[frameCount];

        for (int i = 0; i < frameCount; i++)
        {
            frames[i] = i;
            ack[i] = false;
        }
    }

    public void sendFrames()
    {
        int sendIndex = 0;

        while (sendIndex < frames.length)
        {
            System.out.println("\nWindow starting at frame: " + sendIndex);

            for (int i = 0; i < windowSize && (sendIndex + i) < frames.length; i++)
            {
                System.out.println("Sending frame: " + frames[sendIndex + i]);
            }

            for (int i = 0; i < windowSize && (sendIndex + i) < frames.length; i++)
            {
                ack[sendIndex + i] = receiveAck(sendIndex + i);
            }

            while (sendIndex < frames.length && ack[sendIndex])
            {
                sendIndex++;
            }
        }
    }

    private boolean receiveAck(int frame)
    {
        System.out.println("ACK received for frame: " + frame);
        return true;
    }

    public static void main(String[] args)
    {
        int windowSize = 4;
        int frameCount = 10;

        SWP swp = new SWP(windowSize, frameCount);
        swp.sendFrames();
    }
}
