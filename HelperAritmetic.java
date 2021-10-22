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
public class HelperAritmetic {
    
    String formula;
    DataSet tabla= new DataSet();
    double B0,B1;
    double a= 0.0003;
    double error;
    
    
    
    public int SumaX(){
       int suma=0;
       for (int i=0;i<=tabla.getMatrizX().length-1;i++){
           suma= tabla.getMatrizX()[i]+suma;
       }
       return suma;
   } 
   
   public int SumaY(){
       int suma=0;
       for (int i=0;i<=tabla.getMatrizY().length-1;i++){
           suma= tabla.getMatrizY()[i]+suma;
       }
       return suma;
   } 
    
   public int SumaXY(){
       int suma=0;
       for (int i=0;i<=tabla.getMatrizX().length-1;i++){
           suma= (tabla.getMatrizX()[i]*tabla.getMatrizY()[i])+suma;
       }
       return suma;
   }
   
   public int SumaXX(){
       int suma=0;
       for (int i=0;i<=tabla.getMatrizX().length-1;i++){
           suma= tabla.getMatrizX()[i]*tabla.getMatrizX()[i]+suma;
       }
       return suma;
   }
   
   public double B1(){
       double b1= ( ((tabla.getMatrizX().length)*this.SumaXY())-(this.SumaX()*this.SumaY()) )/
               ( ((tabla.getMatrizX().length)*this.SumaXX())-(this.SumaX()*this.SumaX()) );
       B1=b1;
       return b1;
   }
   
   public double B0(){
       double b0= ( (this.SumaXX()*this.SumaY())-(this.SumaX()*this.SumaXY()) )
               / ( (tabla.getMatrizX().length*this.SumaXX())-(this.SumaX()*this.SumaX()) );
       B0=b0;
       return b0;
       }
   
   public String formula (){
        formula = ("Regresion Lineal Simple: y="+B0+"-"+B1+"x");
        return formula;
    }
   
   public double gradieteB0(double B0,double B1){
       //calculo del error
       double beta0 = 0;
       int x[]= tabla.getMatrizX();
       int y[]= tabla.getMatrizY();
       int n= x.length;
       
       for (int i=0; i<= n-1; i++){
            beta0 =+ (y[i]- (B0+B1*x[i]));
       }
       beta0= -2*beta0 /n;
       return beta0;
   }
   
   public double gradieteB1(double B0,double B1){
       //calculo del error
       double beta1 = 0;
       int x[]= tabla.getMatrizX();
       int y[]= tabla.getMatrizY();
       int n= x.length;
       
       for (int i=0; i<= n-1; i++){
            beta1=+ x[1]*(y[i]- (B0+B1*x[i]));
       }
       beta1= -2*beta1 /n;
       return beta1;
   }
   
   public double Error(double B0,double B1){
       //calculo del error
       double err = 0;
       int x[]= tabla.getMatrizX();
       int y[]= tabla.getMatrizY();
       int n= x.length;
       
       for (int i=0; i<= n-1; i++){
            err = (y[i]- (B0+B1*x[i]));
       }
       err= 1*err /n;
       return err;
   }
   
   
   public boolean MeanSquared(){
       //calculo del error
       double oB0= this.B0();
       double oB1= this.B1();
       double err= this.Error(oB0, oB1);
       
       double beta0, beta1;

       while(err > a){
        beta0= this.gradieteB0(oB0, oB1);
        beta1= this.gradieteB1(oB0, oB1);
        
        oB0= oB0 - beta0*a;
        oB1= oB1 - beta1*a;
        
        err= this.Error(oB0, oB1);
       }
       B0=oB0;
       B1=oB1;
       error=err;
       return true;
   }
   
   public double getB0(){
       return B0;
   }
   
   public double getB1(){
       return B1;
   }
   
   public double getError(){
       return error;
   }
   
}
