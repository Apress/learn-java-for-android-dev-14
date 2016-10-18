import java.lang.ref.SoftReference;

class Image
{
   private byte[] image;

   private Image(String name)
   {
      image = new byte[1024 * 1024 * 100];
   }

   static Image getImage(String name)
   {
      return new Image(name);
   }
}

public class SoftCacheDemo
{
   public static void main(String[] args)
   {
      SoftCache<Integer, Image> sc = new SoftCache<Integer, Image>();
      int i = 0;
      while (true)
      {
         System.out.printf("Putting large image %d into soft cache.%n", i);
         sc.put(i, Image.getImage("large.png" + i));
         i++;
         int x = (int) (Math.random() * i);
         System.out.printf("Acquiring image %d from cache.%n", x);
         Image im = sc.get(x);
         if (im == null)
         {
            System.out.printf("Image %d no longer in cache. Re-caching.%n", x);
            sc.put(x, im = Image.getImage("large.png" + x));
         }
         System.out.printf("Drawing image %d.%n", x);
         im = null; // Remove strong reference to image.
      }
   }
}