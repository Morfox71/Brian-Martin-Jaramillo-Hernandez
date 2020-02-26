package com;

import java.util.ArrayList;

public class Usuarios {
	private String NumeroTarjeta;
	private String Nip;
	private String saldo;
	private String tipoTarjeta;

	public String getNumeroTarjeta() {
		return NumeroTarjeta;
	}

	public String getNip() {
		return Nip;
	}

	public String getSaldo() {
		return saldo;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		NumeroTarjeta = numeroTarjeta;
	}

	public void setNip(String nip) {
		Nip = nip;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder ();

		sb.append ("\nNumeroTarjeta");
		sb.append (NumeroTarjeta);
		sb.append ("\nNip");
		sb.append (Nip);
		sb.append ("\nSaldo");
		sb.append (saldo);
		sb.append ("\nTipoTarjeta");
		sb.append (tipoTarjeta);
		return sb.toString ();
	}
}
