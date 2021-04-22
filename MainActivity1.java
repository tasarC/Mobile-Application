package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText user_name, password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_name = findViewById(R.id.editTextTextPersonName4);
        password = findViewById(R.id.editTextNumberPassword2);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user_name.getText().toString();
                String userpassword = password.getText().toString();
                if (username.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Lütfen kullanıcı adı giriniz", Toast.LENGTH_LONG).show();
                } else if (userpassword.isEmpty()) {
                    password.setError("Lütfen şifre giriniz");
                    password.requestFocus();
                }
                else if(username.isEmpty() && userpassword.isEmpty()){
                    Toast.makeText(MainActivity.this, "Lütfen değer giriniz", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(MainActivity.this, "Hata", Toast.LENGTH_LONG).show();
                }
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, MainActivity3.class);
                startActivity(a);
            }
        });
    }
}