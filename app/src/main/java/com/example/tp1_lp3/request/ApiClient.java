package com.example.tp1_lp3.request;

import android.content.Context;
import android.widget.Toast;
import com.example.tp1_lp3.model.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ApiClient {


    public static void guardar(Context context, Usuario usuario){

        try{
        File archivo = new File(context.getFilesDir(), "datos.dat");
        FileOutputStream fo = new FileOutputStream(archivo);
        BufferedOutputStream bo = new BufferedOutputStream(fo);
        DataOutputStream dos = new DataOutputStream(bo);

            dos.writeLong(usuario.getDni());
            dos.writeUTF(usuario.getApellido());
            dos.writeUTF(usuario.getNombre());
            dos.writeUTF(usuario.getPassword());
            dos.writeUTF(usuario.getMail());

            bo.flush();
            fo.close();

        }catch(Exception e){
            Toast.makeText(context, "error al guardar", Toast.LENGTH_SHORT).show();
        }

    }

    public static Usuario leer (Context context) {

      Usuario usuario = null;

        try {
            File archivo = new File(context.getFilesDir(), "datos.dat");
            FileInputStream fi = new FileInputStream(archivo);
            BufferedInputStream bi = new BufferedInputStream(fi);
            DataInputStream doi = new DataInputStream(bi);

            Long dni = doi.readLong();
            String apellido = doi.readUTF();
            String nombre = doi.readUTF();
            String password = doi.readUTF();
            String email = doi.readUTF();
            fi.close();

            usuario = new Usuario(dni, apellido, nombre, email, password);

        } catch (Exception e) {
            Toast.makeText(context, "error al leer", Toast.LENGTH_SHORT).show();
        }return usuario;
    }

    public static Usuario login(Context context, String mail, String password){

    Usuario usuario = null;
    usuario= leer(context);

    if (mail.equals(usuario.getMail())&&password.equals(usuario.getPassword())){
        return usuario;
    }return  null;
}
}
