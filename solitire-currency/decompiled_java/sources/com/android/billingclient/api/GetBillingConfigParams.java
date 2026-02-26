package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@zzi
public final class GetBillingConfigParams {

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
    @zzi
    public static final class Builder {
        private Builder() {
        }

        @NonNull
        public GetBillingConfigParams build() {
            return new GetBillingConfigParams();
        }
    }

    private GetBillingConfigParams() {
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }
}
