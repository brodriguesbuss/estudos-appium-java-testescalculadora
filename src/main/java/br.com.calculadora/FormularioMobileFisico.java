package br.com.calculadora;

import br.com.appium.core.DSL;
import br.com.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import java.net.MalformedURLException;

import static org.junit.Assert.*;

/**
 * Automatização utilizando emulador Android
 * <p>
 * O objetivo desta classe é realizar a automatização de uma soma na calculadora
 * Utilizando o JUnit para realizar a comparação do resultado
 */

public class FormularioMobileFisico {

    AndroidDriver driver;

    private DSL dsl = new DSL();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        driver = DriverFactory.getDriver();

        //Selecionar formulario
        driver.findElement(By.xpath("//*[@text='Formulário']")).click();
    }

    @After
    public void aoFinal(){
        //Encerrar sessão com servidor
        DriverFactory.killDriver();
    }

    @Test
    public void devePreencherCampoNome() throws MalformedURLException {

        //Escrever Nome
        dsl.escrever(MobileBy.AccessibilityId("nome"),"Brenda" );

        //Checar nome escrito
        assertEquals("Brenda", dsl.obterTexto(MobileBy.AccessibilityId("nome")));

    }


    @Test
    public void deveInteragirCombo() throws MalformedURLException {

        //Clica no combo
        dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

        //Verificar opção escolhida
        String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
        assertEquals("Nintendo Switch", text);

    }

    @Test
    public void deveInteragirSwitchCheckBox() throws MalformedURLException {

        //Verificar status dos elementos
        MobileElement check = (MobileElement) driver.findElement(By.className("android.widget.CheckBox"));
        MobileElement switc = (MobileElement) driver.findElement(MobileBy.AccessibilityId("switch"));
        assertTrue(check.getAttribute("checked").equals("false"));
        assertTrue(switc.getAttribute("checked").equals("true"));

        //Clicar nos elementos
        check.click();
        switc.click();

        //Verificar estados alterados
        assertFalse(check.getAttribute("checked").equals("false"));
        assertFalse(switc.getAttribute("checked").equals("true"));

    }

    @Test
    public void desafio() throws MalformedURLException {

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
        assertEquals("Nome: Brenda", text);
        String text2 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[3]")).getText();
        assertEquals("Console: switch", text2);
        String text3 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[5]")).getText();
        assertEquals("Switch: Off", text3);
        String text4 = driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.TextView[6]")).getText();
        assertEquals("Checkbox: Marcado", text4);

    }


}