package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/Cucumber",glue="rsclassesa.seleniumframework.setpdefination",monochrome=true,
plugin= {"html:target/cucumber.html"},tags="Smoke")
public class TestNGTestRunner extends AbstractTestNGCucumberTests {
	

}
