/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package slrgradiente;

/**
 *
 * @author PC
 */
public class DataSet {
    private int [] x = {23,26,30,34,43,48,52,57,58};
    private int [] y = {651,762,856,1063,1190,1298,1421,1440,1518};
    public int contador=0;
    
    public DataSet (){}
    
    public void tamaño(int n ){
        this.x= new int[n];
        this.y= new int [n];
    }
    
    public void setVal(int xn, int yn){
            x[contador]=xn;
            y[contador]=yn;
            contador++;
    }
    public int[] getMatrizX(){
            
            return x;
            
    }//Fin public int[] getMatrizx
        
    public int[] getMatrizY(){        
        return y;
    }//Fin public int[] getMatrizy

    
}
