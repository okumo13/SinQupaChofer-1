package com.sinqupa.chofer.presenter;

import android.content.Context;

public interface IForgetPasswordPresenter {
    void getActivityContext(Context context);
    void navigationToLogin();
    void send(String email);
    boolean validateEmail(String email);
    void doSend(String email);
    void cancel();
}
