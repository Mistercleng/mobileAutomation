package br.com.ton.component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;
import java.util.concurrent.TimeUnit;

public class ContaComponet {

    private AppiumDriver driver;

    public ContaComponet(AppiumDriver driver) {
        this.driver = driver;
    }

    @BeforeAll
    public void inicio() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    public void btnCriarConta() {
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Criar conta')]").click();
    }

    public void btnSouCliente() {
        driver.findElementByXPath("//*/android.view.ViewGroup[@index='0']/android.view.ViewGroup[@index='5']/android.widget.TextView[@index='0']").click();
    }

    public void btnNaoSouCliente() {
        driver.findElementByXPath("//android.widget.TextView[contains(@text,'Não sou cliente')]").click();
    }

    public void tipoDeCliente(String tipo){
        if(tipo == "Stone"){
            btnSouCliente();
        } else {
            btnNaoSouCliente();
        }
    }

    public void btnContaPF(){
        WebElement childElements = (WebElement) driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Criar uma conta com seu CPF')]")).get(0);
        childElements.click();
    }

    public void clienteStoneMais(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")));
        WebElement childElements = (WebElement) driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='2']")).get(0);
        Assert.assertTrue(childElements.isDisplayed());
    }

    public void btnContaPJ(){
        WebElement childElements = (WebElement) driver.findElements(By.xpath("//android.widget.TextView[contains(@text,'Criar uma conta com seu CNPJ/MEI')]")).get(0);
        childElements.click();
    }

    public void validaTextoTipoConta(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")));
        WebElement childElements = (WebElement) driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")).get(0);
        Assert.assertTrue(childElements.isDisplayed());
    }

    public void loginTextEntrar(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")));
        WebElement childElements = (WebElement) driver.findElements(By.xpath("//*/android.view.ViewGroup[@index='0']/android.widget.TextView[@index='1']")).get(0);
        Assert.assertTrue(childElements.isDisplayed());
    }

    public void tipoConta(String tipo){
        if(tipo == "PF"){
            btnContaPF();
        } else {
            btnContaPJ();
        }

    }

    @After
    public void fim(){
        driver.quit();
        driver.closeApp();
    }




}
