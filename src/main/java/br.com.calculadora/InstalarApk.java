package br.com.calculadora;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Automatização utilizando emulador Android
 *
 * O objetivo desta classe é realizar a automatização de uma soma na calculadora
 * Utilizando o JUnit para realizar a comparação do resultado
 */

public class InstalarApk {

    private AndroidDriver driver;

    @Test
    public  void deveInstalarApk() throws MalformedURLException {

        //Parametros para comunicação com emulador e o aplicativo que irá automatizar no Android
        //Aqui informamos qual o SO do emulador, nome, framework de testes do UI, pasta do aplicativo e aplicativo
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "LMK510SGUWHYSCAQZ9");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
      //  desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\PremierSoft\\Downloads\\AutomatizacaoCalculadora\\src\\main\\resources\\CTAppium_1_2.apk");

        //Parametros para comunicação do servidor do emulador Android
        //AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }
}