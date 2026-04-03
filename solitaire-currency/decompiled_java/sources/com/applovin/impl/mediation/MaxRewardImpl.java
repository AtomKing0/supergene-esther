package com.applovin.impl.mediation;

import androidx.annotation.NonNull;
import com.applovin.mediation.MaxReward;

/* JADX INFO: loaded from: classes2.dex */
public class MaxRewardImpl implements MaxReward {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f5943b;

    private MaxRewardImpl(int i10, String str) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Reward amount must be greater than or equal to 0");
        }
        this.f5942a = str;
        this.f5943b = i10;
    }

    public static MaxReward create(int i10, String str) {
        return new MaxRewardImpl(i10, str);
    }

    public static MaxReward createDefault() {
        return create(0, "");
    }

    @Override // com.applovin.mediation.MaxReward
    public final int getAmount() {
        return this.f5943b;
    }

    @Override // com.applovin.mediation.MaxReward
    public final String getLabel() {
        return this.f5942a;
    }

    @NonNull
    public String toString() {
        return "MaxReward{amount=" + this.f5943b + ", label=" + this.f5942a + "}";
    }
}
