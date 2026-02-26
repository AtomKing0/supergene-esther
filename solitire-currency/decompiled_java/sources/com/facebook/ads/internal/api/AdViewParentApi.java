package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import androidx.annotation.Keep;
import androidx.annotation.UiThread;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@UiThread
public interface AdViewParentApi {
    void onConfigurationChanged(Configuration configuration);
}
