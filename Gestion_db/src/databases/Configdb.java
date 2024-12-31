package databases;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configdb {
    private static Properties properties = new Properties();
    
 static {
	try (FileInputStream input = new FileInputStream("configuration.properties"))
	    {
           properties.load(input);
        } 
	    catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String cle) {
        return properties.getProperty(cle);
    }
}
