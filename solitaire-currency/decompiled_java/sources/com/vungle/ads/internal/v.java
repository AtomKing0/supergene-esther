package com.vungle.ads.internal;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.VungleAds;
import com.vungle.ads.e0;
import com.vungle.ads.internal.bidding.a;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleInternal.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v {

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class a extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.e> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.util.e, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.e invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.util.e.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.d.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.bidding.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.bidding.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.bidding.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class d extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.bidding.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.bidding.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.bidding.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.bidding.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.d.class);
        }
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.util.e m4119getAvailableBidTokens$lambda0(v8.l<com.vungle.ads.internal.util.e> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m4120getAvailableBidTokens$lambda1(v8.l<com.vungle.ads.internal.executor.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.bidding.a m4121getAvailableBidTokens$lambda2(v8.l<com.vungle.ads.internal.bidding.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAvailableBidTokens$lambda-3, reason: not valid java name */
    public static final String m4122getAvailableBidTokens$lambda3(v8.l bidTokenEncoder$delegate) {
        kotlin.jvm.internal.t.i(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        return m4121getAvailableBidTokens$lambda2(bidTokenEncoder$delegate).encode().getBidToken();
    }

    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-4, reason: not valid java name */
    private static final com.vungle.ads.internal.bidding.a m4123getAvailableBidTokensAsync$lambda4(v8.l<com.vungle.ads.internal.bidding.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-5, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.d m4124getAvailableBidTokensAsync$lambda5(v8.l<com.vungle.ads.internal.executor.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getAvailableBidTokensAsync$lambda-6, reason: not valid java name */
    public static final void m4125getAvailableBidTokensAsync$lambda6(e0 callback, v8.l bidTokenEncoder$delegate) {
        kotlin.jvm.internal.t.i(callback, "$callback");
        kotlin.jvm.internal.t.i(bidTokenEncoder$delegate, "$bidTokenEncoder$delegate");
        a.b bVarEncode = m4123getAvailableBidTokensAsync$lambda4(bidTokenEncoder$delegate).encode();
        if (bVarEncode.getBidToken().length() > 0) {
            callback.onBidTokenCollected(bVarEncode.getBidToken());
        } else {
            callback.onBidTokenError(bVarEncode.getErrorMessage());
        }
    }

    @Nullable
    public final String getAvailableBidTokens(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        if (!VungleAds.Companion.isInitialized()) {
            q7.c cVar = q7.c.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
            cVar.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        v8.l lVarB = v8.n.b(pVar, new a(context));
        v8.l lVarB2 = v8.n.b(pVar, new b(context));
        final v8.l lVarB3 = v8.n.b(pVar, new c(context));
        return (String) new com.vungle.ads.internal.executor.b(m4120getAvailableBidTokens$lambda1(lVarB2).getApiExecutor().submit(new Callable() { // from class: com.vungle.ads.internal.u
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return v.m4122getAvailableBidTokens$lambda3(lVarB3);
            }
        })).get(m4119getAvailableBidTokens$lambda0(lVarB).getTimeout(), TimeUnit.MILLISECONDS);
    }

    public final void getAvailableBidTokensAsync(@NotNull Context context, @NotNull final e0 callback) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(callback, "callback");
        if (!VungleAds.Companion.isInitialized()) {
            q7.c cVar = q7.c.INSTANCE;
            Context applicationContext = context.getApplicationContext();
            kotlin.jvm.internal.t.h(applicationContext, "context.applicationContext");
            cVar.init(applicationContext);
        }
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.p pVar = v8.p.f35201a;
        final v8.l lVarB = v8.n.b(pVar, new d(context));
        m4124getAvailableBidTokensAsync$lambda5(v8.n.b(pVar, new e(context))).getApiExecutor().execute(new Runnable() { // from class: com.vungle.ads.internal.t
            @Override // java.lang.Runnable
            public final void run() {
                v.m4125getAvailableBidTokensAsync$lambda6(callback, lVarB);
            }
        });
    }

    @NotNull
    public final String getSdkVersion() {
        return "7.4.2";
    }
}
