package com.example.todolistappnew;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.todolistappnew.data.ToDoDataManager;
import com.example.todolistappnew.data.ToDoListItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UpdateToDoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdateToDoFragment extends DialogFragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ImageButton closeImageButton;
    private ImageButton saveImageButton;


    public static Fragment parentFragment;
    public static int fragmentTypeOfParent;
    private static ToDoListItem goal;

    private EditText materialEditText;
    private static Object objectCame;

    private ToDoDataManager dbManager;

    public UpdateToDoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment UpdateToDoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UpdateToDoFragment newInstance(String param1, int fragemtType, Fragment fragmentToDeal, Object object) {
        UpdateToDoFragment fragment = new UpdateToDoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);

        fragment.setArguments(args);

        parentFragment = fragmentToDeal;
        fragmentTypeOfParent = fragemtType;

        objectCame = object;


        goal = (ToDoListItem) object;


        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_update_tasks, container, false);


        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        materialEditText = (EditText) view.findViewById(R.id.etTask);
        materialEditText.setText(mParam1);


        dbManager = new ToDoDataManager(getActivity());
        dbManager.open();

        closeImageButton = (ImageButton) view.findViewById(R.id.imageButtonClose);

        closeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDialog().dismiss();


            }
        });

        saveImageButton = (ImageButton) view.findViewById(R.id.imageButtonSave);

        saveImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String newGoal = materialEditText.getText().toString();

                if ((materialEditText.getText().toString()).equals("")) {


                } else {


                    goal.setToDoListItemName(newGoal);

                    Toast.makeText(getActivity(), "Updated successfully", Toast.LENGTH_LONG).show();
                }


                dbManager.updateToDoListItem(goal);


                TodolistFragment todolistFragment = (TodolistFragment) parentFragment;
                todolistFragment.setUserVisibleHint(true);
                getDialog().dismiss();


            }


        });


        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(getActivity());
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
