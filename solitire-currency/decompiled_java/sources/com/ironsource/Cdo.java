package com.ironsource;

import com.ironsource.oe;
import com.unity3d.mediation.LevelPlay;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: com.ironsource.do, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public final class Cdo implements oe, oe.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final d8 f11850a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ba f11851b;

    /* JADX INFO: renamed from: com.ironsource.do$a */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11852a;

        static {
            int[] iArr = new int[h8.values().length];
            try {
                iArr[h8.Delivery.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[h8.Pacing.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[h8.ShowCount.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f11852a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Cdo() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.oe
    @NotNull
    public synchronized f8 a(@NotNull String placementName, @NotNull LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        String strA = new io(placementName, adFormat).a();
        f8 f8VarA = this.f11851b.a(strA);
        if (f8VarA.d()) {
            return f8VarA;
        }
        return this.f11850a.a(strA);
    }

    @Override // com.ironsource.oe.a
    public synchronized void b(@NotNull String placementName, @NotNull LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        String strA = new io(placementName, adFormat).a();
        if (!this.f11851b.a(strA).d()) {
            this.f11850a.b(strA);
        }
    }

    public Cdo(@NotNull d8 cappingService, @NotNull ba deliveryHandler) {
        kotlin.jvm.internal.t.i(cappingService, "cappingService");
        kotlin.jvm.internal.t.i(deliveryHandler, "deliveryHandler");
        this.f11850a = cappingService;
        this.f11851b = deliveryHandler;
    }

    @Override // com.ironsource.oe.a
    @NotNull
    public synchronized Object a(@NotNull String placementName, @NotNull LevelPlay.AdFormat adFormat, @NotNull h8 cappingType, @NotNull ud cappingConfig) {
        Object objA;
        kotlin.jvm.internal.t.i(placementName, "placementName");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(cappingType, "cappingType");
        kotlin.jvm.internal.t.i(cappingConfig, "cappingConfig");
        String strA = new io(placementName, adFormat).a();
        int i10 = a.f11852a[cappingType.ordinal()];
        if (i10 != 1) {
            if (i10 != 2 && i10 != 3) {
                throw new v8.q();
            }
            objA = this.f11850a.a(strA, cappingType, cappingConfig);
        } else {
            objA = this.f11851b.a(strA, cappingType, cappingConfig);
        }
        return objA;
    }

    public /* synthetic */ Cdo(d8 d8Var, ba baVar, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? new d8(null, null, null, 7, null) : d8Var, (i10 & 2) != 0 ? new ba() : baVar);
    }
}
