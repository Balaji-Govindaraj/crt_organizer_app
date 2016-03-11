package jim.h.common.android.lib.zxing.sample;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

 
 
public class Save extends Activity{
	DBAdapter db;
	ListView list;
	String eve[]={
			"B-Plan",
			"Dexterity Unbounded",
			"General Quiz",
			"Math-O-Mania",
			"Onsite Photography",
			"How Stuff Works",
			"IPL Auction",
			"Treasure Hunt",
			"Coffee With Java",
			"Debugging",
			"Dumb C",
			"Linux Mate",
			"OSPC",
			"Paper Presentation",
			"PS I LOVE U",
			"Reverse Coding",
			"Sequel Scholars",
			"Web Designing",
			"Code Obfuscation",
			"Pixels",
			"Street Coding",
			"Pursuit Of Prodigies"
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contact_main);
		db = new DBAdapter(Save.this);
		db.open();
		Cursor c = db.getAllContacts();
		Integer img[]=new Integer[c.getCount()];
		String md[]=new String[c.getCount()];
		String sd[]=new String[c.getCount()];

		int i=c.getCount()-1,j=c.getCount()-1,k=c.getCount()-1;
		if (c.moveToFirst())
		{
			do {
				img[i--]=R.drawable.stuff;
				md[j--]=c.getString(1);

				if(c.getString(1).equals("Organizer")){
					sd[k--]=c.getString(2)+"\n"+ c.getString(3)+"\n"+c.getString(4)+"\n"+c.getString(5)+"\n"+c.getString(6);
				}
				else {
					String f=eve[Integer.parseInt(c.getString(5))];
					sd[k--] = "Username:" + c.getString(2) + "\nMailID:" + c.getString(3) + "\nPhoneno:" + c.getString(4) + "\nEvent:" + f + "\nRound:" + c.getString(6);
				}
								//DisplayContact(c);
			} while (c.moveToNext());
		}
		db.close();

		Onsite_List adapter=new Onsite_List(this, md, img,sd);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
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