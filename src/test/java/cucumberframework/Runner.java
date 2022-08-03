package cucumberframework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"pretty","html:target/cucumber-run"},
        features={"src/test/resources"},
        tags="@multiple"
)

public class Runner {
}
