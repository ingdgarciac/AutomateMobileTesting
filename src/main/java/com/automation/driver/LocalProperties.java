package com.automation.driver;

import static com.automation.Constants.PATH_TO_APPIUM_PROPERTIES;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/** Class to load the local properties. */
@Slf4j
@UtilityClass
public class LocalProperties {

  public static final Properties properties = new Properties();

  static {
    try {
      InputStream input =
          LocalProperties.class.getClassLoader().getResourceAsStream(PATH_TO_APPIUM_PROPERTIES);
      properties.load(input);
    } catch (IOException e) {
      log.info(e.getMessage());
    }
  }

  public static String getProperty(String key) {
    return properties.getProperty(key);
  }
}
