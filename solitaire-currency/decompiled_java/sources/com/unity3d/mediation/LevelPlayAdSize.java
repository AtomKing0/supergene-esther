package com.unity3d.mediation;

import android.content.Context;
import com.ironsource.h1;
import com.ironsource.mediationsdk.l;
import com.ironsource.y2;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class LevelPlayAdSize {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f23888f = 320;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f23889g = 50;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f23890h = 320;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f23891i = 90;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f23892j = 300;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f23893k = 250;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f23895m = 90;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f23896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f23897b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f23898c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f23899d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final LevelPlayAdSize f23900e;

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final LevelPlayAdSize BANNER = new LevelPlayAdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 50, l.f13634a, false, null, 16, null);

    @NotNull
    public static final LevelPlayAdSize MEDIUM_RECTANGLE = new LevelPlayAdSize(300, 250, l.f13640g, false, null, 16, null);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f23894l = 728;

    @NotNull
    public static final LevelPlayAdSize LEADERBOARD = new LevelPlayAdSize(f23894l, 90, l.f13637d, false, null, 16, null);

    @NotNull
    public static final LevelPlayAdSize LARGE = new LevelPlayAdSize(Sdk$SDKError.b.WEBVIEW_ERROR_VALUE, 90, l.f13635b, false, null, 16, null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public static /* synthetic */ LevelPlayAdSize createAdaptiveAdSize$default(Companion companion, Context context, Integer num, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                num = null;
            }
            return companion.createAdaptiveAdSize(context, num);
        }

        @NotNull
        public final LevelPlayAdSize createAdSize$mediationsdk_release(@NotNull String adSize) {
            t.i(adSize, "adSize");
            int iHashCode = adSize.hashCode();
            if (iHashCode != -96588539) {
                if (iHashCode != 72205083) {
                    if (iHashCode != 446888797) {
                        if (iHashCode == 1951953708 && adSize.equals(l.f13634a)) {
                            return LevelPlayAdSize.BANNER;
                        }
                    } else if (adSize.equals(l.f13637d)) {
                        return LevelPlayAdSize.LEADERBOARD;
                    }
                } else if (adSize.equals(l.f13635b)) {
                    return LevelPlayAdSize.LARGE;
                }
            } else if (adSize.equals(l.f13640g)) {
                return LevelPlayAdSize.MEDIUM_RECTANGLE;
            }
            throw new IllegalArgumentException("Wrong Ad Size");
        }

        @Nullable
        public final LevelPlayAdSize createAdaptiveAdSize(@NotNull Context context) {
            t.i(context, "context");
            return createAdaptiveAdSize$default(this, context, null, 2, null);
        }

        @NotNull
        public final LevelPlayAdSize createCustomBanner(int i10, int i11) {
            return createCustomSize(i10, i11);
        }

        @NotNull
        public final LevelPlayAdSize createCustomSize(int i10, int i11) {
            return new LevelPlayAdSize(i10, i11, "CUSTOM", false, null, 16, null);
        }

        @Nullable
        public final LevelPlayAdSize createAdaptiveAdSize(@NotNull Context context, @Nullable Integer num) {
            t.i(context, "context");
            return new y2(new h1()).a(context, num);
        }
    }

    public LevelPlayAdSize(int i10, int i11, @Nullable String str, boolean z10, @Nullable LevelPlayAdSize levelPlayAdSize) {
        this.f23896a = i10;
        this.f23897b = i11;
        this.f23898c = str;
        this.f23899d = z10;
        this.f23900e = levelPlayAdSize;
    }

    @Nullable
    public static final LevelPlayAdSize createAdaptiveAdSize(@NotNull Context context) {
        return Companion.createAdaptiveAdSize(context);
    }

    @NotNull
    public static final LevelPlayAdSize createCustomBanner(int i10, int i11) {
        return Companion.createCustomBanner(i10, i11);
    }

    @NotNull
    public static final LevelPlayAdSize createCustomSize(int i10, int i11) {
        return Companion.createCustomSize(i10, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!t.d(LevelPlayAdSize.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        t.g(obj, "null cannot be cast to non-null type com.unity3d.mediation.LevelPlayAdSize");
        LevelPlayAdSize levelPlayAdSize = (LevelPlayAdSize) obj;
        return this.f23896a == levelPlayAdSize.f23896a && this.f23897b == levelPlayAdSize.f23897b && t.d(this.f23898c, levelPlayAdSize.f23898c);
    }

    @NotNull
    public final String getDescription() {
        return String.valueOf(this.f23898c);
    }

    @Nullable
    public final LevelPlayAdSize getFallbackAdSize$mediationsdk_release() {
        return this.f23900e;
    }

    public final int getHeight() {
        return this.f23897b;
    }

    public final int getWidth() {
        return this.f23896a;
    }

    public int hashCode() {
        int i10 = ((this.f23896a * 31) + this.f23897b) * 31;
        String str = this.f23898c;
        return i10 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isAdaptive() {
        return this.f23899d;
    }

    @NotNull
    public String toString() {
        return this.f23898c + ' ' + this.f23896a + 'x' + this.f23897b;
    }

    public /* synthetic */ LevelPlayAdSize(int i10, int i11, String str, boolean z10, LevelPlayAdSize levelPlayAdSize, int i12, k kVar) {
        this(i10, i11, (i12 & 4) != 0 ? null : str, z10, (i12 & 16) != 0 ? null : levelPlayAdSize);
    }

    @Nullable
    public static final LevelPlayAdSize createAdaptiveAdSize(@NotNull Context context, @Nullable Integer num) {
        return Companion.createAdaptiveAdSize(context, num);
    }
}
