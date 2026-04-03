package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l7 implements x2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final m8 f12986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final so f12987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f12988c;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12989a;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f12989a = iArr;
        }
    }

    public l7(@NotNull m8 adFormatConfigurations, @Nullable so soVar, @NotNull IronSource.AD_UNIT adFormat) {
        kotlin.jvm.internal.t.i(adFormatConfigurations, "adFormatConfigurations");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        this.f12986a = adFormatConfigurations;
        this.f12987b = soVar;
        this.f12988c = adFormat;
    }

    @Override // com.ironsource.x2
    @Nullable
    public eh a(@NotNull oo providerName) {
        NetworkSettings networkSettingsB;
        pp ppVarF;
        kotlin.jvm.internal.t.i(providerName, "providerName");
        so soVar = this.f12987b;
        if (soVar == null || (networkSettingsB = soVar.b(providerName.value())) == null) {
            return null;
        }
        int i10 = a.f12989a[this.f12988c.ordinal()];
        if (i10 == 1) {
            n6 n6VarC = this.f12986a.c();
            if (n6VarC != null) {
                return new t6(new v2(networkSettingsB, networkSettingsB.getBannerSettings(), this.f12988c), n6VarC);
            }
            return null;
        }
        if (i10 != 2) {
            if (i10 == 3 && (ppVarF = this.f12986a.f()) != null) {
                return new yo(new v2(networkSettingsB, networkSettingsB.getRewardedVideoSettings(), this.f12988c), ppVarF);
            }
            return null;
        }
        hi hiVarD = this.f12986a.d();
        if (hiVarD != null) {
            return new ki(new v2(networkSettingsB, networkSettingsB.getInterstitialSettings(), this.f12988c), hiVarD);
        }
        return null;
    }
}
