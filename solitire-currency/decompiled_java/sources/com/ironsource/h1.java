package com.ironsource;

import android.content.Context;
import com.ironsource.ks;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.ISContainerParams;
import com.ironsource.mediationsdk.IronSource;
import com.unity3d.mediation.LevelPlayAdSize;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class h1 extends ok {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ks.b f12362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ig f12363c;

    public h1() {
        ks.b bVarA = ks.a(IronSource.AD_UNIT.BANNER);
        kotlin.jvm.internal.t.h(bVarA, "createLogFactory(IronSource.AD_UNIT.BANNER)");
        this.f12362b = bVarA;
        this.f12363c = el.f11917p.d().r();
    }

    private final float c() {
        ak akVarA = this.f12363c.a();
        if (akVarA != null) {
            return akVarA.j();
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    public final int a(int i10) {
        return com.ironsource.mediationsdk.l.a(i10);
    }

    public final int b(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return j9.c.c(c() * na.f14102a.a(context));
    }

    public final boolean d() {
        return el.f11917p.d().r().c();
    }

    private final ISBannerSize a(LevelPlayAdSize levelPlayAdSize) {
        LevelPlayAdSize fallbackAdSize$mediationsdk_release = levelPlayAdSize.getFallbackAdSize$mediationsdk_release();
        if (fallbackAdSize$mediationsdk_release == null) {
            fallbackAdSize$mediationsdk_release = LevelPlayAdSize.BANNER;
        }
        ISBannerSize iSBannerSizeB = b(fallbackAdSize$mediationsdk_release);
        iSBannerSizeB.setAdaptive(true);
        iSBannerSizeB.containerParams = new ISContainerParams(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight());
        return iSBannerSizeB;
    }

    private final ISBannerSize c(LevelPlayAdSize levelPlayAdSize) {
        return kotlin.jvm.internal.t.d(levelPlayAdSize, LevelPlayAdSize.LARGE) ? new ISBannerSize(com.ironsource.mediationsdk.l.f13635b, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : kotlin.jvm.internal.t.d(levelPlayAdSize, LevelPlayAdSize.MEDIUM_RECTANGLE) ? new ISBannerSize(com.ironsource.mediationsdk.l.f13636c, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : kotlin.jvm.internal.t.d(levelPlayAdSize, LevelPlayAdSize.LEADERBOARD) ? new ISBannerSize(com.ironsource.mediationsdk.l.f13638e, 0, 0) : kotlin.jvm.internal.t.d(levelPlayAdSize, LevelPlayAdSize.Companion.createCustomSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight())) ? new ISBannerSize(levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight()) : new ISBannerSize(com.ironsource.mediationsdk.l.f13634a, levelPlayAdSize.getWidth(), levelPlayAdSize.getHeight());
    }

    @NotNull
    public final ISBannerSize b(@NotNull LevelPlayAdSize size) {
        kotlin.jvm.internal.t.i(size, "size");
        boolean zIsAdaptive = size.isAdaptive();
        if (zIsAdaptive) {
            return a(size);
        }
        if (zIsAdaptive) {
            throw new v8.q();
        }
        return c(size);
    }

    public static /* synthetic */ String a(h1 h1Var, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        if ((i10 & 2) != 0) {
            str2 = null;
        }
        return h1Var.a(str, str2);
    }

    @NotNull
    public final List<LevelPlayAdSize> b() {
        ak akVarA = this.f12363c.a();
        if (akVarA != null) {
            return akVarA.h();
        }
        throw new IllegalStateException("Error getting sdk configurations");
    }

    @NotNull
    public final String a(@Nullable String str, @Nullable String str2) {
        String strA = this.f12362b.a(str, str2);
        kotlin.jvm.internal.t.h(strA, "logFactory.createLogMessage(message, suffix)");
        return strA;
    }
}
