import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Scanner;

public class RSA 
{
    private BigInteger n, d, e;
    private int bitlen = 1024;  // strong key size

    /**
     * Constructor to generate public and private keys
     */
    public RSA() 
    {
        SecureRandom random = new SecureRandom();

        // Generate two large random primes p and q
        BigInteger p = BigInteger.probablePrime(bitlen / 2, random);
        BigInteger q = BigInteger.probablePrime(bitlen / 2, random);

        n = p.multiply(q);  // modulus
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));  // Euler's totient

        e = BigInteger.valueOf(65537);  // common choice for public exponent

        // Calculate private exponent d, modular inverse of e mod phi
        d = e.modInverse(phi);
    }

    /**
     * Encrypt message using public key (e, n)
     * @param message plaintext as BigInteger
     * @return ciphertext as BigInteger
     */
    public BigInteger encrypt(BigInteger message) 
    {
        if (message.compareTo(n) >= 0) 
        {
            throw new IllegalArgumentException("Message too long for the current key size.");
        }
        return message.modPow(e, n);
    }

    /**
     * Decrypt ciphertext using private key (d, n)
     * @param ciphertext encrypted message as BigInteger
     * @return decrypted plaintext as BigInteger
     */
    public BigInteger decrypt(BigInteger ciphertext) 
    {
        return ciphertext.modPow(d, n);
    }

    /**
     * Main method: reads input, encrypts and decrypts the message
     */
    public static void main(String[] args)
    {
        RSA rsa = new RSA();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a message to encrypt:");
        String message = sc.nextLine();

        // Convert the input string to a positive BigInteger (to avoid sign issues)
        BigInteger plaintext = new BigInteger(1, message.getBytes());

        // Encrypt the message
        BigInteger ciphertext = rsa.encrypt(plaintext);

        // Decrypt the message
        BigInteger decrypted = rsa.decrypt(ciphertext);

        System.out.println("Original message: " + message);
        System.out.println("Encrypted message (numeric): " + ciphertext);
        System.out.println("Decrypted message: " + new String(decrypted.toByteArray()));

        sc.close();
    }
}
