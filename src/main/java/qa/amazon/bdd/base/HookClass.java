package qa.amazon.bdd.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class HookClass {

    static TestBaseClass baseClass;

    @BeforeAll
    public static void beforeAllTests(){
        baseClass = new TestBaseClass();
        System.out.println("------ Before All ------");
    }

    @Before
    public void beforeEachTest(){
        baseClass.setUp();
        System.out.println("------- Before -------");
    }

    @After
    public void afterEachTest(Scenario scenario){
		if(scenario.isFailed()) {
			final byte [] ss = ((TakesScreenshot) TestBaseClass.driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(ss, "image/png", "error.png");
		}
        baseClass.tearUp();
        System.out.println("------- After --------");
    }
}
