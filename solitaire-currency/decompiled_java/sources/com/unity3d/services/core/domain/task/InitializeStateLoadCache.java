package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import com.unity3d.services.core.properties.SdkProperties;
import java.io.File;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.d;

/* JADX INFO: compiled from: InitializeStateLoadCache.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class InitializeStateLoadCache extends MetricTask<Params, LoadCacheResult> {

    @NotNull
    private final ISDKDispatchers dispatchers;

    /* JADX INFO: compiled from: InitializeStateLoadCache.kt */
    public static final class LoadCacheResult {
        private final boolean hasHashMismatch;

        @Nullable
        private final String webViewData;

        public LoadCacheResult(boolean z10, @Nullable String str) {
            this.hasHashMismatch = z10;
            this.webViewData = str;
        }

        public static /* synthetic */ LoadCacheResult copy$default(LoadCacheResult loadCacheResult, boolean z10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = loadCacheResult.hasHashMismatch;
            }
            if ((i10 & 2) != 0) {
                str = loadCacheResult.webViewData;
            }
            return loadCacheResult.copy(z10, str);
        }

        public final boolean component1() {
            return this.hasHashMismatch;
        }

        @Nullable
        public final String component2() {
            return this.webViewData;
        }

        @NotNull
        public final LoadCacheResult copy(boolean z10, @Nullable String str) {
            return new LoadCacheResult(z10, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadCacheResult)) {
                return false;
            }
            LoadCacheResult loadCacheResult = (LoadCacheResult) obj;
            return this.hasHashMismatch == loadCacheResult.hasHashMismatch && t.d(this.webViewData, loadCacheResult.webViewData);
        }

        public final boolean getHasHashMismatch() {
            return this.hasHashMismatch;
        }

        @Nullable
        public final String getWebViewData() {
            return this.webViewData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            boolean z10 = this.hasHashMismatch;
            ?? r02 = z10;
            if (z10) {
                r02 = 1;
            }
            int i10 = r02 * 31;
            String str = this.webViewData;
            return i10 + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "LoadCacheResult(hasHashMismatch=" + this.hasHashMismatch + ", webViewData=" + this.webViewData + ')';
        }

        public /* synthetic */ LoadCacheResult(boolean z10, String str, int i10, k kVar) {
            this(z10, (i10 & 2) != 0 ? null : str);
        }
    }

    /* JADX INFO: compiled from: InitializeStateLoadCache.kt */
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

    public InitializeStateLoadCache(@NotNull ISDKDispatchers dispatchers) {
        t.i(dispatchers, "dispatchers");
        this.dispatchers = dispatchers;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] getWebViewData() {
        try {
            return Utilities.readFileBytes(new File(SdkProperties.getLocalWebViewFile()));
        } catch (Exception e10) {
            DeviceLog.debug("Unity Ads init: webapp not found in local cache: " + e10.getMessage());
            return null;
        }
    }

    @Override // com.unity3d.services.core.domain.task.BaseTask
    /* JADX INFO: renamed from: doWork-gIAlu-s */
    public /* bridge */ /* synthetic */ Object mo3999doWorkgIAlus(BaseParams baseParams, d dVar) {
        return m4012doWorkgIAlus((Params) baseParams, (d<? super v8.t<LoadCacheResult>>) dVar);
    }

    @Override // com.unity3d.services.core.domain.task.MetricTask
    @NotNull
    public String getMetricName() {
        return getMetricNameForInitializeTask("read_local_webview");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: doWork-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m4012doWorkgIAlus(@org.jetbrains.annotations.NotNull com.unity3d.services.core.domain.task.InitializeStateLoadCache.Params r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.t<com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1
            if (r0 == 0) goto L13
            r0 = r7
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1 r0 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1 r0 = new com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$1
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
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2 r2 = new com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2
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
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadCache.m4012doWorkgIAlus(com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params, z8.d):java.lang.Object");
    }
}
