package com.MacroQA.aplicativo.pageObject;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.31.219.52:8084/MacroIndividuosDesktop/")
public class macroRecargasPageObject extends MacroPageObject {

	@FindBy(id = "recharges")
	public WebElementFacade btnRecarga;
	
	@FindBy(xpath = "(//P[@class='autoAdjustText'][text()='Con tus Cuentas'][text()='Con tus Cuentas'])[1]")
	public WebElementFacade btnConTusCuentasCelu;
	
	@FindBy(xpath = "//P[@class='autoAdjustText'][text()='Con Tarjeta o Puntos Macro Premia']")
	public WebElementFacade btnTarjetaOPremia;
	
	@FindBy(xpath = "(//P[@class='autoAdjustText'][text()='Con tus Cuentas'][text()='Con tus Cuentas'])[2]")
	public WebElementFacade btnConTusCuentasOtrosServicios;
	
	@FindBy(xpath = "//SPAN[@id='step-process_title-span']")
	public WebElementFacade lblRecargas;
	
	@FindBy(xpath = "//IMG[@tabindex='0']")
	public WebElementFacade btnMacroFooter;
	
	public void recargaHeader() {
		waitFor(6).seconds();
		btnRecarga.isCurrentlyEnabled();
		btnRecarga.click();
		waitFor(2).seconds();
		scrollToElement(btnMacroFooter);
		Serenity.takeScreenshot();
	}
	
	public void recargaTarjetaPremia() {
		recargaHeader();
		btnTarjetaOPremia.click();
		waitFor(1).second();
		Serenity.takeScreenshot();
	}

	public void recargasConTusCuentas() {
		recargaHeader();
		btnConTusCuentasCelu.click();
		waitFor(1).second();
		Serenity.takeScreenshot();
	}
	
	public void recargasConTusCuentasOtrosServicios() {
		recargaHeader();
		btnConTusCuentasOtrosServicios.click();
		waitFor(1).second();
		
	}
	public void assertRecarga(String strRecarga) {
		compararConAssert(lblRecargas, strRecarga);
	}

}
