package com.example.bmi_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etChieuCao, etCanNang;
    Button btnOK;
    TextView tvKQ, tvTB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khai báo biến
        etChieuCao = findViewById(R.id.etChieuCao);
        etCanNang = findViewById(R.id.etCanNang);
        btnOK = findViewById(R.id.btnOK);
        tvKQ = findViewById(R.id.tvKQ);
        tvTB = findViewById(R.id.tvTB);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double chieucao, cannang;
                chieucao =Double.parseDouble(etChieuCao.getText().toString());
                cannang = Double.parseDouble(etCanNang.getText().toString());

                double BMI = cannang/(chieucao*chieucao);
                String thongbao;
                if(BMI < 18.6){
                    thongbao = "Nhẹ cân";
                }
                else if(BMI <25){
                    thongbao = "Cân nặng bình thường";
                }
                else if(BMI < 30){
                    thongbao = "Thừa cân";
                }
                else if(BMI < 35){
                    thongbao = "Béo phì độ I";
                }
                else if(BMI < 40){
                    thongbao = "Béo phì độ II";
                }
                else {
                    thongbao = "Béo phì độ III";
                }
                tvTB.setText(thongbao);
                tvKQ.setText(String.valueOf(BMI));
            }
        });

    }


}