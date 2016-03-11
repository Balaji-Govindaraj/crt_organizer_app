package jim.h.common.android.lib.zxing.sample;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class Async_data_set3 extends AsyncTask<String,Void,String>{
	Context context;
	String content;
	String sid;
	String name;
	String email;
	String event;
	String notification;
	String round;
	private ProgressDialog p;
	public Async_data_set3(Context context,String sid,String name,String email,String event,String notification,String round)
	{
		this.context=context;
		this.sid=sid;
		this.name=name;
		this.email=email;
		this.event=event;
		this.notification=notification;
		this.round=round;
	}
	@Override
	protected void onPreExecute()
	{
		p=new ProgressDialog(context);
		p.setMessage("Loading.please Wait");
		p.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		p.setIndeterminate(true);
		p.setCancelable(false);
		p.setInverseBackgroundForced(false);
		p.show();
	}
    @Override
	protected String doInBackground(String... arg0) {
		content="";	
    	try
		        {
					String link=(String)arg0[0];
					String data = URLEncoder.encode("sid", "UTF-8")
							+ "=" + URLEncoder.encode(sid, "UTF-8");
					data += "&" + URLEncoder.encode("name", "UTF-8") + "="
							+ URLEncoder.encode(name, "UTF-8");
					data += "&" + URLEncoder.encode("email", "UTF-8") + "="
							+ URLEncoder.encode(email, "UTF-8");
					data += "&" + URLEncoder.encode("event", "UTF-8") + "="
							+ URLEncoder.encode(event, "UTF-8");
					data += "&" + URLEncoder.encode("notification", "UTF-8") + "="
							+ URLEncoder.encode(notification, "UTF-8");
					data += "&" + URLEncoder.encode("round", "UTF-8") + "="
							+ URLEncoder.encode(round, "UTF-8");

					BufferedReader reader=null;
					try
					{
						URL url = new URL(link);
						URLConnection conn = url.openConnection();
						conn.setDoOutput(true);
						OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
						wr.write( data );
						wr.flush();
						reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
						StringBuilder sb = new StringBuilder();
						String line = null;
						while((line = reader.readLine()) != null)
						{
							sb.append(line + "\n");
						}
						content = sb.toString();
					}
					catch(Exception ex){}
					finally
					{
						try
						{
							reader.close();
						}
						catch(Exception ex) {}
					}
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
		p.cancel();
	}
}
