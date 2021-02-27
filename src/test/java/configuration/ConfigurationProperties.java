package configuration;

import java.util.Properties;

public class ConfigurationProperties {

    //prywatne statyczne pole do przechowywania propertiesow
    private static Properties properties;

    //prywatny konstruktor pod wzorzec singleton
    private ConfigurationProperties() {
    }

    //Metoda setter, służy do załadowania obiektu properties do statycznego obiektu typu Properties, dostępnego dla wszystkich
    // wątków
    public static void setProperties(Properties properties) {
        ConfigurationProperties.properties = properties;
    }

    //Metoda zwraca nam wszystkie załadowane properties, jeśli nie są one null-em
    public static Properties getProperties() {
        if (properties != null) {
            return properties;
        }else {
            throw new IllegalStateException("setProperties not performed yet, do it before invoking getter");
        }
    }
}
