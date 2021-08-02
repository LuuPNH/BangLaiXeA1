package com.example.finaldoan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class BienBaoActivity extends AppCompatActivity {

    Button btn_nguyhiem, btn_cam,btn_chidan,btn_hiẹulenh;
    ScrollView v_nguyhiem, v_cam, v_hieulenh, v_chidan;
    TextView tv_nguyhiem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bien_bao);
        btn_nguyhiem = (Button)findViewById(R.id.btnNguyHiem);
        btn_cam = (Button)findViewById(R.id.btnCam);
        btn_hiẹulenh = (Button)findViewById(R.id.btnHieuLenh);
        btn_chidan = (Button)findViewById(R.id.btnChiDan);
        v_nguyhiem = (ScrollView)findViewById(R.id.View_BBNguyHiem);
        v_hieulenh = (ScrollView)findViewById(R.id.View_BBHieuLenh);
        v_chidan = (ScrollView)findViewById(R.id.View_BBChiDan);
        v_cam = (ScrollView)findViewById(R.id.View_BBCam);
        tv_nguyhiem = (TextView)findViewById(R.id.tv_BBNguyHiem);

        btn_nguyhiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_nguyhiem.setVisibility(View.VISIBLE);
                v_cam.setVisibility(View.GONE);
                v_chidan.setVisibility(View.GONE);
                v_hieulenh.setVisibility(View.GONE);
                tv_nguyhiem.setText("Biển báo nguy hiểm");
            }
        });
        btn_cam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_nguyhiem.setVisibility(View.GONE);
                v_cam.setVisibility(View.VISIBLE);
                v_chidan.setVisibility(View.GONE);
                v_hieulenh.setVisibility(View.GONE);
                tv_nguyhiem.setText("Biển báo cấm");
            }
        });
        btn_hiẹulenh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_nguyhiem.setVisibility(View.GONE);
                v_cam.setVisibility(View.GONE);
                v_chidan.setVisibility(View.GONE);
                v_hieulenh.setVisibility(View.VISIBLE);
                tv_nguyhiem.setText("Biển báo hiệu lệnh.");
            }
        });
        btn_chidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v_nguyhiem.setVisibility(View.GONE);
                v_cam.setVisibility(View.GONE);
                v_chidan.setVisibility(View.VISIBLE);
                v_hieulenh.setVisibility(View.GONE);
                tv_nguyhiem.setText("Biển báo chỉ dẫn");
            }
        });
    }
}
