/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hussienalbared
 */
public class FuzzyLogic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       /* ArrayList<Double>a=new ArrayList<>();
         ArrayList<String>b=new ArrayList<>();
         a.add(25.0); a.add(30.0); a.add(20.0); a.add(100.0); a.add(20.0); 
         b.add("and"); b.add("or"); b.add("and"); b.add("or"); 
         test2(a, b);*/
       File f=new File("sample.txt");
        Scanner s=new Scanner(f);
        int varNo=s.nextInt();
        Variables[]vars=new Variables[varNo];
        String varname,fuzzydesc,fuzzytype;
        double value;
        double []points;
       int numberFuzzyset;
        for (int i = 0; i < varNo; i++) {
            varname=s.next();
            value=s.nextDouble();
            numberFuzzyset=s.nextInt();
              vars[i]=new Variables(varname,numberFuzzyset,value); 
            for (int j = 0; j < numberFuzzyset; j++) {
                fuzzydesc=s.next();
                fuzzytype=s.next();
                if(fuzzytype.equals("trapezoidal"))
                {
                    
                points=new double[4];
                for(int y=0;y<4;y++)
                {
                    points[y]=s.nextDouble();
                }
                vars[i].shape[j]=new Trapzoid(fuzzydesc, points);
                
            }
                else if(fuzzytype.equals("triangle"))
                {
                    points=new double[3];
                for(int y=0;y<3;y++)
                    points[y]=s.nextDouble();
                vars[i].shape[j]=new Triangle(fuzzydesc, points);
                    
                }
        }
      
        
      
        }
        
        varname=s.next();
        varNo=s.nextInt();
        Variables outvar=new Variables(varname, varNo, -1);
        for (int j = 0; j < varNo; j++) {
                fuzzydesc=s.next();
                fuzzytype=s.next();
                if(fuzzytype.equals("trapezoidal"))
                {
                    points=new double[4];
                for(int y=0;y<4;y++)
                    points[y]=s.nextDouble();
                outvar.shape[j]=new Trapzoid(fuzzydesc, points);
                
            }
                else if(fuzzytype.equals("triangle"))
                {
                    points=new double[3];
                for(int y=0;y<3;y++)
                    points[y]=s.nextDouble();
                   outvar.shape[j]=new Triangle(fuzzydesc, points);
                    
                }}

            
       
       
        int pNumber=s.nextInt();
        
        String[]pp=new String[pNumber];
        for(int i=0;i<pNumber;i++)
        {
            int yyy=s.nextInt();
            
            pp[i]=s.nextLine().trim();
            
            
            
        }
         Premises ps=new Premises( vars, pp, outvar);
         
        
        
    }
    public static void test2(ArrayList<Double> a1,ArrayList<String> a2)
    {
        
        while(a1.size()>1)
        {
            double d1=a1.get(0);
            double d2=a1.get(1);
            a1.remove(0);
               a1.remove(0);
            if(a2.get(0).equals("and"))
            {
                a1.add(0, Math.min(d2, d1));
                a2.remove(0);
                
            }
            else if(a2.get(0).equals("or"))
            {
                 a1.add(0, Math.max(d2, d1)); 
              a2.remove(0);  
            }
            
        }
        
        System.out.println(""+a1.get(0));
        
    }
    public static void test(String w)
    {int small;
        ArrayList<String> array=new ArrayList<>();
        ArrayList<String> array2=new ArrayList<>();
        while(w.indexOf(" and ")>=0||w.indexOf(" or ")>=0)
        {
            
            int a=w.indexOf(" and ");
            int o=w.indexOf(" or ");
            if(o>=0&&a>=0)
            {
                if(o<a)
                {
                    array2.add(w.substring(0,o));
                    w=w.substring(o+3);
                    
                    
                    array.add("or");
                }
                else
                {
                    array2.add(w.substring(0,a));
                    w=w.substring(a+4);
                    array.add("and");
                }
            }
            else if(a==-1)
            {   array2.add(w.substring(0,o));
            w=w.substring(o+3);
                array.add("or");
                
            }
            else if(o==-1)
            {
                array2.add(w.substring(0,a));
                 w=w.substring(a+4);
                array.add("and");
                
            }
            
            
        }
        for(String s:array)
        {
            
            System.out.print(" "+s);
        }
        for(String s:array2)
        {
            
            System.out.print(" "+s);
        }
    }
}
