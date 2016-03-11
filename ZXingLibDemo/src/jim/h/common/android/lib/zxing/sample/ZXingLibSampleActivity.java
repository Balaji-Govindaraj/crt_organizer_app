package jim.h.common.android.lib.zxing.sample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.pushbots.push.Pushbots;

import java.util.ArrayList;
import java.util.List;

import jim.h.common.android.lib.zxing.config.ZXingLibConfig;
import jim.h.common.android.lib.zxing.integrator.IntentIntegrator;
import jim.h.common.android.lib.zxing.integrator.IntentResult;

public class ZXingLibSampleActivity extends AppCompatActivity {
    public static final String UPLOAD_URL = "http://samhita.org.in/ii_create.php";
    public static final String UPLOAD_SID = "SID";
    public static final String UPLOAD_NAME = "NAME";
    public static final String UPLOAD_EMAIL="EMAIL";
    public static final String UPLOAD_EVENT="EVENT";
    public static final String UPLOAD_NOTIFICATION="NOTIFICATION";
    public static final String UPLOAD_ROUND="ROUND";
    private Bitmap bitmap;
    String sid1 = "";
    String name1 = "";
    String email1 = "";
    String event1 = "";
    String notification1 = "";
    String round1 = "";
    int check=0;
    private Handler handler = new Handler();
    private TextView txtScanResult;
    private TextView name;
    private TextView mailid;
    private TextView phoneno;
    private Button attendance;
    private ZXingLibConfig zxingLibConfig;
    private Spinner event;
    private Spinner round;
    private Spinner title_push;
    private Button submit;
    private Button push_notify;
    private Button push_receive;
    private EditText msgg;
    private Spinner pri;
    DBAdapter db;

    private EditText sid_edit;
    private EditText name_edit;
    private EditText mailid_edit;
    private EditText phoneno_edit;
    private Spinner event_edit;
    private Spinner round_edit;
    private Button submit_edit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Pushbots.sharedInstance().init(this);

        sid_edit=(EditText)findViewById(R.id.sid_edit);
        name_edit=(EditText)findViewById(R.id.name_edit);
        mailid_edit=(EditText)findViewById(R.id.mailid_edit);
        phoneno_edit=(EditText)findViewById(R.id.phoneno_edit);
        event_edit=(Spinner)findViewById(R.id.event_edit);
        round_edit=(Spinner)findViewById(R.id.round_edit);
        submit_edit=(Button)findViewById(R.id.submit_edit);
        attendance=(Button)findViewById(R.id.attendance);

        txtScanResult = (TextView) findViewById(R.id.sid);
        name=(TextView)findViewById(R.id.name);
        mailid=(TextView)findViewById(R.id.mailid);
        phoneno=(TextView)findViewById(R.id.phoneno);
        event=(Spinner)findViewById(R.id.event);
        round=(Spinner)findViewById(R.id.round);
        title_push=(Spinner)findViewById(R.id.push_title);
        submit=(Button)findViewById(R.id.submit);
        push_notify=(Button)findViewById(R.id.push_notify);


        msgg=(EditText)findViewById(R.id.msg_push);
        pri=(Spinner)findViewById(R.id.price);


        zxingLibConfig = new ZXingLibConfig();
        zxingLibConfig.useFrontLight = true;

       // pri.setEnabled(false);

        List<String> categories1 = new ArrayList<String>();
        categories1.add("B-Plan");
        categories1.add("Dexterity Unbounded");
        categories1.add("General Quiz");
        categories1.add("Math-O-Mania");
        categories1.add("Onsite Photography");
        categories1.add("How Stuff Works");
        categories1.add("IPL Auction");
        categories1.add("Treasure Hunt");
        categories1.add("Coffee With Java");
        categories1.add("Debugging");
        categories1.add("Dumb C");
        categories1.add("Linux Mate");
        categories1.add("OSPC");
        categories1.add("Paper Presentation");
        categories1.add("PS I LOVE U");
        categories1.add("Reverse Coding");
        categories1.add("Sequel Scholars");
        categories1.add("Web Designing");
        categories1.add("Code Obfuscation");
        categories1.add("Pixels");
        categories1.add("Street Coding");
        categories1.add("Pursuit Of Prodigies");


        ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        event.setAdapter(dataAdapter1);

