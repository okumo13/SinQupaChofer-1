package com.sinqupa.chofer.presenter;

import android.content.Context;
import com.google.firebase.auth.FirebaseAuth;
import com.sinqupa.chofer.model.User;

public interface ILoginPresenter {
    void getActivityContext(Context context);
    void instanceFirebase(FirebaseAuth firebaseAuth);
    void navigationToForgetPassword();
    void navigationToMenu();
    void navigationToRegister();
    void login(User user);
    boolean validateLogin(User user);
    void doLogin(User user);
}
