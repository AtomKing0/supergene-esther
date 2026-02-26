package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class h3 implements i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f12377a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12378a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12378a = iArr;
        }
    }

    public h3(@NotNull IronSource.AD_UNIT adFormat) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        this.f12377a = adFormat;
    }

    @Override // com.ironsource.i3
    @NotNull
    public j3 a(@NotNull e3 eventBaseData) {
        kotlin.jvm.internal.t.i(eventBaseData, "eventBaseData");
        int i10 = a.f12378a[this.f12377a.ordinal()];
        if (i10 == 1) {
            return new fi(eventBaseData);
        }
        if (i10 == 2) {
            return new np(eventBaseData);
        }
        if (i10 == 3) {
            return new k6(eventBaseData);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + this.f12377a);
    }
}
