package com.king.store;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.android.billingclient.api.PendingPurchasesParams;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.king.store.BillingScheduler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BillingManager implements PurchasesUpdatedListener, ConsumeResponseListener, BillingClientStateListener, SkuDetailsResponseListener, AcknowledgePurchaseResponseListener, PurchasesResponseListener {
    private static final String TAG = "com.king.store.BillingManager";
    private Activity mActivity;
    private BillingClient mBillingClient;
    private com.king.store.f mBillingManagerListener;
    private Map<String, SkuDetails> mSkuDetails = new HashMap();
    private BillingQueue mBillingQueue = new BillingQueue();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BillingResult f17119a;

        a(BillingResult billingResult) {
            this.f17119a = billingResult;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BillingManager.this.mBillingClient.isReady()) {
                Log.i(BillingManager.TAG, "Connected to Google Play.");
            } else {
                Log.e(BillingManager.TAG, "Billing client not ready to start a new connection");
            }
            BillingManager.this.mBillingManagerListener.onBillingSetupFinished(this.f17119a);
        }
    }

    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(BillingManager.TAG, "Disconnected from Google Play.");
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Log.i(BillingManager.TAG, "Business layer wants to disconnect.");
            if (BillingManager.this.mBillingClient.isReady()) {
                BillingManager.this.mBillingClient.endConnection();
            } else {
                Log.e(BillingManager.TAG, "Billing client not ready to end connection.");
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f17123a;

        d(String str) {
            this.f17123a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BillingManager.this.mBillingClient.consumeAsync(ConsumeParams.newBuilder().setPurchaseToken(this.f17123a).build(), BillingManager.this);
            } catch (Exception e10) {
                Log.e(BillingManager.TAG, "Could not consume purchase token(" + this.f17123a + ") with exception: " + e10.getMessage());
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SkuDetails f17125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f17126b;

        e(SkuDetails skuDetails, String str) {
            this.f17125a = skuDetails;
            this.f17126b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BillingFlowParams.Builder builderNewBuilder = BillingFlowParams.newBuilder();
                builderNewBuilder.setSkuDetails(this.f17125a);
                if (BillingManager.this.mBillingClient.launchBillingFlow(BillingManager.this.mActivity, builderNewBuilder.build()) == null) {
                    Log.e(BillingManager.TAG, "Result from purchase with sku=" + this.f17126b + " is null!");
                }
            } catch (Exception unused) {
                Log.e(BillingManager.TAG, "Could not purchase sku: " + this.f17126b);
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f17128a;

        f(List list) {
            this.f17128a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SkuDetailsParams.Builder builderNewBuilder = SkuDetailsParams.newBuilder();
                builderNewBuilder.setSkusList(this.f17128a).setType("inapp");
                builderNewBuilder.build();
                BillingManager.this.mBillingClient.querySkuDetailsAsync(builderNewBuilder.build(), BillingManager.this);
            } catch (Exception e10) {
                Log.e(BillingManager.TAG, "Failed to querySkuDetails with exception: " + e10.getMessage());
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BillingManager.this.mBillingClient != null && BillingManager.this.mBillingClient.isReady()) {
                BillingManager.this.mBillingClient.queryPurchasesAsync(QueryPurchasesParams.newBuilder().setProductType("inapp").build(), BillingManager.this);
                return;
            }
            BillingResult.Builder builderNewBuilder = BillingResult.newBuilder();
            builderNewBuilder.setResponseCode(6);
            builderNewBuilder.setDebugMessage("Billing client is not ready or setup properly!");
            BillingResult billingResultBuild = builderNewBuilder.build();
            Log.e(BillingManager.TAG, "Debug message: " + billingResultBuild.getDebugMessage());
            BillingManager.this.mBillingManagerListener.onBillingQueryPurchasesFinished(billingResultBuild, null);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BillingResult f17131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f17132b;

        h(BillingResult billingResult, List list) {
            this.f17131a = billingResult;
            this.f17132b = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(BillingResult billingResult, List list) {
            if (billingResult.getResponseCode() != 0) {
                Log.e(BillingManager.TAG, "Something went very wrong when purchasing. Error code: " + billingResult.getResponseCode());
                Log.e(BillingManager.TAG, "Debug message: " + billingResult.getDebugMessage());
            }
            BillingManager.this.mBillingManagerListener.onBillingPurchasesUpdated(billingResult, list);
        }

        @Override // java.lang.Runnable
        public void run() {
            Handler handlerFindUiHandler = BillingManager.this.findUiHandler();
            final BillingResult billingResult = this.f17131a;
            final List list = this.f17132b;
            handlerFindUiHandler.post(new Runnable() { // from class: com.king.store.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f17161a.b(billingResult, list);
                }
            });
        }
    }

    public BillingManager(Activity activity, com.king.store.f fVar) {
        this.mActivity = activity;
        this.mBillingManagerListener = fVar;
    }

    private void connectToGooglePlayService() {
        Log.i(TAG, "Connecting to Google Play");
        this.mBillingClient.startConnection(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Handler findUiHandler() {
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onAcknowledgePurchaseResponse$2(BillingResult billingResult) {
        if (billingResult.getResponseCode() != 0) {
            String str = TAG;
            Log.e(str, "Something went very wrong when acknowledging. Error code: " + billingResult.getResponseCode());
            Log.e(str, "Debug message: " + billingResult.getDebugMessage());
        }
        this.mBillingManagerListener.onBillingAcknowledgeResponse(billingResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onConsumeResponse$1(BillingResult billingResult, String str) {
        if (billingResult.getResponseCode() != 0) {
            String str2 = TAG;
            Log.e(str2, "Something went very wrong when consuming. Error code: " + billingResult.getResponseCode());
            Log.e(str2, "Debug message: " + billingResult.getDebugMessage());
        } else {
            Log.i(TAG, "Purchase successfully consumed with token: " + str);
        }
        this.mBillingManagerListener.onBillingConsumeResponse(billingResult, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onQueryPurchasesResponse$3(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() != 0) {
            String str = TAG;
            Log.e(str, "Something went very wrong when querying purchases. Error code: " + billingResult.getResponseCode());
            Log.e(str, "Debug message: " + billingResult.getDebugMessage());
        }
        this.mBillingManagerListener.onBillingQueryPurchasesFinished(billingResult, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onSkuDetailsResponse$0(BillingResult billingResult, List list) {
        if (billingResult.getResponseCode() == 0) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SkuDetails skuDetails = (SkuDetails) it.next();
                this.mSkuDetails.put(skuDetails.getSku(), skuDetails);
            }
        } else {
            String str = TAG;
            Log.e(str, "Something went very wrong when querying for sku details. Error code: " + billingResult.getResponseCode());
            Log.e(str, "Debug message: " + billingResult.getDebugMessage());
        }
        this.mBillingManagerListener.onBillingQuerySkuDetailsFinished(billingResult, list);
    }

    public void acknowledgePurchase(String str) {
        throw new UnsupportedOperationException("The Acknowledge feature is not yet supported!");
    }

    public void connect() {
        Log.i(TAG, "Business layer wants to connect.");
        try {
            this.mBillingClient = BillingClient.newBuilder(this.mActivity).setListener(this).enablePendingPurchases(PendingPurchasesParams.newBuilder().enableOneTimeProducts().build()).build();
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage());
        }
        connectToGooglePlayService();
    }

    public void consumePurchase(String str) {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient == null || !billingClient.isReady()) {
            Log.e(TAG, "Billing client is not ready or setup properly! Will abort action.");
            return;
        }
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new d(str));
        billingScheduler.submit(this.mBillingQueue);
    }

    public void disconnect() {
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new c());
        billingScheduler.willChangeStateTo(BillingScheduler.c.DISCONNECTED);
        billingScheduler.submit(this.mBillingQueue);
    }

    @Override // com.android.billingclient.api.AcknowledgePurchaseResponseListener
    public void onAcknowledgePurchaseResponse(@NonNull final BillingResult billingResult) {
        findUiHandler().post(new Runnable() { // from class: com.king.store.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f17156a.lambda$onAcknowledgePurchaseResponse$2(billingResult);
            }
        });
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingServiceDisconnected() {
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new b());
        billingScheduler.willChangeStateTo(BillingScheduler.c.DISCONNECTED);
        billingScheduler.submit(this.mBillingQueue);
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public void onBillingSetupFinished(@NonNull BillingResult billingResult) {
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new a(billingResult));
        billingScheduler.willChangeStateTo(BillingScheduler.c.CONNECTED);
        billingScheduler.submit(this.mBillingQueue);
    }

    @Override // com.android.billingclient.api.ConsumeResponseListener
    public void onConsumeResponse(final BillingResult billingResult, final String str) {
        findUiHandler().post(new Runnable() { // from class: com.king.store.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f17158a.lambda$onConsumeResponse$1(billingResult, str);
            }
        });
    }

    @Override // com.android.billingclient.api.PurchasesUpdatedListener
    public void onPurchasesUpdated(@NonNull BillingResult billingResult, @Nullable List<Purchase> list) {
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new h(billingResult, list));
        billingScheduler.willChangeStateTo(BillingScheduler.c.PURCHASE_FINISHED);
        billingScheduler.submit(this.mBillingQueue);
    }

    @Override // com.android.billingclient.api.PurchasesResponseListener
    public void onQueryPurchasesResponse(@NonNull final BillingResult billingResult, @NonNull final List<Purchase> list) {
        findUiHandler().post(new Runnable() { // from class: com.king.store.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f17150a.lambda$onQueryPurchasesResponse$3(billingResult, list);
            }
        });
    }

    @Override // com.android.billingclient.api.SkuDetailsResponseListener
    public void onSkuDetailsResponse(@NonNull final BillingResult billingResult, @Nullable final List<SkuDetails> list) {
        findUiHandler().post(new Runnable() { // from class: com.king.store.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f17153a.lambda$onSkuDetailsResponse$0(billingResult, list);
            }
        });
    }

    public void purchase(String str) {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient == null || !billingClient.isReady()) {
            Log.e(TAG, "Billing client is not ready or setup properly! Will abort action.");
            return;
        }
        SkuDetails skuDetails = this.mSkuDetails.get(str);
        if (skuDetails == null) {
            Log.e(TAG, "The SKU that you're trying to use when purchasing doesn't exist in  the internal cache. Did you run querySkuDetails before?");
            return;
        }
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new e(skuDetails, str));
        billingScheduler.willChangeStateTo(BillingScheduler.c.PURCHASE_ONGOING);
        billingScheduler.submit(this.mBillingQueue);
    }

    public void queryPurchases() {
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new g());
        billingScheduler.submit(this.mBillingQueue);
    }

    public void querySkuDetails(List<String> list) {
        BillingClient billingClient = this.mBillingClient;
        if (billingClient == null || !billingClient.isReady()) {
            Log.e(TAG, "Billing client is not ready or setup properly! Will abort action.");
            return;
        }
        BillingScheduler billingScheduler = new BillingScheduler();
        billingScheduler.enableDebugLogging(false);
        billingScheduler.addAction(new f(list));
        billingScheduler.submit(this.mBillingQueue);
    }
}
