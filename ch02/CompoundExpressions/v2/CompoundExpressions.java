public class CompoundExpressions
{
   public static void main(String[] args)
   {
      int[] ages = { 52, 28, 93, 16 };
      char gradeLetters[] = { 'A', 'B', 'C', 'D', 'F' };
      float[][] matrix = { { 1.0F, 2.0F, 3.0F }, { 4.0F, 5.0F, 6.0F }};
      System.out.println(ages[0]);
      System.out.println(gradeLetters[2]);
      System.out.println(matrix[1][2]);
      System.out.println(ages['\u0002']);
      ages[1] = 19;
      System.out.println(ages[1]);
   }
}