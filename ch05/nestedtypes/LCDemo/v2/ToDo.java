class ToDo
{
   private String name;
   private String desc;

   ToDo(String name, String desc)
   {
      this.name = name;
      this.desc = desc;
   }

   String getName()
   {
      return name;
   }

   String getDesc()
   {
      return desc;
   }

   @Override
   public String toString()
   {
      return "Name = " + getName() + ", Desc = " + getDesc();
   }
}