package com.MacroQA.aplicativo.runnerSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.MacroQA.aplicativo.pageObject.macroInversionesPageObject;
import com.MacroQA.aplicativo.steps.macroInversionesNuestrosFondosSteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("dataDriven/solicitudSuscripcion.csv")
public class MacroSolicitudSuscribirFCIRunnerSuite {
	
	private String strUser,strPass;
	private String strFondoAInvertir, strImporte, strCuentaDebito,strFondoComun;

	@Managed
	macroInversionesPageObject invsMacro;
	
	@Steps
	macroInversionesNuestrosFondosSteps inMacro;
	
	@Test
	public void testSolicitudDeSuscripcionFCI() {
		inMacro.iniciarSesion(getStrUser(), getStrPass());
		inMacro.invertirEnNuestrosFondos(getStrFondoComun(),getStrFondoAInvertir(), getStrImporte(), getStrCuentaDebito());
	}

	
	
	public String getStrFondoComun() {
		return strFondoComun;
	}



	public void setStrFondoComun(String strFondoComun) {
		this.strFondoComun = strFondoComun;
	}



	public String getStrFondoAInvertir() {
		return strFondoAInvertir;
	}


	public void setStrFondoAInvertir(String strFondoAInvertir) {
		this.strFondoAInvertir = strFondoAInvertir;
	}


	public String getStrImporte() {
		return strImporte;
	}


	public void setStrImporte(String strImporte) {
		this.strImporte = strImporte;
	}


	public String getStrCuentaDebito() {
		return strCuentaDebito;
	}


	public void setStrCuentaDebito(String strCuentaDebito) {
		this.strCuentaDebito = strCuentaDebito;
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
