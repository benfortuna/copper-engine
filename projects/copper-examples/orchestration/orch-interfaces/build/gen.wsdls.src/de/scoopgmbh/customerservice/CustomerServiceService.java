package de.scoopgmbh.customerservice;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.6.0
 * 2013-04-08T12:41:16.326+02:00
 * Generated source version: 2.6.0
 * 
 */
@WebServiceClient(name = "CustomerServiceService", 
                  wsdlLocation = "classpath:wsdl/CustomerService.wsdl",
                  targetNamespace = "http://customerservice.scoopgmbh.de/") 
public class CustomerServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://customerservice.scoopgmbh.de/", "CustomerServiceService");
    public final static QName CustomerServicePort = new QName("http://customerservice.scoopgmbh.de/", "CustomerServicePort");
    static {
        URL url = CustomerServiceService.class.getClassLoader().getResource("wsdl/CustomerService.wsdl");
        if (url == null) {
            java.util.logging.Logger.getLogger(CustomerServiceService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "classpath:wsdl/CustomerService.wsdl");
        }       
        WSDL_LOCATION = url;   
    }

    public CustomerServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CustomerServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CustomerServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public CustomerServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServicePort")
    public CustomerService getCustomerServicePort() {
        return super.getPort(CustomerServicePort, CustomerService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CustomerService
     */
    @WebEndpoint(name = "CustomerServicePort")
    public CustomerService getCustomerServicePort(WebServiceFeature... features) {
        return super.getPort(CustomerServicePort, CustomerService.class, features);
    }

}