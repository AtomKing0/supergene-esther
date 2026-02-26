package com.moloco.sdk.internal.services.bidtoken;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v8.l f18480a = v8.n.a(a.f18481g);

    public static final class a extends kotlin.jvm.internal.v implements h9.a<n> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f18481g = new a();

        public a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n invoke() {
            MolocoLogger.info$default(MolocoLogger.INSTANCE, "BidTokenService", "Creating BidTokenService instance", null, false, 12, null);
            return new n(y.f18586a.a(), r.f18552a.a());
        }
    }

    @NotNull
    public static final m a() {
        return b();
    }

    public static final n b() {
        return (n) f18480a.getValue();
    }
}
