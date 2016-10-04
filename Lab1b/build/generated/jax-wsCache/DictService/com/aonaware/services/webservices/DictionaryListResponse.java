
package com.aonaware.services.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DictionaryListResult" type="{http://services.aonaware.com/webservices/}ArrayOfDictionary" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dictionaryListResult"
})
@XmlRootElement(name = "DictionaryListResponse")
public class DictionaryListResponse {

    @XmlElement(name = "DictionaryListResult")
    protected ArrayOfDictionary dictionaryListResult;

    /**
     * Gets the value of the dictionaryListResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDictionary }
     *     
     */
    public ArrayOfDictionary getDictionaryListResult() {
        return dictionaryListResult;
    }

    /**
     * Sets the value of the dictionaryListResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDictionary }
     *     
     */
    public void setDictionaryListResult(ArrayOfDictionary value) {
        this.dictionaryListResult = value;
    }

}
