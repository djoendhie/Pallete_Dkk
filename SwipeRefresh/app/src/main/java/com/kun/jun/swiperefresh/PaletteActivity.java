package com.kun.jun.swiperefresh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {
    private TextView vibrantView;
    private TextView vibrantLightView;
    private TextView vibrantDarkView;
    private TextView mutedView;
    private TextView mutedLightView;
    private TextView mutedDarkView;

    Button button, button1, button2, button3, button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);

        button = (Button)findViewById(R.id.RL);
        button1 = (Button)findViewById(R.id.SC);
        button2 = (Button)findViewById(R.id.RE);
        button3 = (Button)findViewById(R.id.RB);
        button4 = (Button)findViewById(R.id.SB);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent p = new Intent(PaletteActivity.this, MainActivity.class);
                startActivity(p);
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent n = new Intent(PaletteActivity.this, SwitchCompat.class);
                startActivity(n);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent na = new Intent(PaletteActivity.this, RippleEffectActivity.class);
                startActivity(na);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nq = new Intent(PaletteActivity.this, RatingBarActivity.class);
                startActivity(nq);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nq = new Intent(PaletteActivity.this, BottomSheetActivity.class);
                startActivity(nq);
            }
        });
        initViews();
        paintTextBackground();
    }

    private void initViews() {
        vibrantView = (TextView) findViewById(R.id.tvVibrant);
        vibrantLightView = (TextView) findViewById(R.id.tvVibrantLight);
        vibrantDarkView = (TextView) findViewById(R.id.tvVibrantDark);
        mutedView = (TextView) findViewById(R.id.tvMuted);
        mutedLightView = (TextView) findViewById(R.id.tvMutedLight);
        mutedDarkView = (TextView) findViewById(R.id.tvMutedDark);
    }

    private void paintTextBackground() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.deco);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                // ambil warna dari gambar menggunakan Palette
                int defaultValue = 0x000000;
                int vibrant = palette.getVibrantColor(defaultValue);
                int vibrantLight = palette.getLightVibrantColor(defaultValue);
                int vibrantDark = palette.getDarkVibrantColor(defaultValue);
                int muted = palette.getMutedColor(defaultValue);
                int mutedLight = palette.getLightMutedColor(defaultValue);
                int mutedDark = palette.getDarkMutedColor(defaultValue);

                vibrantView.setBackgroundColor(vibrant);
                vibrantLightView.setBackgroundColor(vibrantLight);
                vibrantDarkView.setBackgroundColor(vibrantDark);
                mutedView.setBackgroundColor(muted);
                mutedLightView.setBackgroundColor(mutedLight);
                mutedDarkView.setBackgroundColor(mutedDark);
            }
        });

    }
}