package ca.tutortutor.planets;

import android.app.Activity;

import android.content.res.Resources;

import android.os.Bundle;

public class PlanetInfo extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      Bundle extras = getIntent().getExtras(); 
      int layout = extras.getInt("layout");
      setContentView(layout);
      Resources res = getResources();
      setTitle(res.getString(R.string.app_name) + ": " +
               res.getString(extras.getInt("name")));
   }
}