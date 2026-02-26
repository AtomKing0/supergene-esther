package com.google.android.gms.ads;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AdLoadCallback<AdT> {
    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
    }

    public void onAdLoaded(@NonNull AdT adt) {
    }
}
