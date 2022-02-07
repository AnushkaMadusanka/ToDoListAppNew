package com.example.todolistappnew.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "db_todo";


    // ToDoListItem_list table name
    private static final String TABLE_ToDoListItem_LIST = "ToDoListItem_list";


    // ToDoListItem_list Table Columns names
    private static final String KEY_ToDoListItem_LIST_NAMES_LIST_ID = "ToDoListItem_list_id";
    private static final String KEY_ToDoListItem_LIST_NAME = "ToDoListItem_list_name";
    private static final String KEY_ToDoListItem_LIST_DESCRIPTION = "ToDoListItem_list_description";
    private static final String KEY_ToDoListItem_LIST_COLOR = "ToDoListItem_list_background_color";
    private static final String KEY_ToDoListItem_LIST_MORE_INFO = "ToDoListItem_list_more_info";
    private static final String KEY_ToDoListItem_LIST_CREATED = "ToDoListItem_list_created_date";
    private static final String KEY_ToDoListItem_LIST_LAST_UPDATED = "ToDoListItem_list_last_updated_date";
    private static final String KEY_ToDoListItem_LIST_PLANED_ACHIEVEMENT_DATE = "ToDoListItem_list_planed_achievement_date";
    private static final String KEY_ToDoListItem_LIST_ACHIEVED_DATE = "ToDoListItem_list_achieved_date";
    private static final String KEY_ToDoListItem_LIST_ITEM_STATUS = "ToDoListItem_list_item_status";
    private static final String KEY_ToDo_Id = "ToDo_id";


    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        //Create ToDoListItem_list table
        String CREATE_ToDoS_LIST_ITEMS_TABLE = "CREATE TABLE " + TABLE_ToDoListItem_LIST + "("
                + KEY_ToDoListItem_LIST_NAMES_LIST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_ToDoListItem_LIST_NAME + " TEXT,"
                + KEY_ToDoListItem_LIST_DESCRIPTION + " TEXT,"
                + KEY_ToDoListItem_LIST_COLOR + " TEXT,"
                + KEY_ToDoListItem_LIST_MORE_INFO + " TEXT,"
                + KEY_ToDoListItem_LIST_CREATED + " TEXT,"
                + KEY_ToDoListItem_LIST_LAST_UPDATED + " TEXT,"
                + KEY_ToDoListItem_LIST_PLANED_ACHIEVEMENT_DATE + " TEXT,"
                + KEY_ToDoListItem_LIST_ACHIEVED_DATE + " TEXT,"
                + KEY_ToDoListItem_LIST_ITEM_STATUS + " TEXT,"
                + KEY_ToDo_Id + " INTEGER" + ")";
        db.execSQL(CREATE_ToDoS_LIST_ITEMS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ToDoListItem_LIST);

        // Create tables again
        onCreate(db);

    }

}
