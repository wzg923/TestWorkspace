package com.client;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.0.3
 * 2015-06-09T15:16:24.328+08:00
 * Generated source version: 3.0.3
 * 
 */
@WebServiceClient(name = "TransAuthorityFromEDOCToGEMS", 
                  wsdlLocation = "TransAuthorityFromEDOCToGEMS.wsdl",
                  targetNamespace = "http://www.example.org/TransAuthorityFromEDOCToGEMS/") 
public class TransAuthorityFromEDOCToGEMS_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://www.example.org/TransAuthorityFromEDOCToGEMS/", "TransAuthorityFromEDOCToGEMS");
    public final static QName TransAuthorityFromEDOCToGEMSSOAP = new QName("http://www.example.org/TransAuthorityFromEDOCToGEMS/", "TransAuthorityFromEDOCToGEMSSOAP");
    static {
        URL url = TransAuthorityFromEDOCToGEMS_Service.class.getResource("TransAuthorityFromEDOCToGEMS.wsdl");
        if (url == null) {
            url = TransAuthorityFromEDOCToGEMS_Service.class.getClassLoader().getResource("TransAuthorityFromEDOCToGEMS.wsdl");
        } 
        if (url == null) {
            java.util.logging.Logger.getLogger(TransAuthorityFromEDOCToGEMS_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "TransAuthorityFromEDOCToGEMS.wsdl");
        }       
        WSDL_LOCATION = url;
    }

    public TransAuthorityFromEDOCToGEMS_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public TransAuthorityFromEDOCToGEMS_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TransAuthorityFromEDOCToGEMS_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransAuthorityFromEDOCToGEMS_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransAuthorityFromEDOCToGEMS_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public TransAuthorityFromEDOCToGEMS_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    

    /**
     *
     * @return
     *     returns TransAuthorityFromEDOCToGEMS
     */
    @WebEndpoint(name = "TransAuthorityFromEDOCToGEMSSOAP")
    public TransAuthorityFromEDOCToGEMS getTransAuthorityFromEDOCToGEMSSOAP() {
        return super.getPort(TransAuthorityFromEDOCToGEMSSOAP, TransAuthorityFromEDOCToGEMS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TransAuthorityFromEDOCToGEMS
     */
    @WebEndpoint(name = "TransAuthorityFromEDOCToGEMSSOAP")
    public TransAuthorityFromEDOCToGEMS getTransAuthorityFromEDOCToGEMSSOAP(WebServiceFeature... features) {
        return super.getPort(TransAuthorityFromEDOCToGEMSSOAP, TransAuthorityFromEDOCToGEMS.class, features);
    }

}
