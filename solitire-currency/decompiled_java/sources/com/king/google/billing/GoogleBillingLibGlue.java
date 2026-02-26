package com.king.google.billing;

import android.app.Activity;
import android.util.Log;
import androidx.annotation.Keep;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.king.store.BillingManager;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class GoogleBillingLibGlue implements com.king.store.f {
    public static final String TAG = "com.king.google.billing.GoogleBillingLibGlue";
    private BillingManager mBillingManager;
    private Activity mMainActivity;
    private long mStoreAndroidObject = 0;
    private long mUserData;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f17100a;

        a(List list) {
            this.f17100a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = GoogleBillingLibGlue.TAG;
            Log.i(str, "querySkuDetails with " + this.f17100a.size() + " number of SKUs");
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(str, "BillingManager null, cannot query for sku details.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.querySkuDetails(this.f17100a);
            }
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(GoogleBillingLibGlue.TAG, "BillingManager null, cannot query for purchases.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.queryPurchases();
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17103a;

        c(String str) {
            this.f17103a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(GoogleBillingLibGlue.TAG, "BillingManager null, cannot consume purchases.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.consumePurchase(this.f17103a);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17105a;

        d(String str) {
            this.f17105a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(GoogleBillingLibGlue.TAG, "BillingManager null, cannot acknowledge purchases.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.acknowledgePurchase(this.f17105a);
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17107a;

        e(String str) {
            this.f17107a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(GoogleBillingLibGlue.TAG, "BillingManager null, cannot purchase.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.purchase(this.f17107a);
            }
        }
    }

    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (GoogleBillingLibGlue.this.mBillingManager == null) {
                Log.e(GoogleBillingLibGlue.TAG, "BillingManager null, cannot connect.");
            } else {
                GoogleBillingLibGlue.this.mBillingManager.connect();
            }
        }
    }

    public GoogleBillingLibGlue(Activity activity, long j10) {
        this.mMainActivity = activity;
        this.mUserData = j10;
        this.mBillingManager = new BillingManager(this.mMainActivity, this);
    }

    private native void onAcknowledgeFinished(int i10, long j10);

    private native void onConsumeFinished(int i10, String str, long j10);

    private native void onPurchaseFinished(int i10, Purchase[] purchaseArr, long j10);

    private native void onQueryPurchasesFinished(int i10, Purchase[] purchaseArr, long j10);

    private native void onQuerySkuDetailsFinished(int i10, SkuDetails[] skuDetailsArr, long j10);

    private native void onSetupFinished(int i10, long j10);

    public void acknowledge(String str) {
        this.mMainActivity.runOnUiThread(new d(str));
    }

    public void connect() {
        this.mMainActivity.runOnUiThread(new f());
    }

    public void consume(String str) {
        this.mMainActivity.runOnUiThread(new c(str));
    }

    public void disconnect() {
        BillingManager billingManager = this.mBillingManager;
        if (billingManager != null) {
            billingManager.disconnect();
        }
    }

    @Override // com.king.store.f
    public void onBillingAcknowledgeResponse(BillingResult billingResult) {
        onAcknowledgeFinished(billingResult.getResponseCode(), this.mUserData);
    }

    @Override // com.king.store.f
    public void onBillingConsumeResponse(BillingResult billingResult, String str) {
        onConsumeFinished(billingResult.getResponseCode(), str, this.mUserData);
    }

    @Override // com.king.store.f
    public void onBillingPurchasesUpdated(BillingResult billingResult, List<Purchase> list) {
        Purchase[] purchaseArr = list != null ? (Purchase[]) list.toArray(new Purchase[list.size()]) : null;
        long j10 = this.mUserData;
        if (purchaseArr == null) {
            Log.i(TAG, "onPurchaseFinished called with no products");
            onPurchaseFinished(billingResult.getResponseCode(), null, j10);
            return;
        }
        Log.i(TAG, "onPurchaseFinished called with " + list.size() + " number of products");
        onPurchaseFinished(billingResult.getResponseCode(), purchaseArr, j10);
    }

    @Override // com.king.store.f
    public void onBillingQueryPurchasesFinished(BillingResult billingResult, List<Purchase> list) {
        onQueryPurchasesFinished(billingResult.getResponseCode(), list != null ? (Purchase[]) list.toArray(new Purchase[list.size()]) : null, this.mUserData);
    }

    @Override // com.king.store.f
    public void onBillingQuerySkuDetailsFinished(BillingResult billingResult, List<SkuDetails> list) {
        onQuerySkuDetailsFinished(billingResult.getResponseCode(), list != null ? (SkuDetails[]) list.toArray(new SkuDetails[list.size()]) : null, this.mUserData);
    }

    @Override // com.king.store.f
    public void onBillingSetupFinished(BillingResult billingResult) {
        onSetupFinished(billingResult.getResponseCode(), this.mUserData);
    }

    public void purchase(String str) {
        this.mMainActivity.runOnUiThread(new e(str));
    }

    public void queryPurchases() {
        this.mMainActivity.runOnUiThread(new b());
    }

    public void querySkuDetails(List<String> list) {
        this.mMainActivity.runOnUiThread(new a(list));
    }
}
