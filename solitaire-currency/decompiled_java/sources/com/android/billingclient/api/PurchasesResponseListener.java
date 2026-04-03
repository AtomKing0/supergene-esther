package com.android.billingclient.api;

import androidx.annotation.NonNull;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface PurchasesResponseListener {
    void onQueryPurchasesResponse(@NonNull BillingResult billingResult, @NonNull List<Purchase> list);
}
