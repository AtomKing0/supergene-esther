package com.vungle.ads.internal.util;

import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: ConcurrencyTimeoutProvider.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    @NotNull
    public static final a Companion = new a(null);
    private static final long OPERATION_TIMEOUT = TimeUnit.SECONDS.toMillis(4);

    /* JADX INFO: compiled from: ConcurrencyTimeoutProvider.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public final long getTimeout() {
        if (v.INSTANCE.isMainThread()) {
            return OPERATION_TIMEOUT;
        }
        return Long.MAX_VALUE;
    }
}
