import java.util.Scanner;
public class Program9 
{
    public static void main(String[] args) 
  {
        String msg;
        int pt[] = new int[100];
        int ct[] = new int[100];
        int z, n, d, e, p, q, mlen;

        Scanner in = new Scanner(System.in);

        // Input two primes p and q until both are prime
        do 
        {
            System.out.println("Enter the two large prime numbers for p and q:");
            p = in.nextInt();
            q = in.nextInt();
        } while (prime(p) == 0 || prime(q) == 0);

        n = p * q;
        z = (p - 1) * (q - 1);

        System.out.println("n = " + n);
        System.out.println("z = " + z);

        // Find e such that gcd(e, z) == 1
        for (e = 2; e < z; e++) 
        {
            if (gcd(e, z) == 1)
                break;
        }

        System.out.println("e = " + e);
        System.out.println("Public Key: (" + e + ", " + n + ")");

        // Find d such that (d*e) % z == 1
        for (d = 2; d < z; d++) 
        {
            if ((e * d) % z == 1)
                break;
        }

        System.out.println("d = " + d);
        System.out.println("Private Key: (" + d + ", " + n + ")");

        in.nextLine();  // consume leftover newline

        System.out.println("Enter the message for Encryption:");
        msg = in.nextLine();

        mlen = msg.length();

        // Convert message chars to ASCII int array
        for (int i = 0; i < mlen; i++)
        {
            pt[i] = msg.charAt(i);
        }
        System.out.println("ASCII values of plaintext:");
        for (int i = 0; i < mlen; i++)
        {
            System.out.println(pt[i]);
        }
        System.out.println("Encryption: Cipher Text Obtained");
        for (int i = 0; i < mlen; i++)
        {
            ct[i] = mult(pt[i], e, n);
        }  
        for (int i = 0; i < mlen; i++)
        {
            System.out.print(ct[i] + "\t");
        }
        System.out.println("\nDecryption: Plain Text Obtained");
        for (int i = 0; i < mlen; i++)
        {
            pt[i] = mult(ct[i], d, n);
        }
        for (int i = 0; i < mlen; i++) 
        {
            System.out.println(pt[i] + " : " + (char) pt[i]);
        }

        in.close();
    }

    // Compute gcd of a and b
    public static int gcd(int a, int b) {
        while (b != 0) 
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Check if num is prime; returns 1 if prime, else 0
    public static int prime(int num) 
    {
        if (num <= 1)
            return 0;
        for (int i = 2; i <= Math.sqrt(num); i++) 
        {
            if (num % i == 0)
                return 0;
        }
        return 1;
    }

    // Compute (base^exp) % n using repeated multiplication (not efficient)
    public static int mult(int base, int exp, int n) 
    {
        int res = 1;
        for (int j = 1; j <= exp; j++)
        {
            res = (res * base) % n;
        }
        return res;
    }
}
