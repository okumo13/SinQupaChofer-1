package com.sinqupa.chofer.presenter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.sdsmdg.tastytoast.TastyToast;
import com.sinqupa.chofer.model.Employee;
import com.sinqupa.chofer.model.Utility;
import com.sinqupa.chofer.view.LoginActivity;

public class ProfilePresenterImpl  implements IProfilePresenter{
    private Context context;
    private boolean serviceActive = false;

    @Override
    public boolean checkPermissions() {
        for(String permission : Utility.PERMISSIONS){
            if(context.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED)
                return false;
        }
        return true;
    }

    @Override
    public void getFragmentContext(Context context) {
        this.context = context;
    }

    @Override
    public void navigationToLogin() {
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    public void logout() {
        doLogout();
    }

    @Override
    public void doLogout() {
        if (serviceActive){
            Utility.databaseReference.child("Employee").child(Utility.userID).setValue(new Employee(Utility.DEFAULT_LATITUDE,Utility.DEFAULT_LONGITUDE,false));
            context.stopService(new Intent(context, LocationUpdatesService.class));
        }
        Utility.firebaseAuth.signOut();
        navigationToLogin();
    }

    @Override
    public boolean doStartService() {
        boolean result = false;
        if (checkPermissions()){
            result = true;
        }
        return result;
    }

    @Override
    public boolean doStopService() {
        boolean result = false;
        if (checkPermissions()){
            result = true;
        }
        return result;
    }

    @Override
    public void startService() {
        if (doStartService()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(new Intent(context, LocationUpdatesService.class));
            }
            context.startService(new Intent(context, LocationUpdatesService.class));
            serviceActive = true;
            TastyToast.makeText(context, "Aplicacion Iniciada", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
        }else {
            TastyToast.makeText(context, "Permisos Requeridos", TastyToast.LENGTH_LONG, TastyToast.WARNING);
        }
    }

    @Override
    public void stopService() {
        if (doStopService()){
            if (serviceActive){
                Utility.databaseReference.child("Employee").child(Utility.userID).setValue(new Employee(Utility.DEFAULT_LATITUDE,Utility.DEFAULT_LONGITUDE,false));
                context.stopService(new Intent(context, LocationUpdatesService.class));
                TastyToast.makeText(context, "Aplicacion Detenida", TastyToast.LENGTH_LONG, TastyToast.DEFAULT);
            }else {
                TastyToast.makeText(context, "Iniciar Recorrido", TastyToast.LENGTH_LONG, TastyToast.WARNING);
            }
        }else {
            TastyToast.makeText(context, "Permisos Requeridos", TastyToast.LENGTH_LONG, TastyToast.WARNING);
        }
    }

    @Override
    public String loadUsername() {
        return Utility.username;
    }
}
