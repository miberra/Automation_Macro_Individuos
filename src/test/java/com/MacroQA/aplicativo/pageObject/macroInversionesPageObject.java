package com.MacroQA.aplicativo.pageObject;

import java.util.Date;

import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.31.219.52:8084/MacroIndividuosDesktop/")
public class macroInversionesPageObject extends MacroPageObject{
	
	@FindBy(xpath = "//A[@id='investments']")
	public WebElementFacade btnInversiones;
	
	@FindBy(xpath = "//A[@id='loanpf']")
	public WebElementFacade btnConstitucionPlazoFijo;
	
	@FindBy(xpath = "//A[@id='consultaDeTasas']")
	public WebElementFacade btnConsultasTasas;
	
	@FindBy(xpath = "//A[@id='mondedas2']")
	public WebElementFacade btnCompraVentaDolares;
	
	@FindBy(xpath = "//A[@id='saltoSitioFCI']")
	public WebElementFacade btnNuestroFondosFCI;
	
	@FindBy(xpath = "//A[@id='tenenciasFCI']")
	public WebElementFacade btnTenenciasFCI;
	
	@FindBy(xpath = "//A[@id='comparativaFondos']")
	public WebElementFacade btnComparativaFondos;
	
	@FindBy(xpath = "//A[@id='simuladorCartera']")
	public WebElementFacade btnSimuladorCartera;
	
	@FindBy(xpath = "//A[@id='testInversor']")
	public WebElementFacade btnTestInversor;
	
	@FindBy(xpath = "//A[@id='preguntasFrecuentes']")
	public WebElementFacade btnPreguntasFrecuentes;
	
	//FCI - Nuestros fondos
	@FindBy(xpath ="//P[@class='autoAdjustText'][text()='Invertí en nuestros fondos']")
	public WebElementFacade btnInvertiNuestrosFondos;
	
	@FindBy(id="selectFieldFondoInversion")
	public WebElementFacade drpFondoAInvertir;
	
	@FindBy(id="floatFieldImporte")
	public WebElementFacade txtImporteASuscribir;
	
	@FindBy(id ="selectFieldCuentasDebito")
	public WebElementFacade drpCuentaDebito;
	
	@FindBy(xpath ="//P[@class='autoAdjustText'][text()='Continuar']")
	public WebElementFacade btnContinuarGeneracionSolicitudFCI;
	
	@FindBy(xpath="//input[@aria-label=\"Leí y acepto los términos y condiciones de la operación.\"]")
	public WebElementFacade chkOperacion;
	
	@FindBy(xpath="//input[@aria-label=\"Leí y acepto los términos y condiciones del reglamento de gestión.\"]")
	public WebElementFacade chkGestion;
	
	@FindBy(xpath="//P[@class='autoAdjustText'][text()='Confirmar']")
	public WebElementFacade btnConfirmarFCI;
	
	@FindBy(xpath="//*[@id=\"richTextNSolicitud\"]")
	public WebElementFacade lblNroSolicitud;
	
	public void inversiones() {
		waitFor(6).seconds();
		btnInversiones.click();
		Serenity.takeScreenshot();
	}
	
	public void constitucionPlazoFijos() {
		inversiones();
		btnConstitucionPlazoFijo.click();
		waitFor(3).second();
		Serenity.takeScreenshot();
	}
	
	public void consultasTasasFijas() {
		inversiones();
		btnConsultasTasas.click();
		waitFor(3).second();
		Serenity.takeScreenshot();
	}
	public void compraVentaDolares() {
		inversiones();
		btnCompraVentaDolares.click();
		waitFor(3).second();
		Serenity.takeScreenshot();
		
	}
	
	public void nuestroFondos() {
		inversiones();
		btnNuestroFondosFCI.click();
		waitFor(3).second();
		Serenity.takeScreenshot();
	}
	
	public void invertiEnNuestroFondos() {
		nuestroFondos();
		btnInvertiNuestrosFondos.click();
		waitFor(2).seconds();
	}
	
	public void solicitudDeSuscripcionDeFCI(String strFondoAInvertir, String strImporte, String strCuentaDebito) {
		waitFor(2).seconds();
		new Select(drpFondoAInvertir).selectByVisibleText(strFondoAInvertir);
		txtImporteASuscribir.isEnabled();
		txtImporteASuscribir.sendKeys(strImporte);
		drpCuentaDebito.sendKeys(strCuentaDebito);
		Serenity.takeScreenshot();
		waitFor(2).seconds();
		scrollToElement(btnContinuarGeneracionSolicitudFCI);
		btnContinuarGeneracionSolicitudFCI.click();
		waitFor(4).seconds();
		Serenity.takeScreenshot();
		chkGestion.click();
		chkOperacion.click();
		scrollToElement(btnConfirmarFCI);
		waitFor(2).seconds();
		Serenity.takeScreenshot();
		btnConfirmarFCI.click();
		waitFor(2).seconds();
		System.out.println(new Date());
		String NroSolicitud = lblNroSolicitud.getText();
		System.out.println(NroSolicitud);
		
		
	}
	
}
