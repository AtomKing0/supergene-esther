package com.ironsource;

import com.ironsource.j4;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.t7;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f12692a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s1 f12693b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x4 f12694c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<q7> f12695d;

    public static final class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f12696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j4 f12697b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ t7.b f12698c;

        a(t7 t7Var, j4 j4Var, t7.b bVar) {
            this.f12696a = t7Var;
            this.f12697b = j4Var;
            this.f12698c = bVar;
        }

        @Override // com.ironsource.yp
        public void a() {
            this.f12696a.a(this.f12697b.c(), this.f12698c, this.f12697b.f12693b.g(), TimeUnit.MILLISECONDS);
        }
    }

    public static final class b implements r7 {
        b() {
        }

        @Override // com.ironsource.r7
        public void a(@Nullable NetworkSettings networkSettings) {
            AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, j4.this.f12693b.b().a(), j4.this.f12693b.b().d().b());
            if (adapterBaseInterfaceB != null) {
                j4.this.f12692a.e().f().a(j4.this.a(networkSettings, adapterBaseInterfaceB));
            }
        }

        @Override // com.ironsource.r7
        public void a(@Nullable String str) {
            j4.this.f12692a.e().g().f(str);
        }
    }

    public static final class c implements t7.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f12701b;

        c(d dVar) {
            this.f12701b = dVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(j4 this$0, long j10, List biddingDataList, List reachedTimeout, d biddingDataListener) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(biddingDataList, "$biddingDataList");
            kotlin.jvm.internal.t.i(reachedTimeout, "$reachedTimeout");
            kotlin.jvm.internal.t.i(biddingDataListener, "$biddingDataListener");
            this$0.a(j10, (List<? extends u7>) biddingDataList, (List<String>) reachedTimeout, biddingDataListener);
        }

        @Override // com.ironsource.t7.b
        public void onFailure(@NotNull final String error) {
            kotlin.jvm.internal.t.i(error, "error");
            p2 p2Var = j4.this.f12692a;
            final j4 j4Var = j4.this;
            final d dVar = this.f12701b;
            p2Var.a(new Runnable() { // from class: com.ironsource.yw
                @Override // java.lang.Runnable
                public final void run() {
                    j4.c.a(j4Var, error, dVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(j4 this$0, String error, d biddingDataListener) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(error, "$error");
            kotlin.jvm.internal.t.i(biddingDataListener, "$biddingDataListener");
            this$0.f12692a.e().f().a(error);
            biddingDataListener.a(this$0, error);
        }

        @Override // com.ironsource.t7.b
        public void a(@NotNull final List<? extends u7> biddingDataList, final long j10, @NotNull final List<String> reachedTimeout) {
            kotlin.jvm.internal.t.i(biddingDataList, "biddingDataList");
            kotlin.jvm.internal.t.i(reachedTimeout, "reachedTimeout");
            p2 p2Var = j4.this.f12692a;
            final j4 j4Var = j4.this;
            final d dVar = this.f12701b;
            p2Var.a(new Runnable() { // from class: com.ironsource.zw
                @Override // java.lang.Runnable
                public final void run() {
                    j4.c.a(j4Var, j10, biddingDataList, reachedTimeout, dVar);
                }
            });
        }
    }

    public interface d {
        void a(@NotNull j4 j4Var);

        void a(@NotNull j4 j4Var, @NotNull String str);
    }

    public j4(@NotNull p2 adTools, @NotNull s1 adUnitData) {
        StringBuilder sb;
        String providerName;
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        this.f12692a = adTools;
        this.f12693b = adUnitData;
        this.f12694c = new x4(adUnitData);
        this.f12695d = new ArrayList();
        b bVarA = a();
        ts tsVarF = adUnitData.b().f();
        for (NetworkSettings networkSettings : adUnitData.n()) {
            if (tsVarF == null || tsVarF.a(networkSettings, this.f12693b.b().a())) {
                AdData adDataA = this.f12693b.a(networkSettings);
                if (networkSettings.isBidder(this.f12693b.b().a())) {
                    AdapterBaseInterface adapterBaseInterfaceA = a(networkSettings);
                    if (!(adapterBaseInterfaceA instanceof s7)) {
                        if (adapterBaseInterfaceA == null) {
                            sb = new StringBuilder();
                            sb.append("prepareAuctionCandidates - could not load network adapter ");
                            providerName = networkSettings.getProviderName();
                        } else {
                            sb = new StringBuilder();
                            sb.append("network adapter ");
                            sb.append(networkSettings.getProviderName());
                            providerName = " does not implementing BiddingDataInterface";
                        }
                        sb.append(providerName);
                        this.f12692a.e().g().f(sb.toString());
                    } else if (this.f12693b.f()) {
                        this.f12695d.add(new q7(networkSettings.getInstanceType(this.f12693b.b().a()), networkSettings.getProviderInstanceName(), adDataA, (s7) adapterBaseInterfaceA, bVarA, networkSettings));
                    } else {
                        a(adapterBaseInterfaceA, (s7) adapterBaseInterfaceA, adDataA, networkSettings);
                    }
                } else {
                    this.f12694c.a(networkSettings);
                }
            }
        }
    }

    private final b a() {
        return new b();
    }

    @NotNull
    public final List<q7> c() {
        return this.f12695d;
    }

    public final boolean d() {
        return !this.f12695d.isEmpty();
    }

    public final boolean e() {
        return this.f12694c.d();
    }

    private final AdapterBaseInterface a(NetworkSettings networkSettings) {
        return com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12693b.b().a(), this.f12693b.b().d().b());
    }

    private final t7.b b(d dVar) {
        return new c(dVar);
    }

    @NotNull
    public final x4 b() {
        return this.f12694c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        String providerDefaultInstance;
        HashMap map = new HashMap();
        if (networkSettings != null) {
            try {
                providerDefaultInstance = networkSettings.getProviderDefaultInstance();
            } catch (Exception e10) {
                i9.d().a(e10);
                IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
                IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.INTERNAL;
                StringBuilder sb = new StringBuilder();
                sb.append("getProviderEventData ");
                sb.append(networkSettings != null ? networkSettings.getProviderDefaultInstance() : null);
                logger.logException(ironSourceTag, sb.toString(), e10);
            }
        } else {
            providerDefaultInstance = null;
        }
        map.put(IronSourceConstants.EVENTS_PROVIDER, providerDefaultInstance);
        map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getAdapterVersion() : null);
        map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface != null ? adapterBaseInterface.getNetworkSDKVersion() : null);
        map.put("spId", networkSettings != null ? networkSettings.getSubProviderId() : null);
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        map.put("instanceType", networkSettings != null ? Integer.valueOf(networkSettings.getInstanceType(this.f12693b.b().a())) : null);
        return map;
    }

    private final Map<String, Object> a(String str) {
        NetworkSettings networkSettingsA = this.f12693b.a(str);
        return a(networkSettingsA, a(networkSettingsA));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(long j10, List<? extends u7> list, List<String> list2, d dVar) {
        this.f12692a.e().f().a(j10);
        for (u7 u7Var : list) {
            String strC = u7Var.c();
            kotlin.jvm.internal.t.h(strC, "biddingResponse.instanceName");
            Map<String, Object> mapA = a(strC);
            if (u7Var.a() != null) {
                this.f12694c.a(u7Var);
                this.f12692a.e().f().a(mapA, u7Var.e());
            } else {
                this.f12692a.e().f().a(mapA, u7Var.e(), u7Var.b());
            }
        }
        Iterator<String> it = list2.iterator();
        while (it.hasNext()) {
            this.f12692a.e().f().b(a(it.next()), j10);
        }
        dVar.a(this);
    }

    public final void a(@NotNull d biddingDataListener) {
        kotlin.jvm.internal.t.i(biddingDataListener, "biddingDataListener");
        t7 t7Var = new t7();
        t7.b bVarB = b(biddingDataListener);
        this.f12692a.e().f().a();
        this.f12692a.c((yp) new a(t7Var, this, bVarB));
    }

    private final void a(AdapterBaseInterface adapterBaseInterface, s7 s7Var, AdData adData, NetworkSettings networkSettings) {
        StringBuilder sb;
        String str;
        try {
            Map<String, ? extends Object> mapA = s7Var.a(adData);
            if (mapA != null) {
                this.f12694c.a(networkSettings, mapA);
            } else {
                this.f12692a.e().g().a(a(networkSettings, adapterBaseInterface), "Missing bidding data");
            }
        } catch (Exception e10) {
            e = e10;
            i9.d().a(e);
            sb = new StringBuilder();
            str = "prepareAuctionCandidates - exception while calling networkAdapter.getBiddingData - ";
            sb.append(str);
            sb.append(e.getMessage());
            String string = sb.toString();
            IronLog.INTERNAL.error(string);
            this.f12692a.e().g().f(string);
        } catch (NoClassDefFoundError e11) {
            e = e11;
            i9.d().a(e);
            sb = new StringBuilder();
            str = "prepareAuctionCandidates - error while calling networkAdapter.getBiddingData - ";
            sb.append(str);
            sb.append(e.getMessage());
            String string2 = sb.toString();
            IronLog.INTERNAL.error(string2);
            this.f12692a.e().g().f(string2);
        }
    }
}
