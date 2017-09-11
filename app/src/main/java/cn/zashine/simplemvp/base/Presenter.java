package cn.zashine.simplemvp.base;

/**
 * Created by zashinE on 2017/9/11.
 */

public interface Presenter<V extends BaseView> {
    void attachView(V view);

    void detachView();
}
