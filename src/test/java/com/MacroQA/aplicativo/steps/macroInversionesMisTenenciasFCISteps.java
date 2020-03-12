package com.MacroQA.aplicativo.steps;

import com.MacroQA.aplicativo.pageObject.MacroMisTenenciasFCIPageObject;

import net.thucydides.core.annotations.Step;

public class macroInversionesMisTenenciasFCISteps {

	MacroMisTenenciasFCIPageObject macroMisTenenciasFCI;
	@Step
	public void iniciarSesion(String strUser, String strPass) {
		macroMisTenenciasFCI.open();
		macroMisTenenciasFCI.login(strUser, strPass);
	}
	
	@Step
	public void seleccionarFondo(String strFondoComun) {
		macroMisTenenciasFCI.seleccionarFondo(strFondoComun);
	}
	
	@Step
	public void inversionesMisTenencias() {
		macroMisTenenciasFCI.InverionesMisTenencias();
	}
	
	@Step
	public void procesoRescateFCI(String strTipoRescate,String strCantidad,String strCuentaCredito) {
		macroMisTenenciasFCI.solicitudRescate(strTipoRescate, strCantidad, strCuentaCredito);
		
		macroMisTenenciasFCI.logout();

	}
}
