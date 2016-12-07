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
        this.allshapes=s;
        total=new Premise[t.length];
        fuzzifification();
       System.out.println("Inference rules:");
        for(int i=0;i<t.length;i++)
        {total[i]=new Premise(t[i], s);
            System.out.println("Premise "+i+"= "+total[i].result+" "+total[i].fuzzysetname);
        }
        
        double sum=0.0,d=0.0;
        
        for(Premise nn:total)
        {
           // System.out.println(nn.fuzzysetname+""+nn.result);
            
            for(FuzzySet f:varout.shape)
            {
                if(f.desc.equals(nn.fuzzysetname))
                {
                   // System.out.println(""+f.calCenroid().x);
                   sum+=nn.result*f.calCenroid().x;
                }
            }
            d+=nn.result;
            
            
        }
        sum/=d;
        System.out.println("final answer"+sum);  
    }
    public void InferenceRule()
    {
        
        
        
        
    }
    public void fuzzifification()
    {
        
        for(Variables x:allshapes)
        {System.out.println("Variable:"+x.varName+":"+x.value);
            for(FuzzySet ss:x.shape)
            {
                System.out.println("Membership:"+x.value+"In "+ss.desc+"="+ss.Fuzzify(x.value));
                
                
            }
            
            System.out.println("************");
        }
        
    }
    
}
