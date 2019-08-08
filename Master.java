import java.util.*;
import java.math.*;
import java.io.*;

/**
 * <p>Title: Master</p>
 *
 * <p>Description: Master program that takes in any number of command line
                  numbers.  For every pair of numbers a pair of slave threads
                  is spawned.  A global thread counter and kill all variable is
                  used to control the threads.  Since a thread uses the same
                  memory as its master process they will be able to minipulate
                  the global variables.</p>
 * <p>Sample Input: 10 12 1 2 5 8 3 5 8 </p>
 *
 * @author Jeffrey S. Haley
 * @version 1.0
 */

public class Master {

  public int threadCounter;
  public int killAllFlag;

  public Master() {
  }

  public static void main(String[] args) {
    int i = 0;
	int length = args.length;
	int size;
	
    Master m = new Master();
    Vector v = new Vector(length);

    while(i<length){
      v.addElement((String)args[i]);
      i++;
    }

    //Initializations
    size = v.size(); 
	i = 0; 
	m.threadCounter = 0; 
	m.killAllFlag = 0;
	
	//While the vector of numbers to add has more than one number, and the killAllFlag has not been set
	//continue to span threads for adding.
    while(size>1 && m.killAllFlag!=1){

   	  //Start a group of threads
	  //For every pair of numbers create a new thread to add the pair
   	  System.out.println("Grouping");
      while(i<=Math.ceil((size-1)/2)){
		m.threadCounter++;
		new Slave(v,m).start();
        i++;
      }
	  
      //Start Timer from when the last set of processes has started
      Timer t = new Timer();

      //Loop until all the process have complete or the timer has expired
      while(m.threadCounter>0 && t.getTime()<2000);

      //If the timer is over 2 seconds set the timeout interrupt flag and
      //kill all the running threads
      if(t.getTime()>2000){
		  m.killAllFlag = 1;
	  }

      //re-initialize looping variables
      size = size/2;
	  i = 0;
	  m.threadCounter = 0;
    }

	//Print the total if processes have not timed out.
    if(m.killAllFlag!=1)
      System.out.println("Total: "+v.firstElement());
  }
}

