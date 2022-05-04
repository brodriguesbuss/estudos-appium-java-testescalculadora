package br.com.calculadora;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Automatização utilizando emulador Android
 *
 * O objetivo desta classe é realizar a automatização de uma soma na calculadora
 * Utilizando o JUnit para realizar a comparação do resultado
 */

public class CalculadoraTesteEmulador {

    @Test
    public  void deveSomarDoisValores() throws MalformedURLException {

        //Parametros para comunicação com emulador e o aplicativo que irá automatizar no Android
        //Aqui informamos qual o SO do emulador, nome, framework de testes do UI, pasta do aplicativo e aplicativo
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        // OBS: O uiautomator2 oferece um conjunto de APIs para criar testes de IU que realizam interações em apps de usuário e do sistema

        //Parametros para comunicação do servidor do emulador Android
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        //busca elemento, numero 8
        MobileElement el1 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_8");
        //clica no elemento
        el1.click();
        //busca elemento, soma
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("plus");
        //clica no elemento
        el2.click();
        //busca elemento, numero 9
        MobileElement el3 = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_9");
        //clica no elemento
        el3.click();
        //busca elemento, resultado
        MobileElement el4 = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        //Comparando resultado com JUnit
        Assert.assertEquals("17", el4.getText());

        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }
}