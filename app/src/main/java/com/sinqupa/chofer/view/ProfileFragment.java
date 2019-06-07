package com.sinqupa.chofer.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sinqupa.chofer.R;
import com.sinqupa.chofer.presenter.IProfilePresenter;
import com.sinqupa.chofer.presenter.ProfilePresenterImpl;

public class ProfileFragment extends Fragment {
    private IProfilePresenter profilePresenter = new ProfilePresenterImpl();
    Button btnLogoutProfile,btnStartProfile,btnStopProfile;
    TextView txtUsernameProfile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        txtUsernameProfile = (TextView)view.findViewById(R.id.txtUsernameProfile);
        btnStartProfile = (Button)view.findViewById(R.id.btnStartProfile);
        btnStopProfile = (Button)view.findViewById(R.id.btnStopProfile);
        btnLogoutProfile = (Button)view.findViewById(R.id.btnLogoutProfile);
        btnStartProfile.setOnClickListener(startListener);
        btnStopProfile.setOnClickListener(stopListener);
        btnLogoutProfile.setOnClickListener(logoutListener);
        txtUsernameProfile.setText(profilePresenter.loadUsername());
        profilePresenter.getFragmentContext(container.getContext());
        return view;
    }


    Button.OnClickListener startListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profilePresenter.startService();
        }
    };


    Button.OnClickListener stopListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profilePresenter.stopService();
        }
    };


    Button.OnClickListener logoutListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            profilePresenter.logout();
        }
    };


}
