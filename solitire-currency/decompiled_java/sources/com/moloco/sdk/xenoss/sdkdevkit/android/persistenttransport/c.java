package com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport;

import androidx.annotation.VisibleForTesting;
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.service_locator.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.n;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f21709a = n.a(a.f21710g);

    public static final class a extends v implements h9.a<b> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f21710g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return c.c();
        }
    }

    @NotNull
    public static final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a a() {
        return b();
    }

    public static final b b() {
        return (b) f21709a.getValue();
    }

    @VisibleForTesting
    @NotNull
    public static final b c() {
        d dVarA;
        try {
            dVarA = a.i.f18932a.c();
        } catch (Exception e10) {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, "BestAttemptHttpRequest", "Failed to create PersistentHttpRequest, invoking NonPersistendHttpRequest", e10, false, 8, null);
            dVarA = h.a();
        }
        return new b(dVarA);
    }
}
