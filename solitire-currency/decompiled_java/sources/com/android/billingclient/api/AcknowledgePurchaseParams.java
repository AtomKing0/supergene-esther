package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class AcknowledgePurchaseParams {
    private String zza;

    /* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
    public static final class Builder {
        private String zza;

        private Builder() {
            throw null;
        }

        /* synthetic */ Builder(zza zzaVar) {
        }

        @NonNull
        public AcknowledgePurchaseParams build() {
            String str = this.zza;
            if (str == null) {
                throw new IllegalArgumentException("Purchase token must be set");
            }
            AcknowledgePurchaseParams acknowledgePurchaseParams = new AcknowledgePurchaseParams(null);
            acknowledgePurchaseParams.zza = str;
            return acknowledgePurchaseParams;
        }

        @NonNull
        public Builder setPurchaseToken(@NonNull String str) {
            this.zza = str;
            return this;
        }
    }

    private AcknowledgePurchaseParams() {
        throw null;
    }

    /* synthetic */ AcknowledgePurchaseParams(zzb zzbVar) {
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder(null);
    }

    @NonNull
    public String getPurchaseToken() {
        return this.zza;
    }
}
