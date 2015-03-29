package ro.pub.cs.systems.pdsd.practicaltest01;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01MainActivity extends Activity {
	Button ets, etd, tosec;
	EditText stanga, dreapta;
	
	private class Action implements View.OnClickListener{

		@Override
		public void onClick(View v) {
			String s = stanga.getText().toString();
			String d = dreapta.getText().toString();
			switch (v.getId()){
				case R.id.editTextPressStanga:
					int nr = Integer.parseInt(s);
					nr++;
					s = String.valueOf(nr);
					stanga.setText(s);
					break;
				case R.id.editTextPressDreapta:
					int nr1 = Integer.parseInt(d);
					nr1++;
					d = String.valueOf(nr1);
					dreapta.setText(d);
					break;
				case R.id.buttonSecondary:
					Intent intent = new Intent("ro.pub.cs.systems.pdsd.intent.action.PracticalTest01SecondaryActivity");
					
					intent.putExtra("num_clicks",Integer.toString(Integer.parseInt(s)+Integer.parseInt(d)));
					startActivityForResult(intent, 2015);
					break;
			}
				
			
		}
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_practical_test01_main);
		
		ets = (Button)findViewById(R.id.editTextPressStanga);
		etd = (Button)findViewById(R.id.editTextPressDreapta);
		tosec = (Button)findViewById(R.id.buttonSecondary);
		stanga = (EditText)findViewById(R.id.editTextstanga);
		dreapta = (EditText)findViewById(R.id.editTextdreapta);
		Action act = new Action();
		ets.setOnClickListener(act);
		etd.setOnClickListener(act);
		tosec.setOnClickListener(act);
		if(savedInstanceState != null)
		{
			String st = savedInstanceState.getString("stanga");
			if(st != null)
				stanga.setText(st);
			String dr = savedInstanceState.getString("dreapta");
			if(dr != null)
				dreapta.setText(dr);
		}
		
		
	}
	 @Override
	  protected void onSaveInstanceState(Bundle savedInstanceState) {
	    EditText ets = (EditText)findViewById(R.id.editTextstanga);
	    EditText etd = (EditText)findViewById(R.id.editTextdreapta);
	    savedInstanceState.putString("stanga",ets.getText().toString());
	    savedInstanceState.putString("dreapta", etd.getText().toString());
	  }
	 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.practical_test01_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	  public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    Toast.makeText(this, "The activity returned with result "+resultCode+" "+requestCode, Toast.LENGTH_LONG).show();
	  }
}
