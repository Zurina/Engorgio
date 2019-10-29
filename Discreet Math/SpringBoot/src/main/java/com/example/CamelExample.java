/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author Orchi
 */
@Component
public class CamelExample extends RouteBuilder {

   @Override
   public void configure() throws Exception {
       from(url: "stream:in?promptMessage=Enter message:")
       .to("stream:out");
   }

}
