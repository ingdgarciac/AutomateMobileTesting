package com.automation.core.base;

import com.automation.driver.Driver;
import com.automation.screens.WelcomeScreen;
import java.net.MalformedURLException;
import java.net.URL;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

/** Base hooks class. */
@Slf4j
public class BaseHooks {

  protected Driver driver;
  protected WelcomeScreen welcomeScreen;

  @BeforeSuite
  public void beforeSuite() {
    log.info("Before suite");
  }

  /** Before method hook for initiate the driver. */
  @BeforeMethod
  @Parameters({"platform", "url"})
  public void beforeMethod(String platform, String url) throws MalformedURLException {
    log.info("Before method, initiating the driver");
    driver = new Driver(platform, new URL(url));
    welcomeScreen = new WelcomeScreen(driver.getDriver());
  }

  @AfterMethod
  public void afterMethod() {
    log.info("After method, disposing driver");
    driver.getDriver().quit();
  }
}
