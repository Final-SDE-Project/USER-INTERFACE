
package ehealth.controller_pc.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PcService", targetNamespace = "http://ws.controller_pc.ehealth/", wsdlLocation = "https://sde-pc.herokuapp.com/ws/pc?wsdl")
public class PcService
    extends Service
{

    private final static URL PCSERVICE_WSDL_LOCATION;
    private final static WebServiceException PCSERVICE_EXCEPTION;
    private final static QName PCSERVICE_QNAME = new QName("http://ws.controller_pc.ehealth/", "PcService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("https://sde-pc.herokuapp.com/ws/pc?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PCSERVICE_WSDL_LOCATION = url;
        PCSERVICE_EXCEPTION = e;
    }

    public PcService() {
        super(__getWsdlLocation(), PCSERVICE_QNAME);
    }

    public PcService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PCSERVICE_QNAME, features);
    }

    public PcService(URL wsdlLocation) {
        super(wsdlLocation, PCSERVICE_QNAME);
    }

    public PcService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PCSERVICE_QNAME, features);
    }

    public PcService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PcService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ServicePc
     */
    @WebEndpoint(name = "ServicePcImplPort")
    public ServicePc getServicePcImplPort() {
        return super.getPort(new QName("http://ws.controller_pc.ehealth/", "ServicePcImplPort"), ServicePc.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ServicePc
     */
    @WebEndpoint(name = "ServicePcImplPort")
    public ServicePc getServicePcImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.controller_pc.ehealth/", "ServicePcImplPort"), ServicePc.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PCSERVICE_EXCEPTION!= null) {
            throw PCSERVICE_EXCEPTION;
        }
        return PCSERVICE_WSDL_LOCATION;
    }

}
