public class StringBufferDemo
{
   public static void main(String[] args)
   {
      StringBuffer sb = new StringBuffer("Hello,");
      sb.append(' ');
      sb.append("world. ");
      sb.append(args.length);
      sb.append(" argument(s) have been passed to this method.");
      String s = sb.toString();
      System.out.println(s);      
   }
}