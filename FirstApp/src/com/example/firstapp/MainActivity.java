package com.example.firstapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	public static String EXTRA_DATA_MESSAGE = "com.example.firstapp.MainActivity.EXTRA_DATA_MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void sendMessage(View view) {
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	
    	// get the message from the dialog and save it into the intent
    	EditText txt = (EditText) findViewById(R.id.edit_message);
    	String msg = txt.getText().toString();
    	intent.putExtra(EXTRA_DATA_MESSAGE, msg);
    	
    	// handle the intent
    	startActivity(intent);
    }
    
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_search:
			onSearch();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	private void onSearch() {
		AlertDialog alert = new AlertDialog.Builder(this)
				.setMessage(getString(R.string.on_search))
				.setPositiveButton(getString(R.string.ok_button), new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {						
					}
				}).create();
		alert.show();
	}
}
