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
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JFrame;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.gui.treevisualizer.PlaceNode2;
import weka.gui.treevisualizer.TreeVisualizer;

public class MyDecisionTree {
	public static void main(String args[])
	{
            try {
                Instances data = new Instances(new BufferedReader(new FileReader("C:\\Program Files\\Weka-3-8-4\\data\\diabetes.arff")));
                data.setClassIndex(8);
                int trainSize = (int) Math.round(data.numInstances() * 0.8);
                int testSize = data.numInstances() - trainSize;
                Instances train = new Instances(data, 0, trainSize);
                Instances test = new Instances(data, trainSize, testSize);
                J48 dt=new J48();
                dt.buildClassifier(train);
                TreeVisualizer tv = new TreeVisualizer(null,dt.graph(),new PlaceNode2());
                JFrame frame=new JFrame("Decision Tree");
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                frame.getContentPane().setLayout(new BorderLayout());
                frame.getContentPane().add(tv, BorderLayout.CENTER);
                frame.setVisible(true);
                Evaluation eval = new Evaluation(test);
                eval.evaluateModel(dt,test);
                System.out.println(eval.toSummaryString());
            } 
            catch (Exception e) {
                System.out.println(e);
            } 
	}
}


