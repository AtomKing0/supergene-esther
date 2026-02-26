package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mg;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
class ir implements mg, mg.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f12655c = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<IronSource.AD_UNIT, Integer> f12656a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final cj f12657b = new cj();

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f12658a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            f12658a = iArr;
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12658a[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12658a[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12658a[IronSource.AD_UNIT.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    ir() {
        for (IronSource.AD_UNIT ad_unit : IronSource.AD_UNIT.values()) {
            a(ad_unit, 1);
        }
    }

    @Override // com.ironsource.mg
    public synchronized int a(IronSource.AD_UNIT ad_unit) {
        int iIntValue = -1;
        if (ad_unit == null) {
            return -1;
        }
        Integer num = this.f12656a.get(ad_unit);
        if (num != null) {
            iIntValue = num.intValue();
        }
        return iIntValue;
    }

    @Override // com.ironsource.mg.a
    public synchronized void b(IronSource.AD_UNIT ad_unit) {
        if (ad_unit == null) {
            return;
        }
        a(ad_unit, this.f12656a.get(ad_unit).intValue() + 1);
    }

    private void a(@NotNull IronSource.AD_UNIT ad_unit, int i10) {
        this.f12656a.put(ad_unit, Integer.valueOf(i10));
        int i11 = a.f12658a[ad_unit.ordinal()];
        if (i11 == 1) {
            this.f12657b.d(i10);
            return;
        }
        if (i11 == 2) {
            this.f12657b.b(i10);
        } else if (i11 == 3) {
            this.f12657b.a(i10);
        } else {
            if (i11 != 4) {
                return;
            }
            this.f12657b.c(i10);
        }
    }
}
