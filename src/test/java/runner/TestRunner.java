package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(	tags = "@data-table",
					features = "src/test/java/features",
					glue = {"base","stepdefs"},
					plugin = {"pretty", "html:target/index.html"},
					monochrome = false,
					dryRun = false
					)
public class TestRunner {

}
