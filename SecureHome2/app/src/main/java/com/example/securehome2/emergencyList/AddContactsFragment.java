package com.example.securehome2.emergencyList;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.securehome2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactsFragment extends Fragment implements View.OnClickListener {
    private OnDataSentListener onDataSentListener;
    private OnDataSentListener onNameSentListener;
    private OnDataSentListener onPhoneSentListener;

    private static String nameC;
    public static final String FILE_NAME = nameC;
    private static String numberC;
    public static final String FILE_CONTACT = numberC;
    public Object setOnDataSentListener;
    public Object setOnNameSentListener;
    public Object setOnPhoneSentListener;


    private NavController navController;
    private ImageView contactList;
    private CardView addContacts;

    private EditText contactName;
    private EditText phoneNumber;
    private boolean phoneFilled = false;
    private boolean nameFilled = false;
    private int sumName = 0;


    public AddContactsFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*Bundle sumNameB = new Bundle();
        sumNameB.putInt("sumName", sumName);

        Intent intent = new Intent(getActivity().getBaseContext(),EmergencyList.class);
        intent.putExtras(sumNameB);
        getActivity().startActivity(intent);
        Intent intent = new Intent(getActivity().getBaseContext(),EmergencyList.class);
        intent.putExtra("sumName", sumName);
        getActivity().startActivity(intent);



        Intent intentName = new Intent(getActivity().getBaseContext(),EmergencyList.class);
        intentName.putExtra("contactName", name1);
        getActivity().startActivity(intentName);

        Intent intentPhone = new Intent(getActivity().getBaseContext(),EmergencyList.class);
        intentPhone.putExtra("phoneNumber", phone1);
        getActivity().startActivity(intentPhone);*/
        return inflater.inflate(R.layout.fragment_add_contacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        contactList =  view.findViewById(R.id.contact_list);
        addContacts = view.findViewById(R.id.add_contact);
        contactName = view.findViewById(R.id.contact_name);
        phoneNumber = view.findViewById(R.id.phone_number);
        contactList.setOnClickListener(this);
        addContacts.setOnClickListener(this);

    }

    private void isPhoneFilled() {
        String contact = phoneNumber.getText().toString();
        if(contact.trim().length() == 10 && contact.trim().length() < 11) {
            phoneFilled = true;
        } else{
            phoneFilled = false;
        }
    }
    private void isNameFilled(){
        String name = contactName.getText().toString();
        if(name.trim().length() < 0){
            nameFilled = false;
        }else{
            nameFilled = true;
        }
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.contact_list:
                navController.navigate(R.id.action_addContactsFragment_to_contactList);
                break;
            case R.id.add_contact:
                if(nameFilled = true){
                    if(phoneFilled = true){
                            sumName += 1;
                        navController.navigate(R.id.action_addContactsFragment_to_contactList);
                    }
                }
                break;
        }
    }
    private void sendDataToContactList(Object data){
        if(onDataSentListener != null) onDataSentListener.onDataSentListener(data);
        data = sumName;
    }
    private void sendNameToContactList(String name){
        if(onNameSentListener != null) onNameSentListener.onNameSentListener(name);
        name = contactName.getText().toString();
    }
    private void sendPhoneToContactList(String phone){
        if(onPhoneSentListener != null) onPhoneSentListener.onPhoneSentListener(phone);
        phone = phoneNumber.getText().toString();
    }


    public void setOnDataSentListener(OnDataSentListener listener) {
        this.onDataSentListener = listener;
        this.onNameSentListener = listener;
        this.onPhoneSentListener = listener;
    }

}
