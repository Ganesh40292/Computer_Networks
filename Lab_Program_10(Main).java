import java.util.Scanner;

public class Leaky
{
    public static void main(String[] args)
    {
        int i;
        int a[] = new int[20];
        int buck_rem = 0, sent, recv;

        Scanner in = new Scanner(System.in);

        System.out.println("enter the number of packets:");
        int n = in.nextInt();

        System.out.println("enter the buckets capacity:");
        int buck_cap = in.nextInt();

        System.out.println("enter the output rate:");
        int rate = in.nextInt();

        System.out.println("enter the size of packets:");
        for(i = 0; i < n; i++)
        {
            a[i] = in.nextInt();
        }

        System.out.println("CLOCK\tPACKET_SIZE\tACCEPT\tSENT\tREMAINING");

        for(i = 0; i < n; i++)
        {
            int dropped = 0;

            if(a[i] != 0)
            {
                if(buck_rem + a[i] > buck_cap)
                {
                    recv = buck_cap - buck_rem;
                    dropped = (buck_rem + a[i]) - buck_cap;
                    buck_rem = buck_cap;
                }
                else
                {
                    recv = a[i];
                    buck_rem += a[i];
                }
            }
            else
            {
                recv = 0;
            }

            if(buck_rem != 0)
            {
                if(buck_rem < rate)
                {
                    sent = buck_rem;
                    buck_rem = 0;
                }
                else
                {
                    sent = rate;
                    buck_rem -= rate;
                }
            }
            else
            {
                sent = 0;
            }

            if(dropped > 0)
            {
                System.out.println((i+1) + "\t\t" + a[i] + "\t\t" + recv + " (dropped:" + dropped + ")\t" + sent + "\t" + buck_rem);
            }
            else
            {
                System.out.println((i+1) + "\t\t" + a[i] + "\t\t" + recv + "\t\t" + sent + "\t" + buck_rem);
            }
        }
    }
}
