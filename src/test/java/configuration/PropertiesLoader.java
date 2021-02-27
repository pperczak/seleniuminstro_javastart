package configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private Logger logger = LogManager.getLogger(PropertiesLoader.class);

    //w klasie znajduje sie metoda do ladowania danych z pliku konfiguracyjnego
    public Properties getPropertiesFromFile(String propertiesFileName) {

        //Obiekt InputStream posłuży do odczytu danych z pliku
        InputStream inputStream = null;
        //obiekt Properties będzie przechowywał właściwości
        Properties properties = new Properties();

        try {
            logger.info("Trying to load properties from file: "+ propertiesFileName);

            //Odczytujemy plik properties i inicjalizujemy obiekt inputStream
            inputStream = getClass().getClassLoader().getResourceAsStream(propertiesFileName);

            if (inputStream!=null) {

                properties.load(inputStream);
                logger.info("Successfully loaded configuration file "+propertiesFileName);

            }else {
                throw new FileNotFoundException("Property filename "+propertiesFileName+ " was not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot load properties due to IOException!");
        } finally {
            closeResource(inputStream);
        }
        return properties;
    }
    private void closeResource(InputStream inputStream) {
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
