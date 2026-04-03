package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface PurchasesUpdatedListener {
    void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> list);
}
