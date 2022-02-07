package com.example.todolistappnew.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.todolistappnew.R;

public class MyDialog {

    private int result = 0;

    public void openDialog(Context context, String mainTitle, String title, String description, final int category) {
        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_demo_mission);
        dialog.setTitle(mainTitle);
        Button dialogButtonCancel = dialog.findViewById(R.id.dialog_cancel);
        Button dialogButtonOk = dialog.findViewById(R.id.dialog_ok);
        TextView dialogDesc = dialog.findViewById(R.id.dialog_message);
        dialogDesc.setText(description);

        if (category == 0) {

            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

            dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();

                }
            });

            dialog.show();

        } else if (category == 1) {

            dialogButtonOk.setText("OK");

            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    dialog.dismiss();
                }
            });


            dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    dialog.dismiss();

                }
            });

            dialog.show();


        } else if (category == 2) {

            dialogButtonOk.setText("OK");

            dialogButtonCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    dialog.dismiss();
                }
            });


            dialogButtonOk.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    dialog.dismiss();

                }
            });

            dialog.show();

        }
    }

    public void openConfirmDialog(Context context, String title, String description) {

        final Dialog dialog = new Dialog(context);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_confirm);
        dialog.setTitle(title);
        Button dialogButtonOk = dialog.findViewById(R.id.dialog_ok);
        dialogButtonOk.setText("OK");
        TextView dialogDesc = dialog.findViewById(R.id.dialog_message);
        dialogDesc.setText(description);


        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();

            }
        });

        dialog.show();

    }


    public int openSaveDialog(Context context, String title, String description) {

        final Dialog dialog = new Dialog(context); // Context, this, etc.

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_save);
        dialog.setTitle(title);
        Button dialogButtonOk = dialog.findViewById(R.id.dialog_ok);
        Button dialogCancel = dialog.findViewById(R.id.dialog_cancel);
        dialogButtonOk.setText("OK");
        TextView dialogDesc = dialog.findViewById(R.id.dialog_message);
        dialogDesc.setText(description);


        dialogButtonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();


            }
        });


        dialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                dialog.dismiss();

            }
        });

        dialog.show();

        return result;

    }
}
