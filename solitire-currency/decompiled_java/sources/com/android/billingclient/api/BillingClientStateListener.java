package com.android.billingclient.api;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface BillingClientStateListener {
    void onBillingServiceDisconnected();

    void onBillingSetupFinished(@NonNull BillingResult billingResult);
}
