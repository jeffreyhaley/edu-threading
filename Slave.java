import java.util.Vector;
import java.io.*;

/**
 * <p>Title: Slave </p>
 *
 * <p>Description: This is a thread that adds two numbers from the front
 *                 of a public vector, removes them, and places the result
 *                 back on the vector.  </p>
 *
 * @author Jeffrey Haley
 * @version 1.0
 */

public class Slave extends Thread{

  private Vector v = new Vector();
  private Master m = new Master();

  public Slave(){}

  public Slave(Vector v, Master m) {
    this.v = v;
    this.m = m;
  }

  public void run(){
	int value1 = 0;
	int value2 = 0;

    //Check the input vector for values.  If there is not value at the first element
    //use a value of 0.
    try{
    	value1 = Integer.parseInt((String)v.remove(0));
    }
    catch(Exception e){}
	
	try{
	    value2 = Integer.parseInt((String)v.remove(0));
	}
	catch(Exception e){}

	//if a negative value is entered loop infinatly until inturrupt is set
	if(value1<0 || value2<0){
		while(m.killAllFlag!=1);
		m.threadCounter--;
		System.out.println("All Processes Killed\n Exiting Program....");
	}

	//Add the two input values and decrement the threadCounter
	else{
    	int result = value1+value2;
    	v.addElement(Integer.toString(result));
    	System.out.println("Slave: "+value1+" + "+value2+" = "+result);
    	m.threadCounter--;
	}
  }

}


