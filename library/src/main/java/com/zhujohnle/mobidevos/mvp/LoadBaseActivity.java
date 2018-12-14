package com.zhujohnle.mobidevos.mvp;

import android.view.View;

import com.zhujohnle.mobidevos.AaBaseActivity;
import com.zhujohnle.mobidevos.view.ErrView;
import com.zhujohnle.mobidevos.view.StatusLayout;

public abstract class LoadBaseActivity extends AaBaseActivity {

    public void showErrorView(String msg) {
        if(getStatusLayout()!=null)
        {
            getStatusLayout().showErr();
            View errView = getStatusLayout().getErrView();
            if(errView!=null&& errView instanceof ErrView){
                ErrView kmErrView = (ErrView) errView;
                kmErrView.setErrMsg(msg);
            }
        }
    }

    public void showEmptyView(){
        if(getStatusLayout()!=null)
        {
            getStatusLayout().showEmpty();
        }
    }


    public void showLoadingView() {
        if(getStatusLayout()!=null)
        {
            getStatusLayout().showLoading();
        }
    }


    public void showNormalView() {
        if(getStatusLayout()!=null)
        {
            getStatusLayout().showNormal();
        }
    }

    public StatusLayout getStatusLayout(){
        return null;
    }
}
