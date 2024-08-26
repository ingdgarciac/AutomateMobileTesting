package com.automation.screens;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.automation.screens.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the Welcome screen. */
public class WelcomeScreen extends BaseScreen {

  @FindBy(id = "imageViewCentered")
  private WebElement wikipediaLogo;

  @FindBy(id = "fragment_onboarding_skip_button")
  private WebElement skipButton;

  @FindBy(id = "fragment_onboarding_forward_button")
  private WebElement continueButton;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object AppiumDriver
   */
  public WelcomeScreen(AppiumDriver driver) {
    super(driver);
  }

  public MainScreen tapOnSkipButton() {
    skipButton.click();
    return new MainScreen(getDriver());
  }

  @Override
  public boolean isScreenLoaded() {
    return getWait().until(visibilityOf(wikipediaLogo)).isDisplayed();
  }
}
