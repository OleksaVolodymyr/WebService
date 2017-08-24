
package com.epam.lab.webmodel;

import com.epam.lab.model.Copter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for response complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="response"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element ref="{http://service.lab.epam.com/}Copter"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "response", propOrder = {
    "message",
    "copter"
})
public class Response {

    protected String message;
    @XmlElement(name = "Copter", namespace = "http://service.lab.epam.com/", required = true)
    protected Copter copter;

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

    /**
     * Gets the value of the copter property.
     * 
     * @return
     *     possible object is
     *     {@link Copter }
     *     
     */
    public Copter getCopter() {
        return copter;
    }

    /**
     * Sets the value of the copter property.
     * 
     * @param value
     *     allowed object is
     *     {@link Copter }
     *     
     */
    public void setCopter(Copter value) {
        this.copter = value;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", copter=" + copter +
                '}';
    }
}
