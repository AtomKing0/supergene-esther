package com.android.billingclient.api;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbu implements AcknowledgePurchaseResponseListener, BillingClientStateListener, ConsumeResponseListener, PurchaseHistoryResponseListener, PurchasesResponseListener, PurchasesUpdatedListener, SkuDetailsResponseListener {
    private final long zza;

    zzbu() {
        this.zza = 0L;
    }

    public static native void nativeOnAcknowledgePurchaseResponse(int i10, String str, long j10);

    public static native void nativeOnBillingServiceDisconnected();

    public static native void nativeOnBillingSetupFinished(int i10, String str, long j10);

    public static native void nativeOnConsumePurchaseResponse(int i10, String str, String str2, long j10);

    public static native void nativeOnPriceChangeConfirmationResult(int i10, String str, long j10);

    public static native void nativeOnPurchaseHistoryResponse(int i10, String str, PurchaseHistoryRecord[] purchaseHistoryRecordArr, long j10);

    public static native void nativeOnPurchasesUpdated(int i10, String str, Purchase[] purchaseArr);

    public static native void nativeOnQueryPurchasesResponse(int i10, String str, Purchase[] purchaseArr, long j10);

    public static native void nativeOnSkuDetailsResponse(int i10, String str, SkuDetails[] skuDetailsArr, long j10);

    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public final void onAcknowledgePurchaseResponse(BillingResult billingResult) {
        nativeOnAcknowledgePurchaseResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), this.zza);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        nativeOnBillingServiceDisconnected();
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(BillingResult billingResult) {
        nativeOnBillingSetupFinished(billingResult.getResponseCode(), billingResult.getDebugMessage(), this.zza);
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public final void onConsumeResponse(BillingResult billingResult, String str) {
        nativeOnConsumePurchaseResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), str, this.zza);
    }

    @Override // com.android.billingclient.api.PurchaseHistoryResponseListener
    public final void onPurchaseHistoryResponse(BillingResult billingResult, List<PurchaseHistoryRecord> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnPurchaseHistoryResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), (PurchaseHistoryRecord[]) list.toArray(new PurchaseHistoryRecord[list.size()]), this.zza);
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public final void onPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnPurchasesUpdated(billingResult.getResponseCode(), billingResult.getDebugMessage(), (Purchase[]) list.toArray(new Purchase[list.size()]));
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public final void onQueryPurchasesResponse(BillingResult billingResult, List<Purchase> list) {
        nativeOnQueryPurchasesResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), (Purchase[]) list.toArray(new Purchase[list.size()]), this.zza);
    }

    @Override // com.android.billingclient.api.SkuDetailsResponseListener
    public final void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        nativeOnSkuDetailsResponse(billingResult.getResponseCode(), billingResult.getDebugMessage(), (SkuDetails[]) list.toArray(new SkuDetails[list.size()]), this.zza);
    }

    zzbu(long j10) {
        this.zza = j10;
    }
}
