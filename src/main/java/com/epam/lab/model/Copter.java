package com.epam.lab.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for copter complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="copter"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="distance" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="height" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "copter", propOrder = {
        "distance",
        "height"
})
public class Copter {

    protected int distance;
    protected int height;

    /**
     * Gets the value of the distance property.
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Sets the value of the distance property.
     */
    public void setDistance(int value) {
        this.distance = value;
    }

    /**
     * Gets the value of the height property.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     */
    public void setHeight(int value) {
        this.height = value;
    }

    @Override
    public String toString() {
        return "Copter{" +
                "distance=" + distance +
                ", height=" + height +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copter copter = (Copter) o;

        if (distance != copter.distance) return false;
        return height == copter.height;
    }

    @Override
    public int hashCode() {
        int result = distance;
        result = 31 * result + height;
        return result;
    }
}
