public class JoystickDemo
{
   public static void main(String[] args)
   {
      if (!Joystick.init())
      {
         System.err.println("unable to load joystick library");
         return;
      }
      System.out.printf("Number of joysticks = %d%n", Joystick.joyGetNumDevs());
   }
}