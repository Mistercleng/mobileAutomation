package br.com.ton.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features/cadastroConta.feature",
        glue = "br.com.ton.steps",
        plugin = {"pretty","html:target/report.html","json:target/report.json"},
        tags = "@TestCaseID:01",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false)
public class Runner {
}
