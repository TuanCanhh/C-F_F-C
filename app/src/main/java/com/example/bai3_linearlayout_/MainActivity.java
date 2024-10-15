package com.example.bai3_linearlayout_;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //khai bao cac bien giao dien
    EditText edtC, edtF;
    Button btnCF, btnFC, btnclear;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Ánh xạ Id
         edtC = findViewById(R.id.edtC);
         edtF = findViewById(R.id.edtF);
        btnCF = findViewById(R.id.btnCF);
        btnFC = findViewById(R.id.btnFC);
        btnclear = findViewById(R.id.btnclear);

        // xu li Click

        btnCF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputC = edtC.getText().toString().trim();
                if(inputC.isEmpty()){
                    Toast.makeText(MainActivity.this, "ban chua nhap cai meo gi", Toast.LENGTH_LONG).show();
                }else{
                    int C = Integer.parseInt(inputC);
                    Double F = C*1.8 +32; //C => F : * 1.8 + 32
                    edtF.setText(F + "");
                }
            }
        });

        btnFC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputF = edtF.getText().toString().trim();
                if(inputF.isEmpty()){
                    Toast.makeText(MainActivity.this, "ban chua nhap cai meo gi", Toast.LENGTH_LONG).show();
                }else{
                    int F = Integer.parseInt(inputF);
                    Double C = (F-32)/ 1.8; // (x - 32)/1.8
                    edtC.setText(C + "");
                }

            }
        });

        btnclear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtC.setText("");
                edtF.setText("");
            }
        });
    }
}