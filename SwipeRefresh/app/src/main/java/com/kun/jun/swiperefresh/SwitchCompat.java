package com.kun.jun.swiperefresh;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SwitchCompat extends AppCompatActivity {
    private SwitchCompat switchCompat1;
    private SwitchCompat switchCompat2;
    private CompoundButton.OnCheckedChangeListener checkedChangeListener;
    private CompoundButton.OnCheckedChangeListener onCheckedChangeListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_switch_compat);

        switchCompat1 = (SwitchCompat) findViewById(R.id.sw_button).getContext();
        switchCompat2 = (SwitchCompat) findViewById(R.id.sw_button2).getContext();
        super.onCreate(savedInstanceState);

        checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SwitchCompat.this, compoundButton.getText()
                        + " is " + compoundButton.isChecked(), Toast.LENGTH_SHORT).show();
            }
        };

        switchCompat1.setOnCheckedChangeListener(checkedChangeListener);
        switchCompat2.setOnCheckedChangeListener(checkedChangeListener);
    }


/// ndak paralu sana nyo yg bawah ko lah ...pi error nyo kalo ndak pakai iko... ndak tw wak dek a lah hahahah
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }
}