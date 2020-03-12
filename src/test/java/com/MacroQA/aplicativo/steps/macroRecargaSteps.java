package com.MacroQA.aplicativo.steps;

import com.MacroQA.aplicativo.pageObject.macroRecargasPageObject;

import net.thucydides.core.annotations.Step;

public class macroRecargaSteps {

	macroRecargasPageObject recargaMacro;
	
	@Step
	public void iniciarSesion(String strUser, String strPass) {
		recargaMacro.open();
		recargaMacro.login(strUser, strPass);
		
	}
	
	@Step
	public void recargaCuentas() {
		recargaMacro.recargasConTusCuentas();
	}
	@Step
	public void assertLabelRecarga(String strRecarga) {
		recargaMacro.assertRecarga(strRecarga);
	}
	@Step
	public void cerrarSesion() {
		recargaMacro.logout();
	}
	@Step
	public void recargaTarjeta() {
		recargaMacro.recargaTarjetaPremia();
	}
	@Step
	public void recargaOtroServicio() {
		recargaMacro.recargasConTusCuentasOtrosServicios();
	}
}
