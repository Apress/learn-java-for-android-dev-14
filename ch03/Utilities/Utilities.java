public class Utilities
{
   static void dumpMatrix(float[][] matrix)
   {
      for (int row = 0; row < matrix.length; row++)
      {
         for (int col = 0; col < matrix[row].length; col++)
            System.out.print(matrix[row][col] + " ");
         System.out.print("\n");
      }
   }

   public static void main(String[] args)
   {
      float[][] temperatures = {
                                  { 37.0f, 14.0f, -22.0f },
                                  { 0.0f, 29.0f, -5.0f }
                               };
      dumpMatrix(temperatures);
      System.out.println();
      Utilities.dumpMatrix(temperatures);
   }
}