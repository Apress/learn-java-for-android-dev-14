import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadlockDemo
{
   private final Lock lock1 = new ReentrantLock();
   private final Lock lock2 = new ReentrantLock();

   public void m1()
   {
      if (lock1.tryLock())
         try
         {
            if (lock2.tryLock())
               try
               {
                  System.out.println("first thread in m1()");
               }
               finally
               {
                  lock2.unlock();
               }
         }
         finally
         {
            lock1.unlock();
         }
   }

   public void m2()
   {
      if (lock2.tryLock())
         try
         {
            if (lock1.tryLock())
               try
               {
                  System.out.println("second thread in m2()");
               }
               finally
               {
                  lock1.unlock();
               }
         }
         finally
         {
            lock2.unlock();
         }
   }

   public static void main(String[] args)
   {
      final DeadlockDemo dld = new DeadlockDemo();
      Runnable runnable1 = new Runnable()
                           {
                              @Override
                              public void run()
                              {
                                 while(true)
                                 {
                                    dld.m1();
                                    try
                                    {
                                       Thread.sleep(50);
                                    }
                                    catch (InterruptedException ie)
                                    {
                                       assert false;
                                    }
                                 }
                              }
                           };
      ExecutorService executor1 = Executors.newSingleThreadExecutor();
      Runnable runnable2 = new Runnable()
                           {
                              @Override
                              public void run()
                              {
                                 while(true)
                                 {
                                    dld.m2();
                                    try
                                    {
                                       Thread.sleep(50);
                                    }
                                    catch (InterruptedException ie)
                                    {
                                       assert false;
                                    }
                                 }
                              }
                           };
      ExecutorService executor2 = Executors.newSingleThreadExecutor();
      executor1.submit(runnable1);
      executor2.submit(runnable2);
   }
}