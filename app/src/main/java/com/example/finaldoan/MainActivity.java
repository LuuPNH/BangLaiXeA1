package com.example.finaldoan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout bt_Thi, bt_BienBao,bt_OnThi,bt_DanhGia,bt_Video,bt_MeoThi;
    Dialog dialogSelect;
    Button btn_lyThuyet,btn_bienBao1,btn_saHinh,btn_cancels;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_Thi = (LinearLayout)findViewById(R.id.bt_thiSatHach);
        bt_BienBao = (LinearLayout)findViewById(R.id.bt_bienBao);
        bt_OnThi=(LinearLayout)findViewById(R.id.bt_onThi);
        bt_DanhGia=(LinearLayout)findViewById(R.id.bt_danhGia);
        bt_Video=(LinearLayout)findViewById(R.id.bt_meoGhiNho);
        bt_MeoThi=(LinearLayout)findViewById(R.id.bt_meoThucHanh);
        dialogSelect = new Dialog(this);
        dialogSelect.setContentView(R.layout.custom_dialog_select);
        dialogSelect.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogSelect.setCanceledOnTouchOutside(false);
        btn_lyThuyet=dialogSelect.findViewById(R.id.btn_select1);
        btn_bienBao1=dialogSelect.findViewById(R.id.btn_select2);
        btn_saHinh=dialogSelect.findViewById(R.id.btn_select3);
        btn_cancels=dialogSelect.findViewById(R.id.btn_cancels);

        bt_OnThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dialogSelect.show();
            }
        });
        bt_Thi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThiSatHach.class);
                startActivity(intent);
            }
        });
        bt_BienBao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bienbao = new Intent(MainActivity.this,BienBaoActivity.class);
                startActivity(bienbao);
            }
        });
        bt_DanhGia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DanhGiaActivity.class);
                startActivity(intent);
            }
        });
        bt_Video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ListVideo.class);
                startActivity(intent);
            }
        });
        bt_MeoThi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThiThucHanhActivity.class);
                startActivity(intent);
            }
        });
        btn_lyThuyet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThiSatHach.class);
                intent.putExtra("phanloai", "Ly thuyet");
                startActivityForResult(intent,69);
                dialogSelect.dismiss();
            }
        });
        btn_bienBao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThiSatHach.class);
                intent.putExtra("phanloai", "Bien bao");
                startActivityForResult(intent,69);
                dialogSelect.dismiss();
            }
        });
        btn_saHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ThiSatHach.class);
                intent.putExtra("phanloai", "Sa hinh");
                startActivityForResult(intent,69);
                dialogSelect.dismiss();
            }
        });
        btn_cancels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogSelect.dismiss();
            }
        });
    }

}
