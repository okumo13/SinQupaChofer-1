package com.sinqupa.chofer.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.sinqupa.chofer.R;
import com.sinqupa.chofer.presenter.IMapPresenter;
import com.sinqupa.chofer.presenter.MapPresenterImpl;

public class MapFragment extends Fragment implements OnMapReadyCallback {
    IMapPresenter mapPresenter = new MapPresenterImpl();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map,container,false);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.viewMap);
        mapFragment.getMapAsync(this);
        mapPresenter.getFragmentContext(container.getContext());
        return view;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapPresenter.loadMap(googleMap);
    }
}
