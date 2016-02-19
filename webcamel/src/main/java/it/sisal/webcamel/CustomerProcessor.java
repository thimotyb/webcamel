package it.sisal.webcamel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.cxf.binding.soap.SoapHeader;
import org.w3c.dom.Element;
 
 
public class CustomerProcessor {
 
	static Integer counter = 0;
	
    public void processData(
            @Header("org.apache.cxf.headers.Header.list") List<SoapHeader> soapHeaders,
            Exchange exchange) {       
 
        // Print SOAP Headers
        for (SoapHeader soapHeader : soapHeaders) {
            System.out.println(soapHeader.getName().getLocalPart() + "  : "
                             + ((Element)soapHeader.getObject()).getTextContent());
        }
 
    }
    
    /**
     * Generates a new order structured as a {@link Map}
     */
    public Map<String, Object> insertCustomer(
    		@Header("org.apache.cxf.headers.Header.list") List<SoapHeader> soapHeaders,
            Exchange exchange) {      		
    	
    	// TODO: GET DATA FROM THE EXCHANGE
    	String desc = "";
    	String message = exchange.getIn().getBody(String.class);
    	
    	desc = substringBetween(message, "<arg0>", "</arg0>");
    	
        Map<String, Object> answer = new HashMap<String, Object>();
        answer.put("id", counter++);
        answer.put("description", desc);
        return answer;
    }
    
    public static String substringBetween(String str, String open, String close) {
        if (str == null || open == null || close == null) {
            return null;
        }
        int start = str.indexOf(open);
        if (start != -1) {
            int end = str.indexOf(close, start + open.length());
            if (end != -1) {
                return str.substring(start + open.length(), end);
            }
        }
        return null;
    }
}
