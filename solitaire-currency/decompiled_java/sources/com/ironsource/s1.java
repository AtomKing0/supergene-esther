package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class s1 {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    public static final a f14755s = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f14756t = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final b1 f14757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f14759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final List<NetworkSettings> f14760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final lj f14761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final h5 f14762f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f14763g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14764h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14765i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f14766j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f14767k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final g2 f14768l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f14769m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final long f14770n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f14771o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f14772p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f14773q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f14774r;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final <AdFormatConfig, AdUnitData> AdUnitData a(@NotNull b1 adProperties, @Nullable ak akVar, @NotNull h9.l<? super m8, ? extends AdFormatConfig> getAdFormatConfig, @NotNull h9.p<? super r1, ? super AdFormatConfig, ? extends AdUnitData> createAdUnitData) {
            List<rm> listL;
            cr crVarD;
            kotlin.jvm.internal.t.i(adProperties, "adProperties");
            kotlin.jvm.internal.t.i(getAdFormatConfig, "getAdFormatConfig");
            kotlin.jvm.internal.t.i(createAdUnitData, "createAdUnitData");
            AdFormatConfig adformatconfigInvoke = getAdFormatConfig.invoke((akVar == null || (crVarD = akVar.d()) == null) ? null : crVarD.c());
            if (adformatconfigInvoke == null) {
                throw new IllegalStateException("Error getting " + adProperties.a() + " configurations");
            }
            if (akVar == null || (listL = akVar.b(adProperties.c(), adProperties.b())) == null) {
                listL = kotlin.collections.v.l();
            }
            String userIdForNetworks = IronSourceUtils.getUserIdForNetworks();
            List<rm> list = listL;
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((rm) it.next()).f());
            }
            lj ljVarB = lj.b();
            kotlin.jvm.internal.t.h(ljVarB, "getInstance()");
            return createAdUnitData.mo4invoke(new r1(userIdForNetworks, arrayList, ljVarB), adformatconfigInvoke);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public s1(@NotNull b1 adProperties, boolean z10, @Nullable String str, @NotNull List<? extends NetworkSettings> providerList, @NotNull lj publisherDataHolder, @NotNull h5 auctionSettings, int i10, int i11, boolean z11, int i12, int i13, @NotNull g2 loadingData, boolean z12, long j10, boolean z13, boolean z14, boolean z15, boolean z16) {
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        kotlin.jvm.internal.t.i(providerList, "providerList");
        kotlin.jvm.internal.t.i(publisherDataHolder, "publisherDataHolder");
        kotlin.jvm.internal.t.i(auctionSettings, "auctionSettings");
        kotlin.jvm.internal.t.i(loadingData, "loadingData");
        this.f14757a = adProperties;
        this.f14758b = z10;
        this.f14759c = str;
        this.f14760d = providerList;
        this.f14761e = publisherDataHolder;
        this.f14762f = auctionSettings;
        this.f14763g = i10;
        this.f14764h = i11;
        this.f14765i = z11;
        this.f14766j = i12;
        this.f14767k = i13;
        this.f14768l = loadingData;
        this.f14769m = z12;
        this.f14770n = j10;
        this.f14771o = z13;
        this.f14772p = z14;
        this.f14773q = z15;
        this.f14774r = z16;
    }

    public final int a() {
        return this.f14767k;
    }

    @NotNull
    public b1 b() {
        return this.f14757a;
    }

    @NotNull
    public abstract JSONObject b(@NotNull NetworkSettings networkSettings);

    @NotNull
    public abstract String c();

    public final boolean d() {
        return this.f14765i;
    }

    @NotNull
    public final h5 e() {
        return this.f14762f;
    }

    public final boolean f() {
        return this.f14769m;
    }

    public final long g() {
        return this.f14770n;
    }

    public final int h() {
        return this.f14766j;
    }

    public final int i() {
        return this.f14764h;
    }

    @NotNull
    public final g2 j() {
        return this.f14768l;
    }

    @NotNull
    public abstract String k();

    public final int l() {
        return this.f14763g;
    }

    @NotNull
    public final String m() {
        String placementName;
        Placement placementE = b().e();
        return (placementE == null || (placementName = placementE.getPlacementName()) == null) ? "" : placementName;
    }

    @NotNull
    public final List<NetworkSettings> n() {
        return this.f14760d;
    }

    public final boolean o() {
        return this.f14771o;
    }

    @NotNull
    public final lj p() {
        return this.f14761e;
    }

    public final boolean q() {
        return this.f14773q;
    }

    public final boolean r() {
        return this.f14774r;
    }

    @Nullable
    public final String s() {
        return this.f14759c;
    }

    public final boolean t() {
        return this.f14772p;
    }

    public final boolean u() {
        return this.f14762f.g() > 0;
    }

    public boolean v() {
        return this.f14758b;
    }

    @NotNull
    public final String w() {
        String str = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", com.ironsource.mediationsdk.d.f13342w, Integer.valueOf(this.f14763g), com.ironsource.mediationsdk.d.f13343x, Boolean.valueOf(this.f14765i), com.ironsource.mediationsdk.d.f13344y, Boolean.valueOf(this.f14774r));
        kotlin.jvm.internal.t.h(str, "format(\n          Locale…     showPriorityEnabled)");
        return str;
    }

    public /* synthetic */ s1(b1 b1Var, boolean z10, String str, List list, lj ljVar, h5 h5Var, int i10, int i11, boolean z11, int i12, int i13, g2 g2Var, boolean z12, long j10, boolean z13, boolean z14, boolean z15, boolean z16, int i14, kotlin.jvm.internal.k kVar) {
        this(b1Var, z10, str, list, ljVar, h5Var, i10, i11, z11, i12, i13, g2Var, z12, j10, z13, z14, z15, (i14 & 131072) != 0 ? false : z16);
    }

    @NotNull
    public AdData a(@NotNull NetworkSettings providerSettings) {
        kotlin.jvm.internal.t.i(providerSettings, "providerSettings");
        AdData adDataCreateAdDataForNetworkAdapter = AdData.createAdDataForNetworkAdapter(b(providerSettings), b().a(), this.f14759c);
        kotlin.jvm.internal.t.h(adDataCreateAdDataForNetworkAdapter, "createAdDataForNetworkAd…perties.adFormat, userId)");
        return adDataCreateAdDataForNetworkAdapter;
    }

    public final void b(boolean z10) {
        this.f14774r = z10;
    }

    @Nullable
    public final NetworkSettings a(@NotNull String instanceName) {
        Object next;
        kotlin.jvm.internal.t.i(instanceName, "instanceName");
        Iterator<T> it = this.f14760d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                break;
            }
        }
        return (NetworkSettings) next;
    }

    public final void a(int i10) {
        this.f14763g = i10;
    }

    public final void a(boolean z10) {
        this.f14765i = z10;
    }
}
