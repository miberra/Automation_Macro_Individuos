package com.MacroQA.aplicativo.steps;

import com.MacroQA.aplicativo.pageObject.macroInversionesPageObject;

import net.thucydides.core.annotations.Step;

public class macroInversionesSteps {
	
	macroInversionesPageObject inversionMacro;
	
	@Step
	public void iniciarSesion(String strUser, String strPass) {
		inversionMacro.open();
		inversionMacro.login(strUser, strPass);
	}
	
	@Step 
	public void constitucionPlazoFijo() {
		inversionMacro.constitucionPlazoFijos();
	}
	
	@Step
	public void consultasTasasFijas() {
		inversionMacro.consultasTasasFijas();
	}
	
	@Step
	public void compraVentaDolares() {
		inversionMacro.compraVentaDolares();
	}
	
	@Step 
	public void nuestroFondosFCI(){
		inversionMacro.nuestroFondos();
	}
	
	@Step
	public void cerrarSesion() {
		inversionMacro.logout();
	}
}
