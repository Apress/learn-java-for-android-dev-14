class ToDoList
{
   private ToDo[] toDoList;
   private int index = 0;

   ToDoList(int size)
   {
      toDoList = new ToDo[size];
   }

   Iterator iterator()
   {
      class Iter implements Iterator
      {
         int index = 0;

         @Override
         public boolean hasMoreElements()
         {
            return index < toDoList.length;
         }

         @Override
         public Object nextElement()
         {
            return toDoList[index++];
         }
      }
      return new Iter();
   }

   void add(ToDo item)
   {
      toDoList[index++] = item;
   }
}