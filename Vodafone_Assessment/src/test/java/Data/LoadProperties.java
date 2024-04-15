package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class LoadProperties {
    public static Properties UserData=  loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\Properties_Package\\UserData.properties");

    public static Properties loadProperties(String path)
    {
        Properties properties=new Properties();
        try {
            FileInputStream file=new FileInputStream(path);
            properties.load(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error : " + e);
        } catch (IOException e) {
            System.out.println("Error : "+ e);
        }
        return properties;
    }
}
