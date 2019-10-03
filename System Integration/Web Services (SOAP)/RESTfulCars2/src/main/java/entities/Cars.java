package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.List;
 
@XmlRootElement(name = "cars")
@XmlAccessorType (XmlAccessType.FIELD)
public class Cars
{
    @XmlElement(name = "car")
    private List<Car> cars = null;
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setCars(List<Car> cars) {


    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
