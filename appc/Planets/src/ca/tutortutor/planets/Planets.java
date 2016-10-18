package ca.tutortutor.planets;

import android.app.Activity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;

public class Planets extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
   }

   public void doBtnClicked(View view)
   {
      Intent intent = new Intent(Planets.this, PlanetInfo.class);
      String tag = (String) view.getTag();
      if (tag.equals("mercury"))
      {
         intent.putExtra("layout", R.layout.mercury);
         intent.putExtra("name", R.string.mercury);
      }
      else
      if (tag.equals("venus"))
      {
         intent.putExtra("layout", R.layout.venus);
         intent.putExtra("name", R.string.venus);
      }
      else
      if (tag.equals("earth"))
      {
         intent.putExtra("layout", R.layout.earth);
         intent.putExtra("name", R.string.earth);
      }
      else
      if (tag.equals("mars"))
      {
         intent.putExtra("layout", R.layout.mars);
         intent.putExtra("name", R.string.mars);
      }
      else
      if (tag.equals("jupiter"))
      {
         intent.putExtra("layout", R.layout.jupiter);
         intent.putExtra("name", R.string.jupiter);
      }
      else
      if (tag.equals("saturn"))
      {
         intent.putExtra("layout", R.layout.saturn);
         intent.putExtra("name", R.string.saturn);
      }
      else
      if (tag.equals("uranus"))
      {
         intent.putExtra("layout", R.layout.uranus);
         intent.putExtra("name", R.string.uranus);
      }
      else
      {
         intent.putExtra("layout", R.layout.neptune);
         intent.putExtra("name", R.string.neptune);
      }
      startActivity(intent);
   }
}