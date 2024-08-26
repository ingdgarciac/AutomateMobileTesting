package com.automation.driver;

import static com.automation.Constants.APP;
import static com.automation.Constants.APP_ACTIVITY;
import static com.automation.Constants.APP_PACKAGE;
import static com.automation.Constants.AUTOMATION_NAME;
import static com.automation.Constants.AUTO_GRANT_PERMISSIONS;
import static com.automation.Constants.DEVICE_NAME;
import static com.automation.Constants.FULL_RESET;
import static com.automation.Constants.PLATFORM_NAME;
import static com.automation.Constants.PLATFORM_VERSION;

import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import lombok.experimental.UtilityClass;

/** Class for get the Capabilities. */
@UtilityClass
public class Capabilities {

  /**
   * Obtain Android capabilities.
   *
   * @return UiAutomator2Options instance
   */
  public static UiAutomator2Options getAndroidCapabilities() {
    return new UiAutomator2Options()
        .setPlatformName(LocalProperties.getProperty(PLATFORM_NAME))
        .setDeviceName(LocalProperties.getProperty(DEVICE_NAME))
        .setAutomationName(LocalProperties.getProperty(AUTOMATION_NAME))
        .setApp(LocalProperties.getProperty(APP))
        .setAppPackage(LocalProperties.getProperty(APP_PACKAGE))
        .setAppActivity(LocalProperties.getProperty(APP_ACTIVITY))
        .setFullReset(Boolean.parseBoolean(LocalProperties.getProperty(FULL_RESET)))
        .setAutoGrantPermissions(
            Boolean.parseBoolean(LocalProperties.getProperty(AUTO_GRANT_PERMISSIONS)));
  }

  /**
   * Obtain iOS capabilities.
   *
   * @return XCUITestOptions instance
   */
  public static XCUITestOptions getIosCapabilities() {
    return new XCUITestOptions()
        .setPlatformName(LocalProperties.getProperty(PLATFORM_NAME))
        .setDeviceName(LocalProperties.getProperty(DEVICE_NAME))
        .setAutomationName(LocalProperties.getProperty(AUTOMATION_NAME))
        .setPlatformVersion(LocalProperties.getProperty(PLATFORM_VERSION))
        .setApp(LocalProperties.getProperty(APP))
        .setFullReset(Boolean.parseBoolean(LocalProperties.getProperty(FULL_RESET)));
  }
}
