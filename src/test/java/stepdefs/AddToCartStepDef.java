package stepdefs;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qa.amazon.bdd.base.TestBaseClass;

public class AddToCartStepDef extends TestBaseClass {

	static int itemNumber;
	
	@Given("user is in the homepage")
	public void user_is_in_the_homepage() {
		Assert.assertEquals(driver.getTitle(), "Amazon.com");
	}

	@Given("user clicks on search box")
	public void user_clicks_on_search_box() {
		homepage.clickSearchBox();
	}

	@Given("user type in {string}")
	public void user_type_in(String string) {
	    homepage.inputSearchItem(string);
	}

	@When("user click the search icon")
	public void user_click_the_search_icon() {
	    homepage.clickSearchButton();
	}

	@Then("user will see {string} from the result")
	public void user_will_see_from_the_result(String string) {
	    resultPage.scrollIntoViewMoreResults(javascriptExecutor);
	    resultPage.validateResultItem(string);
	}

	@When("user click the first item")
	public void user_click_the_first_item() {
	    resultPage.clickResultItem();
	}

	@When("select storage")
	public void select_storage() {
	    iphonePage.clickStorage256();
	}

	@When("click add to cart button")
	public void clickAddToCartButton(){
		itemNumber = iphonePage.getCartItemCount();
	    iphonePage.clickAddToCartButton();
	}

	@Then("cart item number will increase")
	public void cart_item_number_will_increase() {
	    Assert.assertEquals(itemNumber+1, iphonePage.getCartItemCount());
	}
}
