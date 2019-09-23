package entities;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Cars")
public class Cars
{
    public List<Car> list;
    
    public Cars() {
    }
    
    public Cars(final List<Car> cars) {
        this.list = cars;
    }
    
    @XmlElement(name = "car")
    public List<Car> getCars() {
        return this.list;
    }
    
    public void setCars(final ArrayList<Car> cars) {
        this.list = cars;
    }
}