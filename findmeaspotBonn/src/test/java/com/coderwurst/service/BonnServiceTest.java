package com.coderwurst.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;

import org.junit.Test;

import com.coderwurst.dao.Parkhaeuser;
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
	public void testUnmarshalSingleXmlObject() {
		
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
	
	@Test
	public void testUnmarshalParkhaeuserList() {
		
		Parkhaeuser result = service.unmarshalParkhausList();
		List <Parkhaus> resultList = result.getParkhaeuser();
		
		assertNotNull(result);
		assertEquals(6, resultList.size());
		assertEquals("bahnhof.txt", resultList.get(0).getBezeichnung());
		assertEquals("beethoven.txt", resultList.get(1).getBezeichnung());
		assertEquals("friedensplatz.txt", resultList.get(2).getBezeichnung());
		assertEquals("markt.txt", resultList.get(3).getBezeichnung());
		assertEquals("muensterplatz.txt", resultList.get(4).getBezeichnung());
		assertEquals("stadthaus.txt", resultList.get(5).getBezeichnung());
	}
	
}
