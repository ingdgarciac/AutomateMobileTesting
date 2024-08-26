package com.automation.core.search;

import static org.hamcrest.Matchers.is;

import com.automation.core.base.BaseTest;
import com.automation.screens.MainScreen;
import com.automation.screens.SearchScreen;
import org.testng.annotations.BeforeMethod;

public class SearchBaseTest extends BaseTest {

  protected String textToSearch = faker.animal().name();
  protected MainScreen mainScreen;
  protected SearchScreen searchScreen;

  @BeforeMethod
  public void navigateToMainScreen() {
    mainScreen = welcomeScreen.tapOnSkipButton();

    checkThat.hardAssert("Main screen is visible", mainScreen.isScreenLoaded(), is(true));
  }
}
