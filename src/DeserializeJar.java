import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class DeserializeJar {
    public static void main(String[] args) {
        try {
            JarFile jarFile = new JarFile("TokenJar.jar");
            JarEntry jarEntry = jarFile.getJarEntry("src/Token.java");
            InputStream inputStream = jarFile.getInputStream(jarEntry);

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Object object = objectInputStream.readObject();

            jarFile.close();
            inputStream.close();
            objectInputStream.close();

            System.out.println("Objeto " + object);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}