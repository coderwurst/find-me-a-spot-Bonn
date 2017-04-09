package com.coderwurst.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.coderwurst.dao.Parkhaus;

public class BonnServiceTest {

	BonnService service = new BonnService();
	
	@Test
	public void testGetParkhausInformation() {
		
		String result = service.getParkhausInformation();
		
		assertNotNull(result);
		System.out.println(result);
	}
	
	@Test
	public void testGetSingleXmlObject() {
		
		String parkHausTestString = "<parkhaus>"
				+ "<lfdnr>6</lfdnr>"
				+ "<bezeichnung>stadthaus.txt</bezeichnung>"
				+ "<gesamt>320</gesamt>"
				+ "<frei>135</frei>"
				+ "<status>0</status>"
				+ "<zeitstempel>09.04.2017 11:40</zeitstempel>"
				+ "<tendenz>1</tendenz>"
				+ "</parkhaus>";
		
		Parkhaus result = service.unmarschalParkhausObject(parkHausTestString);
		
		assertNotNull(result);
		assertEquals(6, result.getLfdnr());
		assertEquals("stadthaus.txt", result.getBezeichnung());
		assertEquals(320, result.getGesamt());
		assertEquals(135, result.getFrei());
		assertEquals(0, result.getStatus());
		assertEquals(1, result.getTendenz());
	}
	
}
