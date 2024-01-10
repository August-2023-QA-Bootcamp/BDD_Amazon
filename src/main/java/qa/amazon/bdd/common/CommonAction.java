package qa.amazon.bdd.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import qa.amazon.bdd.util.LoggerClass;

public class CommonAction {

	public static void click(WebElement element) {
		try {
			element.click();
			LoggerClass.log("Element has been clicked ---> " + element);
		}catch (Exception e) {
			e.printStackTrace();
			LoggerClass.log("Element Not Found ---> " + element);
		}
	}
	
	public static void input(WebElement element, String value) {
		try {
			element.sendKeys(value);
			LoggerClass.log(value + " : Value has been passed into ---> " + element);
		}catch (Exception e) {
			e.printStackTrace();
			LoggerClass.log("Element Not Found ---> " + element);
		}
	}
	
	public static void scrollIntoView(JavascriptExecutor jsExecutor, WebElement element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
