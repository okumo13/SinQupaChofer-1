package com.sinqupa.chofer.presenter;

import android.content.Context;

public interface IProfilePresenter {
    boolean checkPermissions();
    void getFragmentContext(Context context);
    void navigationToLogin();
    void logout();
    boolean doStartService();
    boolean doStopService();
    void doLogout();
    void startService();
    void stopService();
    String loadUsername();
}
