package br.com.calculadora;

import com.sun.xml.internal.ws.resources.UtilMessages;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Automatização utilizando emulador Android
 * <p>
 * O objetivo desta classe é realizar a automatização de uma soma na calculadora
 * Utilizando o JUnit para realizar a comparação do resultado
 */

public class FormularioMobileFisico {

    @Test
    public void devePreencherCampoNome() throws MalformedURLException {

        AndroidDriver driver = getAndroidDriver();

        //Selecionar formulario
        List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        // for (MobileElement elemento: elementosEncontrados){
        //    System.out.println(elemento.getText());
        // }
        elementosEncontrados.get(1).click();

        //Escrever Nome
        MobileElement campoNome = (MobileElement) driver.findElement(MobileBy.AccessibilityId("nome"));
        campoNome.sendKeys("Brenda");
        //Checar nome escrito

        String text = campoNome.getText();
        Assert.assertEquals("Brenda", text);


        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }

    private AndroidDriver getAndroidDriver() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "LMK510SGUWHYSCAQZ9");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.ctappium");
        desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
        //Usar noReset senão ele fica limpando o app e fica pedindo permissões ao abrir o app
        desiredCapabilities.setCapability("noReset", "true");


        //Parametros para comunicação do servidor do emulador Android
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @Test
    public void deveInteragirCombo() throws MalformedURLException {

        AndroidDriver driver = getAndroidDriver();

        //Selecionar formulario
        driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();

        //Clica no combo
        driver.findElement(MobileBy.AccessibilityId("console")).click();

        //selecionar opção desejada
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();


        //Verificar opção escolhida
        String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
        Assert.assertEquals("Nintendo Switch", text);


        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {

        AndroidDriver driver = getAndroidDriver();

        //Selecionar formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

        //Verificar status dos elementos
        MobileElement check = (MobileElement) driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switc = (MobileElement) driver.findElement(MobileBy.AccessibilityId("switch"));
        Assert.assertTrue(check.getAttribute("checked").equals("false"));
        Assert.assertTrue(switc.getAttribute("checked").equals("true"));

        //Clicar nos elementos
        check.click();
        switc.click();

        //Verificar estados alterados
        Assert.assertFalse(check.getAttribute("checked").equals("false"));
        Assert.assertFalse(switc.getAttribute("checked").equals("true"));


        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }

    @Test
    public void desafio() throws MalformedURLException {

        AndroidDriver driver = getAndroidDriver();

        //Selecionar formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();

        //Preencher Campos
        driver.findElement(MobileBy.AccessibilityId("nome")).sendKeys("Brenda");
        driver.findElement(MobileBy.AccessibilityId("console")).click();
        driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
        driver.findElement(By.className("android.widget.CheckBox")).click();
        driver.findElement(MobileBy.AccessibilityId("switch")).click();


        //Clicar no Salvar
        driver.findElement(By.xpath("//android.widget.Button/android.widget.TextView")).click();

        //Verificar texto
        String text = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[2]")).getText();
        Assert.assertEquals("Nome: Brenda", text);
        String text2 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[3]")).getText();
        Assert.assertEquals("Console: switch", text2);
        String text3 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[5]")).getText();
        Assert.assertEquals("Switch: Off", text3);
        String text4 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[6]")).getText();
        Assert.assertEquals("Checkbox: Marcado", text4);

        //Encerrar sessão com servidor
        //Esse comando retorna o celular para tela inicial
        driver.quit();
    }
}