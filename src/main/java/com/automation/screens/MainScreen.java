package com.automation.screens;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import com.automation.screens.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the main screen. */
public class MainScreen extends BaseScreen {

  @FindBy(id = "search_container")
  private WebElement searchBar;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object AppiumDriver
   */
  public MainScreen(AppiumDriver driver) {
    super(driver);
  }

  public SearchScreen tapOnSearchBar() {
    searchBar.click();
    return new SearchScreen(getDriver());
  }

  @Override
  public boolean isScreenLoaded() {
    return getWait().until(visibilityOf(searchBar)).isDisplayed();
  }
}
