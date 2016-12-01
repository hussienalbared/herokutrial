/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussienalbared
 */
public class Variables {
    public FuzzySet[]shape;
    public String varName;
    public double value;

    public Variables(String v,int n,double vv) {
        value=vv;
        this.varName=v;
        shape=new FuzzySet[n];
        
    }
    public double Fuzzify(String s)
    {
        
        
        for(int i=0;i<shape.length;i++)
        {
          if(shape[i].desc.equals(s))
              return shape[i].Fuzzify(value);
            
        }
        return 0.0;
    }
            
    
}
