package com.hack.beacon;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import static java.lang.Math.abs;

public class CreateEvent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_event);
		
		
		 final SeekBar StartTimeBar = (SeekBar) findViewById(R.id.startTime_bar);
		 final TextView StartTimeText = (TextView) findViewById(R.id.startTime_text);
		 
		 StartTimeBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {       

			 @Override       
		     public void onStopTrackingTouch(SeekBar seekBar) {      
		         // TODO Auto-generated method stub      
		     }       

			 @Override       
		     public void onStartTrackingTouch(SeekBar seekBar) {     
		         // TODO Auto-generated method stub      
		     }       

		     @Override
		     public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		    	 //MaxValue = 60
		    	 int [] startStepsValue = {0, 5, 10, 15, 20, 30, 45, 60};
		    	 int [] startStepsLocation = {0, 5, 10, 15, 20, 30, 45, 60};
		    	 int startStep = 8;
		    	 int currentStep = 0;
		    	 //Greater than Progress
		    	 int currentDiff = 60;
		    	 for(int i = 0; i < startStepsValue.length; i ++)
		    	 {
		    		 if(abs(progress - startStepsValue[i]) < currentDiff)
		    		 {
		    			 currentDiff = abs(progress - startStepsValue[i]);
		    			 currentStep = i;
		    		 }
		    		 if(progress - startStepsValue[i] < 0)
		    		 {
		    			 break;
		    		 }
		    	 }
    			 progress = startStepsLocation[currentStep];
		     	 // progress = ((int)Math.round(progress/startStep ))*startStep;
		    	 // Alternitive if runtime is bad
		         seekBar.setProgress(progress);
		         if(currentStep == 0)
		         {
		        	 StartTimeText.setText("Now!");
		         }
		         else
		         {
		        	 StartTimeText.setText(startStepsValue[currentStep] + " Minutes");
		         }

		        }   
		    });
		    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_event, menu);
		return true;
	}
	
	
   
}
