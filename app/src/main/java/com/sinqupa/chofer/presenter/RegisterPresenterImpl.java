package com.sinqupa.chofer.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.sdsmdg.tastytoast.TastyToast;
import com.sinqupa.chofer.model.User;
import com.sinqupa.chofer.model.Utility;
import com.sinqupa.chofer.view.LoginActivity;

public class RegisterPresenterImpl implements IRegisterPresenter {
    private Context context;

    @Override
    public void getActivityContext(Context context) {
        this.context = context;
    }

    @Override
    public void navigationToLogin() {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public boolean comparatePassword(String password, String repeatPassword) {
        boolean result = false;
        if (password.equals(repeatPassword)){
            result = true;
        }
        return result;
    }

    @Override
    public void register(User user,String repeatPassword) {
        if (validateRegister(user,repeatPassword)){
            if (comparatePassword(user.getPassword(),repeatPassword)){
                doRegisterAuthentication(user);
            }else {
                TastyToast.makeText(context, "Contraseñas no coinciden", TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }
        }else {
            TastyToast.makeText(context, "Ingresar los Datos", TastyToast.LENGTH_LONG, TastyToast.WARNING);
        }
    }

    @Override
    public boolean validateRegister(User user,String repeatPassword) {
        boolean result = true;
        if (TextUtils.isEmpty(user.getEmail()) || TextUtils.isEmpty(user.getPassword()) || TextUtils.isEmpty(repeatPassword)){
            result = false;
        }
        return result;
    }

    @Override
    public void doRegisterAuthentication(User user) {
        Utility.firebaseAuth.createUserWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener((Activity)context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    navigationToLogin();
                }else {
                    TastyToast.makeText(context, "No se pudo registrar", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
    }

    @Override
    public void cancel() {
        navigationToLogin();
    }
}
