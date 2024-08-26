package com.automation.screens.base;

import static java.time.Duration.ofSeconds;

import io.appium.java_client.AppiumDriver;
import lombok.Getter;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/** Abstract model page for POM pattern. */
@Getter
public abstract class BaseScreen {

  private final AppiumDriver driver;
  private final WebDriverWait wait;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object AppiumDriver
   */
  public BaseScreen(AppiumDriver driver) {
    PageFactory.initElements(driver, this);
    wait = new WebDriverWait(driver, ofSeconds(5));
    this.driver = driver;
  }

  public abstract boolean isScreenLoaded();
}
