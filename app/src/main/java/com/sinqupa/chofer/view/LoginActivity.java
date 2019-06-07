package com.sinqupa.chofer.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.sinqupa.chofer.R;
import com.sinqupa.chofer.model.User;
import com.sinqupa.chofer.presenter.ILoginPresenter;
import com.sinqupa.chofer.presenter.LoginPresenterImpl;

public class LoginActivity extends AppCompatActivity {
    private ILoginPresenter loginPresenter = new LoginPresenterImpl();
    private EditText txtEmailLogin,txtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtEmailLogin = (EditText)findViewById(R.id.txtEmailLogin);
        txtPasswordLogin = (EditText) findViewById(R.id.txtPasswordLogin);
        loginPresenter.getActivityContext(this);
        loginPresenter.instanceFirebase(FirebaseAuth.getInstance());
    }

    public void ForgetPassword(View view) {
        loginPresenter.navigationToForgetPassword();
    }

    public void Register(View view) {
        loginPresenter.navigationToRegister();
    }

    public void Login(View view) {
        loginPresenter.login(new User(null,txtEmailLogin.getText().toString(),txtPasswordLogin.getText().toString()));
    }
}
