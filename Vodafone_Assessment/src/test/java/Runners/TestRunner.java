package Runners;
import Tests.BaseTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/Features",
glue = {"Steps"},
tags = "CompleteCheckout")
public class TestRunner extends BaseTest
{
}
