package com.example.finaldoan;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.finaldoan.Adapter.MyDB;
import com.example.finaldoan.Models.Question;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class ThiSatHach extends AppCompatActivity {

    int currentQuestion = 0, totalPoint=0 ,minutes,seconds;
    final long COUNTDOWN_IN_MILLIS = 900000;
    long timeLeftInMillis;
    String phanloaiFromIntent;
    CountDownTimer countDownTimer;
    Dialog dialogFinish,dialogHetGio;
    CheckBox cb_A,cb_B,cb_C,cb_D;
    Button btnLui,btnTien,btn_dongy,btn_huy,btn_cancel,btnKetThuc;
    TextView tv_cauhoi, tv_stt, tv_time;
    LinearLayout linearLayout_OK,linearLayout_cauHoi;
    ImageView anhCauHoi;

    ArrayList<Question> questions = new ArrayList<>();
    ArrayList<Question> Newquestions = new ArrayList<>();
    ArrayList<String> userAnswer = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thi_sat_hach);
        Initialize();
        PracticeOrStudy();
        hienThiSoCauHoi();

    }

    private void chuyen_cau_hoi_P() {
        unCheckCauHoi();
        switch (questions.get(currentQuestion).getSo_cau_tra_loi()) {
            case "2":
                chuyen_2_cau();
                suKienClick_P();
                break;
            case "3":
                chuyen_3_cau();
                suKienClick_P();
                break;
            case "4":
                chuyen_4_cau();
                suKienClick_P();
                break;
        }
    }
    private void chuyen_cau_hoi() {
        unCheckCauHoi();
        switch (questions.get(currentQuestion).getSo_cau_tra_loi()) {
            case "2":
                chuyen_2_cau();
                suKienClick();
                break;
            case "3":
                chuyen_3_cau();
                suKienClick();
                break;
            case "4":
                chuyen_4_cau();
                suKienClick();
                break;
        }
    }

    private void tinh_diem() {

        if (cb_A.isChecked()) {
            if (!userAnswer.contains("A")) {
                userAnswer.add("A");
            }

        }
        if (!cb_A.isChecked()) {
            userAnswer.remove("A");
        }

        if (cb_B.isChecked()) {
            if (!userAnswer.contains("B")) {
                userAnswer.add("B");
            }

        }
        if (!cb_B.isChecked()) {
            userAnswer.remove("B");
        }

        if (cb_C.isChecked()) {
            if (!userAnswer.contains("C")) {
                userAnswer.add("C");
            }

        }
        if (!cb_C.isChecked()) {
            userAnswer.remove("C");
        }

        if (cb_D.isChecked()) {
            if (!userAnswer.contains("D")) {
                userAnswer.add("D");
            }

        }
        if (!cb_D.isChecked()) {
            userAnswer.remove("D");
        }

            countRightAnswer(userAnswer);
    }

    private int countRightAnswer(ArrayList<String> userAnswer) {


        String userInput = "";
        for (String str : userAnswer) {
            userInput = userInput + str; //them mot hang
        }
        if (questions.get(currentQuestion).getDap_an_2().equals("null")) {
            if (userAnswer.contains(questions.get(currentQuestion).getDap_an_1())) {
                totalPoint+=1;
                return 1;
            } else {
                return 0;
            }
        } else {
            if (userAnswer.contains(questions.get(currentQuestion).getDap_an_1()) && userAnswer.contains(questions.get(currentQuestion).getDap_an_2())) {
                totalPoint+=1;
                return 1;
            } else {

                return 0;
            }
        }
    }

    private void displayRightAnswer(int currentQuestion) {
        ArrayList<String> cauTraLoiDung1 = new ArrayList<>();
        ArrayList<String> cauTraLoiDung2 = new ArrayList<>();

        cauTraLoiDung1.add(questions.get(currentQuestion).getDap_an_1());
        cauTraLoiDung2.add(questions.get(currentQuestion).getDap_an_2());

        if (cauTraLoiDung1.contains("A")) {
            cb_A.setTextColor(Color.RED);
            cb_A.setChecked(true);
        }
        if (cauTraLoiDung1.contains("B")) {
            cb_B.setTextColor(Color.RED);
            cb_B.setChecked(true);
        }
        if (cauTraLoiDung1.contains("C")) {
            cb_C.setTextColor(Color.RED);
            cb_C.setChecked(true);
        }
        if (cauTraLoiDung1.contains("D")) {
            cb_D.setTextColor(Color.RED);
            cb_D.setChecked(true);
        }
        if (!questions.get(currentQuestion).getDap_an_2().equals("null")){
            cauTraLoiDung2.add(questions.get(currentQuestion).getDap_an_2());

            if (cauTraLoiDung2.contains("A")) {
                cb_A.setTextColor(Color.RED);
                cb_A.setChecked(true);
            }
            if (cauTraLoiDung2.contains("B")) {
                cb_B.setTextColor(Color.RED);
                cb_B.setChecked(true);
            }
            if (cauTraLoiDung2.contains("C")) {
                cb_C.setTextColor(Color.RED);
                cb_C.setChecked(true);
            }
            if (cauTraLoiDung2.contains("D")) {
                cb_D.setTextColor(Color.RED);
                cb_D.setChecked(true);
            }
        }
    }

    private void chuyen_2_cau() {
        cb_C.setVisibility(View.INVISIBLE);
        cb_D.setVisibility(View.INVISIBLE);

        if (questions.get(currentQuestion).getImage() != 0) {
            anhCauHoi.setVisibility(View.VISIBLE);
            anhCauHoi.setImageResource(questions.get(currentQuestion).getImage());
        } else {
            anhCauHoi.setVisibility(View.INVISIBLE);
        }
        tv_cauhoi.setText(questions.get(currentQuestion).getCau_hoi());
        cb_A.setText(questions.get(currentQuestion).getCau_A());
        cb_B.setText(questions.get(currentQuestion).getCau_B());

    }

    private void chuyen_3_cau() {
        cb_C.setVisibility(View.VISIBLE);
        cb_D.setVisibility(View.INVISIBLE);

        if (questions.get(currentQuestion).getImage() != 0) {
            anhCauHoi.setVisibility(View.VISIBLE);
            anhCauHoi.setImageResource(questions.get(currentQuestion).getImage());
        } else {
            anhCauHoi.setVisibility(View.INVISIBLE);
        }
        tv_cauhoi.setText(questions.get(currentQuestion).getCau_hoi());
        cb_A.setText(questions.get(currentQuestion).getCau_A());
        cb_B.setText(questions.get(currentQuestion).getCau_B());
        cb_C.setText(questions.get(currentQuestion).getCau_C());
    }

    private void chuyen_4_cau() {
        cb_C.setVisibility(View.VISIBLE);
        cb_D.setVisibility(View.VISIBLE);

        if (questions.get(currentQuestion).getImage() != 0) {
            anhCauHoi.setVisibility(View.VISIBLE);
            anhCauHoi.setImageResource(questions.get(currentQuestion).getImage());
        } else {
            anhCauHoi.setVisibility(View.INVISIBLE);
        }
        tv_cauhoi.setText(questions.get(currentQuestion).getCau_hoi());
        cb_A.setText(questions.get(currentQuestion).getCau_A());
        cb_B.setText(questions.get(currentQuestion).getCau_B());
        cb_C.setText(questions.get(currentQuestion).getCau_C());
        cb_D.setText(questions.get(currentQuestion).getCau_D());
    }

    private void startCountDown() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                dialogHetGio.show();
            }
        }.start();
    }

    private void updateCountDownText() {
        minutes = (int) (timeLeftInMillis / 1000) / 60;
        seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        tv_time.setText(timeFormatted);

        if (timeLeftInMillis < 10000) {
            tv_time.setTextColor(Color.RED);
        }
        else {
            tv_time.setTextColor(Color.BLACK);
        }
    }
    @SuppressLint("SetTextI18n")
    private void hienThiSoCauHoi() {
        tv_stt.setText(String.valueOf(currentQuestion + 1));
    }

    @SuppressLint("SetTextI18n")
    private void ketThucKiemTra() {
        anhCauHoi.setVisibility(View.INVISIBLE);
        linearLayout_cauHoi.setVisibility(View.INVISIBLE);
        linearLayout_OK.setVisibility(View.INVISIBLE);
        tv_cauhoi.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 5.5f));
        if (totalPoint > 15) {
            tv_cauhoi.setText(" ĐÚNG " + totalPoint + " TRÊN " + questions.size()
                    + "\n KẾT QUẢ : ĐẠT");
            btnLui.setText("=))");
        } else {
            tv_cauhoi.setText(" ĐÚNG " + totalPoint + " TRÊN " + questions.size()
                    + "\n KẾT QUẢ : KHÔNG ĐẠT");
            btnLui.setText(":((");
        }
        btnTien.setText("Kết thúc");
    }

    private void unCheckCauHoi() {
        cb_A.setChecked(false);
        cb_B.setChecked(false);
        cb_C.setChecked(false);
        cb_D.setChecked(false);
    }

    private void PracticeOrStudy() {

        MyDB dbHelper = new MyDB(this);
        Newquestions = dbHelper.getAllQuestions();
        Intent intent = this.getIntent();
        phanloaiFromIntent = intent.getStringExtra("phanloai");

        if (phanloaiFromIntent == null) {
            startCountDown();
            randomCauHoi();
            chuyen_cau_hoi();
            btnKetThuc.setVisibility(View.GONE);
        } else if (phanloaiFromIntent.equals("Ly thuyet")) {
            tv_time.setVisibility(View.GONE);
            questions.clear();
            questions = dbHelper.getKhaiNiemQuestions();
            chuyen_cau_hoi_P();
            displayRightAnswer(currentQuestion);
        }
        else if (phanloaiFromIntent.equals("Bien bao")) {
            tv_time.setVisibility(View.GONE);
            questions.clear();
            questions = dbHelper.getBienBaoQuestions();
            chuyen_cau_hoi_P();
            displayRightAnswer(currentQuestion);
        }
        else if (phanloaiFromIntent.equals("Sa hinh")) {
            tv_time.setVisibility(View.GONE);
            questions.clear();
            questions = dbHelper.getSaHinhQuestions();
            chuyen_cau_hoi_P();
            displayRightAnswer(currentQuestion);
        }

    }

    /* Sự kiện khi tiến câu hỏi */
    private void partOfChuyenCauHoi() {
        if (currentQuestion + 1 < questions.size()) {
            currentQuestion++;
            hienThiSoCauHoi();
            chuyen_cau_hoi();
        } else if (btnTien.getText().toString().equals("Kết thúc")) {
            dialogFinish.show();
        }
        else {
            ketThucKiemTra();
        }
    }

    /* Sự kiện khi lùi câu hỏi */
    private void partOfChuyenCauHoi_2() {
        if (currentQuestion - 1 < questions.size() && currentQuestion - 1 >= 0) {
            currentQuestion--;
            hienThiSoCauHoi();
            chuyen_cau_hoi();
        }
    }
    /* Sự kiện khi tiến câu hỏi */
    private void partOfChuyenCauHoi_P() {
        if (currentQuestion + 1 < questions.size()) {
            currentQuestion++;
            hienThiSoCauHoi();
            chuyen_cau_hoi_P();
        } else if (btnTien.getText().toString().equals("Kết thúc")) {
            dialogFinish.show();
        }
        else {
            ketThucKiemTra();
        }
    }

    /* Sự kiện khi lùi câu hỏi */
    private void partOfChuyenCauHoi_P_2() {
        if (currentQuestion - 1 < questions.size() && currentQuestion - 1 >= 0) {
            currentQuestion--;
            hienThiSoCauHoi();
            chuyen_cau_hoi_P();
        }
    }
    private void suKienClick_P()
    {
        btnTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unCheckRightAnswer();
                tinh_diem();
                partOfChuyenCauHoi_P();
                displayRightAnswer(currentQuestion);
            }
        });
        btnLui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unCheckRightAnswer();
                tinh_diem();
                partOfChuyenCauHoi_P_2();
                displayRightAnswer(currentQuestion);
            }
        });
        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void suKienClick() {
        /* Nút tiến */
        btnTien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unCheckRightAnswer();
                tinh_diem();
                partOfChuyenCauHoi();
            }
        });
        /* Nút lùi */
        btnLui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                unCheckRightAnswer();
                tinh_diem();
                partOfChuyenCauHoi_2();
            }
        });
        btnKetThuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_dongy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogFinish.dismiss();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentQuestion=19;
                dialogHetGio.dismiss();
                ketThucKiemTra();
            }
        });
    }

    private void unCheckRightAnswer() {
        cb_A.setTextColor(Color.BLACK);
        cb_B.setTextColor(Color.BLACK);
        cb_C.setTextColor(Color.BLACK);
        cb_D.setTextColor(Color.BLACK);
    }


    private void Initialize() {
        tv_stt = findViewById(R.id.tv_stt);
        tv_time = findViewById(R.id.tv_time);
        tv_cauhoi = findViewById(R.id.tv_cauhoi);
        cb_A = findViewById(R.id.cb_A);
        cb_B = findViewById(R.id.cb_B);
        cb_C = findViewById(R.id.cb_C);
        cb_D = findViewById(R.id.cb_D);
        btnTien = findViewById(R.id.btnTiep);
        btnLui = findViewById(R.id.btnLui);
        btnKetThuc=findViewById(R.id.btnKetThuc);
        dialogFinish = new Dialog(this);
        dialogFinish.setContentView(R.layout.custom_dialog_finish);
        dialogFinish.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogFinish.setCanceledOnTouchOutside(false);
        dialogHetGio = new Dialog(this);
        dialogHetGio.setContentView(R.layout.custom_dialog_hetgio);
        dialogHetGio.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogHetGio.setCanceledOnTouchOutside(false);
        btn_dongy = dialogFinish.findViewById(R.id.btn_dongy);
        btn_huy= dialogFinish.findViewById(R.id.btn_huy);
        btn_cancel=dialogHetGio.findViewById(R.id.btn_select2);
        anhCauHoi = findViewById(R.id.anhCauHoi);
        timeLeftInMillis = COUNTDOWN_IN_MILLIS;
        cb_C.setVisibility(View.INVISIBLE);
        cb_D.setVisibility(View.INVISIBLE);
        linearLayout_cauHoi = findViewById(R.id.Layout_dapan);
        linearLayout_OK=findViewById(R.id.Layout_ok);
    }

    private void randomCauHoi() {
        Random rand = new Random();
        questions.clear();

        for (int i = 0; i < 20; i++) {
            int randomIndex = rand.nextInt(Newquestions.size());
            Question randomElement = Newquestions.get(randomIndex);
            questions.add(randomElement);
        }
    }
}
