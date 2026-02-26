package com.android.billingclient.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public interface SkuDetailsResponseListener {
    void onSkuDetailsResponse(@NonNull BillingResult billingResult, @Nullable List<SkuDetails> list);
}
