package com.sinqupa.chofer.presenter;

import android.content.Context;

import com.sinqupa.chofer.model.User;

public interface IRegisterPresenter {
    void getActivityContext(Context context);
    void navigationToLogin();
    boolean comparatePassword(String password,String repeatPassword);
    void register(User user,String repeatPassword);
    boolean validateRegister(User user,String repeatPassword);
    void doRegisterAuthentication(User user);
    void cancel();

}
