package ru.job4j.serialization;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "bus")
public class Bus {
    @XmlAttribute
    private  String brand;

    public Bus() {
    }

    public Bus(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Bus{"
                + "brand='" + brand + '\''
                + '}';
    }
}
