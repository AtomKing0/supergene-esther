package com.king.amp.sa;

import android.app.Activity;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface AbmAdProviderRewardAd {
    String getProperty(String str);

    void load(AdProviderNameValuePairs adProviderNameValuePairs);

    void setActivity(Activity activity);

    void setListener(p pVar);

    void setLogTag(String str);

    void show();
}
