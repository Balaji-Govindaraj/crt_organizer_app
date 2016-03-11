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

public class Async_data_set2 extends AsyncTask<String,Void,String>{
	Context context;
	String content;
	String tit1;
	String msg1;
	private ProgressDialog p;
	public Async_data_set2(Context context,String tit1,String msg1)
	{
		this.context=context;
		this.tit1=tit1;
		this.msg1=msg1;
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
					String data = URLEncoder.encode("msg", "UTF-8")
							+ "=" + URLEncoder.encode(msg1, "UTF-8");

					data += "&" + URLEncoder.encode("title", "UTF-8") + "="
							+ URLEncoder.encode(tit1, "UTF-8");
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
