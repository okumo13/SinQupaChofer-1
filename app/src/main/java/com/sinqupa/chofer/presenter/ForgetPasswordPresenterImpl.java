package com.sinqupa.chofer.presenter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.sdsmdg.tastytoast.TastyToast;
import com.sinqupa.chofer.model.Utility;
import com.sinqupa.chofer.view.LoginActivity;

public class ForgetPasswordPresenterImpl implements IForgetPasswordPresenter {
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
    public void send(String email) {
        if (validateEmail(email)){
            doSend(email);
        }else {
            TastyToast.makeText(context, "Ingresar los Datos", TastyToast.LENGTH_LONG, TastyToast.WARNING);
        }
    }

    @Override
    public boolean validateEmail(String email) {
        boolean result = true;
        if (TextUtils.isEmpty(email)){
            result = false;
        }
        return result;
    }

    @Override
    public void doSend(String email) {
        Utility.firebaseAuth.setLanguageCode("es");
        Utility.firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    navigationToLogin();
                }else {
                    TastyToast.makeText(context, "No se pudo enviar", TastyToast.LENGTH_LONG, TastyToast.ERROR);
                }
            }
        });
    }

    @Override
    public void cancel() {
        navigationToLogin();
    }
}
