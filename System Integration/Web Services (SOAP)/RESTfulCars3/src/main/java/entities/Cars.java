/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 *
 * @author Orchi
 */
@XmlRootElement
public class Cars implements Serializable{

    Car[] cars;

    public Cars(Car[] cars) {
        this.cars = cars;
    }

    public Cars() {
    }
    
    @XmlElement
    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
