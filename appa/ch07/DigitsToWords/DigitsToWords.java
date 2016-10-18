public class DigitsToWords
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java DigitsToWords integer");
         return;
      }
      System.out.println(convertDigitsToWords(Integer.parseInt(args[0])));
   }

   static String convertDigitsToWords(int integer)
   {
      if (integer < 0 || integer > 9999)
          throw new IllegalArgumentException("Out of range: " + integer);
      if (integer == 0)
          return "zero";
      String[] group1 =
      {
         "one",
         "two",
         "three",
         "four",
         "five",
         "six",
         "seven",
         "eight",
         "nine"
      };
      String[] group2 =
      {
         "ten",
         "eleven",
         "twelve",
         "thirteen",
         "fourteen",
         "fifteen",
         "sixteen",
         "seventeen",
         "eighteen",
         "nineteen"
      };
      String[] group3 =
      {
         "twenty",
         "thirty",
         "fourty",
         "fifty",
         "sixty",
         "seventy",
         "eighty",
         "ninety"
      };
      StringBuffer result = new StringBuffer();
      if (integer >= 1000)
      {
          int tmp = integer / 1000;
          result.append(group1[tmp - 1] + " thousand");
          integer -= tmp * 1000;
          if (integer == 0)
              return result.toString();
          result.append(" ");
      }
      if (integer >= 100)
      {
          int tmp = integer / 100;
          result.append(group1[tmp - 1] + " hundred");
          integer -= tmp * 100;
          if (integer == 0)
              return result.toString();
          result.append(" and ");
      }
      if (integer >= 10 && integer <= 19)
      {
          result.append(group2[integer - 10]);
          return result.toString();
      }
      if (integer >= 20)
      {
          int tmp = integer / 10;
          result.append(group3[tmp - 2]);
          integer -= tmp * 10;
          if (integer == 0)
              return result.toString();
          result.append("-");
      }
      result.append(group1[integer - 1]);
      return result.toString();
   }
}