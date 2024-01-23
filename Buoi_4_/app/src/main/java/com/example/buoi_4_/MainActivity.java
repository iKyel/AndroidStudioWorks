package com.example.buoi_4_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvMonHoc;
    Spinner spMonHoc;
    EditText etMonHoc;
    Button btnOK;
    ArrayList<String> arrMonHoc; // Thêm ArrayList để lưu dữ liệu cho Spinner Adapter
    ArrayAdapter<String> adapter; // Thêm ArrayAdapter cho Spinner
    ArrayAdapter<String> lvAdapter; // Thêm ArrayAdapter cho ListView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitWidget();

        // Mảng thường
        final String arr[] = {"Java", "Android", "Data mining", "Image Processing", "Game"};

        // ArrayList
        ArrayList<String> arrMonHoc = new ArrayList<String>();
        arrMonHoc.add("Java");
        arrMonHoc.add("Android");
        arrMonHoc.add("Data Mining");
        arrMonHoc.add("Image Processing");
        arrMonHoc.add("Game");


        // gán data vào adapter
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                MainActivity.this, android.R.layout.simple_list_item_1, arr
//        );
        ArrayAdapter<String> spAdapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, arrMonHoc
        );

        ArrayAdapter<String> lvAdapter = new ArrayAdapter<String>(
                MainActivity.this, android.R.layout.simple_list_item_1, arrMonHoc
        );

        lvMonHoc.setAdapter(lvAdapter);
        spMonHoc.setAdapter(spAdapter);

        spMonHoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, arrMonHoc.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lvMonHoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this, arrMonHoc.get(position), Toast.LENGTH_SHORT).show();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy dữ liệu từ EditText
                String monHocMoi = etMonHoc.getText().toString();

                // Kiểm tra xem EditText có dữ liệu hay không
                if (!monHocMoi.isEmpty() && !arrMonHoc.contains(monHocMoi)) {
                    // Thêm dữ liệu mới vào ArrayList
                    arrMonHoc.add(monHocMoi);

                    // Cập nhật lại Adapter của Spinner
                    spAdapter.notifyDataSetChanged();
                    lvAdapter.notifyDataSetChanged();

                    // Đặt Spinner về vị trí mới thêm
                    spMonHoc.setSelection(arrMonHoc.size() - 1);

                    // Xóa nội dung của EditText
                    etMonHoc.setText("");
                }
            }
        });
    }

    private void InitWidget() {
        lvMonHoc = (ListView) findViewById(R.id.lvMonHoc);
        spMonHoc = (Spinner) findViewById(R.id.spinner);
        etMonHoc = (EditText) findViewById(R.id.etMonHoc);
        btnOK = (Button) findViewById(R.id.btnOK);
    }
}