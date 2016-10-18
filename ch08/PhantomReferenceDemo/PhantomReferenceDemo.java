import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

class LargeObject
{
   private byte[] memory = new byte[1024 * 1024 * 50]; // 50 megabytes
}

public class PhantomReferenceDemo
{
   public static void main(String[] args)
   {
      ReferenceQueue<LargeObject> rq = new ReferenceQueue<LargeObject>();
      PhantomReference<LargeObject> pr;
      pr = new PhantomReference<LargeObject>(new LargeObject(), rq);
      while (rq.poll() == null)
      {
         System.out.println("waiting for first large object to be finalized");
         new LargeObject(); // Create another (unreferenced) LargeObject.
      }
      System.out.println("first large object finalized");
      System.out.println("pr.get() returns " + pr.get());
   }
}