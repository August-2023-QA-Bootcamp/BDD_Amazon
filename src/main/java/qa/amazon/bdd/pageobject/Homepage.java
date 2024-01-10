package qa.amazon.bdd.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static qa.amazon.bdd.common.CommonAction.*;

public class Homepage {

	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchButton;
	
	public void clickSearchBox() {
		click(searchBox);
	}
	
	public void inputSearchItem(String itemName) {
		input(searchBox, itemName);
	}
	
	public void clickSearchButton() {
		click(searchButton);
	}
}
