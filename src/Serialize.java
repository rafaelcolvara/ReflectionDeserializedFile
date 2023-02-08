import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void main(String[] args) {
        Token obj = new Token();

        try {
            FileOutputStream fos = new FileOutputStream("object.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
            fos.close();
            System.out.println("Serialization successful");
        } catch (Exception e) {
            System.out.println("Serialization failed");
            e.printStackTrace();
        }
    }
}