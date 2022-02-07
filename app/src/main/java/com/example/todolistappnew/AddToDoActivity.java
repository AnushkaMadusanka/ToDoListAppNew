package com.example.todolistappnew;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import com.example.todolistappnew.adapter.MyDialog;
import com.example.todolistappnew.data.ToDoDataManager;
import com.example.todolistappnew.data.ToDoListItem;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddToDoActivity extends AppCompatActivity {

    private String date;
    private int mYear, mMonth, mDay;
    private String currentDate;
    Calendar calendar;
    SimpleDateFormat mdformat;
    private String goalStatus;
    private ImageButton closeImageButton;
    private ImageButton clearImageButton;
    private ImageButton setTimeImageButton;
    public ImageButton addNotificationImageButton;
    private ImageButton saveImageButton;

    private EditText goalContent;
    private TextView rangeTextView;
    public TextView reminderTextView;
    public Calendar calendarForReminder;

    private View horizontalView;
    public View horizontalViewReminder;

    // private RemindersDataManager remindersDataManager;
    private long rounded;
    private int goalCategoryId;

    private ToDoDataManager dbManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_add_goal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        goalStatus = getIntent().getStringExtra("status");

        dbManager = new ToDoDataManager(this);
        dbManager.open();

        calendar = Calendar.getInstance();
        mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        currentDate = mdformat.format(calendar.getTime());


        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        int correctMonthint = mMonth + 1;

        //set date to the right format
        if (correctMonthint < 10 && mDay < 10) {

            date = mYear + " / " + "0" + correctMonthint + " / " + "0" + mDay;

        } else if (correctMonthint < 10 && mDay >= 10) {

            date = mYear + " / " + "0" + correctMonthint + " / " + mDay;

        } else if (correctMonthint >= 10 && mDay < 10) {

            date = mYear + " / " + correctMonthint + " / " + "0" + mDay;


        } else {

            date = mYear + " / " + correctMonthint + " / " + mDay;
        }


        rangeTextView = (TextView) findViewById(R.id.tvRange);
        reminderTextView = (TextView) findViewById(R.id.tvReminder);

        horizontalView = (View) findViewById(R.id.view_horizontal_line);
        horizontalViewReminder = (View) findViewById(R.id.view_horizontal_line_reminder);

        closeImageButton = (ImageButton) findViewById(R.id.imageButtonClose);

        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(AddToDoActivity.this, ToDoMainActivity.class);

                startActivity(intent);

            }
        });


        goalContent = (EditText) findViewById(R.id.etTask);


        clearImageButton = (ImageButton) findViewById(R.id.imageButtonClear);

        clearImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goalContent.setText(" ");
            }
        });


        setTimeImageButton = (ImageButton) findViewById(R.id.imageButtonTimeRange);

        setTimeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewDatePickerDialog();
            }
        });


        saveImageButton = (ImageButton) findViewById(R.id.imageButtonSave);

        saveImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (String.valueOf(goalContent.getText().toString()).equals("")) {


                    new MyDialog().openConfirmDialog(AddToDoActivity.this, "Empty field", "Please, add a content");


                }
                if (false) {


                    new MyDialog().openConfirmDialog(AddToDoActivity.this, "Empty field", "Please, set the time");


                } else {


                    if (calendarForReminder != null) {

                        setAlarm(calendarForReminder);


                    }

                    dbManager.addToDoListItem(new ToDoListItem(
                            goalContent.getText().toString(),
                            "desc",
                            currentDate,
                            currentDate,
                            goalStatus,
                            date,
                            goalCategoryId));

                    Intent main = new Intent(AddToDoActivity.this, ToDoMainActivity.class)
                            .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    main.putExtra("result", "1");
                    //dialog.dismiss();
                    startActivity(main);

                }

            }
        });


    }


    private void setAlarm(Calendar targetCal) {


    }


    private void viewDatePickerDialog() {

        // Get Current Date
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        // targetedDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        mYear = year;


                        mMonth = monthOfYear + 1;

                        mDay = dayOfMonth;

                        if (mMonth < 10 && mDay < 10) {

                            date = mYear + " / " + "0" + mMonth + " / " + "0" + mDay;

                        } else if (mMonth < 10 && mDay >= 10) {

                            date = mYear + " / " + "0" + mMonth + " / " + mDay;

                        } else if (mMonth >= 10 && mDay < 10) {

                            date = mYear + " / " + mMonth + " / " + "0" + mDay;


                        } else {

                            date = mYear + " / " + mMonth + " / " + mDay;
                        }

                        Log.i("datebug", "came here" + date + "  year  " + mYear + " month  " + mMonth + " day " + " " + mDay);

                        rangeTextView.setText(date);
                        setTimeImageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_clock));
                        saveImageButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_save));
                        horizontalView.setVisibility(View.VISIBLE);


                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();


    }

}