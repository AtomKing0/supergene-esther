package com.vungle.ads.internal.task;

import android.content.Context;
import android.os.Bundle;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.util.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: ResendTpatJob.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class i implements com.vungle.ads.internal.task.b {

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    public static final String TAG = "ResendTpatJob";

    @NotNull
    private final Context context;

    @NotNull
    private final q pathProvider;

    /* JADX INFO: compiled from: ResendTpatJob.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final d makeJobInfo() {
            return new d(i.TAG).setPriority(0).setUpdateCurrent(true);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class b extends v implements h9.a<com.vungle.ads.internal.network.i> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.network.i, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.network.i invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.network.i.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    public i(@NotNull Context context, @NotNull q pathProvider) {
        t.i(context, "context");
        t.i(pathProvider, "pathProvider");
        this.context = context;
        this.pathProvider = pathProvider;
    }

    /* JADX INFO: renamed from: onRunJob$lambda-0, reason: not valid java name */
    private static final com.vungle.ads.internal.network.i m4104onRunJob$lambda0(v8.l<com.vungle.ads.internal.network.i> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: onRunJob$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4105onRunJob$lambda1(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @NotNull
    public final q getPathProvider() {
        return this.pathProvider;
    }

    @Override // com.vungle.ads.internal.task.b
    public int onRunJob(@NotNull Bundle bundle, @NotNull f jobRunner) {
        t.i(bundle, "bundle");
        t.i(jobRunner, "jobRunner");
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        Context context = this.context;
        p pVar = p.f35201a;
        v8.l lVarB = n.b(pVar, new b(context));
        v8.l lVarB2 = n.b(pVar, new c(this.context));
        new com.vungle.ads.internal.network.g(m4104onRunJob$lambda0(lVarB), null, null, null, m4105onRunJob$lambda1(lVarB2).getIoExecutor(), this.pathProvider, null, 64, null).resendStoredTpats$vungle_ads_release(m4105onRunJob$lambda1(lVarB2).getJobExecutor());
        return 0;
    }
}
