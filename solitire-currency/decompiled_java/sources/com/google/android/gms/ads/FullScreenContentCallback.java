package com.google.android.gms.ads;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FullScreenContentCallback {
    public static final int ERROR_CODE_AD_REUSED = 1;
    public static final int ERROR_CODE_APP_NOT_FOREGROUND = 3;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_MEDIATION_SHOW_ERROR = 4;
    public static final int ERROR_CODE_NOT_READY = 2;

    public void onAdClicked() {
    }

    public void onAdDismissedFullScreenContent() {
    }

    public void onAdImpression() {
    }

    public void onAdShowedFullScreenContent() {
    }

    public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
    }
}
