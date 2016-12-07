/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author hussienalbared
 */
public abstract class FuzzySet {
    public String desc;
public Point[]position;
    public FuzzySet(int n) {
        position=new Point[n];
    }
  abstract public double Fuzzify(double x);
  abstract public Point calCenroid();
    
}
