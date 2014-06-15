package todo.list;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Juzer on 3/20/14.
 */
public class ToDoDbAdapter {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Reminder.db";
    public static final String TABLE_NAME = "reminderlist";
    public static final String COLUMN_TITLE_NAME = "title";
    public static final String COLUMN_NOTE_NAME = "notes";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATETIME = "unix_date_time";
    private final Context mCtx;
    private DatabaseHelper mDbHelper;
    private SQLiteDatabase mDb;

    private static final String SQL_CREATE_TABLE = "CREATE TABLE "+ TABLE_NAME + "( "+ COLUMN_ID + " integer autoincrement, "
            + COLUMN_TITLE_NAME + " VARCHAR(2000), "
            + COLUMN_NOTE_NAME + " VARCHAR(4000), "
            + COLUMN_DATETIME + " INTEGER"
            + "PRIMARY KEY (" + COLUMN_ID + ")";

    private static class DatabaseHelper extends SQLiteOpenHelper {

        DatabaseHelper(Context context) {
          super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);
    }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            Log.w(DatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");

            //TODO
            //CHECK IMPLEMENTATION SCENARIOS
            // db.execSQL("ALTER TABLE " + TABLE_NAME + " ADD COLUMN "+ );
            // onCreate(db);
        }
    }

    public ToDoDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public ToDoDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public long createItem(String Title, String Note, int date_time) {
        //date_time = UNIX_TIMESTAMP
        ContentValues initialValues = new ContentValues();
        initialValues.put(COLUMN_TITLE_NAME, Title);
        initialValues.put(COLUMN_NOTE_NAME, Note);
        initialValues.put(COLUMN_DATETIME, date_time);

        return mDb.insert(TABLE_NAME, null, initialValues);
    }

    public boolean deleteItem(long rowId) {
        return mDb.delete(TABLE_NAME, COLUMN_ID +" = " + rowId, null) > 0;
    }

    public Cursor fetchAllItems() {
        return mDb.query(TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME}, null, null, null, null, null);
    }

    public Cursor fetchItem(int rowId) {
        Cursor mCursor =
                mDb.query(true, TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME},
                        COLUMN_ID + "=" + rowId,
                        null, null, null, null, null);

        if (mCursor != null)
            mCursor.moveToFirst();
        return mCursor;
    }

    // TODO: Complete Date Time code
   /* public Cursor fetchItemsByDate(int c) {
        switch (c)
        {
            case 0: //Past Tasks
                Cursor mCursor = mDb.query(TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME}, , null, null, null, null);     Code for Date selection
                if (mCursor != null)
                    mCursor.moveToFirst();
                break;

            case 1: //Today's Tasks
                Cursor mCursor = mDb.query(TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME}, , null, null, null, null);     Code for Date selection
                if (mCursor != null)
                    mCursor.moveToFirst();
                break;

            case 2: // Tomorrow's Tasks
                Cursor mCursor = mDb.query(TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME}, , null, null, null, null);     Code for Date selection
                if (mCursor != null)
                    mCursor.moveToFirst();
                break;

            case 3: //Later
                Cursor mCursor = mDb.query(TABLE_NAME, new String[] {COLUMN_TITLE_NAME, COLUMN_NOTE_NAME, COLUMN_DATETIME}, , null, null, null, null);     Code for Date selection
                if (mCursor != null)
                    mCursor.moveToFirst();
                break;
        }
        return mCursor;
    }*/

    public boolean UpdateItem(int rowId, String Title, String Note, int date_time) {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put(COLUMN_TITLE_NAME, Title);
        updatedValues.put(COLUMN_NOTE_NAME, Note);
        updatedValues.put(COLUMN_DATETIME, date_time);

        return mDb.update(TABLE_NAME, updatedValues, COLUMN_ID + "=" + rowId, null) > 0;
    }
}
