package com.coderwurst.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class BonnServiceTest {

	BonnService service = new BonnService();
	
	@Test
	public void getParkhausInformation() {
		
		String result = service.getParkhausInformation();
		
		assertNotNull(result);
		System.out.println(result);
	}
	
}
