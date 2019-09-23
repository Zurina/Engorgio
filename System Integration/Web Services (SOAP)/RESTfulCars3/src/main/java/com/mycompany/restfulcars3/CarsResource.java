/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfulcars3;

import javax.xml.bind.Marshaller;
import javax.xml.bind.JAXBException;
import java.io.Writer;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.InputSource;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import entities.CarType;
import entities.Car;
import entities.Cars;
import org.w3c.dom.Document;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;

@Path("cars")
public class CarsResource
{
    @Context
    private UriInfo context;

    public CarsResource() {
    }

    public CarsResource(UriInfo context) {
        this.context = context;
    }
    
    @GET
    @Produces({ "application/xml" })
    public Document getXml() {
        Car[] list = {
            new Car(1, "AB112233", new CarType("BigSean", 7, 100.0)),
            new Car(2, "AB444444", new CarType("Mediumi", 5, 75.0)),
            new Car(3, "AB666666", new CarType("Little shit", 2, 49.0))
        };
        
        Cars cars = new Cars(list);
        
        final String xmlString = jaxbObjectToXML(cars);
        System.out.println(xmlString);
        return convertStringToXMLDocument(xmlString);
    }
    
    @PUT
    @Consumes({ "application/xml" })
    public void putXml(final String content) {
    }
    
    private static Document convertStringToXMLDocument(final String xmlString) {
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            final Document doc = builder.parse(new InputSource(new StringReader(xmlString)));
            return doc;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private static String jaxbObjectToXML(Cars cars) {
        String xmlString = "";
        try {
            final JAXBContext context = JAXBContext.newInstance(Cars.class);
            final Marshaller m = context.createMarshaller();
            m.setProperty("jaxb.formatted.output", (Object)Boolean.TRUE);
            final StringWriter sw = new StringWriter();
            m.marshal((Object)cars, (Writer)sw);
            xmlString = sw.toString();
            System.out.println("XMLSTRING: " + xmlString);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlString;
    }
}