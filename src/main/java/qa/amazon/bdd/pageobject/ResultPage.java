package qa.amazon.bdd.pageobject;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static qa.amazon.bdd.common.CommonAction.*;

public class ResultPage {

	public ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='More results']")
	WebElement moreResults;
	
	@FindBy(xpath = "(//div[@data-cy='title-recipe'])[7]//span")
	WebElement randomResultItem;
	
	public void scrollIntoViewMoreResults(JavascriptExecutor jsExecutor) {
		scrollIntoView(jsExecutor, moreResults);
	}
	
	public void validateResultItem(String expected) {
		String text = randomResultItem.getText();
		System.err.println(text);
		Assert.assertTrue(text.toLowerCase().contains(expected));
	}
	
	public void clickResultItem() {
		click(randomResultItem);
	}
}
