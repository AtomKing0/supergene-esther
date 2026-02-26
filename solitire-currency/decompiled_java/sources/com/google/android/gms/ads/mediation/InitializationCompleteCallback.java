package com.google.android.gms.ads.mediation;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InitializationCompleteCallback {
    void onInitializationFailed(@NonNull String str);

    void onInitializationSucceeded();
}
