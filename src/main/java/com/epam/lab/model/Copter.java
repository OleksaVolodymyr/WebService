package com.epam.lab.model;


import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "copter")
public class Copter implements Serializable {
    private int height;
    private int distance;

    public Copter() {
        this.height = 0;
        this.distance = 0;

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Copter{" +
                "height=" + height +
                ", distance=" + distance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Copter copter = (Copter) o;

        if (height != copter.height) return false;
        return distance == copter.distance;
    }

    @Override
    public int hashCode() {
        int result = height;
        result = 31 * result + distance;
        return result;
    }
}
