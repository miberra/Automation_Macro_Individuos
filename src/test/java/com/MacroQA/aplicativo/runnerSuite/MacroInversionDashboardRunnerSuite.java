package com.MacroQA.aplicativo.runnerSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.MacroQA.aplicativo.pageObject.MacroDashBoardInversionesPageObject;
import com.MacroQA.aplicativo.steps.macroInversionesDashboardSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("dataDriven/solicitudSuscripcion.csv")
public class MacroInversionDashboardRunnerSuite {
	private String strUser,strPass,strFondoComun;
	@Managed
	MacroDashBoardInversionesPageObject macroDashBoardInversiones;
	
	@Steps
	macroInversionesDashboardSteps inversionDashboardMacro;

	@Test
	public void verDetalle() {
		inversionDashboardMacro.iniciarSesion(getStrUser(), getStrPass());
		inversionDashboardMacro.verDetalle(getStrFondoComun());
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

	public String getStrFondoComun() {
		return strFondoComun;
	}

	public void setStrFondoComun(String strFondoComun) {
		this.strFondoComun = strFondoComun;
	}
	
	
	
}
