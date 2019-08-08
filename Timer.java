import java.util.Date;



/**
 * Class for program event timing.
 * Usage:
 *
 *   <pre>
 *   Timer timer = new Timer();
 *
 *   // do stuff
 *
 *   System.out.println (timer);  // prints time elapsed since
 *                                // object was created.
 *   </pre>
 *
 */
public class Timer
{
  private Date  start_;



  /**
   * Start timer.
   */
  public Timer()
  {
    reset();
  }



  /**
   * Returns exact number of milliseconds since timer was started.
   *
   * @return  Number of milliseconds since timer was started.
   */
  public long getTime()
  {
    Date now = new Date();
    long nMillis = now.getTime() - start_.getTime();

    return nMillis;
  }



  /**
   * Restarts the timer.
   */
  public void reset()
  {
    start_ = new Date();  // now
  }



  /**
   * Returns a formatted string showing the elaspsed time
   * suince the instance was created.
   *
   * @return  Formatted time string.
   */
  public String toString()
  {
    long nMillis = getTime();

    long nHours   = nMillis / 1000 / 60 / 60;
    nMillis -= nHours * 1000 * 60 * 60;

    long nMinutes = nMillis / 1000 / 60;
    nMillis -= nMinutes * 1000  * 60;

    long nSeconds = nMillis / 1000;
    nMillis -= nSeconds * 1000;

    StringBuffer time = new StringBuffer();
    if (nHours > 0) time.append (nHours + ":");
    if (nHours > 0 && nMinutes < 10) time.append ("0");
    time.append (nMinutes + ":");
    if (nSeconds < 10) time.append ("0");
    time.append (nSeconds);
    time.append (".");
    if (nMillis < 100) time.append ("0");
    if (nMillis <  10) time.append ("0");
    time.append (nMillis);

    return time.toString();
  }
}

