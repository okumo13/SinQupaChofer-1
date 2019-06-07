package com.sinqupa.chofer.presenter;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;

public interface IMapPresenter {
    void getFragmentContext(Context context);
    void loadMap(GoogleMap googleMap);
}
