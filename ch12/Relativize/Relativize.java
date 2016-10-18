import java.net.URI;
import java.net.URISyntaxException;

public class Relativize
{
   public static void main(String[] args) throws URISyntaxException
   {
      if (args.length != 2)
      {
         System.err.println("usage: java Relativize uri1 uri2");
         return;
      }

      URI uri1 = new URI(args[0]);
      URI uri2 = new URI(args[1]);
      System.out.println("Relativized URI = " + uri1.relativize(uri2));
   }
}