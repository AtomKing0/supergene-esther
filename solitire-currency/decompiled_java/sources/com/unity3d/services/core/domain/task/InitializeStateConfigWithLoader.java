package com.unity3d.services.core.domain.task;

import com.unity3d.services.ads.token.TokenStorage;
import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.BaseTask;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializeStateConfigWithLoader implements BaseTask<Params, Configuration> {

    @NotNull
    private final ISDKDispatchers dispatchers;

    @NotNull
    private final InitializeStateNetworkError initializeStateNetworkError;

    @NotNull
    private final SDKMetricsSender sdkMetricsSender;

    @NotNull
    private final TokenStorage tokenStorage;

    /* JADX INFO: compiled from: InitializeStateConfigWithLoader.kt */
    public static final class Params implements BaseParams {

        @NotNull
        private final Configuration config;

        public Params(@NotNull Configuration config) {
            t.i(config, "config");
            this.config = config;
        }

        public static /* synthetic */ Params copy$default(Params params, Configuration configuration, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                configuration = params.config;
            }
            return params.copy(configuration);
        }

        @NotNull
        public final Configuration component1() {
            return this.config;
        }

        @NotNull
        public final Params copy(@NotNull Configuration config) {
            t.i(config, "config");
            return new Params(config);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Params) && t.d(this.config, ((Params) obj).config);
        }

        @NotNull
        public final Configuration getConfig() {
            return this.config;
        }

        public int hashCode() {
            return this.config.hashCode();
        }

        @NotNull
        public String toString() {
            return "Params(config=" + this.config + ')';
        }
    }

    public InitializeStateConfigWithLoader(@NotNull ISDKDispatchers dispatchers, @NotNull InitializeStateNetworkError initializeStateNetworkError, @NotNull TokenStorage tokenStorage, @NotNull SDKMetricsSender sdkMetricsSender) {
        t.i(dispatchers, "dispatchers");
        t.i(initializeStateNetworkError, "initializeStateNetworkError");
        t.i(tokenStorage, "tokenStorage");
        t.i(sdkMetricsSender, "sdkMetricsSender");
        this.dispatchers = dispatchers;
        this.initializeStateNetworkError = initializeStateNetworkError;
        this.tokenStorage = tokenStorage;
        this.sdkMetricsSender = sdkMetricsSender;
    }

    @Override // com.unity3d.services.core.di.IServiceComponent
    @NotNull
    public IServiceProvider getServiceProvider() {
        return BaseTask.DefaultImpls.getServiceProvider(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.unity3d.services.core.domain.task.BaseTask
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: doWork-gIAlu-s, reason: not valid java name and merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo3999doWorkgIAlus(@org.jetbrains.annotations.NotNull com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.Params r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<? extends com.unity3d.services.core.configuration.Configuration>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$1
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r7)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            v8.u.b(r7)
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r5.dispatchers
            kotlinx.coroutines.k0 r7 = r7.getDefault()
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2
            r4 = 0
            r2.<init>(r5, r6, r4)
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.i.g(r7, r2, r0)
            if (r7 != r1) goto L49
            return r1
        L49:
            v8.t r7 = (v8.t) r7
            java.lang.Object r6 = r7.j()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.mo3999doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params, z8.d):java.lang.Object");
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    @Nullable
    /* JADX INFO: renamed from: invoke-gIAlu-s, reason: not valid java name and merged with bridge method [inline-methods] */
    public Object mo4000invokegIAlus(@NotNull Params params, @NotNull d<? super v8.t<? extends Configuration>> dVar) {
        return BaseTask.DefaultImpls.m4001invokegIAlus(this, params, dVar);
    }
}
