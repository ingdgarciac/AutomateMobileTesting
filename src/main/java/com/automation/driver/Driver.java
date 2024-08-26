package com.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import java.net.URL;
import lombok.Getter;

/** Class for model the mobile driver. */
@Getter
public class Driver {

  private final AppiumDriver driver;

  /** Constructor of the class. */
  public Driver(String platform, URL url) {
    switch (platform) {
      case "Android":
        this.driver = new AndroidDriver(url, Capabilities.getAndroidCapabilities());
        break;
      case "Ios":
        this.driver = new IOSDriver(url, Capabilities.getIosCapabilities());
        break;
      default:
        throw new RuntimeException("Invalid platform");
    }
  }
}
