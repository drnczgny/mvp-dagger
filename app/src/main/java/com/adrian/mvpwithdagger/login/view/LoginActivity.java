package com.adrian.mvpwithdagger.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.adrian.mvpwithdagger.R;
import com.adrian.mvpwithdagger.app.MyApp;
import com.adrian.mvpwithdagger.login.di.DaggerLoginComponent;
import com.adrian.mvpwithdagger.login.di.LoginComponent;
import com.adrian.mvpwithdagger.login.di.LoginModule;
import com.adrian.mvpwithdagger.login.presenter.LoginPresenter;
import com.adrian.mvpwithdagger.main.view.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private static final String TAG = LoginActivity.class.getName().toString();

    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.btnLogIn)
    Button btnLogIn;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    LoginPresenter loginPresenterImpl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        LoginComponent loginComponent = DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .appComponent(MyApp.get(this).getAppComponent())
                .build();
        loginComponent.inject(this);

        sharedPreferences.toString();

    }

    @OnClick(R.id.btnLogIn)
    public void onClickLogIn() {
        loginPresenterImpl.validateCredentials(etUsername.getText().toString(), etPassword.getText().toString());
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void errorOnUsername() {
        etUsername.setError("Cannot be empty");
    }

    @Override
    public void errorOnPassword() {
        etPassword.setError("Cannot be empty");
    }

    @Override
    public void credentialsVerified() {
        loginPresenterImpl.saveCredentialsToSharedPreferences(sharedPreferences, etUsername.getText().toString());
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
