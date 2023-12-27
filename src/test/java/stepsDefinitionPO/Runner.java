package stepsDefinitionPO;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.Test;

@CucumberOptions(
    features = {"src/test/resources/features/selectProductPO.feature"},
    glue = {"stepsDefinitionPO"},
    dryRun = false,
    monochrome = true
)

@Test
public class Runner extends AbstractTestNGCucumberTests {}
