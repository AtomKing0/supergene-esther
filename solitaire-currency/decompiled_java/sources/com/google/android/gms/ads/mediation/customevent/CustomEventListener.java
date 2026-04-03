package com.google.android.gms.ads.mediation.customevent;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public interface CustomEventListener {
    void onAdClicked();

    void onAdClosed();

    @Deprecated
    void onAdFailedToLoad(int i10);

    void onAdFailedToLoad(@NonNull AdError adError);

    void onAdLeftApplication();

    void onAdOpened();
}
