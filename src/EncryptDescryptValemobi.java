import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
public class EncryptDescryptValemobi implements Serializable {

    public static void encryptFile(String inputFile, String outputFile, byte[] expectedDigest) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        byte[] buffer = new byte[8192];
        int length;
        while ((length = in.read(buffer)) != -1) {
            md.update(buffer, 0, length);
            out.write(buffer, 0, length);
        }
        byte[] digest = md.digest();
        in.close();
        out.close();
        if (!MessageDigest.isEqual(digest, expectedDigest)) {
            throw new Exception("Encryptação do arquivo Java falhou!");
        }
    }

    public static void decryptFile(String inputFile, String outputFile, byte[] expectedDigest) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        byte[] buffer = new byte[8192];
        int length;
        while ((length = in.read(buffer)) != -1) {
            md.update(buffer, 0, length);
            out.write(buffer, 0, length);
        }
        byte[] digest = md.digest();
        in.close();
        out.close();
        if (!MessageDigest.isEqual(digest, expectedDigest)) {
            throw new Exception("Decryptação do arquivo java falhou");
        }
    }



}
