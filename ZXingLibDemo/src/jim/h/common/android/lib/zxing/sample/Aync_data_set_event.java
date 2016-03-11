package jim.h.common.android.lib.zxing.sample;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Aync_data_set_event extends AsyncTask<String,Void,String>{
	private ProgressDialog p;
	Context context;
	String content;
	ListView lid;
	int flag;
	//String[] images;
	String[] mt;
	String[] st;
	String[] tel;
	public Aync_data_set_event(Context context,ListView lid)
	{
		this.context=context;
		this.lid=lid;
		p=new ProgressDialog(context);
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
/*	 @Override 
	 public void onProgressUpdate(Integer... prog) {
	        if (prog == null)
	            return;
	        p.setProgress(prog[0]);
	    }
	*/@Override
		protected String doInBackground(String... arg0) {
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
		        		break; 
		        	}
		        	content=sb.toString();
		        	 return "success";
		        }
		        catch(Exception e)
		        {
		        	e.printStackTrace();
		        }
			 return "success";
		}
	
	  @Override	 
	protected void onPostExecute(String result)
	{
		p.cancel();
		
			 ArrayList<jim.h.common.android.lib.zxing.sample.ListItem> listData = getListData(result);

		        final ListView listView =lid;
		        listView.setAdapter(new CustomListAdapter(context, listData));
	}
	 private ArrayList<ListItem> getListData(String result) {
	        ArrayList<jim.h.common.android.lib.zxing.sample.ListItem> listMockData = new ArrayList<jim.h.common.android.lib.zxing.sample.ListItem>();
	        converttoLISTVIEW(result);
			for (int i = 0; i < mt.length; i++) {
				jim.h.common.android.lib.zxing.sample.ListItem newsData = new jim.h.common.android.lib.zxing.sample.ListItem();
	            	newsData.setmt(mt[i]);
	            	newsData.setst(st[i]);
	            	listMockData.add(newsData);
	        	}   
			 return listMockData;
	    }
	public void converttoLISTVIEW(String response)
	{
		try
		{
		JSONObject jsonRootObject=new JSONObject(content);
		JSONArray jsonArray=jsonRootObject.optJSONArray("results");
		//images=new String[jsonArray.length()];
		mt=new String[jsonArray.length()];
		st=new String[jsonArray.length()];
		tel=new String[jsonArray.length()];
		
			for(int i=0;i<jsonArray.length();i++)
			{
				JSONObject jsonObject=jsonArray.getJSONObject(i);
				mt[i]=jsonObject.optString("title").toString();
				st[i]=jsonObject.optString("msg").toString();
			}
			if(jsonArray.length()==0)
			{
				Toast.makeText(context,"No Message Yet",Toast.LENGTH_SHORT).show();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	}
