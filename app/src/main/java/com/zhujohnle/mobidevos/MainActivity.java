package com.zhujohnle.mobidevos;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * @auth &{zhujiule}
 * @date 2018/12/14
 * @copyright
 **/
public class MainActivity extends Activity {
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      setContentView(new View(this));
   }
}
