package com.MacroQA.aplicativo.runnerSuite;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.MacroQA.aplicativo.pageObject.MacroMisTenenciasFCIPageObject;
import com.MacroQA.aplicativo.steps.macroInversionesMisTenenciasFCISteps;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;

@RunWith(SerenityParameterizedRunner.class)

@UseTestDataFrom("dataDriven/rescatar.csv")
public class MacroInversionesMisTenenciasRunnerSuite {
	
	private String strUser,strPass,strFondoComun, strTipoRescate, strCantidad, strCuentaCredito;
	
	@Managed
	MacroMisTenenciasFCIPageObject macroMisTenenciasFCI;
	
	@Steps
	macroInversionesMisTenenciasFCISteps misTenenciasFCI;
	
	@Test
	public void rescatarImporte() {
		misTenenciasFCI.iniciarSesion(getStrUser(), getStrPass());
		misTenenciasFCI.inversionesMisTenencias();
		misTenenciasFCI.seleccionarFondo(getStrFondoComun());
		misTenenciasFCI.procesoRescateFCI(getStrTipoRescate(), getStrCantidad(), getStrCuentaCredito());
	}
	
	

	public String getStrFondoComun() {
		return strFondoComun;
	}



	public void setStrFondoComun(String strFondoComun) {
		this.strFondoComun = strFondoComun;
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

	public String getStrTipoRescate() {
		return strTipoRescate;
	}

	public void setStrTipoRescate(String strTipoRescate) {
		this.strTipoRescate = strTipoRescate;
	}

	public String getStrCantidad() {
		return strCantidad;
	}

	public void setStrCantidad(String strCantidad) {
		this.strCantidad = strCantidad;
	}

	public String getStrCuentaCredito() {
		return strCuentaCredito;
	}

	public void setStrCuentaCredito(String strCuentaCredito) {
		this.strCuentaCredito = strCuentaCredito;
	}
	
	
	
	
}
