import java.net.URI;
import java.net.URISyntaxException;

public class Resolve
{
   public static void main(String[] args) throws URISyntaxException
   {
      if (args.length != 2)
      {
         System.err.println("usage: java Resolve baseuri uri");
         return;
      }

      URI uri = new URI(args[0]);
      System.out.println("Resolved URI = " + uri.resolve(args[1]));
   }
}