package com.way2free.vvbot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BotApplication {
    private static final String CONFIG_FILE = "config.properties";
    private static Properties properties;

    public static final String CONFIG_KEY_BOT_TOKEN = "token";

    static {
        properties = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(CONFIG_FILE);
            properties.load(fis);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(-1);
        } finally {
            if (null != fis)
                try {
                    fis.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        
    }

    public static String getBotToken() {
        return properties.getProperty(CONFIG_KEY_BOT_TOKEN, "");
    }
}
