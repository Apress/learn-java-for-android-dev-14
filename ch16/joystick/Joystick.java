class Joystick
{
   static boolean init()
   {
      try
      {
         System.loadLibrary("joystick");
         return true;
      }
      catch (UnsatisfiedLinkError ule)
      {System.out.println(ule);
         return false;
      }
   }

   static native int joyGetNumDevs();
}