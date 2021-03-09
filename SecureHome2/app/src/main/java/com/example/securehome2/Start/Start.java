package com.example.securehome2.Start;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.securehome2.R;

public class Start extends Fragment {
    private onAlertCardSelected listener4;
    private onHomeCardSelected listener5;
    private onEmergencyCardSelected listener6;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.start,container,false);
        CardView alert = view.findViewById(R.id.alertCard);
        alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener4.onAlertSelected();
            }
        });
        CardView home = view.findViewById(R.id.homeCard);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener5.onHomeSelected();
            }
        });
        CardView emergency = view.findViewById(R.id.listCard);
        emergency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener6.onEmergencySelected();
            }
        });
        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof onAlertCardSelected){
            listener4 = (onAlertCardSelected) context;
        }if(context instanceof onHomeCardSelected){
            listener5 = (onHomeCardSelected) context;
        }if(context instanceof onEmergencyCardSelected){
            listener6 = (onEmergencyCardSelected) context;
        }else {
            throw new ClassCastException(context.toString() + "Must implement listener");
        }

    }


    public interface onAlertCardSelected{
        void onAlertSelected();
    }
    public interface onHomeCardSelected{
        void onHomeSelected();
    }
    public interface onEmergencyCardSelected{
        void onEmergencySelected();
    }
}
