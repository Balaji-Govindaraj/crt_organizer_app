package jim.h.common.android.lib.zxing.sample;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Async_data_set extends AsyncTask<String,Void,String>{
	Context context;
	String content;
	TextView textview1;
	public Async_data_set(Context context,TextView textview1)
	{
		this.context=context;
		this.textview1=textview1;
	}
	@Override
	protected void onPreExecute()
	{
	}
    @Override
	protected String doInBackground(String... arg0) {
		content="";	
    	try
		        {
		        	String link=(String)arg0[0];
		        	URL url = new URL(link); 
		        	URLConnection conn = url.openConnection(); 
		        	BufferedReader reader = new BufferedReader (new InputStreamReader(conn.getInputStream())); 
		        	StringBuilder sb = new StringBuilder(); 
		        	String line = null; 
		        	while((line = reader.readLine()) != null) 
		        	{ 
		        		sb.append(line); 
		        		//break; 
		        	}
		        	content=sb.toString();
		        	 return content;
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
			 return content;
		}
	
	 @Override	 
	protected void onPostExecute(String result)
	{
		 this.textview1.setText(result);
	}
}
