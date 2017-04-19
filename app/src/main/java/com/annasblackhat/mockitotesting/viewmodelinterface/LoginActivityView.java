package com.annasblackhat.mockitotesting.viewmodelinterface;

import android.support.annotation.StringRes;

/**
 * Created by ANNASBlackHat on 20/04/2017.
 */

public interface LoginActivityView {
    void showUsernameError(@StringRes int msgResource);

    void showPasswordError(@StringRes int msgResource);

    void navigateToMainActivity();

    void showErrorMessage(@StringRes int login_error);
}
