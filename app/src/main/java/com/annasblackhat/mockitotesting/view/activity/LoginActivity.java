package com.annasblackhat.mockitotesting.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.annasblackhat.mockitotesting.R;
import com.annasblackhat.mockitotesting.databinding.ActivityLoginBinding;
import com.annasblackhat.mockitotesting.model.Login;
import com.annasblackhat.mockitotesting.viewmodel.LoginViewModel;
import com.annasblackhat.mockitotesting.viewmodelinterface.LoginActivityView;

public class LoginActivity extends AppCompatActivity implements LoginActivityView {

    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        viewModel = new LoginViewModel(this);
        binding.setLogin(new Login());
        binding.setViewmodel(viewModel);
    }

    @Override
    public void showUsernameError(@StringRes int msgResource) {
        binding.edtUsername.setError(getString(msgResource));
    }

    @Override
    public void showPasswordError(@StringRes int msgResource) {
        binding.edtPassword.setError(getString(msgResource));
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void showErrorMessage(@StringRes int login_error) {
        Toast.makeText(this, getString(login_error), Toast.LENGTH_SHORT).show();
    }
}
