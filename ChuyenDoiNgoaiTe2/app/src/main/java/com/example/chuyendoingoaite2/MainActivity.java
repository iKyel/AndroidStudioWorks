package com.example.chuyendoingoaite2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNhapTien, etKetQua;
    Spinner spnTienTe;
    Button btnDoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();
        ArrayList<String> arrTienTe = new ArrayList<String>();
        arrTienTe.add("USD");
        arrTienTe.add("EUR");
        arrTienTe.add("NDT");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, arrTienTe
        );
        spnTienTe.setAdapter(adapter);
        btnDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doiTienTe();
            }
        });
    }

    private void doiTienTe(){
        Double tienViet = Double.parseDouble(etNhapTien.getText().toString());
        // Lấy loại tiền tệ từ Spinner
        String loaiTienTe = spnTienTe.getSelectedItem().toString();
        // Xử lý chuyển đổi theo loại tiền tệ
        double ketQua = 0;
        switch (loaiTienTe) {
            case "USD":
                // Thực hiện chuyển đổi từ VND sang USD (giả sử tỷ giá là 0.000043)
                ketQua = tienViet * 0.000043;
                break;
            case "EUR":
                // Thực hiện chuyển đổi từ VND sang EUR (giả sử tỷ giá là 0.000038)
                ketQua = tienViet * 0.000038;
                break;
            case "NDT":
                // Thực hiện chuyển đổi từ VND sang NDT (giả sử tỷ giá là 0.0032)
                ketQua = tienViet * 0.0032;
                break;
            default:
                // Xử lý trường hợp không khớp loại tiền tệ nào
                break;
        }

        // Hiển thị kết quả chuyển đổi
        etKetQua.setText(String.valueOf(ketQua));
    }

    private void InitWidget() {
        etNhapTien = (EditText) findViewById(R.id.etNhapTien);
        etKetQua = (EditText) findViewById(R.id.etKetQua);
        spnTienTe = (Spinner) findViewById(R.id.spinner);
        btnDoi = (Button) findViewById(R.id.btnDoi);
    }
}