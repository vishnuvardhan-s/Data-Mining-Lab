/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myweka;

/**
 *
 * @author Rag
 */
import java.io.BufferedReader;
import java.io.FileReader;

import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.core.Instances;

public class MyMLP {
	public static void main(String args[])
        {
            try {
                Instances data = new Instances(new BufferedReader(new FileReader("C:\\Program Files\\Weka-3-8-4\\data\\diabetes.arff")));
                data.setClassIndex(8);
                int trainSize = (int) Math.round(data.numInstances() * 0.8);
                int testSize = data.numInstances() - trainSize;
                Instances train = new Instances(data, 0, trainSize);
                Instances test = new Instances(data, trainSize, testSize);
                MultilayerPerceptron mlp=new MultilayerPerceptron();
                mlp.buildClassifier(train);
                Evaluation eval = new Evaluation(test);
                eval.evaluateModel(mlp,test);
                System.out.println(eval.toSummaryString());
            } 
            catch (Exception e) {
                    System.out.println(e);
            } 
	}
}
