import java.util.Scanner;

public class p1 
{
    public static void main(String[] args) 
  {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the bucket capacity: ");
        int bCapacity = sc.nextInt();
        
        System.out.print("Enter the Output Rate: ");
        int oRate = sc.nextInt();
        
        System.out.print("Enter the number of seconds to simulate: ");
        int time = sc.nextInt();
        
        int[] iPackets = new int[time];
        for (int i = 0; i < time; i++) 
        {
            System.out.print("Enter packets at second " + (i + 1) + ": ");
            iPackets[i] = sc.nextInt();
        }
        
        int bucketContent = 0;
        System.out.println("\nTime\tArrived\tBucket\tSent\tDropped");
        System.out.println("------------------------------------------------------");
        
        for (int i = 0; i < time; i++) 
        {
            int arrived = iPackets[i];
            int dropped = 0;
            
            bucketContent += arrived;
            
            if (bucketContent > bCapacity) 
            {
                dropped = bucketContent - bCapacity;
                bucketContent = bCapacity;
            }
            
            int sent = Math.min(bucketContent, oRate);
            bucketContent -= sent;
            
            System.out.printf("%d\t%d\t%d\t%d\t%d\n", (i + 1), arrived, bucketContent, sent, dropped);
        }
        
        sc.close();
    }
}
