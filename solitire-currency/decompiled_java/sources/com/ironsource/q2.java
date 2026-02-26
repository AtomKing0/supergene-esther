package com.ironsource;

import com.ironsource.ad;
import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q2 f14430a = new q2();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14431a;

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
            f14431a = iArr;
        }
    }

    private q2() {
    }

    @NotNull
    public static final ad.a a(@NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        int i10 = a.f14431a[adUnit.ordinal()];
        if (i10 == 1) {
            return ad.a.REWARDED_VIDEO;
        }
        if (i10 == 2) {
            return ad.a.INTERSTITIAL;
        }
        if (i10 == 3) {
            return ad.a.BANNER;
        }
        if (i10 == 4) {
            return ad.a.NATIVE_AD;
        }
        throw new v8.q();
    }
}
