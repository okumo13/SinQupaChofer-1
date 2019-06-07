package com.sinqupa.chofer.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapPresenterImpl implements IMapPresenter{
    private Context context;

    @Override
    public void getFragmentContext(Context context) {
        this.context = context;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void loadMap(GoogleMap googleMap) {
        final GoogleMap map = googleMap;
        if (map != null) {
            map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            map.setMyLocationEnabled(true);


            FusedLocationProviderClient mFusedLocationClient =  LocationServices.getFusedLocationProviderClient((FragmentActivity)context);

            mFusedLocationClient.getLastLocation().addOnSuccessListener((FragmentActivity)context, new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    LatLng originPosition = new  LatLng(location.getLatitude(),location.getLongitude());
                    MarkerOptions markerOptionsDestination = new MarkerOptions();
                    markerOptionsDestination.position(originPosition);
                    //markerOptionsDestination.title(Utility.TITLE_MARKER_EMPLOYEE);
                    //markerOptionsDestination.icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_house));
                    //mDestinationMarker = mGoogleMap.addMarker(markerOptionsDestination);
                    CameraPosition cameraPosition = new CameraPosition.Builder().target(originPosition).zoom(19).bearing(45).tilt(70).build();
                    CameraUpdate zoomCam = CameraUpdateFactory.newCameraPosition(cameraPosition);
                    map.animateCamera(zoomCam);
                }
            }).addOnFailureListener((FragmentActivity)context, new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                }
            });

        }
    }
}
