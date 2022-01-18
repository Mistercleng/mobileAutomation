package br.com.ton.steps;

import br.com.ton.component.ContaComponet;
import br.com.ton.utils.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class ContaStep {


    AppiumDriver driver = AppiumDriverConfig.Instance().driver;

    ContaComponet component = new ContaComponet(driver);

    @Dado("que o usuario acessa o aplicativo")
    public void inicializaAplicacao() {
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @Quando("^escolher a opcão criar nova conta$")
    public void novaConta(){
        component.btnCriarConta();
    }

    @Quando("selecionar não sou cliente")
    public void contaNaoStone(){
        component.btnNaoSouCliente();
    }

    @Entao("deverá exibir tela de tipo de conta")
    public void validaTelaDeTipoDeConta(){
        component.validaTextoTipoConta();
    }


    @Entao("deverá mostrar pergunta Você já é cliente Stone Mais?")
    public void validaClienteStoneMais(){
        component.clienteStoneMais();
    }

    public void selecionaTipoDeConta(String tipo){
        component.tipoConta(tipo);
    }

    @Quando("selecionar sou cliente")
    public void selecionarSouCliente() {
        component.btnSouCliente();
    }

    @Entao("deverá exibir tela login")
    public void deveraExibirTelaLogin() {
       component.loginTextEntrar();
    }


}
