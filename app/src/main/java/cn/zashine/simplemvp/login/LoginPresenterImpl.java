package cn.zashine.simplemvp.login;

import android.text.TextUtils;

import cn.zashine.simplemvp.base.BasePresenter;

/**
 * Created by zashinE on 2017/9/11.
 */

public class LoginPresenterImpl extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    public LoginPresenterImpl() {
    }

    @Override
    public void login(String username, String password) {
        if (TextUtils.equals("username", username) && TextUtils.equals("mima1234", password)) {
            mView.showErrorToast("登录成功");
        } else {
            mView.showErrorToast("登录失败，请重新输入");
        }
    }
}
