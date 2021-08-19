package testNG;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesPractice {

    @Test
    public void practice() throws IOException {

        // 1. Create a path for connection to out file
        String path = "test.properties";

        //2. We will create Properties object

        Properties properties = new Properties();

        //3. Open the file using FileInputStream

        FileInputStream file = new FileInputStream(path);

        //4. Load the properties to file into the properties object
        properties.load(file);

        //5. Read the values from the file using a method getProperty()

        System.out.println(properties.getProperty("login"));
        System.out.println(properties.getProperty("mybaseURl"));


    }

}
