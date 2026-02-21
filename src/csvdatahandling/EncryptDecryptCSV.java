package csvdatahandling;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.*;
import java.util.Base64;

public class EncryptDecryptCSV {

    // 16 byte key (AES requires 16 characters)
    private static final String SECRET_KEY = "1234567890123456";

    // Encrypt method
    public static String encrypt(String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(str.getBytes());
        return Base64.getEncoder().encodeToString(encrypted);
    }

    // Decrypt method
    public static String decrypt(String str) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec key = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(str));
        return new String(decrypted);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // ========== WRITE ENCRYPTED CSV ==========
            BufferedWriter bw = new BufferedWriter(new FileWriter("secure.csv"));

            bw.write("ID,Name,Email,Salary");
            bw.newLine();

            for (int i = 1; i <= 3; i++) {

                System.out.println("\nEnter details for Employee " + i);

                System.out.print("ID: ");
                String id = sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Salary: ");
                String salary = sc.nextLine();

                String encryptedEmail = encrypt(email);
                String encryptedSalary = encrypt(salary);

                bw.write(id + "," + name + "," + encryptedEmail + "," + encryptedSalary);
                bw.newLine();
            }

            bw.close();
            System.out.println("\nEncrypted CSV created successfully!\n");

            // ========== READ AND DECRYPT ==========
            BufferedReader br = new BufferedReader(new FileReader("secure.csv"));

            String line;
            br.readLine(); // skip header

            System.out.println("Decrypted Data:\n");

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                String decryptedEmail = decrypt(data[2]);
                String decryptedSalary = decrypt(data[3]);

                System.out.println("ID: " + data[0]);
                System.out.println("Name: " + data[1]);
                System.out.println("Email: " + decryptedEmail);
                System.out.println("Salary: " + decryptedSalary);
                System.out.println("----------------------");
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        sc.close();
    }
}
