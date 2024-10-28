
package com.stockearte_backend;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="catalogo" type="{http://stockearte-backend.com/}CatalogoType"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "catalogo"
})
@XmlRootElement(name = "getCatalogoByIdResponse")
public class GetCatalogoByIdResponse {

    @XmlElement(required = true)
    protected CatalogoType catalogo;

    /**
     * Gets the value of the catalogo property.
     * 
     * @return
     *     possible object is
     *     {@link CatalogoType }
     *     
     */
    public CatalogoType getCatalogo() {
        return catalogo;
    }

    /**
     * Sets the value of the catalogo property.
     * 
     * @param value
     *     allowed object is
     *     {@link CatalogoType }
     *     
     */
    public void setCatalogo(CatalogoType value) {
        this.catalogo = value;
    }

}
