package com.annasblackhat.mockitotesting.viewmodel;

import com.annasblackhat.mockitotesting.R;
import com.annasblackhat.mockitotesting.model.Login;
import com.annasblackhat.mockitotesting.viewmodelinterface.LoginActivityView;

/**
 * Created by ANNASBlackHat on 20/04/2017.
 */

public class LoginViewModel {

    private LoginActivityView view;

    public LoginViewModel(LoginActivityView  view) {
        this.view = view;
    }

    public void login(Login login){
        //checking field
        if(login.getUsername() == null || login.getUsername().isEmpty()){
            view.showUsernameError(R.string.username_error);
            return;
        }else if(login.getPassword() == null || login.getPassword().isEmpty()){
            view.showPasswordError(R.string.password_error_empty);
            return;
        }else if(login.getPassword().length() < 6){
            view.showPasswordError(R.string.password_error_length);
            return;
        }

        //sending username and password to the server for checking
        //........
        //at this time, we just do manual checking
        boolean isValid = login.getUsername().equals("admin") && login.getPassword().equals("password");
        if(isValid){
            view.navigateToMainActivity();
        }else{
            view.showErrorMessage(R.string.login_error);
        }
    }
}
