package com.automation.core.base;

import static org.hamcrest.Matchers.is;

import net.datafaker.Faker;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseHooks {

  protected final Faker faker = new Faker();
  protected Assert checkThat = new Assert();

  @BeforeMethod
  public void beforeMethod() {
    checkThat.hardAssert("Welcome screen is visible", welcomeScreen.isScreenLoaded(), is(true));
  }
}
