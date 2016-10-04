
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
 *         &lt;element name="MatchInDictResult" type="{http://services.aonaware.com/webservices/}ArrayOfDictionaryWord" minOccurs="0"/>
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
    "matchInDictResult"
})
@XmlRootElement(name = "MatchInDictResponse")
public class MatchInDictResponse {

    @XmlElement(name = "MatchInDictResult")
    protected ArrayOfDictionaryWord matchInDictResult;

    /**
     * Gets the value of the matchInDictResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfDictionaryWord }
     *     
     */
    public ArrayOfDictionaryWord getMatchInDictResult() {
        return matchInDictResult;
    }

    /**
     * Sets the value of the matchInDictResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfDictionaryWord }
     *     
     */
    public void setMatchInDictResult(ArrayOfDictionaryWord value) {
        this.matchInDictResult = value;
    }

}
