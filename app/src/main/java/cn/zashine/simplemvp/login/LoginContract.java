package cn.zashine.simplemvp.login;

import cn.zashine.simplemvp.base.LoadDataViwe;
import cn.zashine.simplemvp.base.Presenter;

/**
 * Created by zashinE on 2017/9/11.
 */

public class LoginContract {
    interface LoginView extends LoadDataViwe {
        String getUsername();

        String getPassword();

        void loginSuccess(String str);

        void loginFailure(String str);
    }

    interface LoginPresenter extends Presenter<LoginView> {
        void login(String username, String password);
    }
}
