
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussienalbared
 * @version 1
 */
public class Premise {
       public Variables[]allshapes;
       public double result;
       public String fuzzysetname;
        ArrayList<String> array=new ArrayList<>();
        ArrayList<String> array2=new ArrayList<>();
        ArrayList<Double>array3=new ArrayList<>();
    public Premise(String p,Variables[]s) {
        this.allshapes=s;
        int index=p.indexOf("outputVar");
        String output=p.substring(index);
        String[]temp=output.trim().split("=");
        fuzzysetname=temp[1].trim();
        
        String input=p.substring(0,index).trim();
       
        test(input);
        
        
        
    }
    
    
     public  void test2()
    {
        
        while(array3.size()>1)
        {
            double d1=array3.get(0);
            double d2=array3.get(1);
            array3.remove(0);
               array3.remove(0);
            if(array.get(0).equals("AND"))
            {
                array3.add(0, Math.min(d2, d1));
                array.remove(0);
                
            }
            else if(array.get(0).equals("OR"))
            {
                 array3.add(0, Math.max(d2, d1)); 
              array.remove(0);  
            }
            
        }
        
        result=array3.get(0);
        
    }
    
    public  void test(String w)
    {
        
       
        while(w.indexOf(" AND ")>=0||w.indexOf(" OR ")>=0)
        {
            
            int a=w.indexOf(" AND ");
            int o=w.indexOf(" OR ");
          //  System.out.println("index of a:"+a+"index of or:"+o);
            if(o>=0&&a>=0)
            {
                if(o<a)
                {
                    array2.add(w.substring(0,o));
                    w=w.substring(o+3);
                    
                    
                    array.add("OR");
                }
                else
                {
                    array2.add(w.substring(0,a));
                    w=w.substring(a+4);
                    array.add("AND");
                }
            }
            else if(a==-1)
            {   array2.add(w.substring(0,o));
            w=w.substring(o+3);
                array.add("OR");
                
            }
            else if(o==-1)
            {
                array2.add(w.substring(0,a));
                 w=w.substring(a+4);
                array.add("AND");
                
            }
            
            
        }
        array2.add(w.trim());
        for(String s:array2)
        {
         String[]t=s.split("=");
         for(Variables q:allshapes)
         {
             if(t[0].trim().equals(q.varName))
             {
                 
                 array3.add(q.Fuzzify(t[1].trim()));
             }
             
             
             
         }
         
        }
       // System.out.println("********/*/*");
      
        /*for(String ww:array)
        {
            
            System.out.println(""+ww);
        }
        for(String hh:array2)
        {
            System.out.println(""+hh);
            
        }
        System.out.println("&&&&&&&&");
               */
    test2();
    } 
}

