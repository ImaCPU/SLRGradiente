/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slrgradiente;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class SLR extends Agent{
    HelperAritmetic HA = new HelperAritmetic();
    boolean I= HA.MeanSquared();
    double b0= HA.getB0();
    double b1= HA.getB1();
    
    public double predict(){
        float valor = Float.parseFloat(JOptionPane.showInputDialog("Ingresa El Valor a Predecir"));
        double predict = b0 + b1 * valor;
        return predict;
    }
    
    public void formula(){
        System.out.println(HA.formula());
        System.out.println("Error: "+String.format("%.7f",HA.getError()));
        
}
    
   @Override
   protected void setup (){
       System.out.println("Agent " + getLocalName() + " Started.");
       addBehaviour(new MyOneShotBehaviour());
   }
   
   public class MyOneShotBehaviour extends OneShotBehaviour{

    @Override
        public void action(){
            SLR slr = new SLR();
            
            slr.formula();
            System.out.println("Predicción: "+slr.predict());
            
        }//Fin public void action
    
        @Override
        public int onEnd(){
            
            myAgent.doDelete();
            return super.onEnd();
        }
        
    }
}