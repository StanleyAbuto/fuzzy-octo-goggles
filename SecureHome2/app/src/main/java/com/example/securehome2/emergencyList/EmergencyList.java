package com.example.securehome2.emergencyList;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.securehome2.R;

public class EmergencyList extends AppCompatActivity {
    private OnDataSentListener onDataSentListener;
    private OnDataSentListener onNameSentListener;
    private OnDataSentListener onPhoneSentListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_list);

        //try replacing "from activity" with the variable names
        /*Intent intent = getIntent();
        String sumName = intent.getStringExtra("sumName");

        Bundle bundle = new Bundle();
        bundle.putString("sumName", sumName);
        ContactList contactList = new ContactList();
        contactList.setArguments(bundle);

        Intent intentName = getIntent();
        String contactName = intentName.getStringExtra("contactName");

        Bundle bundleName = new Bundle();
        bundleName.putString("contactName", contactName);
        ContactList contactListName = new ContactList();
        contactListName.setArguments(bundleName);

        Intent intentPhone = getIntent();
        String contactPhone = intentPhone.getStringExtra("contactPhone");

        Bundle bundlePhone = new Bundle();
        bundlePhone.putString("contactPhone", contactPhone);
        ContactList contactListPhone = new ContactList();
        contactListPhone.setArguments(bundlePhone);*/


        FragmentTransaction trans = getFragmentManager().beginTransaction();
        AddContactsFragment acf = new AddContactsFragment();
        ContactList cl = new ContactList();

        acf.setOnDataSentListener(new OnDataSentListener(){

            @Override
            public void onDataSentListener(Object data) {
                if(onDataSentListener != null) onDataSentListener.onDataSentListener(data);
            }

            @Override
            public void onNameSentListener(String name) {
                if(onNameSentListener != null) onNameSentListener.onNameSentListener(name);
            }

            @Override
            public void onPhoneSentListener(String phone) {
                if(onPhoneSentListener != null) onPhoneSentListener.onPhoneSentListener(phone);
            }


        });
        trans.commit();
    }
    public void setOnDataSentListener(OnDataSentListener listener){
        this.onDataSentListener = listener;
        this.onNameSentListener = listener;
        this.onPhoneSentListener = listener;
    }



}
//for the checkbox you should use shared preferences tutorial
