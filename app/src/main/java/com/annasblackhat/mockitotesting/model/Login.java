package com.annasblackhat.mockitotesting.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.annasblackhat.mockitotesting.BR;

/**
 * Created by ANNASBlackHat on 20/04/2017.
 */

public class Login extends BaseObservable {
    private String username;
    private String password;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
