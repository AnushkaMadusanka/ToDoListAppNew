package com.example.todolistappnew.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.todolistappnew.TodolistFragment;

public class ToDoPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ToDoPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        //returns to do list views
        switch (position) {
            case 0:

                TodolistFragment todolistFragment1=TodolistFragment.newInstance("0","to do tasks");
                return  todolistFragment1;
            case 1:

                TodolistFragment todolistFragment2=TodolistFragment.newInstance("1","done tasks");
                return todolistFragment2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
