package com.automation.screens;

import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

import com.automation.screens.base.BaseScreen;
import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Class to model the search screen. */
public class SearchScreen extends BaseScreen {

  @FindBy(id = "search_src_text")
  private WebElement searchBar;

  @FindBy(xpath = "//*[@resource-id='org.wikipedia:id/search_results_list']/android.view.ViewGroup")
  private List<WebElement> resultsList;

  /**
   * Constructor of the class, for initialize the driver.
   *
   * @param driver Object AppiumDriver
   */
  public SearchScreen(AppiumDriver driver) {
    super(driver);
  }

  public SearchScreen setTextToSearch(String textToSearch) {
    searchBar.sendKeys(textToSearch);
    return this;
  }

  /**
   * Get the size of the results.
   *
   * @return int size of results.
   */
  public int getResultsSize() {
    return getWait()
        .withTimeout(ofSeconds(5))
        .pollingEvery(ofMillis(500))
        .ignoring(TimeoutException.class)
        .until(visibilityOfAllElements(resultsList))
        .size();
  }

  @Override
  public boolean isScreenLoaded() {
    return getWait().until(visibilityOf(searchBar)).isDisplayed();
  }
}
