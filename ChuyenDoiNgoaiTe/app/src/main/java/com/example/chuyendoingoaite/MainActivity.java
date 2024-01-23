package com.example.chuyendoingoaite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etTien, etKetQua;
    CheckBox cbChietKhau;
    Button btnDoi;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        ArrayList<String> arrTienTe = new ArrayList<>();
        arrTienTe.add("USD");
        arrTienTe.add("EUR");
        arrTienTe.add("NDT");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, arrTienTe
        );
        spn.setAdapter(adapter);

        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double USDrate = 24565, EURrate = 26773, NDTrate = 3411;
                double tienViet = Double.parseDouble(etTien.getText().toString());
                double tienChuyenDoi = tienViet;


                etKetQua.setText(String.valueOf(tienChuyenDoi));
            }
        });
    }

    private void InitWidget() {
        etTien = (EditText) findViewById(R.id.etTien);
        etKetQua = (EditText) findViewById(R.id.etKetQua);
        spn = (Spinner) findViewById(R.id.spinner2);
        cbChietKhau = (CheckBox) findViewById(R.id.cbChietKhau);
    }
}