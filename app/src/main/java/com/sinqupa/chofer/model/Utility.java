package com.sinqupa.chofer.model;

import android.Manifest;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Utility {
    public static String userID;
    public static String username;
    public static FirebaseAuth firebaseAuth;
    public static DatabaseReference databaseReference;
    public static final String[] PERMISSIONS = { Manifest.permission.INTERNET,Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION};
    public static final int REQUEST_PERMISSIONS_REQUEST_CODE = 101;
    public static final String PERMISSION_TEXT = "Permisos Requeridos para SinQupa";
    public static final String OK = "Ok";
    public static final long UPDATE_INTERVAL_IN_MILLISECONDS = 2000;
    public static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = UPDATE_INTERVAL_IN_MILLISECONDS / 2;
    public static final int DEFAULT_LATITUDE = 0;
    public static final int DEFAULT_LONGITUDE = 0;
}
