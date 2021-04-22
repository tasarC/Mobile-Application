package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private EditText Yaş, Boy, Kilo, Sonuc, Durum;
    private RadioGroup group;
    private Button Hesapla;
    boolean kadınmi = true;
    private double boyu = 0.0;
    private int kilosu = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Yaş = findViewById(R.id.editTextNumberDecimal6);
        Boy = findViewById(R.id.editTextNumberDecimal);
        Kilo = findViewById(R.id.editTextNumberDecimal2);
        Sonuc = findViewById(R.id.editTextNumberDecimal3);
        Durum = findViewById(R.id.editTextTextPersonName);
        group = findViewById(R.id.RadioGroup);
        Hesapla = findViewById(R.id.button2);
        String str = getIntent().getStringExtra("str");
        Yaş.setText(str);
        Boy.setText(str);
        Kilo.setText(str);
        Sonuc.setText(str);
        Durum.setText(str);

        Hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String boy = Boy.getText().toString();
                String kilo = Kilo.getText().toString();
                float x = Integer.parseInt(boy);
                float y = Integer.parseInt(kilo);
                float z = y / (x * x) * 10000;
                Sonuc.setText("" + z);
                if (z >= 0 && z <= 18.4) {
                    Durum.setText("-Zayıf- Dikkat, Bir diyetisyen yardımı almalısınız");
                } else if (z >= 18.5 && z <= 24.9) {
                    Durum.setText("-Normal- Dengeli ve saglıklı beslenmeye devam");
                } else if (z >= 25 && z <= 29.9) {
                    Durum.setText("-Fazla Kilolu - Dikkat, Diyet yardımı ile fazla kilolardan kurtulmalısınız");
                } else if (z >= 30 && z <= 34.9) {
                    Durum.setText("-Şişman(1.dereceden obez)- Dikkat, Bir diyetisyen yardımı almalısınız");
                } else if (z >= 35 && z <= 44.9) {
                    Durum.setText("-Şişman(2.dereceden obez)- Dikkat, Bir diyetisyen yardımı almalısınız");
                } else if (z >= 45) {
                    Durum.setText("-Aşırı Şişman- Dikkat, hekim ve diyetisyen yardımı almalısınız");
                }
                if (boy.isEmpty()) {
                    Boy.setError("Lütfen boy uzunlugunuzu giriniz");
                    Boy.requestFocus();
                } else if (kilo.isEmpty()) {
                    Kilo.setError("Lütfen kilonuzu giriniz");
                    Kilo.requestFocus();
                } else if (boy.isEmpty() && kilo.isEmpty()) {
                    Toast.makeText(MainActivity2.this, "Lütfen değer giriniz", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}




