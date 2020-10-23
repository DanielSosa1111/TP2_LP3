package com.example.tp1_lp3.ui.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.tp1_lp3.model.Usuario;
import com.example.tp1_lp3.request.ApiClient;
import com.example.tp1_lp3.ui.registro.RegistroActivity;

public class ViewModelMain extends AndroidViewModel {

    private MutableLiveData<String>btnLogin;
    private Context context;


    public ViewModelMain(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<String> getBtnLogin(){

        if(btnLogin==null){
            btnLogin=new MutableLiveData<>();
        }
        return btnLogin;
    }

    public void login (String usr, String pass){

        Usuario usu = ApiClient.login(context, usr, pass);

        if(usu!=null){
            Intent i = new Intent(context, RegistroActivity.class);
            i.putExtra("usuario", 1);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);

        }

    }
}
