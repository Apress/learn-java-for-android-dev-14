import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo
{
   public static void main(String[] args)
   {
      Timer t = new Timer(true);
      t.schedule(new TimerTask()
                 {
                    @Override
                    public void run()
                    {
                       System.out.println("one-shot timer task executing");
                    }
                 }, 2000); // Execute one-shot timer task after 2-second delay.
      System.out.println("main thread is sleeping for 4 seconds");
      try { Thread.sleep(4000); } catch (InterruptedException ie) {}
      System.out.println("main thread has woken up");
      t = new Timer();
      t.schedule(new TimerTask()
                 {
                    int i; // initializes to 0 by default
                    @Override
                    public void run()
                    {
                       System.out.println("repeated timer task is running");
                       if (++i == 6)
                       {
                          System.out.println("canceling repeated timer task");
                          cancel();
                          System.out.println("canceled");
                          System.exit(0);
                       }
                    }
                 }, 2000, 500);
      System.out.println("main thread is terminating");
   }
}