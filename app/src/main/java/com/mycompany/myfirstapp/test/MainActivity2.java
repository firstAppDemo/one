package com.mycompany.myfirstapp.test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

import com.mycompany.myfirstapp.R;

public class MainActivity2 extends Activity implements EditTextWithAddInterFace{

	
	private EditTextWithAdd selectUserNames;//已选接收人  

	
	@Override
	protected void onCreate(Bundle savedInstanceState)  {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		selectUserNames=(EditTextWithAdd)findViewById( R.id.selectUserNames);
        selectUserNames.setActivity(this); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public void addButtonListener() {
		Toast.makeText(getApplicationContext(), "默认的Toast", Toast.LENGTH_SHORT).show();
		
	}

}
