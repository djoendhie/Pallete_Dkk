package com.kun.jun.swiperefresh;

import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BottomSheetActivity extends AppCompatActivity {

    private Button btShow;
    private Button btHide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_bottom_sheet);
        setupToolbar();

        //Inisialisasi LinearLayout sebagai base bottom sheet view
        final View bottomsheet = findViewById(R.id.bs_ll);

        //Assign LinearLayout tersebut ke BottomSheetBehavior
        final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);

        //Set BottomSheet view supaya bisa disembunyikan semuanya
        bottomSheetBehavior.setHideable(true);

        //Inisialisasi tombol
        btShow = findViewById(R.id.bt_show);
        btHide = findViewById(R.id.bt_hide);

        //Set listener dan set BottomSheet state
        btShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED){
                    btShow.setText("tutuik Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }else{
                    btShow.setText("nampak-an Bottom Sheet");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        btHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_HIDDEN){
                    btHide.setText("andok an");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }else{
                    btHide.setText("cigok");
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }
        });

        super.onCreate(savedInstanceState);
    }

    private void setupToolbar() {

    }

}