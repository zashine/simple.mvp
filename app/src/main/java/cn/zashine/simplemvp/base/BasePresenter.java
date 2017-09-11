package cn.zashine.simplemvp.base;

/**
 * Created by zashinE on 2017/9/11.
 */

public class BasePresenter<V extends BaseView> {
    protected V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView() {
        this.mView = null;
    }

    protected void registerEventBus() {
        if (isRegisterEventBus()) {
            // 注册事件总线
        }
    }

    private void unRegisterEventBus() {
        // 反注册
    }

    protected boolean isRegisterEventBus() {
        return true;
    }
}
