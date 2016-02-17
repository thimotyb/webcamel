package it.sisal.webcamel;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.cxf.binding.soap.SoapHeader;
import org.w3c.dom.Element;
 
 
public class CustomerProcessor {
 
    public void processData(
            @Header("org.apache.cxf.headers.Header.list") List<SoapHeader> soapHeaders,
            Exchange exchange) {       
 
        // Print SOAP Headers
        for (SoapHeader soapHeader : soapHeaders) {
            System.out.println(soapHeader.getName().getLocalPart() + "  : "
                             + ((Element)soapHeader.getObject()).getTextContent());
        }
 
    }
}
