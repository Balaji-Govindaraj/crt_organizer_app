package jim.h.common.android.lib.zxing.sample;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

 
 
public class Contact_List_Main extends Activity{
	
	ListView list;
	String[] itemname ={
			"ITA Chairman",
			"ITA Secretary",
			"Accomodation-In-charge",
			"Sponser Coordinator",
			"Workshop Coordinator",
			"Event Coordinator1",
			"Event Coordinator2",
			"Deputy Chairman"
		};
	String[] sub_itemname ={
			"Name:J.SasiDharan\nPhoneno:8870068020",
			"Name:M.Vimal Kumar\nPhoneno:8122107944",
			"Name:A.Kaviyarasu\nPhoneno:9789864587",
			"Name:R.Kaushik\nPhoneno:8681027488",
			"Name:Ananth Narayanan\nPhoneno:9444899843",
			"Name:Badri Narayanan\nPhoneno:9884411961",
			"Name:Rajeswari\nPhoneno:9094140227",
			"Name:Subhashini\nPhoneno:7598474931"
	};
	Integer[] imgid={
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone,
			R.drawable.phone
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_main);
		
	/*	ActionBar ab = getActionBar();
        ab.setDisplayHomeAsUpEnabled(true);*/

		
		Onsite_List adapter=new Onsite_List(this, itemname, imgid,sub_itemname);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
 
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Selecteditem= itemname[+position];
				if(Selecteditem.equals("ITA Chairman"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8870068020"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("ITA Secretary"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8122107944"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Accomodation-In-charge"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9789864587"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Sponser Coordinator"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:8681027488"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Workshop Coordinator"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9444899843"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Event Coordinator1"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9884411961"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Event Coordinator2"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9094140227"));
					startActivity(intent);
				}
				else if(Selecteditem.equals("Deputy Chairman"))
				{
					Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:7598474931"));
					startActivity(intent);
				}

				//Toast.makeText(getApplicationContext(), Selecteditem, Toast.LENGTH_SHORT).show();
				
			}
		});

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
}