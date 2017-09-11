package cn.zashine.simplemvp.login;

import android.text.TextUtils;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zashine.simplemvp.R;
import cn.zashine.simplemvp.base.BaseActivity;

public class LoginActivity extends BaseActivity<LoginContract.LoginPresenter> implements LoginContract.LoginView {

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @OnClick(R.id.bt_login)
    void login() {
        if (checkNull()) {
            mPresenter.login(getUsername(), getPassword());
        }
     }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected LoginContract.LoginPresenter generatePresenter() {
        return new LoginPresenterImpl();
    }

    @Override
    public String getUsername() {
        return etUsername.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return etPassword.getText().toString().trim();
    }

    @Override
    public void loginSuccess(String str) {
        showErrorToast(str);
    }

    @Override
    public void loginFailure(String str) {
        showErrorToast(str);
    }

    private boolean checkNull() {
        boolean checkNull = true;
        if (TextUtils.isEmpty(getUsername())) {
            etUsername.setError("帐号不能为空");
            checkNull = false;
        }
        if (TextUtils.isEmpty(getPassword())) {
            etPassword.setError("密码不能为空");
            checkNull = false;
        }
        return checkNull;
    }
}
