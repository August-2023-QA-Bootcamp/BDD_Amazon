package stepdefs;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import qa.amazon.bdd.base.TestBaseClass;

public class CommonSteps extends TestBaseClass{

	@Given("user is in the homepage")
	public void user_is_in_the_homepage() {
		Assert.assertEquals(driver.getTitle(), "Amazon.com");
	}
	
	@Given("user clicks on search box")
	public void user_clicks_on_search_box() {
		homepage.clickSearchBox();
	}
}
