package com.tnnowu.android.switchlanguage;

import android.app.Application;
import android.content.Context;

/**
 * Created by Tnno Wu on 2017/04/17.
 */

public class BaseApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base, "en"));
    }

}
