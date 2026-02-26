package com.google.android.gms.ads.rewarded;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface RewardItem {

    @NonNull
    public static final RewardItem DEFAULT_REWARD = new zza();

    int getAmount();

    @NonNull
    String getType();
}
