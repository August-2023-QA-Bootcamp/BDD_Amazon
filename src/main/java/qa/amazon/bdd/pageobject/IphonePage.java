package qa.amazon.bdd.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static qa.amazon.bdd.common.CommonAction.*;

public class IphonePage {

	public IphonePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "a-autoid-11")
	WebElement storage256;
	
	@FindBy(id = "a-autoid-0-announce")
	WebElement addToCartButton;
	
	@FindBy(id = "nav-cart-count")
	WebElement cartItemCount;
	
	public void clickStorage256() {
		click(storage256);
	}
	
	public void clickAddToCartButton() {
		click(addToCartButton);
	}
	
	public int getCartItemCount() {
		return Integer.parseInt(cartItemCount.getText());
	}
}
