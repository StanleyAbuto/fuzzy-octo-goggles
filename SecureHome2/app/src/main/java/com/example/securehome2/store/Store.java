package com.example.securehome2.store;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.securehome2.R;

public class Store extends Fragment {
    public onBuySelected listener2;
    public onSellSelected listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store,container,false);
        CardView sell = view.findViewById(R.id.seller);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.sellText();
            }
        });
        CardView buy = view.findViewById(R.id.buyer);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener2.buyText();
            }
        });

        return view;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof onBuySelected) {
            listener2 = (onBuySelected) context;
        } if(context instanceof onSellSelected){
            listener = (onSellSelected) context;
        }else{
            throw new ClassCastException(context.toString() + "Must implement listener");
        }

    }

    public interface onBuySelected{
        void buyText();
    }
    public interface onSellSelected{
        void sellText();
    }

}
