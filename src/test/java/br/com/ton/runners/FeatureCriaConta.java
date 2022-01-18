package br.com.ton.runners;

import br.com.ton.utils.AppiumDriverConfig;
import br.com.ton.component.ContaComponet;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Given;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class FeatureCriaConta {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;

    @Test
    public void criarContaSemSerClientStoneTest() {
        ContaComponet conta = new ContaComponet(this.driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        conta.btnCriarConta();
        conta.btnNaoSouCliente();

        WebElement childElements = (WebElement) driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Criar uma conta com seu CPF')]")).get(0);
        childElements.click();
        List<AndroidElement> checkbox = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='5']"));
        checkbox.get(0).click();
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Criar minha conta')]").click();

        List<AndroidElement> CPF = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='9']/android.widget.EditText"));
        CPF.get(0).click();
        CPF.get(0).sendKeys("99999999999");

        List<AndroidElement> nome = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='13']/android.widget.EditText"));
        nome.get(0).click();
        nome.get(0).sendKeys("Pedro Alvares Cabral");

        driver.navigate().back();

        List<AndroidElement> dataNascimento = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='17']/android.widget.EditText"));
        dataNascimento.get(0).click();
        dataNascimento.get(0).sendKeys("22022000");

        driver.navigate().back();

        List<AndroidElement> continuar = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='19']/android.widget.TextView"));
        continuar.get(0).click();

        List<AndroidElement> celular = driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='9']/android.widget.EditText"));
        System.out.println(celular.get(0).getLocation());


        assertTrue(true);
    }



}
