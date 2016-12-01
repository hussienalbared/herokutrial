/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussienalbared
 */
public class Premises {
    public Premise[]total;
    public String[]textpremises;
    public Variables[]allshapes;
    public Variables varout;
    public Premises(Variables[]s,String[]t,Variables varout) 
    {
        this.varout=varout;
        this.textpremises=t;
        total=new Premise[t.length];
        for(int i=0;i<t.length;i++)
            total[i]=new Premise(t[i], s);
        this.allshapes=s;
        double sum=0.0,d=0.0;
        for(Premise nn:total)
        {
           // System.out.println(nn.fuzzysetname+""+nn.result);
            
            for(FuzzySet f:varout.shape)
            {
                if(f.desc.equals(nn.fuzzysetname))
                {
                    System.out.println(""+f.calCenroid().x);
                   sum+=nn.result*f.calCenroid().x;
                }
            }
            d+=nn.result;
            
            
        }
        sum/=d;
        System.out.println("final answer"+sum);  
    }
    
}
