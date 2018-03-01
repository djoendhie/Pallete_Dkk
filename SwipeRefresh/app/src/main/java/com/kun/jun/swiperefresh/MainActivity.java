package com.kun.jun.swiperefresh;

import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

        SwipeRefreshLayout swLayout;
        LinearLayout llayout;
        TextView tvHello;

        @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Inisialisasi SwipeRefreshLayout
            swLayout = (SwipeRefreshLayout) findViewById(R.id.swlayout);

            llayout = (LinearLayout) findViewById(R.id.ll_swiperefresh);
            tvHello = (TextView) findViewById(R.id.tv_helloworld);

            // Mengeset properti warna yang berputar pada SwipeRefreshLayout
            swLayout.setColorSchemeResources(R.color.colorPrimary,R.color.colorPrimaryDark);

            // Mengeset listener yang akan dijalankan saat layar di refresh/swipe
            swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {

                    // Handler untuk menjalankan jeda selama 5 detik
                    new Handler().postDelayed(new Runnable() {
                        @Override public void run() {

                            // Berhenti berputar/refreshing
                            swLayout.setRefreshing(false);

                            // fungsi-fungsi lain yang dijalankan saat refresh berhenti
                            llayout.setBackground(ContextCompat.getDrawable(MainActivity.this, R.mipmap.ic_launcher_round));
                            tvHello.setText("Jegerrzzzzz");
                        }
                    }, 5000);
                }
            });
        }
    }
