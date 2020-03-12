package com.MacroQA.aplicativo.runnerSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.MacroQA.aplicativo.pageObject.macroInversionesPageObject;
import com.MacroQA.aplicativo.steps.macroInversionesSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("dataDriven/recarga.csv")
public class MacroInversionesRunnerSuite {
	
	private String strUser;
	private String strPass;
	
	@Managed
	macroInversionesPageObject inversionMacro;
	
	@Steps
	macroInversionesSteps inversionSteps;
	
	@Test
	public void testConstitucionPlazosFijos() {
		inversionSteps.iniciarSesion(getStrUser(), getStrPass());
		inversionSteps.constitucionPlazoFijo();
		inversionSteps.cerrarSesion();
	}
	
	@Test
	public void testConsultaTasasFijas() {
		inversionSteps.iniciarSesion(getStrUser(), getStrPass());
		inversionSteps.consultasTasasFijas();
		inversionSteps.cerrarSesion();
	}
	@Test
	public void testCompraVentaDolares() {
		inversionSteps.iniciarSesion(getStrUser(), getStrPass());
		inversionSteps.compraVentaDolares();
		inversionSteps.cerrarSesion();
	}
	@Test
	public void testNuestroFondosFCI() {
		inversionSteps.iniciarSesion(getStrUser(), getStrPass());
		inversionSteps.nuestroFondosFCI();
		inversionSteps.cerrarSesion();
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
	
	
}
