package com.example.securehome2.alert;


import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.securehome2.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.io.IOException;



/**
 * A simple {@link Fragment} subclass.
 */
public class RecordFragment extends Fragment implements View.OnClickListener{
    private ConstraintLayout editName;
    private BottomSheetBehavior bottomSheetBehavior;
    private NavController navController;
    private ImageView listBtn;
    private ImageView recordBtn;
    private boolean isRecording = false;
    private String recordPermission = Manifest.permission.RECORD_AUDIO;
    private int PERMISSION_CODE = 2;
    private MediaRecorder mediaRecorder;

    private String recordFile2;

    private Chronometer timer;
    private TextView filenameText;

    private CardView saveBtn;
    private EditText recordingName;
    private int btn;
    private boolean nameType = false;





    public RecordFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_record, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editName = view.findViewById(R.id.edit_sheet);
        bottomSheetBehavior = BottomSheetBehavior.from(editName);
        saveBtn= view.findViewById(R.id.saveCard);

        recordingName =  view.findViewById(R.id.recording_name);

        navController = Navigation.findNavController(view);
        listBtn = view.findViewById(R.id.record_list_btn);
        recordBtn = view.findViewById(R.id.record_button);
        timer = view.findViewById(R.id.recorder_timer);
        filenameText = view.findViewById(R.id.record_filename);

        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState == BottomSheetBehavior.STATE_HIDDEN){
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRecording();
                btn = 1;
                nameType = true;

            }
        });

        listBtn.setOnClickListener(this);
        recordBtn.setOnClickListener(this);



    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.record_list_btn:
                if(isRecording){
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
                    alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            navController.navigate(R.id.action_recordFragment_to_audioListFragment);
                            isRecording = false;
                        }
                    });
                    alertDialog.setNegativeButton("No", null);
                    alertDialog.setTitle("Audio still recording");
                    alertDialog.setMessage("Are you sure you want to stop the recording?");
                    alertDialog.create().show();
                }else{
                    navController.navigate(R.id.action_recordFragment_to_audioListFragment);
                }

                break;
            case R.id.record_button:
                if(isRecording){
                    stopRecording();
                    isRecording = false;
                    recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.recordstop, null));

                }else{
                    if(checkPermissions()){
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        if(nameType = true){

                            recordBtn.setImageDrawable(getResources().getDrawable(R.drawable.recordbtn, null));
                            isRecording = true;
                        }

                    }

                }
                break;
        }
    }




    public void stopRecording() {
        timer.stop();
        mediaRecorder.stop();
        mediaRecorder.release();
        mediaRecorder = null;
        filenameText.setText("Recording stopped");

    }
        /**/
    public void startRecording() {
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
        String recordPath = getActivity().getExternalFilesDir("/").getAbsolutePath();


        String name = recordingName.getText().toString();
        if(name.trim().length() > 0){
            if(nameType = true){
                recordFile2 = name + ".3gp";
                filenameText.setText("Recording:  " + recordFile2);
                mediaRecorder = new MediaRecorder();
                mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
                mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);

                mediaRecorder.setOutputFile(recordPath + "/" + recordFile2);

                mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

                try {
                    mediaRecorder.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaRecorder.start();
            }
        }





    }

    private boolean checkPermissions() {
        if(ActivityCompat.checkSelfPermission(getContext(), recordPermission )== PackageManager.PERMISSION_GRANTED){
            return true;
        }else{
            ActivityCompat.requestPermissions(getActivity(), new String[]{recordPermission}, PERMISSION_CODE);
            return false;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if(isRecording){
            stopRecording();
        }
    }


}
