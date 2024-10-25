
package com.unla.stockearte.soap;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * SOAP Service for managing Purchase Orders.
 * 
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PurchaseOrderSoapService", targetNamespace = "http://stockearte-backend.com/", wsdlLocation = "file:/C:/Users/rricciardulli/Desktop/Personal/UNLa/4to/Distribuidos/stockearte-backend/src/main/resources/PurchaseOrderSoapService.wsdl")
public class PurchaseOrderSoapService
    extends Service
{

    private final static URL PURCHASEORDERSOAPSERVICE_WSDL_LOCATION;
    private final static WebServiceException PURCHASEORDERSOAPSERVICE_EXCEPTION;
    private final static QName PURCHASEORDERSOAPSERVICE_QNAME = new QName("http://stockearte-backend.com/", "PurchaseOrderSoapService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/rricciardulli/Desktop/Personal/UNLa/4to/Distribuidos/stockearte-backend/src/main/resources/PurchaseOrderSoapService.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PURCHASEORDERSOAPSERVICE_WSDL_LOCATION = url;
        PURCHASEORDERSOAPSERVICE_EXCEPTION = e;
    }

    public PurchaseOrderSoapService() {
        super(__getWsdlLocation(), PURCHASEORDERSOAPSERVICE_QNAME);
    }

    public PurchaseOrderSoapService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PURCHASEORDERSOAPSERVICE_QNAME, features);
    }

    public PurchaseOrderSoapService(URL wsdlLocation) {
        super(wsdlLocation, PURCHASEORDERSOAPSERVICE_QNAME);
    }

    public PurchaseOrderSoapService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PURCHASEORDERSOAPSERVICE_QNAME, features);
    }

    public PurchaseOrderSoapService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PurchaseOrderSoapService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PurchaseOrderPortType
     */
    @WebEndpoint(name = "PurchaseOrderPort")
    public PurchaseOrderPortType getPurchaseOrderPort() {
        return super.getPort(new QName("http://stockearte-backend.com/", "PurchaseOrderPort"), PurchaseOrderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PurchaseOrderPortType
     */
    @WebEndpoint(name = "PurchaseOrderPort")
    public PurchaseOrderPortType getPurchaseOrderPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://stockearte-backend.com/", "PurchaseOrderPort"), PurchaseOrderPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PURCHASEORDERSOAPSERVICE_EXCEPTION!= null) {
            throw PURCHASEORDERSOAPSERVICE_EXCEPTION;
        }
        return PURCHASEORDERSOAPSERVICE_WSDL_LOCATION;
    }

}