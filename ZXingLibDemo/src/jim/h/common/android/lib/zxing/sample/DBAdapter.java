package jim.h.common.android.lib.zxing.sample;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {
    public static final String KEY_ROWID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENO = "phoneno";
    public static final String KEY_EVENT = "event";
    public static final String KEY_ROUND = "round";
    public static final String Key_ID="sid";

    private static final String TAG = "DBAdapter";
    private static final String DATABASE_NAME = "MyDB";
    private static final String DATABASE_TABLE = "contacts";
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_CREATE =
            "create table contacts (_id integer primary key autoincrement, "
                    + "sid text not null,name text not null, email text not null,phoneno text not null,event text not null,round text not null);";
    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }

    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS contacts");
            onCreate(db);
        }
    }


    //---opens the database---
    public DBAdapter open() throws SQLException
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }


    //---closes the database---
    public void close()
    {
        DBHelper.close();
    }


    //---insert a contact into the database---
    public long insertContact(String sid,String name, String email,String phoneno,String event,String round)
    {
        ContentValues initialValues = new ContentValues();
        initialValues.put(Key_ID,sid);
        initialValues.put(KEY_NAME, name);
        initialValues.put(KEY_EMAIL, email);
        initialValues.put(KEY_PHONENO, phoneno);
        initialValues.put(KEY_EVENT, event);
        initialValues.put(KEY_ROUND, round);


        return db.insert(DATABASE_TABLE, null, initialValues);
    }


    //---deletes a particular contact---
    public boolean deleteContact(long rowId)
    {
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }


    //---retrieves all the contacts---
    public Cursor getAllContacts()
    {
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, Key_ID,KEY_NAME, KEY_EMAIL,KEY_PHONENO,KEY_EVENT,KEY_ROUND},
                null, null, null, null, null);
    }


    //---retrieves a particular contact---
    public Cursor getContact(long rowId) throws SQLException
    {
        Cursor mCursor =db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,Key_ID,KEY_NAME, KEY_EMAIL,KEY_PHONENO,KEY_EVENT,KEY_ROUND}, KEY_ROWID + "=" + rowId, null,
                null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    //---updates a contact---
    public boolean updateContact(long rowId, String name, String email)
    {
        ContentValues args = new ContentValues();
        args.put(KEY_NAME, name);
        args.put(KEY_EMAIL, email);
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }
}