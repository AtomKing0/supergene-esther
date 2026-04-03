package com.unity3d.ads.core.data.manager;

import a9.c;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.exception.TransactionException;
import com.unity3d.ads.core.data.repository.TransactionEventRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetTransactionData;
import com.unity3d.ads.core.domain.events.GetTransactionRequest;
import com.unity3d.services.store.StoreMonitor;
import com.unity3d.services.store.gpbl.BillingResultResponseCode;
import com.unity3d.services.store.gpbl.bridges.BillingResultBridge;
import com.unity3d.services.store.gpbl.bridges.PurchaseBridge;
import com.unity3d.services.store.gpbl.bridges.SkuDetailsBridge;
import com.unity3d.services.store.gpbl.listeners.BillingInitializationListener;
import com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener;
import h9.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.w;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.h;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.x;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: TransactionEventManager.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TransactionEventManager {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    private static final String INAPP = "inapp";
    private static final int dummyOperationId = 42;

    @NotNull
    private final GetTransactionData getTransactionData;

    @NotNull
    private final GetTransactionRequest getTransactionRequest;

    @NotNull
    private final ByteStringDataSource iapTransactionStore;

    @NotNull
    private final o0 scope;

    @NotNull
    private final SendDiagnosticEvent sendDiagnosticEvent;

    @NotNull
    private final StoreMonitor storeMonitor;

    @NotNull
    private final TransactionEventRepository transactionEventRepository;

    /* JADX INFO: compiled from: TransactionEventManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: TransactionEventManager.kt */
    @f(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1", f = "TransactionEventManager.kt", l = {123}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        Object L$0;
        int label;

        AnonymousClass1(d<? super AnonymousClass1> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return TransactionEventManager.this.new AnonymousClass1(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            Object objE = a9.d.e();
            int i10 = this.label;
            try {
            } catch (TransactionException unused) {
                SendDiagnosticEvent.DefaultImpls.invoke$default(TransactionEventManager.this.sendDiagnosticEvent, "billing_service_unavailable", null, null, null, null, 30, null);
            }
            if (i10 == 0) {
                u.b(obj);
                if (!TransactionEventManager.this.storeMonitor.isInitialized()) {
                    final TransactionEventManager transactionEventManager = TransactionEventManager.this;
                    this.L$0 = transactionEventManager;
                    this.label = 1;
                    final kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(c.c(this), 1);
                    pVar.C();
                    transactionEventManager.storeMonitor.initialize(new BillingInitializationListener() { // from class: com.unity3d.ads.core.data.manager.TransactionEventManager$invoke$1$1$1
                        private final void tryResume() {
                            if (pVar.isActive()) {
                                o<k0> oVar = pVar;
                                t.a aVar = t.f35208b;
                                oVar.resumeWith(t.b(k0.f35197a));
                            }
                        }

                        private final void tryResumeWithException(Exception exc) {
                            if (pVar.isActive()) {
                                o<k0> oVar = pVar;
                                t.a aVar = t.f35208b;
                                oVar.resumeWith(t.b(u.a(exc)));
                            }
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                        public void onBillingServiceDisconnected() {
                            tryResumeWithException(new TransactionException("Billing service disconnected"));
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingClientStateListener
                        public void onBillingSetupFinished(@NotNull BillingResultBridge billingResult) {
                            kotlin.jvm.internal.t.i(billingResult, "billingResult");
                            if (billingResult.getResponseCode() != BillingResultResponseCode.OK) {
                                tryResumeWithException(new TransactionException("Billing setup failed"));
                            } else {
                                tryResume();
                            }
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.BillingInitializationListener
                        public void onIsAlreadyInitialized() {
                            tryResume();
                        }

                        @Override // com.unity3d.services.store.gpbl.listeners.PurchaseUpdatedResponseListener
                        public void onPurchaseUpdated(@NotNull BillingResultBridge billingResult, @Nullable List<? extends PurchaseBridge> list) {
                            kotlin.jvm.internal.t.i(billingResult, "billingResult");
                            transactionEventManager.onPurchasesReceived(billingResult, list);
                        }
                    });
                    Object objZ = pVar.z();
                    if (objZ == a9.d.e()) {
                        h.c(this);
                    }
                    if (objZ == objE) {
                        return objE;
                    }
                }
                return k0.f35197a;
            }
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            u.b(obj);
            StoreMonitor storeMonitor = TransactionEventManager.this.storeMonitor;
            final TransactionEventManager transactionEventManager2 = TransactionEventManager.this;
            storeMonitor.getPurchases(42, "inapp", new PurchasesResponseListener() { // from class: com.unity3d.ads.core.data.manager.a
                @Override // com.unity3d.services.store.gpbl.listeners.PurchasesResponseListener
                public final void onPurchaseResponse(BillingResultBridge billingResultBridge, List list) {
                    TransactionEventManager.access$onPurchasesReceived(transactionEventManager2, billingResultBridge, list);
                }
            });
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: renamed from: com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: TransactionEventManager.kt */
    @f(c = "com.unity3d.ads.core.data.manager.TransactionEventManager$onPurchasesReceived$1", f = "TransactionEventManager.kt", l = {92, 109, 112}, m = "invokeSuspend")
    static final class C31691 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ List<PurchaseBridge> $purchases;
        int I$0;
        int I$1;
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ TransactionEventManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C31691(List<? extends PurchaseBridge> list, TransactionEventManager transactionEventManager, d<? super C31691> dVar) {
            super(2, dVar);
            this.$purchases = list;
            this.this$0 = transactionEventManager;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$3$lambda$2(List list, int i10, List list2, TransactionEventManager transactionEventManager, PurchaseBridge purchaseBridge, BillingResultBridge billingResultBridge, List list3) {
            if (list3 == null || billingResultBridge.getResponseCode() != BillingResultResponseCode.OK) {
                ((x) list.get(i10)).O(k0.f35197a);
                return;
            }
            List list4 = list3;
            ArrayList arrayList = new ArrayList(w.v(list4, 10));
            Iterator it = list4.iterator();
            while (it.hasNext()) {
                arrayList.add(transactionEventManager.getTransactionData.invoke(purchaseBridge, (SkuDetailsBridge) it.next()));
            }
            list2.addAll(arrayList);
            ((x) list.get(i10)).O(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new C31691(this.$purchases, this.this$0, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x009f  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x017b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00de -> B:26:0x00ed). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r21) throws org.json.JSONException {
            /*
                Method dump skipped, instruction units count: 412
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.manager.TransactionEventManager.C31691.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((C31691) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    public TransactionEventManager(@NotNull o0 scope, @NotNull StoreMonitor storeMonitor, @NotNull GetTransactionData getTransactionData, @NotNull GetTransactionRequest getTransactionRequest, @NotNull TransactionEventRepository transactionEventRepository, @NotNull ByteStringDataSource iapTransactionStore, @NotNull SendDiagnosticEvent sendDiagnosticEvent) {
        kotlin.jvm.internal.t.i(scope, "scope");
        kotlin.jvm.internal.t.i(storeMonitor, "storeMonitor");
        kotlin.jvm.internal.t.i(getTransactionData, "getTransactionData");
        kotlin.jvm.internal.t.i(getTransactionRequest, "getTransactionRequest");
        kotlin.jvm.internal.t.i(transactionEventRepository, "transactionEventRepository");
        kotlin.jvm.internal.t.i(iapTransactionStore, "iapTransactionStore");
        kotlin.jvm.internal.t.i(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.scope = scope;
        this.storeMonitor = storeMonitor;
        this.getTransactionData = getTransactionData;
        this.getTransactionRequest = getTransactionRequest;
        this.transactionEventRepository = transactionEventRepository;
        this.iapTransactionStore = iapTransactionStore;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    public static final /* synthetic */ void access$onPurchasesReceived(TransactionEventManager transactionEventManager, BillingResultBridge billingResultBridge, List list) {
        transactionEventManager.onPurchasesReceived(billingResultBridge, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPurchasesReceived(BillingResultBridge billingResultBridge, List<? extends PurchaseBridge> list) {
        if (billingResultBridge.getResponseCode() == BillingResultResponseCode.OK) {
            List<? extends PurchaseBridge> list2 = list;
            if (list2 == null || list2.isEmpty()) {
                return;
            }
            kotlinx.coroutines.k.d(this.scope, null, null, new C31691(list, this, null), 3, null);
        }
    }

    public final void invoke() {
        kotlinx.coroutines.k.d(this.scope, null, null, new AnonymousClass1(null), 3, null);
    }
}
