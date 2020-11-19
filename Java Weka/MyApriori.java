/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myweka;
import weka.associations.*;
import weka.core.Instances;
import java.io.*;

/**
 *
 * @author Rag
**/

public class MyApriori {
	public static void main(String args[]) {
            try {
                Instances data = new Instances(new BufferedReader(new FileReader ("C:\\Users\\Dell\\Desktop\\file.arff"))); 
                Apriori model = new Apriori();
                model.setMinMetric(0.8);
                model.setLowerBoundMinSupport(0.2);
                model.buildAssociations(data);
                System.out.println(model);
            }
            catch(Exception e) {
                System.out.println("Some error occurred!");
            }		
	}
}