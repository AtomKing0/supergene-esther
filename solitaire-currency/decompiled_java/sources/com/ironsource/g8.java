package com.ironsource;

import androidx.media3.exoplayer.upstream.CmcdData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public enum g8 {
    Day("d", com.vungle.ads.internal.signals.b.TWENTY_FOUR_HOURS_MILLIS),
    Hour(CmcdData.Factory.STREAMING_FORMAT_HLS, 3600000),
    Second(CmcdData.Factory.STREAMING_FORMAT_SS, 1000);


    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f12223c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12229b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @Nullable
        public final g8 a(@Nullable String str) {
            for (g8 g8Var : g8.values()) {
                if (kotlin.jvm.internal.t.d(g8Var.f12228a, str)) {
                    return g8Var;
                }
            }
            return null;
        }
    }

    g8(String str, long j10) {
        this.f12228a = str;
        this.f12229b = j10;
    }

    public static /* synthetic */ long a(g8 g8Var, Integer num, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: inMilliseconds");
        }
        if ((i10 & 1) != 0) {
            num = 1;
        }
        return g8Var.a(num);
    }

    public final long a(@Nullable Integer num) {
        return ((long) (num != null ? num.intValue() : 1)) * this.f12229b;
    }
}
