package com.zhujohnle.mobidevos.mvp;

public interface LoadView<T> extends LoadBaseView {
    void requestSuccess(T t);
}
