package com.example.todolistappnew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;

import com.example.todolistappnew.adapter.ToDoPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class ToDoMainActivity extends AppCompatActivity implements TodolistFragment.OnFragmentInteractionListener, UpdateToDoFragment.OnFragmentInteractionListener{

    //define tabs for to do tasks
    TabLayout todoTabs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("My To Do List");

        todoTabs = findViewById(R.id.tab_layout);


        //set images to tabs
        todoTabs.addTab(todoTabs.newTab().setIcon(R.drawable.ic_todo));

        todoTabs.addTab(todoTabs.newTab().setIcon(R.drawable.ic_done));

        todoTabs.setTabGravity(TabLayout.GRAVITY_FILL);

        //set fragments for tabs

        final ViewPager viewPager = findViewById(R.id.todo_pager);


        final ToDoPagerAdapter adapter = new ToDoPagerAdapter
                (getSupportFragmentManager(), todoTabs.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(todoTabs));
        todoTabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}