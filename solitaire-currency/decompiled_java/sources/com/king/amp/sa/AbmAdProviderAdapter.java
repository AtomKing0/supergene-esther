package com.king.amp.sa;

import android.app.Activity;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface AbmAdProviderAdapter {
    void collectBidderToken(BidderTokenListener bidderTokenListener);

    String getAdapterVersion();

    String getProviderVersion();

    void initSDK(AdProviderNameValuePairs adProviderNameValuePairs);

    void setActivity(Activity activity);

    void setListener(AbmAdProviderAdapterListener abmAdProviderAdapterListener);

    void setLogTag(String str);

    void updateConsent(boolean z10);
}
