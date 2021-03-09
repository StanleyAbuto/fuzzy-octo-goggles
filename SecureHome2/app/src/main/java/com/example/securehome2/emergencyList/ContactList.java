package com.example.securehome2.emergencyList;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.securehome2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactList extends Fragment /*implements View.OnClickListener*/ {

    private TextView listTitle;
    private TextView listTitle2;
    private TextView listTitle3;
    private TextView listTitle4;
    private TextView listTitle5;
    private TextView listTitle6;
    private TextView listTitle7;
    private TextView listTitle8;
    private TextView listTitle9;
    private TextView listTitle10;
    private TextView listTitle11;

    private TextView listContact;
    private TextView listContact2;
    private TextView listContact3;
    private TextView listContact4;
    private TextView listContact5;
    private TextView listContact6;
    private TextView listContact7;
    private TextView listContact8;
    private TextView listContact9;
    private TextView listContact10;
    private TextView listContact11;
    int sumName;
    String contactName;
    String contactPhone;

    private void initReciever(){
        ((EmergencyList)getActivity()).setOnDataSentListener(new OnDataSentListener() {
            @Override
            public void onDataSentListener(Object data) {
                sumName = (int) data;
            }

            @Override
            public void onNameSentListener(String name) {
                contactName = name;
            }

            @Override
            public void onPhoneSentListener(String phone) {
                contactPhone = phone;
            }
        });
    }


    public ContactList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*sumName = getArguments().getString("sumName");*/
        //contactName = getArguments().getString("contactName");
        /*contactPhone = getArguments().getString("contactPhone");*/
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CardView delete = view.findViewById(R.id.delete_btn);
        CardView delete2 = view.findViewById(R.id.delete_btn2);
        CardView delete3 = view.findViewById(R.id.delete_btn3);
        CardView delete4 = view.findViewById(R.id.delete_btn4);
        CardView delete5 = view.findViewById(R.id.delete_btn5);
        CardView delete6 = view.findViewById(R.id.delete_btn6);
        CardView delete7 = view.findViewById(R.id.delete_btn7);
        CardView delete8 = view.findViewById(R.id.delete_btn8);
        CardView delete9 = view.findViewById(R.id.delete_btn9);
        CardView delete10 = view.findViewById(R.id.delete_btn10);
        CardView delete11 = view.findViewById(R.id.delete_btn11);

        listTitle = view.findViewById(R.id.list_title);
        listTitle2 = view.findViewById(R.id.list_title2);
        listTitle3 = view.findViewById(R.id.list_title3);
        listTitle4 = view.findViewById(R.id.list_title4);
        listTitle5 = view.findViewById(R.id.list_title5);
        listTitle6 = view.findViewById(R.id.list_title6);
        listTitle7 = view.findViewById(R.id.list_title7);
        listTitle8 = view.findViewById(R.id.list_title8);
        listTitle9 = view.findViewById(R.id.list_title9);
        listTitle10 = view.findViewById(R.id.list_title10);
        listTitle11 = view.findViewById(R.id.list_title11);

        listContact = view.findViewById(R.id.list_contact);
        listContact2 = view.findViewById(R.id.list_contact2);
        listContact3 = view.findViewById(R.id.list_contact3);
        listContact4 = view.findViewById(R.id.list_contact4);
        listContact5 = view.findViewById(R.id.list_contact5);
        listContact6 = view.findViewById(R.id.list_contact6);
        listContact7 = view.findViewById(R.id.list_contact7);
        listContact8 = view.findViewById(R.id.list_contact8);
        listContact9 = view.findViewById(R.id.list_contact9);
        listContact10 = view.findViewById(R.id.list_contact10);
        listContact11 = view.findViewById(R.id.list_contact11);

       /* delete.setOnClickListener(this);
        delete2.setOnClickListener(this);
        delete3.setOnClickListener(this);
        delete4.setOnClickListener(this);
        delete5.setOnClickListener(this);
        delete6.setOnClickListener(this);
        delete7.setOnClickListener(this);
        delete8.setOnClickListener(this);
        delete9.setOnClickListener(this);
        delete10.setOnClickListener(this);
        delete11.setOnClickListener(this);*/


        if(sumName == 1){
            editDetails();
        }else if(sumName == 2){
            editDetails2();
        }else if(sumName == 3){
            editDetails3();
        }else if(sumName == 4){
            editDetails4();
        }else if(sumName == 5){
            editDetails5();
        }else if(sumName == 6) {
            editDetails6();
        }else if(sumName == 7) {
            editDetails7();
        }else if(sumName == 8) {
            editDetails8();
        }else if(sumName == 9) {
            editDetails9();
        }else if(sumName == 10) {
            editDetails10();
        }else if(sumName == 11) {
            editDetails11();
        }
    }
//handle delete after sorting general logic of app
    /*@Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.delete_btn:

                break;
            case R.id.delete_btn2:

                break;
            case R.id.delete_btn3:

                break;
            case R.id.delete_btn4:

                break;
            case R.id.delete_btn5:

                break;
            case R.id.delete_btn6:

                break;
            case R.id.delete_btn7:

                break;
            case R.id.delete_btn8:

                break;
            case R.id.delete_btn9:

                break;
            case R.id.delete_btn10:

                break;
            case R.id.delete_btn11:

                break;


        }
    }*/
    private void editDetails(){
        listTitle.setText(contactName);
        listContact.setText(contactPhone);
    }
    private void editDetails2(){
        listTitle2.setText(contactName);
        listContact2.setText(contactPhone);
    }
    private void editDetails3(){
        listTitle3.setText(contactName);
        listContact3.setText(contactPhone);
    }
    private void editDetails4(){
        listTitle4.setText(contactName);
        listContact4.setText(contactPhone);
    }
    private void editDetails5(){
        listTitle5.setText(contactName);
        listContact5.setText(contactPhone);
    }
    private void editDetails6(){
        listTitle6.setText(contactName);
        listContact6.setText(contactPhone);
    }
    private void editDetails7(){
        listTitle7.setText(contactName);
        listContact7.setText(contactPhone);
    }
    private void editDetails8(){
        listTitle8.setText(contactName);
        listContact8.setText(contactPhone);
    }
    private void editDetails9(){
        listTitle9.setText(contactName);
        listContact9.setText(contactPhone);
    }
    private void editDetails10(){
        listTitle10.setText(contactName);
        listContact10.setText(contactPhone);
    }
    private void editDetails11(){
        listTitle11.setText(contactName);
        listContact11.setText(contactPhone);
    }
}
