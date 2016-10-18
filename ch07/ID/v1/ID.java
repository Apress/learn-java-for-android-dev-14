class ID
{
   private static long nextID = 0;
   static long getNextID()
   {
      return nextID++;
   }
}