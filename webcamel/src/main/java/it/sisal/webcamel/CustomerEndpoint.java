package it.sisal.webcamel;

import javax.jws.WebService;

import org.apache.log4j.Logger;

@WebService
public interface CustomerEndpoint {
	String customer(String partName, int amount, String customerName);
}
