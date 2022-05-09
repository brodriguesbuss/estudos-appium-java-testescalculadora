package br.com.calculadora;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.Console;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Automatização utilizando emulador Android
 *
 * O objetivo desta classe é realizar a automatização de uma soma na calculadora
 * Utilizando o JUnit para realizar a comparação do resultado
 */

public class CalculadoraTesteMobileFisico {

    private AndroidDriver driver;


    @Test
    public  void deveSomarDoisValoresFisico() throws MalformedURLException {

        //Parametros para comunicação com emulador e o aplicativo que irá automatizar no Android
        //Aqui informamos qual o SO do emulador, nome, framework de testes do UI, pasta do aplicativo e aplicativo
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "LMK510SGUWHYSCAQZ9");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.fothong.calculadora");
        desiredCapabilities.setCapability("appActivity", "com.fothong.calculadora.MainActivity");

        // OBS: O uiautomator2 oferece um conjunto de APIs para criar testes de IU que realizam interações em apps de usuário e do sistema

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
        //Parametros para comunicação do servidor do emulador Android
      //  AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View[2]/android.view.View/android.widget.TextView[2]");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View[4]/android.view.View/android.widget.TextView[2]");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[9]/android.view.View[2]/android.view.View/android.widget.TextView[2]");
        el3.click();
     //   MobileElement el4 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[10]/android.view.View[3]/android.view.View/android.widget.TextView[2]");
     //   el4.click();
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.TextView");


        //Comparando resultado com JUnit
        Assert.assertEquals("4", el5.getText());

        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }
}