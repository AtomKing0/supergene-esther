package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.unity3d.mediation.LevelPlay;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class no {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f14159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<rm> f14160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final s1 f14161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f14162d;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14163a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14163a = iArr;
        }
    }

    public static final class b extends yp {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f14165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AdapterBaseInterface f14166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AdData f14167d;

        b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
            this.f14165b = networkSettings;
            this.f14166c = adapterBaseInterface;
            this.f14167d = adData;
        }

        @Override // com.ironsource.yp
        public void a() {
            no noVar = no.this;
            NetworkSettings networkSettings = this.f14165b;
            AdapterBaseInterface networkAdapter = this.f14166c;
            kotlin.jvm.internal.t.h(networkAdapter, "networkAdapter");
            noVar.a(networkSettings, networkAdapter, this.f14167d);
        }

        @Override // com.ironsource.yp
        public void a(@NotNull Throwable t10) {
            kotlin.jvm.internal.t.i(t10, "t");
            no.this.f14159a.e().g().f("initProvider - exception while calling networkAdapter.init with " + this.f14165b.getProviderName() + " - " + t10);
        }
    }

    public no(@NotNull p2 adUnitTools, @NotNull LevelPlay.AdFormat adFormat, @NotNull List<rm> providers, @NotNull s1 adUnitData) {
        kotlin.jvm.internal.t.i(adUnitTools, "adUnitTools");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(providers, "providers");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f14159a = adUnitTools;
        this.f14160b = providers;
        this.f14161c = adUnitData;
        this.f14162d = a(adFormat);
    }

    private final IronSource.AD_UNIT a(LevelPlay.AdFormat adFormat) {
        int i10 = a.f14163a[adFormat.ordinal()];
        if (i10 == 1) {
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        if (i10 == 2) {
            return IronSource.AD_UNIT.INTERSTITIAL;
        }
        if (i10 == 3) {
            return IronSource.AD_UNIT.BANNER;
        }
        if (i10 == 4) {
            return IronSource.AD_UNIT.NATIVE_AD;
        }
        throw new v8.q();
    }

    public final void a() {
        IronLog.INTERNAL.verbose(k1.a(this.f14159a, (String) null, (String) null, 3, (Object) null));
        UUID uuidRandomUUID = UUID.randomUUID();
        Iterator<rm> it = this.f14160b.iterator();
        while (it.hasNext()) {
            NetworkSettings networkSettingsF = it.next().f();
            AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettingsF, this.f14162d, uuidRandomUUID);
            if (a(networkSettingsF, adapterBaseInterfaceB)) {
                ls.a(ls.f13064a, new b(networkSettingsF, adapterBaseInterfaceB, this.f14161c.a(networkSettingsF)), 0L, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface, AdData adData) {
        a("Start initializing provider %s on thread %s", networkSettings);
        adapterBaseInterface.init(adData, ContextProvider.getInstance().getApplicationContext(), null);
        a("Done initializing provider %s on thread %s", networkSettings);
    }

    private final void a(String str, NetworkSettings networkSettings) {
        IronLog ironLog = IronLog.INTERNAL;
        p2 p2Var = this.f14159a;
        kotlin.jvm.internal.s0 s0Var = kotlin.jvm.internal.s0.f29840a;
        String str2 = String.format(str, Arrays.copyOf(new Object[]{networkSettings.getProviderInstanceName(), Thread.currentThread().getName()}, 2));
        kotlin.jvm.internal.t.h(str2, "format(format, *args)");
        ironLog.verbose(k1.a(p2Var, str2, (String) null, 2, (Object) null));
    }

    private final boolean a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (adapterBaseInterface == null) {
            return false;
        }
        p2 p2Var = this.f14159a;
        IronSource.AD_UNIT ad_unit = this.f14162d;
        String providerInstanceName = networkSettings.getProviderInstanceName();
        kotlin.jvm.internal.t.h(providerInstanceName, "providerSettings.providerInstanceName");
        if (p2Var.a(adapterBaseInterface, ad_unit, providerInstanceName)) {
            return false;
        }
        return networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.f14162d);
    }
}
