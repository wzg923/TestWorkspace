
package com.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAuthResponse }
     * 
     */
    public GetAuthResponse createGetAuthResponse() {
        return new GetAuthResponse();
    }

    /**
     * Create an instance of {@link GetAuth }
     * 
     */
    public GetAuth createGetAuth() {
        return new GetAuth();
    }

    /**
     * Create an instance of {@link InType }
     * 
     */
    public InType createInType() {
        return new InType();
    }

    /**
     * Create an instance of {@link UpdateImageStatusResponse }
     * 
     */
    public UpdateImageStatusResponse createUpdateImageStatusResponse() {
        return new UpdateImageStatusResponse();
    }

    /**
     * Create an instance of {@link UpdateImageStatus }
     * 
     */
    public UpdateImageStatus createUpdateImageStatus() {
        return new UpdateImageStatus();
    }

    /**
     * Create an instance of {@link InputType }
     * 
     */
    public InputType createInputType() {
        return new InputType();
    }

}
