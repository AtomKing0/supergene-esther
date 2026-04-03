package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.Placement;
import com.unity3d.mediation.LevelPlay;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class b1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f11327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private Placement f11329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final ts f11330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final wj f11331e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11332a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f11332a = iArr;
        }
    }

    public b1(@NotNull IronSource.AD_UNIT adFormat, @NotNull String adUnitId, @Nullable Placement placement, @Nullable ts tsVar) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        this.f11327a = adFormat;
        this.f11328b = adUnitId;
        this.f11329c = placement;
        this.f11330d = tsVar;
        this.f11331e = new wj();
    }

    @NotNull
    public final IronSource.AD_UNIT a() {
        return this.f11327a;
    }

    @NotNull
    public final String b() {
        return this.f11328b;
    }

    @NotNull
    public final LevelPlay.AdFormat c() {
        int i10 = a.f11332a[this.f11327a.ordinal()];
        if (i10 == 1) {
            return LevelPlay.AdFormat.REWARDED;
        }
        if (i10 == 2) {
            return LevelPlay.AdFormat.INTERSTITIAL;
        }
        if (i10 == 3) {
            return LevelPlay.AdFormat.BANNER;
        }
        if (i10 == 4) {
            return LevelPlay.AdFormat.NATIVE_AD;
        }
        throw new v8.q();
    }

    @NotNull
    public final wj d() {
        return this.f11331e;
    }

    @Nullable
    public final Placement e() {
        return this.f11329c;
    }

    @Nullable
    public final ts f() {
        return this.f11330d;
    }

    public /* synthetic */ b1(IronSource.AD_UNIT ad_unit, String str, Placement placement, ts tsVar, int i10, kotlin.jvm.internal.k kVar) {
        this(ad_unit, str, (i10 & 4) != 0 ? null : placement, (i10 & 8) != 0 ? null : tsVar);
    }

    public final void a(@Nullable Placement placement) {
        this.f11329c = placement;
    }
}
