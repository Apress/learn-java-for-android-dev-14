package ca.tutortutor.circle;

import android.app.Activity;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;

import android.widget.EditText;
import android.widget.TextView;

public class Circle extends Activity
{
   @Override
   public void onCreate(Bundle savedInstanceState)
   {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);
      final EditText etRadius = (EditText) findViewById(R.id.radius);
      final TextView tvArea = (TextView) findViewById(R.id.area);
      final TextView tvCircumference = 
                     (TextView) findViewById(R.id.circumference);
      final String area = getString(R.string.area);
      final String area_undefined = getString(R.string.area_undefined);
      final String circumference = getString(R.string.circumference);
      final String circumference_undefined = 
                   getString(R.string.circumference_undefined);
      TextWatcher tw;
      tw = new TextWatcher()
               {
                  @Override
                  public void afterTextChanged(Editable s)
                  {
                  }

                  @Override
                  public void beforeTextChanged(CharSequence s, int start, 
                                                int count, int after)
                  {
                  }

                  @Override
                  public void onTextChanged(CharSequence s, int start, 
                                            int before, int count)
                  {
                     String text = etRadius.getText().toString();
                     if (text.equals(""))
                     {
                        tvArea.setText(area_undefined);
                        tvCircumference.setText(circumference_undefined);
                        return;
                     }
                     try
                     {
                        double radius = Double.parseDouble(text);
                        tvArea.setText(area + " " + Math.PI * radius * radius);
                        tvCircumference.setText(circumference + " " + Math.PI * 
                                                radius * 2);
                     }
                     catch (NumberFormatException nfe)
                     {
                        System.err.println("bad input detected: " + 
                                           nfe.getMessage());
                     }
                  }
               };
      etRadius.addTextChangedListener(tw);
   }
}