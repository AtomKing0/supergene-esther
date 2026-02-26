package com.google.ads.mediation.applovin;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.rewarded.RewardItem;

/* JADX INFO: compiled from: AppLovinRewardItem.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements RewardItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f8268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8269b;

    public f(int i10, String str) {
        this.f8268a = i10;
        this.f8269b = str;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public int getAmount() {
        return this.f8268a;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    @NonNull
    public String getType() {
        return this.f8269b;
    }
}
