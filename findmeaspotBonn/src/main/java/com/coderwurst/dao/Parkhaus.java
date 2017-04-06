package com.coderwurst.dao;

import java.security.Timestamp;

/*
 * xml returned from http://www.bcp-bonn.de/stellplatz/bcpinfo.xml
 */

public class Parkhaus {

	private int lfdnr;
	private String bezeichnung;
	private int gesamt;
	private int frei;
	private int status;
	private Timestamp zeitstempel;
	private int tendenz;
	
	public int getLfdnr() {
		return lfdnr;
	}
	public String getBezeichnung() {
		return bezeichnung;
	}
	public int getGesamt() {
		return gesamt;
	}
	public int getFrei() {
		return frei;
	}
	public int getStatus() {
		return status;
	}
	public Timestamp getZeitstempel() {
		return zeitstempel;
	}
	public int getTendenz() {
		return tendenz;
	}
}
