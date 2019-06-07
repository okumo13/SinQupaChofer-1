package com.sinqupa.chofer.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.sdsmdg.tastytoast.TastyToast;
import com.sinqupa.chofer.model.User;
import com.sinqupa.chofer.model.Utility;
import com.sinqupa.chofer.view.ForgetPasswordActivity;
import com.sinqupa.chofer.view.MenuActivity;
import com.sinqupa.chofer.view.RegisterActivity;

public class LoginPresenterImpl implements ILoginPresenter {
    private Context context;

    @Override
    public void getActivityContext(Context context) {
        this.context = context;
    }

    @Override
    public void instanceFirebase(FirebaseAuth firebaseAuth) {
        Utility.firebaseAuth = firebaseAuth;
    }

    @Override
    public void navigationToForgetPassword() {
        context.startActivity(new Intent(context, ForgetPasswordActivity.class));
    }

    @Override
    public void navigationToMenu() {
        context.startActivity(new Intent(context, MenuActivity.class));
    }

    @Override
    public void navigationToRegister() {
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    @Override
    public void doLogin(final User user) {
        Utility.firebaseAuth.signInWithEmailAndPassword(user.getEmail(),user.getPassword()).addOnCompleteListener((Activity) context, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    int position = user.getEmail().indexOf("@");
                    String username = user.getEmail().substring(0,position);
                    Utility.userID = Utility.firebaseAuth.getCurrentUser().getUid();
                    Utility.username = username;
                    navigationToMenu();
                }else{
                    TastyToast.makeText(context, "Datos Incorrectos", TastyToast.LENGTH_LONG, TastyToast.CONFUSING);
                }
            }
        });
    }

    @Override
    public void login(User user) {
        if (validateLogin(user)){
            doLogin(user);
        }else {
            TastyToast.makeText(context, "Ingresar los Datos", TastyToast.LENGTH_LONG, TastyToast.WARNING);
        }
    }

    @Override
    public boolean validateLogin(User user) {
        boolean result = true;
        if (TextUtils.isEmpty(user.getEmail()) || TextUtils.isEmpty(user.getPassword())){
            result = false;
        }
        return result;
    }
}
