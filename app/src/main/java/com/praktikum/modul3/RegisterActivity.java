package com.praktikum.modul3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    EditText email, username, password;
    Button btnRegister, btnLogin;
    TextView status;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        status = findViewById(R.id.notif);
        btnRegister = findViewById(R.id.btn_register);
        btnLogin = findViewById(R.id.btn_login);
        scrollView = findViewById(R.id.scrollView);

        btnRegister.setOnClickListener(v-> {

                String emailUser = email.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

            try {

                InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                scrollView.scrollTo(0, 0);
                status.setText("Pendaftaran Berhasil, silahkan lakukan Login");
                status.setVisibility(v.VISIBLE);
                clear(v);

            }catch (NumberFormatException e)
            {
                Toast.makeText(this, "Masukan kredensial yang benar", Toast.LENGTH_SHORT).show();
            }


        });

        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(i);
        });


        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(v-> {
                onBackPressed();
        });

    }
    public void clear(View view){
        email.setText("");
        username.setText("");
        password.setText("");
    }
}