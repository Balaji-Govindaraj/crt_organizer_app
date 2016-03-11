package jim.h.common.android.lib.zxing.sample;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Event_Result extends Activity{
	String username;
	TextView login_username;
	ListView out;
	String url;
//	loading l;
	
	@Override 
	protected void onCreate(Bundle savedInstanceState) 
	{ 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_welcome);

		out=(ListView)findViewById(R.id.out);
		ListView listView = (ListView) findViewById(R.id.out);
    	if(isNetworkAvailable())
    	{
    		try
    		{
    			new Aync_data_set_event(this,listView).execute("http://samhita.org.in/push_view.php");
    		}
    		catch(Exception e){}
    	}
    	else
    	{
    		Toast.makeText(getApplicationContext(),"Please Connect to Internet",Toast.LENGTH_LONG).show();
    	}
		
	}
	 @Override
		public boolean onOptionsItemSelected(MenuItem item) { 
		    switch (item.getItemId()) {
		        case android.R.id.home:
		            this.finish();
		        	// app icon in action bar clicked; go home
		            return true;

		            default:
		            return super.onOptionsItemSelected(item); 
		    }
		}
	private boolean isNetworkAvailable() {
	    ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
	    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
	    return activeNetworkInfo != null && activeNetworkInfo.isConnected();
	}

	
}
