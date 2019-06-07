package com.sinqupa.chofer.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.sinqupa.chofer.R;
import com.sinqupa.chofer.model.User;
import com.sinqupa.chofer.presenter.IRegisterPresenter;
import com.sinqupa.chofer.presenter.RegisterPresenterImpl;

public class RegisterActivity extends AppCompatActivity {
    IRegisterPresenter registerPresenter = new RegisterPresenterImpl();
    private EditText txtEmailRegister,txtPasswordRegister,txtRepeatPasswordRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        txtEmailRegister = (EditText) findViewById(R.id.txtEmailRegister);
        txtPasswordRegister = (EditText) findViewById(R.id.txtPasswordRegister);
        txtRepeatPasswordRegister= (EditText) findViewById(R.id.txtRepeatPasswordRegister);
        registerPresenter.getActivityContext(this);
    }

    public void Save(View view) {
        registerPresenter.register(new User(null,txtEmailRegister.getText().toString(),txtPasswordRegister.getText().toString()),txtRepeatPasswordRegister.getText().toString());
    }

    public void Cancel(View view) {
        registerPresenter.cancel();
    }
}
