package com.coderwurst.dao;

import java.security.Timestamp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * xml returned from http://www.bcp-bonn.de/stellplatz/bcpinfo.xml
 */
@XmlRootElement(name="<parkhaus>")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parkhaus {

	@XmlElement(name="lfdnr")
	private int lfdnr;
	@XmlElement(name = "bezeichnung")
	private String bezeichnung;
	@XmlElement(name = "gesamt")
	private int gesamt;
	@XmlElement(name = "frei")
	private int frei;
	@XmlElement(name = "status")
	private int status;
	@XmlElement(name = "zeitstampel")
	private Timestamp zeitstampel;
	@XmlElement(name = "tendenz")
	private int tendenz;
	
	public void setLfdnr(int lfdnr) {
		this.lfdnr = lfdnr;
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public void setGesamt(int gesamt) {
		this.gesamt = gesamt;
	}
	
	public void setFrei(int frei) {
		this.frei = frei;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public void setTendenz(int tendenz) {
		this.tendenz = tendenz;
	}
	
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
	
	public int getTendenz() {
		return tendenz;
	}
}
