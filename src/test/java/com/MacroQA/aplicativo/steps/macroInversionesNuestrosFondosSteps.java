package com.MacroQA.aplicativo.steps;

import com.MacroQA.aplicativo.pageObject.MacroDashBoardInversionesPageObject;
import com.MacroQA.aplicativo.pageObject.macroInversionesPageObject;

import net.thucydides.core.annotations.Step;

public class macroInversionesNuestrosFondosSteps {
	
	macroInversionesPageObject inversionMacro;
	MacroDashBoardInversionesPageObject inversionDashboardMacro;
	
	@Step
	public void iniciarSesion(String strUser, String strPass) {
		inversionMacro.open();
		inversionMacro.login(strUser, strPass);
	}
	
	@Step 
	public void invertirEnNuestrosFondos(String strFondoComun,String strFondoAInvertir, String strImporte, String strCuentaDebito){
		inversionMacro.invertiEnNuestroFondos();
		inversionDashboardMacro.accesoDirectoFondoComun(strFondoComun);
		inversionMacro.solicitudDeSuscripcionDeFCI(strFondoAInvertir, strImporte, strCuentaDebito);
	}
	
	
}
