/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussienalbared
 */
public class Triangle extends FuzzySet{
 

    
   
 public Triangle(String d,double[]points) {
     
  super(3);
  this.desc=d;
     position[0]=new Point(points[0],0);
     position[1]=new Point(points[1],1);

    position[2]=new Point(points[2],0);

    }
   public double Fuzzify(double x)
    {
        for(int i=0;i<2;i++)
        {
           if(x>position[i].x&&x<position[i+1].x)
           {
               
               double slope=(position[i+1].y-position[i].y)/(position[i+1].x-position[i].x);
               double y=(x-position[i].x)*slope+position[i].y;
               return y;
           }
            
        }
        
        return 0.0;
    }

    @Override
    public Point calCenroid() {
       Point p=new Point(0.0, 0.0);
        for (int i = 0; i < 3; i++) {
            p.x+=position[i].x;
             p.y+=position[i].y; 
        }
        p.x/=3.0;
        p.y/=3.0;
        
       return p;
    }
}
