package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Car")
public class Car
{
    private int id;
    private String licensePlate;
    private CarType ct;
    
    public Car(final int id, final String licensePlate, final CarType ct) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.ct = ct;
    }

    public Car() {
    }
    
    @XmlElement
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    @XmlElement
    public String getLicensePlate() {
        return this.licensePlate;
    }
    
    public void setLicensePlate(final String licensePlate) {
        this.licensePlate = licensePlate;
    }
    
    @XmlElement
    public CarType getCt() {
        return this.ct;
    }
    
    public void setCt(final CarType ct) {
        this.ct = ct;
    }
}