package com.applovin.sdk;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes2.dex */
public interface AppLovinCmpService {

    public interface OnCompletedListener {
        void onCompleted(@Nullable AppLovinCmpError appLovinCmpError);
    }

    boolean hasSupportedCmp();

    void showCmpForExistingUser(@NonNull Activity activity, @NonNull OnCompletedListener onCompletedListener);
}
