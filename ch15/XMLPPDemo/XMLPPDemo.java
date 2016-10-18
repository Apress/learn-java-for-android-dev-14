import java.io.FileReader;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public class XMLPPDemo
{
   public static void main (String args[]) 
      throws IOException, XmlPullParserException
   {
      if (args.length != 1)
      {
         System.err.println("usage: java XMLPPDemo xmlfilespec");
         return;
      }

      XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
      factory.setNamespaceAware(true);
      XmlPullParser xpp = factory.newPullParser();

      xpp.setInput(new FileReader(args[0]));
      int eventType = xpp.getEventType();
      while (eventType != XmlPullParser.END_DOCUMENT) 
      {
         switch (eventType)
         {
            case XmlPullParser.START_DOCUMENT:
                 System.out.println("Start document");
                 break;

            case XmlPullParser.START_TAG:
                 System.out.println("Start tag " + xpp.getName());
                 break;

            case XmlPullParser.TEXT:
                 System.out.println("Text " + xpp.getText());
                 break;

            case XmlPullParser.END_TAG:
                 System.out.println("End tag " + xpp.getName());
         }
         eventType = xpp.next();
      }
   }
}