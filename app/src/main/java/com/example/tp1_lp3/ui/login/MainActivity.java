package com.example.tp1_lp3.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tp1_lp3.R;
import com.example.tp1_lp3.ui.registro.RegistroActivity;
import com.example.tp1_lp3.ui.registro.ViewModelRegistro;

public class MainActivity extends AppCompatActivity {

    private EditText usr, pass;
    private Button login, registrarse;
    private ViewModelMain viewModelMain;
    private ViewModelRegistro viewModelRegistro;
    private RegistroActivity rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    public void inicializar(){

        usr = findViewById(R.id.etUsuario);
        pass = findViewById(R.id.etPassword);
        login = findViewById(R.id.btnLogin);
        registrarse = findViewById(R.id.btnRegistrarse);

        viewModelMain = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelMain.class);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModelMain.login(usr.getText().toString(), pass.getText().toString());

            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                i.putExtra("usuario", 0);
                startActivity(i);
            //startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
            }
        });
    }
}