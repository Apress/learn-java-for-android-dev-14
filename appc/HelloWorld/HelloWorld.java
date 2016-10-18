package ca.tutortutor.helloworld;

import android.app.Activity;

import android.os.Bundle;

import android.util.Log;

import android.widget.Toast;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloWorld extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      Toast.makeText(HelloWorld.this, "hello, world",
                     Toast.LENGTH_SHORT).show();
      Log.v("onCreate() called", "logged via Log.v");
      System.out.println("onCreate() called: logged via System.out.println()");
      System.err.println("onCreate() called: logged via System.err.println()");
      Logger logger = Logger.getLogger("HelloWorld");
      logger.log(Level.INFO, "onCreate() called: logged via logger.log");
      logger.log(Level.FINE, "onCreate() called: logged via logger.log");
   }
}