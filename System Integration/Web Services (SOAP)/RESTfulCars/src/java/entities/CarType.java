package entities;

import javax.xml.bind.annotation.XmlElement;

public class CarType
{
    private String name;
    private int numberOfSeats;
    private double price;
    
    public CarType(final String name, final int numberOfSeats, final double price) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        this.price = price;
    }
    
    @XmlElement
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    @XmlElement
    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }
    
    public void setNumberOfSeats(final int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    
    @XmlElement
    public double getPrice() {
        return this.price;
    }
    
    public void setPrice(final double price) {
        this.price = price;
    }
}