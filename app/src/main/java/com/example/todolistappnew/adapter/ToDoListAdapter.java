package com.example.todolistappnew.adapter;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.todolistappnew.R;
import com.example.todolistappnew.TodolistFragment;
import com.example.todolistappnew.data.ToDoListItem;

import java.util.ArrayList;
import java.util.List;

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.MyViewHolder> implements Filterable {

    private List<ToDoListItem> todolist;
    private List<ToDoListItem> todolistFiltered;
    private int type;
    private int goal_category_id;
    public TodolistFragment todoFragment;


    public ToDoListAdapter(List<ToDoListItem> toDoListItems, int type, TodolistFragment fragment) {

        this.todolist = toDoListItems;
        this.todolistFiltered = toDoListItems;
        this.type = type;
        this.todoFragment = (TodolistFragment) fragment;


    }


    @Override
    public ToDoListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_goallist_list_item, parent, false);
        SharedPreferences prefs = parent.getContext().getSharedPreferences("BackTarget", MODE_PRIVATE);
        goal_category_id = prefs.getInt("goal_category_id", 1);//"No name defined" is the default value.

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ToDoListAdapter.MyViewHolder holder, int position) {

        ToDoListItem item = todolistFiltered.get(position);
        holder.name.setText(item.getToDoListItemName());


        holder.date.setText(item.getToDoListItemDescription());


        if (item.getToDoListItemBackgroundColor() != null) {

            if (Integer.parseInt(item.getToDoListItemBackgroundColor()) == 1) {


                holder.buttonsLayout.setVisibility(View.VISIBLE);


            } else {

                holder.buttonsLayout.setVisibility(View.INVISIBLE);

            }

        } else {


        }


    }

    @Override
    public int getItemCount() {
        return todolistFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    todolistFiltered = todolist;
                } else {
                    List<ToDoListItem> filteredList = new ArrayList<>();
                    for (ToDoListItem item : todolist) {

                        if (item.getToDoListItemName().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(item);
                        }
                    }

                    todolistFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = todolistFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                todolistFiltered = (ArrayList<ToDoListItem>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView name, date;
        public ImageButton achievedButton;
        public ImageButton button, closeButton, deleteButton, editButton;
        public LinearLayout buttonsLayout;


        public MyViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.tvGoallistName);
            date = view.findViewById(R.id.tvGoalListAchieveDate);
            achievedButton = view.findViewById(R.id.button_action_plan);
            achievedButton.setOnClickListener(this);
            name.setOnClickListener(this);
            date.setOnClickListener(this);
            button = view.findViewById(R.id.imageButtonMarkAsDone);
            closeButton = view.findViewById(R.id.imageButtonClose);
            deleteButton = view.findViewById(R.id.imageButtonDelete);
            editButton = view.findViewById(R.id.imageButtonEdit);
            buttonsLayout = view.findViewById(R.id.tasklistbuttons);
            button.setOnClickListener(this);
            closeButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            editButton.setOnClickListener(this);
            name.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {

            if (v == button) {


                todoFragment.markAsAchieved(getAdapterPosition());


            } else if (v == deleteButton) {


                todoFragment.deleteRow(getAdapterPosition());


            } else if (v == closeButton) {


                todoFragment.closeButtonsRow(getAdapterPosition());


            } else if (v == editButton) {


                todoFragment.viewUpdateFragment(getAdapterPosition());


            } else {


                todoFragment.viewListWithButtons(getAdapterPosition());


            }

        }
    }

}
