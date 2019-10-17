/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staticanalysis;

import java.io.File;

/**
 *
 * @author Orchi
 */
public class Main {

    public static void main(String[] args) {

        String filePath = new File("").getAbsolutePath();
        String sep = File.separator;
        filePath += sep + "src" + sep + "staticanalysis" + sep + "vssl.txt";
        String vssl = ReadVSSLFile.readFile(filePath);
        System.out.println(vssl);
        StaticAnalysis sa = new StaticAnalysis(vssl);
    }

}
