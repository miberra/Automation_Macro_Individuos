package com.MacroQA.aplicativo.pageObject;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.31.219.52:8084/MacroIndividuosDesktop/#")
public class MacroPageObject extends PageObject{

	
	@FindBy(xpath = "//INPUT[@id='textField1']")
	public WebElementFacade txtUser;
	
	@FindBy(xpath = "//P[@class='autoAdjustText']")
	public WebElementFacade btnContinuar;
	
	@FindBy(xpath = "//INPUT[@id='login_textField1']")
	public WebElementFacade txtUserPass;
	
	@FindBy(xpath = "//P[@class='autoAdjustText'][text()='Ingresá']")
	public WebElementFacade btnIngresa;
	
	@FindBy(xpath = "//LABEL[@id='constantLdabel0']")
	public WebElementFacade onBoardMessagePrestamo;
	
	//Dashboard
	@FindBy(xpath = "//P[@class='widget_userName']")
	public WebElementFacade lblUserName;
	
	@FindBy(xpath = "//A[@id='widgetLogoutBtn']")
	public WebElementFacade btnExit;
	
	@FindBy(xpath = "//IMG[@role='img']")
	public WebElementFacade logoMacro;
	
	@FindBy(id="tableAlign4111")
	public WebElementFacade onboardPrestamo;
	
	@FindBy(xpath = "//P[@class='autoAdjustText'][text()='Cerrar']")
	public WebElementFacade onboardCancelar;
	
	@FindBy(xpath="//A[@id='investments']")
	public WebElementFacade btnInversiones;
	
	@FindBy(id = "tenenciasFCI")
	public WebElementFacade btnMisTenencias;
	
	@FindBy(xpath = "lstFCINombreCuenta.get(index)")
	public WebElementFacade ftrLogoMacro;
	
	@FindBy(xpath = "//A[@href='https://www.macro.com.ar/conocenos/canales-de-atencion/banca-internet/personas'][text()='PREGUNTAS FRECUENTES']")
	public WebElementFacade ftrPreguntasFrecuentes;
	
	
	public void login(String strUser, String strPass) {
		
			
		System.out.println(getDriver().getCurrentUrl());
		txtUser.isCurrentlyEnabled();
		txtUser.sendKeys(strUser);
		Serenity.takeScreenshot();
		btnContinuar.click();
		txtUserPass.sendKeys(strPass);
		Serenity.takeScreenshot();
		btnIngresa.click();
		waitFor(3).seconds();
		
		if(onboardPrestamo.isVisible()) {
			onboardCancelar.click();
		}
		
//		String tipoCliente = reconocerCliente();
//		tipoCliente(tipoCliente);
//		System.out.println(tipoCliente);
		
	}
	
	public String reconocerCliente() {
		if(onboardPrestamo.isVisible() && onboardCancelar.isCurrentlyEnabled()) {
			return "comun";
		}else {
			return "selecta";
		}
	}
	
	public void tipoCliente(String tipoCliente) {
		switch(tipoCliente) 
        { 
            case "selecta": 
                System.out.println("Usuario Selecta"); 
                break;
            default: 
            	System.out.println("Usuario Comun");
            	onboardCancelar.click();
           
        } 
	}
	
	
	public void clienteComun() {
		onboardCancelar.click();
	
	}
	public void clienteSelecta() {
		
	}
	public void InverionesMisTenencias() {
		waitFor(2).seconds();
		btnInversiones.isEnabled();
		btnInversiones.click();
		waitFor(1).second();
		btnMisTenencias.isEnabled();
		btnMisTenencias.click();
	}
	
	public void assertUsuario(String strUserName) {
		logoMacro.isCurrentlyEnabled();
		compararConAssert(lblUserName, strUserName);
		Serenity.takeScreenshot();
		waitFor(1).second();
	}
	
	
	public void logout() {
		logoMacro.isCurrentlyEnabled();
		waitFor(1).second();
		Serenity.takeScreenshot();
		btnExit.click();
		getDriver().close();
		
	}
	
	
	public void ejecutar(WebElementFacade element) {
		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		  jse.executeScript("arguments[0].click();", element);
	}
	
	public void scrollToElement(WebElementFacade element) {
		  
		  JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		  jse.executeScript("arguments[0].scrollIntoView(true);", element);
		  
	}
	
	public void compararConAssert(WebElementFacade elem, String strTexto) {
		String user = elem.getText();
		assertThat(user,containsString(strTexto));
	}
	public void seleccionarPorTexto(String txtLinkTex) {
		getDriver().findElement(By.linkText(txtLinkTex)).click();
	}
	
	public void footerLogoMacro() {
		scrollToElement(ftrPreguntasFrecuentes);
	}
	
}
