package com.MacroQA.aplicativo.steps;

import com.MacroQA.aplicativo.pageObject.MacroDashBoardInversionesPageObject;

import net.thucydides.core.annotations.Step;

public class macroInversionesDashboardSteps {
	MacroDashBoardInversionesPageObject inversionDashBoardMacro;
	
	
	@Step
	public void iniciarSesion(String strUser, String strPass) {
		inversionDashBoardMacro.open();
		inversionDashBoardMacro.login(strUser, strPass);
	}
	
	@Step
	public void verDetalle(String strFondoComun) {
		inversionDashBoardMacro.accesoDirectoFondoComun(strFondoComun);
	}
}
