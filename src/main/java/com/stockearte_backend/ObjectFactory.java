
package com.stockearte_backend;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.stockearte_backend package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.stockearte_backend
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFiltersRequest }
     * 
     */
    public GetFiltersRequest createGetFiltersRequest() {
        return new GetFiltersRequest();
    }

    /**
     * Create an instance of {@link CreateFiltersModelRequest }
     * 
     */
    public CreateFiltersModelRequest createCreateFiltersModelRequest() {
        return new CreateFiltersModelRequest();
    }

    /**
     * Create an instance of {@link DeleteFiltersModelRequest }
     * 
     */
    public DeleteFiltersModelRequest createDeleteFiltersModelRequest() {
        return new DeleteFiltersModelRequest();
    }

    /**
     * Create an instance of {@link CreateFiltersModelResponse }
     * 
     */
    public CreateFiltersModelResponse createCreateFiltersModelResponse() {
        return new CreateFiltersModelResponse();
    }

    /**
     * Create an instance of {@link UpdateFiltersModelRequest }
     * 
     */
    public UpdateFiltersModelRequest createUpdateFiltersModelRequest() {
        return new UpdateFiltersModelRequest();
    }

    /**
     * Create an instance of {@link DeleteFiltersModelResponse }
     * 
     */
    public DeleteFiltersModelResponse createDeleteFiltersModelResponse() {
        return new DeleteFiltersModelResponse();
    }

    /**
     * Create an instance of {@link UpdateFiltersModelResponse }
     * 
     */
    public UpdateFiltersModelResponse createUpdateFiltersModelResponse() {
        return new UpdateFiltersModelResponse();
    }

    /**
     * Create an instance of {@link GetFiltersResponse }
     * 
     */
    public GetFiltersResponse createGetFiltersResponse() {
        return new GetFiltersResponse();
    }

    /**
     * Create an instance of {@link FilterType }
     * 
     */
    public FilterType createFilterType() {
        return new FilterType();
    }

}
