/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hussienalbared
 */
public class Trapzoid extends FuzzySet{
    

    
    public Trapzoid(String d,double []points) {
        super(4);
     this.desc=d;
     
     position[0]=new Point(points[0],0);
     position[1]=new Point(points[1],1);

    position[2]=new Point(points[2],1);
    position[3]=new Point(points[3],0);

    }
    public double Fuzzify(double x)
    {
        for(int i=0;i<3;i++)
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
        double signedarea=0.0;
        for(int i=0;i<4;i++)
        {
            
           signedarea+= position[i].x*position[(i+1)%4].y-position[(i+1)%4].x*position[i].y;
            
        }
        signedarea/=2.0;
        Point p=new Point();
        p.x=0.0;
        p.y=0.0;
          for(int i=0;i<4;i++)
        {
           p.x+=(position[i].x+position[(i+1)%4].x)*(position[i].x*position[(i+1)%4].y-
                   position[(i+1)%4].x*position[i].y);
           p.y+=(position[i].y+position[(i+1)%4].y)*(position[i].x*position[(i+1)%4].y-
                   position[(i+1)%4].x*position[i].y);
        }
        
        p.y*=1.0/(6.0*signedarea);
          p.x*=1.0/(6.0*signedarea);
        return p;
    }
}
