package com.myspace.githook_1;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class POCController {
		
	@Autowired
	TestService	testServ;
	
	@GetMapping(value = "/executeRule")
	public void callRule() {
	
		/*
		ShipmentObjectInterface sdobject = new ShipmentObject();
		
		sdobject.setCountryCode("MX");
		sdobject.setCountryName("Mexico");
		sdobject.setCountryNotes("");
		

		
		testServ.getExecute(sdobject);
	*/
	}
	
	@PostMapping(value = "/executeRule2")
	public ResponseUtil callRule2(@RequestBody ShipmentRequest  sdo) throws IOException {
		return testServ.testExecute(sdo);
		
		
	}
	
	@PostMapping(value = "/executeRule3")
	public void callRule3(@RequestBody ShipmentRequest  sdo) throws IOException {
		 testServ.testExecute3(sdo);
		
		
	}

}
