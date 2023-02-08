import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;

public class Deserialize {
    public static void main(String[] args) {
        try {

            FileInputStream fis = new FileInputStream("object.ser");

            ObjectInputStream ois = new ObjectInputStream(fis);

            Object obj = ois.readObject();

            Class<?> classToCallMethodOn = obj.getClass();
            Method methodToCall = classToCallMethodOn.getMethod("getToken", Integer.class);
            Object result = methodToCall.invoke(null, 1);

            ois.close();
            fis.close();
            System.out.println("Deserialization successful");
        } catch (Exception e) {
            System.out.println("Deserialization failed");
            e.printStackTrace();
        }
    }
}