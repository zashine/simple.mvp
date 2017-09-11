package cn.zashine.simplemvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zashinE on 2017/9/11.
 */

public abstract class BaseActivity<P extends Presenter> extends AppCompatActivity {
    protected P mPresenter;
    private Unbinder binder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mPresenter = generatePresenter();
        initViewsAndEvents(savedInstanceState);
    }

    protected abstract int getLayoutId();

    protected abstract P generatePresenter();

    protected void initViewsAndEvents(Bundle savedInstanceState) {
        if (mPresenter != null) {
            mPresenter.attachView((BaseView) this);
        }
        bindViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
        unBindViews();
    }

    protected void bindViews() {
        if (isBindView()) {
            binder = ButterKnife.bind(this);
        }
    }

    private void unBindViews() {
        if (isBindView()) {
            binder.unbind();
        }
    }

    public boolean isBindView() {
        return true;
    }

    public void showErrorToast(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    public void showErrorToast(int errorMsgId) {
        Toast.makeText(this, errorMsgId, Toast.LENGTH_SHORT).show();
    }

    public void showLoading() {

    }

    public void hideLoading() {

    }
}
