package com.king.store;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import java.util.List;

/* JADX INFO: compiled from: BillingManagerListener.java */
/* JADX INFO: loaded from: classes4.dex */
public interface f {
    void onBillingAcknowledgeResponse(BillingResult billingResult);

    void onBillingConsumeResponse(BillingResult billingResult, String str);

    void onBillingPurchasesUpdated(BillingResult billingResult, List<Purchase> list);

    void onBillingQueryPurchasesFinished(BillingResult billingResult, List<Purchase> list);

    void onBillingQuerySkuDetailsFinished(BillingResult billingResult, List<SkuDetails> list);

    void onBillingSetupFinished(BillingResult billingResult);
}
