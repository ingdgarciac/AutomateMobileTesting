package com.automation.search;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

import com.automation.core.search.SearchBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

public class SearchTest extends SearchBaseTest {

  @Test
  @Severity(BLOCKER)
  @Story("")
  @TmsLink("")
  @Description("Validate search random text")
  public void validateSearchBar() {
    searchScreen = mainScreen.tapOnSearchBar();

    checkThat.hardAssert("Search screen is visible", searchScreen.isScreenLoaded(), is(true));

    searchScreen.setTextToSearch(textToSearch);

    checkThat.softAssert("Results are visible", searchScreen.getResultsSize(), greaterThan(0));
  }
}
