package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@zzi
public interface BillingConfigResponseListener {
    void onBillingConfigResponse(@NonNull BillingResult billingResult, @Nullable BillingConfig billingConfig);
}
