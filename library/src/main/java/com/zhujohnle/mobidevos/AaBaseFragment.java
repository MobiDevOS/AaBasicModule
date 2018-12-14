package com.zhujohnle.mobidevos;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhujohnle.mobidevos.architecture.mvp.BasePresenter;
import com.zhujohnle.mobidevos.architecture.mvp.BaseView;
import com.zhujohnle.mobidevos.architecture.mvp.PresenterProxy;

/**
 * @auth &{zhujiule}
 * @date 2018/12/11
 * @copyright
 **/
public abstract class AaBaseFragment extends Fragment implements BaseView {

   private PresenterProxy mLogicProxy;
   protected BasePresenter mPresenter;


   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      mLogicProxy = new PresenterProxy();
      initPresenter();

      return super.onCreateView(inflater, container, savedInstanceState);
   }


   @Override
   public void onResume() {
      super.onResume();
      if (mPresenter != null && !mPresenter.isViewBind()) {
         mLogicProxy.bind(getContact(), this);
      }
   }


   protected void initPresenter() {
      mLogicProxy = new PresenterProxy();
      if (getContact() != null)
         mPresenter = getLogicImpl();
   }


   //获得该页面的实例
   public <T> T getLogicImpl() {
      return mLogicProxy.bind(getContact(), this);
   }

   public abstract Class getContact();

   @Override
   public void onDestroy() {
      super.onDestroy();

      if(mLogicProxy!=null){
         mLogicProxy.unbind(getContact(),this);
      }


   }
}
