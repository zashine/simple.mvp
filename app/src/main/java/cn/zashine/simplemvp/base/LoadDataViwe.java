package cn.zashine.simplemvp.base;

/**
 * Created by zashinE on 2017/9/11.
 */

public interface LoadDataViwe extends BaseView {

    void showLoading();

    void hideLoading();

    void showErrorToast(String errorMsg);

    void showErrorToast(int errorMsgId);
}
