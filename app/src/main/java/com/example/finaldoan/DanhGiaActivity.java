package com.example.finaldoan;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DanhGiaActivity extends AppCompatActivity {
    Button btn_xacnhan, btn_dongy,btn_huy;
    RatingBar ratingBar;
    EditText editText;
    String x = "";
    Dialog dialogDanhGia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_gia);
        btn_xacnhan = (Button)findViewById(R.id.OKe);


        ratingBar = (RatingBar)findViewById(R.id.ratingBar);
        editText = (EditText)findViewById(R.id.edit_danhgia);
        dialogDanhGia = new Dialog(this);
        dialogDanhGia.setContentView(R.layout.custom_diglog_danhgia);
        dialogDanhGia.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogDanhGia.setCanceledOnTouchOutside(false);
        btn_dongy = dialogDanhGia.findViewById(R.id.btn_dongydanhgia);
        btn_huy = dialogDanhGia.findViewById(R.id.btn_huydanhgia);
        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDanhGia.show();

            }
        });
        btn_dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Toast.makeText(DanhGiaActivity.this, "Cảm ơn bạn đã đóng góp ý kiến!", Toast.LENGTH_LONG).show();
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogDanhGia.dismiss();
            }
        });
    }
}
