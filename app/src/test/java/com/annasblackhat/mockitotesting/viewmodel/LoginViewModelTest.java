package com.annasblackhat.mockitotesting.viewmodel;

import com.annasblackhat.mockitotesting.R;
import com.annasblackhat.mockitotesting.model.Login;
import com.annasblackhat.mockitotesting.viewmodelinterface.LoginActivityView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

/**
 * Created by ANNASBlackHat on 20/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class LoginViewModelTest {

    private LoginViewModel viewModel;
    @Mock
    private LoginActivityView view;

    @Before
    public void setUp() throws Exception {
        viewModel = new LoginViewModel(view);
    }

    @Test
    public void shoudlShowErrorMessageWhenUsernameIsEmpty() throws Exception {
        viewModel.login(new Login());
        verify(view).showUsernameError(R.string.username_error);
    }

    @Test
    public void shoudShowErrorMessageWhenPasswordIsEmpty() throws Exception {
        Login login = new Login();
        login.setUsername("admin");
        viewModel.login(login);
        verify(view).showPasswordError(R.string.password_error_empty);
    }

    @Test
    public void shouldShowErrorWhenPasswordLengthLessThanSix() throws Exception {
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("123");
        viewModel.login(login);
        verify(view).showPasswordError(R.string.password_error_length);
    }

    @Test
    public void shouldShowWrongUsernameOrPassword() throws Exception {
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("1234567");
        viewModel.login(login);
        verify(view).showErrorMessage(R.string.login_error);
    }

    @Test
    public void shouldNavigateToMainActivity() throws Exception {
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("password");
        viewModel.login(login);
        verify(view).navigateToMainActivity();
    }
}