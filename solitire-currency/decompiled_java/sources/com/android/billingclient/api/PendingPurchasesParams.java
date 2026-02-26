package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@zzk
public final class PendingPurchasesParams {
    private final boolean enableOneTimeProducts;
    private final boolean enablePrepaidPlans;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
    @zzk
    public static final class Builder {
        private boolean enableOneTimeProducts;
        private boolean enablePrepaidPlans;

        private Builder() {
        }

        @NonNull
        public PendingPurchasesParams build() {
            if (!this.enableOneTimeProducts) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new PendingPurchasesParams(true, this.enablePrepaidPlans);
        }

        @NonNull
        public Builder enableOneTimeProducts() {
            this.enableOneTimeProducts = true;
            return this;
        }

        @NonNull
        public Builder enablePrepaidPlans() {
            this.enablePrepaidPlans = true;
            return this;
        }
    }

    private PendingPurchasesParams(boolean z10, boolean z11) {
        this.enableOneTimeProducts = z10;
        this.enablePrepaidPlans = z11;
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    boolean isEnabledForOneTimeProducts() {
        return this.enableOneTimeProducts;
    }

    boolean isEnabledForPrepaidPlans() {
        return this.enablePrepaidPlans;
    }
}
