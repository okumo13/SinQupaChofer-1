package com.sinqupa.chofer.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.sinqupa.chofer.R;
import com.sinqupa.chofer.presenter.ForgetPasswordPresenterImpl;
import com.sinqupa.chofer.presenter.IForgetPasswordPresenter;

public class ForgetPasswordActivity extends AppCompatActivity {
    private IForgetPasswordPresenter forgetPasswordPresenter = new ForgetPasswordPresenterImpl();
    private EditText txtEmailForgetPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        txtEmailForgetPassword = (EditText)findViewById(R.id.txtEmailForgetPassword);
        forgetPasswordPresenter.getActivityContext(this);
    }

    public void Send(View view) {
        forgetPasswordPresenter.send(txtEmailForgetPassword.getText().toString());
    }

    public void Cancel(View view) {
        forgetPasswordPresenter.cancel();
    }
}
