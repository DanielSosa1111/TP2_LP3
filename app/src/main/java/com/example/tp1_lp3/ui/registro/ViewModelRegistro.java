package com.example.tp1_lp3.ui.registro;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.tp1_lp3.model.Usuario;
import com.example.tp1_lp3.request.ApiClient;

public class ViewModelRegistro extends AndroidViewModel {

    private MutableLiveData<Usuario> usuarioMutable;
    private Context context;

    public ViewModelRegistro(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public LiveData<Usuario> getUsuarioMutable(){

        if(usuarioMutable==null){
            usuarioMutable=new MutableLiveData<>();
        }
        return usuarioMutable;
    }

    public void guardar (String dni, String apellido, String nombre, String mail, String pass){

        Usuario usu = new Usuario(Long.parseLong(dni), apellido, nombre, mail, pass);
        ApiClient.guardar(context, usu);

    }

    public void leer(Intent i){
        int dato = i.getIntExtra("usuario", -1);
        if(dato==1){
            Usuario usr = ApiClient.leer(context);
            usuarioMutable.setValue(usr);
        }
    }
}
