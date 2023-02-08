import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {

        String originalFile = System.getProperty("user.dir") + "/src/Token.java";;
        String encryptedFile = System.getProperty("user.dir") + "/Token.ser";
        String decryptedFile = System.getProperty("user.dir") + "/Token.out";

        String encodedString = Base64.getEncoder().encodeToString("SenhaSuperSecretaValemobi".getBytes(StandardCharsets.UTF_8));


        MessageDigest md = MessageDigest.getInstance("SHA-256");

        FileInputStream in = new FileInputStream(originalFile);

        byte[] buffer = new byte[8192];
        int length;
        while ((length = in.read(buffer)) != -1) {
            md.update(buffer, 0, length);
        }
        byte[] originalDigest = md.digest();
        in.close();

        EncryptDescryptValemobi.encryptFile(originalFile, encryptedFile, originalDigest);
        EncryptDescryptValemobi.decryptFile(encryptedFile, decryptedFile, originalDigest);

    }






}