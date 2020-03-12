package com.MacroQA.aplicativo.pageObject;

import java.util.List;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://172.31.219.52:8084/MacroIndividuosDesktop/")
public class MacroDashBoardInversionesPageObject extends MacroPageObject{
	
	 @FindBy(id="section2_arrowButton")
	 public WebElementFacade arrowBtonInversiones;
	 
	 @FindBy(xpath = "//TD[@id='section0_repeat0_collectionTableComposicionFondos_ON-REGISTER'][1]")
	 public List<WebElementFacade> cuentaCuotaPartista;
	 
	 @FindBy(xpath="//td[@class=\"collection-column_default center-align\"]")
	 public List<WebElementFacade> btnAccesoDirecto;
	 
	 @FindBy(xpath="//div[@aria-label=\"Menú desplegable. Presioná enter para desplegar\"]//div[@aria-label=\"Menú desplegado\"]//ul//li[@id=\"menu_detalle\"]")
	 public List<WebElementFacade> btnVerDetalle;
	 
	 @FindBy(id="menu_suscribir")
	 public WebElementFacade btnSuscribirMas;
	 
	 @FindBy(id="menu_rescatar")
	 public WebElementFacade btnRescatar;
	 
	 @FindBy(xpath="//DIV[@id='flechaAbajo']")
	 public List<WebElementFacade> btnFlecha;
	 
	 @FindBy(xpath = "//INPUT[@id='section2_arrowButton']")
	 public WebElementFacade arrowInversiones;
	 
	 @FindBy(xpath = "//INPUT[@value='Inversiones' and @class='sectionToggle font-size_card section_collapsible_close_button']")
	 public WebElementFacade arrowInversionesDown;
	 
	 @FindBy(xpath = "//INPUT[@value='Inversiones' and @class='sectionToggle font-size_card section_collapsible_open_button']")
	 public WebElementFacade arrowInversionesUp;
	 
	 
	 public void accesoDirectoFondoComun(String strFondoComun) {
		 int index = 0;
		 System.out.println(arrowInversionesDown.isEnabled());
		 if(arrowInversionesDown.isEnabled()) {
			 arrowBtonInversiones.click();
		 }else {
			 arrowInversionesUp.click();
		 }
		
		 int cantCuentasCuotapartistas = cuentaCuotaPartista.size();
		 for(int i = 0;i< cantCuentasCuotapartistas ;i++) {
			 if(cuentaCuotaPartista.get(i).getText().equals(strFondoComun)) {		
				 index = i;
				 break;
			 }
			 
		 }
		 cuentaCuotaPartista.get(index).click();
	 }
	

}
