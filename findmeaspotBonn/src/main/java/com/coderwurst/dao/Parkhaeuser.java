package com.coderwurst.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="parkhaeuser")
public class Parkhaeuser {
	
	@XmlElement(name="parkhaus")
	private List<Parkhaus> parkhaeuser;

	public List<Parkhaus> getParkhaeuser() {
		if (this.parkhaeuser == null) {
			this.parkhaeuser = new ArrayList<Parkhaus>();
		}
		return parkhaeuser;
	}

	public void setParkhaeuser(List<Parkhaus> parkhaeuser) {
		this.parkhaeuser = parkhaeuser;
	}

}
