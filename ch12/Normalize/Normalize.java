import java.net.URI;
import java.net.URISyntaxException;

public class Normalize
{
   public static void main(String[] args) throws URISyntaxException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java Normalize uri");
         return;
      }

      URI uri = new URI(args[0]);
      System.out.println("Normalized URI = " + uri.normalize());
   }
}