        List<String> categories2 = new ArrayList<String>();
        categories2.add("1");
        categories2.add("2");

        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        round.setAdapter(dataAdapter2);


        List<String> categories3 = new ArrayList<String>();
        categories3.add("B-Plan");
        categories3.add("Dexterity Unbounded");
        categories3.add("General Quiz");
        categories3.add("Math-O-Mania");
        categories3.add("Onsite Photography");
        categories3.add("How Stuff Works");
        categories3.add("IPL Auction");
        categories3.add("Treasure Hunt");
        categories3.add("Coffee With Java");
        categories3.add("Debugging");
        categories3.add("Dumb C");
        categories3.add("Linux Mate");
        categories3.add("OSPC");
        categories3.add("Paper Presentation");
        categories3.add("PS I LOVE U");
        categories3.add("Reverse Coding");
        categories3.add("Sequel Scholars");
        categories3.add("Web Designing");
        categories3.add("Code Obfuscation");
        categories3.add("Pixels");
        categories3.add("Street Coding");
        categories3.add("Pursuit Of Prodigies");


        ArrayAdapter<String> dataAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories3);
        dataAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        title_push.setAdapter(dataAdapter3);





















        List<String> categories11 = new ArrayList<String>();
        categories11.add("B-Plan");
        categories11.add("Dexterity Unbounded");
        categories11.add("General Quiz");
        categories11.add("Math-O-Mania");
        categories11.add("Onsite Photography");
        categories11.add("How Stuff Works");
        categories11.add("IPL Auction");
        categories11.add("Treasure Hunt");
        categories11.add("Coffee With Java");
        categories11.add("Debugging");
        categories11.add("Dumb C");
        categories11.add("Linux Mate");
        categories11.add("OSPC");
        categories11.add("Paper Presentation");
        categories11.add("PS I LOVE U");
        categories11.add("Reverse Coding");
        categories11.add("Sequel Scholars");
        categories11.add("Web Designing");
        categories11.add("Code Obfuscation");
        categories11.add("Pixels");
        categories11.add("Street Coding");
        categories11.add("Pursuit Of Prodigies");


        ArrayAdapter<String> dataAdapter11 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories11);
        dataAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        event_edit.setAdapter(dataAdapter11);

        List<String> categories21 = new ArrayList<String>();
        categories21.add("1");
        categories21.add("2");

        ArrayAdapter<String> dataAdapter21 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories21);
        dataAdapter21.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        round_edit.setAdapter(dataAdapter21);











        db = new DBAdapter(ZXingLibSampleActivity.this);

        List<String> categories5 = new ArrayList<String>();
        categories5.add("First");
        categories5.add("Second");
        categories5.add("Third");


        ArrayAdapter<String> dataAdapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories5);
        dataAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pri.setAdapter(dataAdapter5);

       pri.setEnabled(false);
        round.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // On selecting a spinner item
                String item = parent.getItemAtPosition(position).toString();
                if (item.equals("2")) {
                    pri.setEnabled(true);
                    check = 1;
                } else {
                    pri.setEnabled(false);
                    check = 0;
                }
                // Showing selected spinner item
                //Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ZXingLibSampleActivity.this);
                alertDialogBuilder.setTitle("Confirm For Attendance Submission");
                alertDialogBuilder.setMessage("")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (isNetworkAvailable()) {
                                    try {
                                        String r = txtScanResult.getText().toString();
                                        String e = Integer.toString(event.getSelectedItemPosition());
                                        new Async_data_set1(ZXingLibSampleActivity.this).execute("http://samhita.org.in/qr_verify.php?SID="+r+"&EVENT="+e);
                                        db.open();
                                        db.insertContact(r,"","","", e,"attendance");
                                        db.close();
                                        Toast.makeText(getBaseContext(), "Attendance Published Successfully",
                                                Toast.LENGTH_SHORT).show();


                                    } catch (Exception e) {
                                    }
                                } else {
                                    Toast.makeText(ZXingLibSampleActivity.this, "Not Internet Available", Toast.LENGTH_LONG).show();
                                }
                                txtScanResult.setText("S-ID");
                                name.setText("USERNAME");
                                mailid.setText("MAIL ID");
                                phoneno.setText("PHONE NUMBER");
                                event.setSelection(0);
                                round.setSelection(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
        push_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ZXingLibSampleActivity.this);
                alertDialogBuilder.setTitle("Confirm For Notify");
                alertDialogBuilder.setMessage("")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (isNetworkAvailable()) {
                                    try {
                                        String title1 = String.valueOf(title_push.getSelectedItem());
                                        String message = msgg.getText().toString();
                                        new Async_data_set2(ZXingLibSampleActivity.this, title1, message).execute("http://samhita.org.in/example.php");
                                        new Async_data_set2(ZXingLibSampleActivity.this, title1, message).execute("http://samhita.org.in/push_insert.php");


                                         /*  db.open();
                                           db.insertContact("Organizer", title1, message, "Notification Sent", "With Regards", "Team ITA");
                                           db.close();*/
                                    } catch (Exception e) {
                                    }
                                } else {
                                    Toast.makeText(ZXingLibSampleActivity.this, "Not Internet Available", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ZXingLibSampleActivity.this);
                alertDialogBuilder.setTitle("Confirm For Result Submission");
                alertDialogBuilder.setMessage("")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (isNetworkAvailable()) {
                                    try {
                                        String r = txtScanResult.getText().toString();

                                        //String res = r.substring(1);
                                        String email2 = mailid.getText().toString();
                                        String name2 = "";
                                        String rx = "";
                                        name2 = name.getText().toString();
                                        if (check == 1) {
                                            rx = String.valueOf(pri.getSelectedItem());
                                        }
                                        String phone2 = phoneno.getText().toString();
                                        String e = Integer.toString(event.getSelectedItemPosition());
                                        String rou = String.valueOf(round.getSelectedItem());
                                        new Async_data_set1(ZXingLibSampleActivity.this).execute("http://samhita.org.in/qr_ii.php?SID=" + r + "&EVENT=" + e + "&ROUND=" + rou + "&RES=" + rx);

                                        db.open();
                                        if (rx.equals("")) {
                                            db.insertContact(r, name2, email2, phone2, e, rou);
                                        } else {
                                            db.insertContact(r, name2 + "-" + rx, email2, phone2, e, rou);
                                        }
                                        db.close();
                                        Toast.makeText(getBaseContext(), "Published Successfully",
                                                Toast.LENGTH_SHORT).show();


                                    } catch (Exception e) {
                                    }
                                } else {
                                    Toast.makeText(ZXingLibSampleActivity.this, "Not Internet Available", Toast.LENGTH_LONG).show();
                                }
                                txtScanResult.setText("S-ID");
                                name.setText("USERNAME");
                                mailid.setText("MAIL ID");
                                phoneno.setText("PHONE NUMBER");
                                event.setSelection(0);
                                round.setSelection(0);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }

        });









        submit_edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ZXingLibSampleActivity.this);
                alertDialogBuilder.setTitle("Confirm For Result Submission");
                alertDialogBuilder.setMessage("")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                if (isNetworkAvailable()) {
                                    try {
                                        String r = sid_edit.getText().toString();

                                        //String res = r.substring(1);
                                        String email2 = mailid_edit.getText().toString();
                                        String name2="";
                                        String rx="";
                                        name2 = name_edit.getText().toString();

                                        String phone2 = phoneno_edit.getText().toString();
                                        String e=Integer.toString(event_edit.getSelectedItemPosition());
                                        String ee = String.valueOf(event_edit.getSelectedItem());
                                        String rou = String.valueOf(round_edit.getSelectedItem());
                                        new Async_data_set3(ZXingLibSampleActivity.this,r,name2,email2,ee,phone2,rou).execute("http://samhita.org.in/qr_ii_edit.php");

                                        db.open();
                                        db.insertContact(r, name2, email2, phone2, e, rou);
                                        db.close();

                                        Toast.makeText(getBaseContext(), "Published Successfully",
                                                Toast.LENGTH_SHORT).show();


                                    } catch (Exception e) {
                                    }
                                } else {
                                    Toast.makeText(ZXingLibSampleActivity.this, "Not Internet Available", Toast.LENGTH_LONG).show();
                                }
                             /*   sid_edit.setHint("S-ID");
                                name_edit.setHint("USERNAME");
                                mailid_edit.setHint("MAIL ID");
                                phoneno_edit.setHint("PHONE NUMBER");
                                event_edit.setSelection(0);
                                round_edit.setSelection(0);*/
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();


            }

        });













        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator.initiateScan(ZXingLibSampleActivity.this, zxingLibConfig);
            }
        });

       // View action_a=(View)findViewById(R.id.action_a);
      //  View action_b=(View)findViewById(R.id.action_b);
     /*   FloatingActionButton fab1 = (FloatingActionButton) findViewById(R.id.action_a);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(ZXingLibSampleActivity.this,Contact_List_Main.class);
                startActivity(intent);
            }
        });
        FloatingActionButton fab2 = (FloatingActionButton) findViewById(R.id.action_b);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ZXingLibSampleActivity.this,Contact_List_Main.class);
                startActivity(intent);
            }
        });*/
    }

    public void action_a(View view)
    {
        Intent intent=new Intent(ZXingLibSampleActivity.this,Contact_List_Main.class);
        startActivity(intent);
    }
    public void action_b(View view)
    {
        Intent intent=new Intent(ZXingLibSampleActivity.this,Save.class);
        startActivity(intent);

/*        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();*/
    }
    private void DisplayContact(Cursor c)
    {
        // TODO Auto-generated method stub
        Toast.makeText(getBaseContext(),"id: " + c.getString(0) + "\n" +"Name: " + c.getString(1) + "\n" + "Email: " + c.getString(2), Toast.LENGTH_LONG).show();
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case IntentIntegrator.REQUEST_CODE: // 扫描结果
                IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode,
                        resultCode, data);
                if (scanResult == null) {
                    return;
                }
                final String result = scanResult.getContents();
                if (result != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(isNetworkAvailable())
                            {
                                try
                                {
                                    new Async_data_set(ZXingLibSampleActivity.this,name).execute("http://samhita.org.in/qr_name.php?sid=" + result);
                                    new Async_data_set(ZXingLibSampleActivity.this,mailid).execute("http://samhita.org.in/qr_mail.php?sid=" + result);
                                    new Async_data_set(ZXingLibSampleActivity.this,phoneno).execute("http://samhita.org.in/qr_phone.php?sid=" + result);
                                }
                                catch(Exception e){}
                            }
                            txtScanResult.setText(result);
                        }
                    });
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(ZXingLibSampleActivity.this);
            alertDialogBuilder.setTitle("Developer");
            alertDialogBuilder.setMessage("Designed and Developed by \n G.Balaji,Team ITA \n Phone Number:9840272346");
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
            return true;
        }
        if(id==R.id.action_view)
        {
            Intent intent=new Intent(ZXingLibSampleActivity.this,Event_Result.class);
            startActivity(intent);
        }
        if(id==R.id.action_verify)
        {
            Intent intent=new Intent(ZXingLibSampleActivity.this,Account_verify.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}