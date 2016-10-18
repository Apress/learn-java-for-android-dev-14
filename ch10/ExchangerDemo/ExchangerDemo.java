import java.util.ArrayList;
import java.util.List;

import java.util.concurrent.Exchanger;

public class ExchangerDemo
{
   static Exchanger<DataBuffer> exchanger = new Exchanger<DataBuffer>();

   static DataBuffer initialEmptyBuffer = new DataBuffer();
   static DataBuffer initialFullBuffer = new DataBuffer("I");

   public static void main(String[] args)
   {
      class FillingLoop implements Runnable 
      {
         int count = 0;

         @Override
         public void run() 
         {
            DataBuffer currentBuffer = initialEmptyBuffer;
            try 
            {
               while (true) 
               {
                  addToBuffer(currentBuffer);
                  if (currentBuffer.isFull())
                  {
                     System.out.println("filling thread wants to exchange");
                     currentBuffer = exchanger.exchange(currentBuffer);
                     System.out.println("filling thread receives an exchange");
                  }
               }
            } 
            catch (InterruptedException ie) 
            { 
               System.out.println("filling thread interrupted");
            }
         }

         void addToBuffer(DataBuffer buffer)
         {
            String item = "NI" + count++;
            System.out.println("Adding: " + item);
            buffer.add(item);
         }
      }

      class EmptyingLoop implements Runnable 
      {
         @Override
         public void run() 
         {
            DataBuffer currentBuffer = initialFullBuffer;
            try 
            {
               while (true) 
               {
                  takeFromBuffer(currentBuffer);
                  if (currentBuffer.isEmpty())
                  {
                     System.out.println("emptying thread wants to exchange");
                     currentBuffer = exchanger.exchange(currentBuffer);
                     System.out.println("emptying thread receives an exchange");
                  }
               }
            } 
            catch (InterruptedException ie) 
            { 
               System.out.println("emptying thread interrupted");
            }
         }

         void takeFromBuffer(DataBuffer buffer)
         {
            System.out.println("taking: " + buffer.remove());
         }
      }
      new Thread(new EmptyingLoop()).start();
      new Thread(new FillingLoop()).start();
   }
}

class DataBuffer
{
   private final static int MAXITEMS = 10;

   private List<String> items = new ArrayList<String>();

   DataBuffer()
   {
   }

   DataBuffer(String prefix)
   {
      for (int i = 0; i < MAXITEMS; i++)
      {
         String item = prefix+i;
         System.out.printf("Adding %s%n", item);
         items.add(item);
      }
   }

   void add(String s)
   {
      if (!isFull())
         items.add(s);
   }

   boolean isEmpty()
   {
      return items.size() == 0;
   }

   boolean isFull()
   {
      return items.size() == MAXITEMS;
   }

   String remove()
   {
      if (!isEmpty())
         return items.remove(0);
      return null;
   }
}