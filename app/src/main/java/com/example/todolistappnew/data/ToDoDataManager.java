package com.example.todolistappnew.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class ToDoDataManager {


    private DatabaseHandler databaseHelper;

    private Context context;

    private SQLiteDatabase database;

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


    public ToDoDataManager(Context c) {
        context = c;
    }

    public ToDoDataManager open() throws SQLException {
        databaseHelper = new DatabaseHandler(context);
        database = databaseHelper.getWritableDatabase();
        return this;
    }


    // Adding new ToDoListItem
    public void addToDoListItem(ToDoListItem ToDoListItem) {


        // Get Current Date
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);
        String lastUpdatedDate = mYear + "/" + mMonth + "/" + mDay;


        ContentValues values = new ContentValues();
        values.put(KEY_ToDoListItem_LIST_NAME, ToDoListItem.getToDoListItemName()); // ToDoListItem Name
        values.put(KEY_ToDoListItem_LIST_DESCRIPTION, ToDoListItem.getToDoListItemDescription()); // ToDoListItem Description
        values.put(KEY_ToDoListItem_LIST_CREATED, ToDoListItem.getToDoListItemCreatedDate()); // ToDoListItem created date
        values.put(KEY_ToDoListItem_LIST_PLANED_ACHIEVEMENT_DATE, ToDoListItem.getToDoListItemPlanedAchievDate()); // ToDoListItem planned complition date
        values.put(KEY_ToDoListItem_LIST_ITEM_STATUS, ToDoListItem.getToDoListItemStatus()); // ToDoListItem status
        values.put(KEY_ToDoListItem_LIST_LAST_UPDATED, lastUpdatedDate); // ToDoListItem last updated
        values.put(KEY_ToDo_Id, ToDoListItem.getGoalId());


        // Inserting Row
        database.insert(TABLE_ToDoListItem_LIST, null, values);

        // database.close();

    }


    // Getting All ToDoListItem_list
    public ArrayList<ToDoListItem> getAllToDoListItem_list() {
        ArrayList<ToDoListItem> ToDoListItemList = new ArrayList<ToDoListItem>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ToDoListItem_LIST;


        Cursor cursor = database.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                ToDoListItem ToDoListItem = new ToDoListItem();
                ToDoListItem.setToDoListItemId(Integer.parseInt(cursor.getString(0)));
                ToDoListItem.setToDoListItemName(cursor.getString(1));
                ToDoListItem.setToDoListItemMoreInfo(cursor.getString(2));
                ToDoListItem.setToDoListItemBackgroundColor(cursor.getString(3));
                ToDoListItem.setToDoListItemMoreInfo(cursor.getString(4));
                ToDoListItem.setToDoListItemCreatedDate(cursor.getString(5));
                ToDoListItem.setToDoListItemLatUpdatedDate(cursor.getString(6));
                ToDoListItem.setToDoListItemPlanedAchievDate(cursor.getString(7));
                ToDoListItem.setToDoListItemAchievedDate(cursor.getString(8));
                ToDoListItem.setToDoListItemStatus(cursor.getString(9));
                ToDoListItem.setGoalId(Integer.parseInt(cursor.getString(10)));

                // Adding ToDoListItem to list
                ToDoListItemList.add(ToDoListItem);
            } while (cursor.moveToNext());
        }

        //  cursor.close();
        // return ToDoListItem list
        return sortByDate(ToDoListItemList);
    }


    // Updating single ToDoListItem
    public int updateToDoListItem(ToDoListItem ToDoListItem) {
        // SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ToDoListItem_LIST_NAME, ToDoListItem.getToDoListItemName());
        values.put(KEY_ToDoListItem_LIST_DESCRIPTION, ToDoListItem.getToDoListItemDescription());
        values.put(KEY_ToDoListItem_LIST_PLANED_ACHIEVEMENT_DATE, ToDoListItem.getToDoListItemPlanedAchievDate());
        values.put(KEY_ToDoListItem_LIST_LAST_UPDATED, ToDoListItem.getToDoListItemLatUpdatedDate());
        values.put(KEY_ToDoListItem_LIST_ITEM_STATUS, ToDoListItem.getToDoListItemStatus());

        // updating row
        int result = database.update(TABLE_ToDoListItem_LIST, values, KEY_ToDoListItem_LIST_NAMES_LIST_ID + " = ?",
                new String[]{String.valueOf(ToDoListItem.getToDoListItemId())});

        //  database.close();

        return result;


    }

    // Deleting single ToDoListItem
    public void deleteToDoListItem(ToDoListItem ToDoListItem) {

        database.delete(TABLE_ToDoListItem_LIST, KEY_ToDoListItem_LIST_NAMES_LIST_ID + " = ?",
                new String[]{String.valueOf(ToDoListItem.getToDoListItemId())});
        // database.close();
    }


    private ArrayList<ToDoListItem> sortByDate(ArrayList<ToDoListItem> goalsToSort) {


        ArrayList<ToDoListItem> sorted_goals_by_date = new ArrayList<>();


        for (ToDoListItem goal : goalsToSort) {

            String date = goal.getToDoListItemPlanedAchievDate();
            if (date != null) {

                sorted_goals_by_date.add(goal);

            }


        }


        for (ToDoListItem goal : sorted_goals_by_date) {

            String date = goal.getToDoListItemPlanedAchievDate();
            if (date != null) {
                String year = date.substring(0, 4);
                String month = date.substring(7, 9);
                String day = date.substring(12, 14);

                String dayMerged = year + month + day;
                //     int dayInt = Integer.parseInt(dayMerged);
                goal.setToDoListItemMoreInfo(dayMerged);

            } else {

            }


        }


        Collections.sort(sorted_goals_by_date, new Comparator<ToDoListItem>() {
            public int compare(ToDoListItem obj1, ToDoListItem obj2) {

                return Integer.valueOf(Integer.parseInt(obj1.getToDoListItemMoreInfo())).compareTo(Integer.parseInt(obj2.getToDoListItemMoreInfo())); // To compare integer values


            }
        });
        return sorted_goals_by_date;


    }


}
