package com.example.tp1_lp3.ui.registro;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp1_lp3.R;
import com.example.tp1_lp3.model.Usuario;

public class RegistroActivity extends AppCompatActivity {

    private Context context;
    private EditText dni, apellido, nombre, mail, password;
    private Button guardarRegistro;
    private ViewModelRegistro viewModelRegistro;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        inicializar();
    }

    private void inicializar(){

        dni = findViewById(R.id.etDniRegistro);
        apellido = findViewById(R.id.etApellidoRegistro);
        nombre = findViewById(R.id.etNombreRegistro);
        mail = findViewById(R.id.etMailRegistro);
        password = findViewById(R.id.etPasswordRegistro);
        guardarRegistro = findViewById(R.id.btnGuardarRegistro);
        viewModelRegistro = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelRegistro.class);

        guardarRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                viewModelRegistro.guardar(dni.getText().toString(), apellido.getText().toString(), nombre.getText().toString(),
                        mail.getText().toString(), password.getText().toString());
            }
        });
        viewModelRegistro.getUsuarioMutable().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                dni.setText(usuario.getDni()+"");
                apellido.setText(usuario.getApellido());
                nombre.setText(usuario.getNombre());
                mail.setText(usuario.getMail());
                password.setText(usuario.getPassword());
            }
        });
        viewModelRegistro.leer(getIntent());
    }
}
