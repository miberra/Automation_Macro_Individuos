package com.MacroQA.aplicativo.pageObject;

import java.util.List;


import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.31.219.52:8084/MacroIndividuosDesktop/#")
public class MacroMisTenenciasFCIPageObject extends MacroPageObject{

	@FindBy(xpath = "//TD[@id='collectionTableFondos2_ON-REGISTER'][1]")
	public List<WebElementFacade> lstFCINombreCuenta;
	
	@FindBy(xpath ="//P[@class='autoAdjustText'][text()='Rescatar']")
	public WebElementFacade btnRescatar;
	
	@FindBy(xpath ="//P[@class='autoAdjustText'][text()='Suscribir más']")
	public WebElementFacade btnSuscribirMas;
	
	@FindBy(xpath="//INPUT[@id='radioButtonField0_opt_0']")
	public WebElementFacade rdioBtnRescateParcial;
	
	@FindBy(xpath="//INPUT[@id='radioButtonField0_opt_1']")
	public WebElementFacade rdioBtnRescateTotal;
	
	@FindBy(xpath="//INPUT[@id='radioButtonField1_opt_0']")
	public WebElementFacade rdioBtnImporte;
	
	@FindBy(xpath="//INPUT[@id='radioButtonField1_opt_1']")
	public WebElementFacade rdioBtnCantCuotaPartes;
	
	@FindBy(xpath="//INPUT[@id='floatFieldImportePesos']")
	public WebElementFacade txtImportePesos;
	
	@FindBy(xpath="//INPUT[@id='cantidadCuot2']")
	public WebElementFacade txtCuotaPartes;
	
	@FindBy(xpath = "//SELECT[@id='selectFieldCuentasCredito2']")
	public WebElementFacade drpCuentaCredito;
	
	@FindBy(xpath="//P[@class='autoAdjustText'][text()='Continuar']")
	public WebElementFacade btnContinuar;
	
	@FindBy(xpath="//INPUT[@id='checkFieldTerms']")
	public WebElementFacade chkTerminos;
	
	@FindBy(xpath="//P[@class='autoAdjustText'][text()='Confirmar']")
	public WebElementFacade btnConfirmar;
	
	@FindBy(xpath="(//P[@align='center'])[1]")
	public WebElementFacade lblNroSolicitud;
	
	@FindBy(xpath = "//DIV[@id='tableAlignrow']")
	public WebElementFacade areaProceso;
	
	public void seleccionarFondo(String strFondoComun) {
		footerLogoMacro();
		int cantCuentas = lstFCINombreCuenta.size();
		int index = 0;
		for(int i = 0 ; i<cantCuentas; i++) {
			if(lstFCINombreCuenta.get(i).getText().equals(strFondoComun)) {
				index = i;
                break;
			}
		}
		System.out.println(cantCuentas);
		System.out.println(lstFCINombreCuenta.get(index).isCurrentlyEnabled());
		lstFCINombreCuenta.get(index).click();

	}


	public void realizarEnFCI(WebElementFacade elem) {
		Serenity.takeScreenshot();
		elem.isEnabled();
		elem.click();
		waitFor(2).seconds();
	}
	
	public void rescateTotalFCI() {
		realizarEnFCI(btnRescatar);
		rdioBtnRescateTotal.click();
	}
	
	public void rescateParcialFCI() {
		realizarEnFCI(btnRescatar);
		rdioBtnRescateParcial.click();
	}
	
	public void suscribirMasFCI() {
		realizarEnFCI(btnSuscribirMas);
	}
	
	public void cuotaParteTotal() {
		rescateTotalFCI();
			
		
	}
	
	public void solicitudRescate(String strTipoRescate,String strCantidad,String strCuentaCredito) {
		switch(strTipoRescate) {
		  case "Total":
			  rescateTotal(strCantidad,strCuentaCredito); 
			break;
		  case "Parcial-CuotaPartes":
			  rescatarCuotaPartesParcial(strCantidad,strCuentaCredito);
		    break;
		  case "Parcial-Importes":
			  rescatarImporteFCIParcial(strCantidad,strCuentaCredito);
			break;
		}
	}
	
	public void rescateTotal(String strCantidad,String strCuentaCredito) {
		realizarEnFCI(btnRescatar);
		rdioBtnRescateTotal.click();
		scrollToElement(drpCuentaCredito);
		rdioBtnRescateTotal.click();
		
		System.out.println(drpCuentaCredito.isEnabled());
		Select cuentaCredito = new Select(drpCuentaCredito);
		cuentaCredito.selectByVisibleText("CA $ ...5244 / $14.757,68");
		btnContinuar.click();
		chkTerminos.isEnabled();
		chkTerminos.click();
		btnConfirmar.click();
//		waitFor(3).second();
		String NroSolicitud =  lblNroSolicitud.getText();
		System.out.println(NroSolicitud);
	}
	
	public void rescatarCuotaPartesParcial(String strCantidad,String strCuentaCredito) {
		realizarEnFCI(btnRescatar);
		rdioBtnCantCuotaPartes.click();
		txtCuotaPartes.sendKeys(strCantidad);
		rdioBtnCantCuotaPartes.click();
//		txtCuotaPartes.sendKeys(Keys.TAB);
//		areaProceso.click();
		System.out.println(drpCuentaCredito.isEnabled());

		Select cuentaCredito = new Select(drpCuentaCredito);
		cuentaCredito.selectByVisibleText("CA $ ...5244 / $14.757,68");
		btnContinuar.click();
		chkTerminos.isEnabled();
		chkTerminos.click();
		btnConfirmar.click();
//		waitFor(1).second();
		String NroSolicitud =  lblNroSolicitud.getText();
		System.out.println(NroSolicitud);
	}

	public void rescatarImporteFCIParcial(String strCantidad,String strCuentaCredito) {
		realizarEnFCI(btnRescatar);
		rdioBtnRescateParcial.click();
		txtImportePesos.sendKeys(strCantidad);
		rdioBtnRescateParcial.click();
		System.out.println(drpCuentaCredito.isEnabled());

//		txtImportePesos.sendKeys(Keys.TAB);
//		areaProceso.click();
		Select cuentaCredito = new Select(drpCuentaCredito);
		cuentaCredito.selectByVisibleText("CA $ ...5244 / $14.757,68");
		btnContinuar.click();
		chkTerminos.isEnabled();
		chkTerminos.click();
		btnConfirmar.click();
//		waitFor(1).second();
		String NroSolicitud =  lblNroSolicitud.getText();
		System.out.println(NroSolicitud);
		
		
	}
	
}
