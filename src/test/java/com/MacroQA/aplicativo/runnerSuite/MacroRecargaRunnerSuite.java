package com.MacroQA.aplicativo.runnerSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.MacroQA.aplicativo.pageObject.macroRecargasPageObject;
import com.MacroQA.aplicativo.steps.macroRecargaSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("C:/Users/Arbusta/eclipse-workspace/com.MacroQA.aplicativo/src/test/resources/dataDriven/recarga.csv")
public class MacroRecargaRunnerSuite {
	private String strUser;
	private String strPass;
	private String streRecarga;

	@Managed
	macroRecargasPageObject recargaMacro;
	
	@Steps
	macroRecargaSteps stepsMacro;
	


	@Test
	public void testRecargaCuentas() {
		stepsMacro.iniciarSesion(getStrUser(), getStrPass());
		stepsMacro.recargaCuentas();
		stepsMacro.cerrarSesion();
	}

	@Test
	public void testRecargaTarjeta() {
		stepsMacro.iniciarSesion(getStrUser(), getStrPass());
		stepsMacro.recargaTarjeta();
		stepsMacro.cerrarSesion();
	}
	@Test
	public void testRecargaOtrosServicios() {
		stepsMacro.iniciarSesion(getStrUser(), getStrPass());
		stepsMacro.recargaOtroServicio();
		stepsMacro.cerrarSesion();

	}
	
	
	public String getStrUser() {
		return strUser;
	}

	public void setStrUser(String strUser) {
		this.strUser = strUser;
	}

	public String getStrPass() {
		return strPass;
	}

	public void setStrPass(String strPass) {
		this.strPass = strPass;
	}

	public String getStreRecarga() {
		return streRecarga;
	}

	public void setStreRecarga(String streRecarga) {
		this.streRecarga = streRecarga;
	}

	
}
