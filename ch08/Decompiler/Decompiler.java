import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Decompiler
{
   public static void main(String[] args)
   {
      if (args.length != 1)
      {
         System.err.println("usage: java Decompiler classname");
         return;
      }
      try
      {
         decompileClass(Class.forName(args[0]), 0);
      }
      catch (ClassNotFoundException cnfe)
      {
         System.err.println("could not locate " + args[0]);
      }
   }

   static void decompileClass(Class<?> clazz, int indentLevel)
   {
      indent(indentLevel * 3);
      System.out.print(Modifier.toString(clazz.getModifiers()) + " ");
      if (clazz.isEnum())
         System.out.println("enum " + clazz.getName());
      else
      if (clazz.isInterface())
      {
         if (clazz.isAnnotation())
            System.out.print("@");
         System.out.println(clazz.getName());
      }
      else
         System.out.println(clazz);
      indent(indentLevel * 3);
      System.out.println("{");
      Field[] fields = clazz.getDeclaredFields();
      for (int i = 0; i < fields.length; i++)
      {
         indent(indentLevel * 3);
         System.out.println("   " + fields[i]);
      }
      Constructor[] constructors = clazz.getDeclaredConstructors();
      if (constructors.length != 0 && fields.length != 0)
         System.out.println();
      for (int i = 0; i < constructors.length; i++)
      {
         indent(indentLevel * 3);
         System.out.println("   "+constructors[i]);
      }
      Method[] methods = clazz.getDeclaredMethods();
      if (methods.length != 0 &&
          (fields.length != 0 || constructors.length != 0))
         System.out.println();
      for (int i = 0; i < methods.length; i++)
      {
         indent(indentLevel * 3);
         System.out.println("   "+methods[i]);
      }
      Method[] methodsAll = clazz.getMethods();
      if (methodsAll.length != 0 &&
          (fields.length != 0 || constructors.length != 0 ||
           methods.length != 0))
         System.out.println();
      if (methodsAll.length != 0)
      {
         indent(indentLevel * 3);
         System.out.println("   ALL PUBLIC METHODS");
         System.out.println();
      }
      for (int i = 0; i < methodsAll.length; i++)
      {
         indent(indentLevel * 3);
         System.out.println("   "+methodsAll[i]);
      }
      Class<?>[] members = clazz.getDeclaredClasses();
      if (members.length != 0 && (fields.length != 0 ||
          constructors.length != 0 || methods.length != 0 ||
          methodsAll.length != 0))
         System.out.println();
      for (int i = 0; i < members.length; i++)
         if (clazz != members[i])
         {
            decompileClass(members[i], indentLevel + 1);
            if (i != members.length - 1)
               System.out.println();
         }
      indent(indentLevel * 3);
      System.out.println("}");
   }

   static void indent(int numSpaces)
   {
      for (int i = 0; i < numSpaces; i++)
         System.out.print(' ');
   }
}