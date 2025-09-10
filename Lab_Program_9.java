import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class p9 
{
    private BigInteger n, d, e;
    private int bitlen = 1024;

    public p9() 
  {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(bitlen / 2, 100, r);
        BigInteger q = new BigInteger(bitlen / 2, 100, r);
        n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        e = new BigInteger("65537");
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) 
  {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) 
  {
        return encrypted.modPow(d, n); 
    }

    public static void main(String[] args) 
  {
        p9 rsa = new p9();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the message:");
        String text = sc.nextLine();

        
        BigInteger message = new BigInteger(1, text.getBytes());

        BigInteger encrypted = rsa.encrypt(message);
        BigInteger decrypted = rsa.decrypt(encrypted);

        System.out.println("\nOriginal Message: " + text);
        System.out.println("Encrypted Message: " + encrypted);
        System.out.println("Decrypted Message: " + new String(decrypted.toByteArray()));

        sc.close();
    }
}
