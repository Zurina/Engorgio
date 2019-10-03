/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Orchi
 */
import java.util.List;
 
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
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
        this.cars = cars;
    }
}
