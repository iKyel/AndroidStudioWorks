package com.example.buoi3_bt1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    EditText etTenKH, etSoLuong, etDonGia, etThanhTien;
    RadioButton rbNam, rbNu;
    CheckBox cbKhachVip;
    Button btnThanhToan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tenKH = etTenKH.getText().toString();
                int SoLuong = Integer.parseInt(etSoLuong.getText().toString());
                double DonGia = Double.parseDouble(etDonGia.getText().toString());
                double ThanhTien = SoLuong * DonGia;

                if(rbNu.isChecked()){
                    ThanhTien = ThanhTien * 0.9;
                }
                else if(cbKhachVip.isChecked()){
                    ThanhTien = ThanhTien * 0.9;
                }
                etThanhTien.setText(tenKH + " " + String.valueOf(ThanhTien));
            }
        });
    }
    private void InitWidget() {
        etTenKH = (EditText) findViewById(R.id.etTenKH);
        etSoLuong = (EditText) findViewById(R.id.etSoLuong);
        etDonGia = (EditText) findViewById(R.id.etDonGia);
        etThanhTien = (EditText) findViewById(R.id.etThanhTien);
        rbNam = (RadioButton) findViewById(R.id.rbNam);
        rbNu = (RadioButton) findViewById(R.id.rbNu);
        cbKhachVip = (CheckBox) findViewById(R.id.cbKhachVip);
        btnThanhToan = (Button) findViewById(R.id.btnThanhToan);
    }
}