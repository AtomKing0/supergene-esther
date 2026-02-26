package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class q0 {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    public static final a f14406r = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f14407s = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f14408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f14409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final List<NetworkSettings> f14410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h5 f14411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f14413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f14415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f14416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final g2 f14417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final b2 f14418k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f14419l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f14420m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f14421n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f14422o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final boolean f14423p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f14424q;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public q0(@NotNull IronSource.AD_UNIT adUnit, @Nullable String str, @Nullable List<? extends NetworkSettings> list, @NotNull h5 auctionSettings, int i10, int i11, boolean z10, int i12, int i13, @NotNull g2 loadingData, @NotNull b2 interactionData, boolean z11, long j10, boolean z12, boolean z13, boolean z14, boolean z15) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        kotlin.jvm.internal.t.i(auctionSettings, "auctionSettings");
        kotlin.jvm.internal.t.i(loadingData, "loadingData");
        kotlin.jvm.internal.t.i(interactionData, "interactionData");
        this.f14408a = adUnit;
        this.f14409b = str;
        this.f14410c = list;
        this.f14411d = auctionSettings;
        this.f14412e = i10;
        this.f14413f = i11;
        this.f14414g = z10;
        this.f14415h = i12;
        this.f14416i = i13;
        this.f14417j = loadingData;
        this.f14418k = interactionData;
        this.f14419l = z11;
        this.f14420m = j10;
        this.f14421n = z12;
        this.f14422o = z13;
        this.f14423p = z14;
        this.f14424q = z15;
    }

    public final int a() {
        return this.f14416i;
    }

    @NotNull
    public final IronSource.AD_UNIT b() {
        return this.f14408a;
    }

    public final boolean c() {
        return this.f14414g;
    }

    @NotNull
    public final h5 d() {
        return this.f14411d;
    }

    public final boolean e() {
        return this.f14419l;
    }

    public final long f() {
        return this.f14420m;
    }

    public final int g() {
        return this.f14415h;
    }

    @NotNull
    public final b2 h() {
        return this.f14418k;
    }

    @NotNull
    public final g2 i() {
        return this.f14417j;
    }

    public final int j() {
        return this.f14412e;
    }

    @Nullable
    public List<NetworkSettings> k() {
        return this.f14410c;
    }

    public final boolean l() {
        return this.f14421n;
    }

    public final boolean m() {
        return this.f14423p;
    }

    public final boolean n() {
        return this.f14424q;
    }

    public final int o() {
        return this.f14413f;
    }

    @Nullable
    public String p() {
        return this.f14409b;
    }

    public final boolean q() {
        return this.f14422o;
    }

    public final boolean r() {
        return this.f14411d.g() > 0;
    }

    @NotNull
    public final String s() {
        String str = String.format(Locale.getDefault(), "%s: %d, %s: %b, %s: %b", com.ironsource.mediationsdk.d.f13342w, Integer.valueOf(this.f14412e), com.ironsource.mediationsdk.d.f13343x, Boolean.valueOf(this.f14414g), com.ironsource.mediationsdk.d.f13344y, Boolean.valueOf(this.f14424q));
        kotlin.jvm.internal.t.h(str, "format(\n          Locale…     showPriorityEnabled)");
        return str;
    }

    public /* synthetic */ q0(IronSource.AD_UNIT ad_unit, String str, List list, h5 h5Var, int i10, int i11, boolean z10, int i12, int i13, g2 g2Var, b2 b2Var, boolean z11, long j10, boolean z12, boolean z13, boolean z14, boolean z15, int i14, kotlin.jvm.internal.k kVar) {
        this(ad_unit, str, list, h5Var, i10, i11, z10, i12, i13, g2Var, b2Var, z11, j10, z12, z13, z14, (i14 & 65536) != 0 ? false : z15);
    }

    @Nullable
    public final NetworkSettings a(@NotNull String instanceName) {
        kotlin.jvm.internal.t.i(instanceName, "instanceName");
        List<NetworkSettings> listK = k();
        Object obj = null;
        if (listK == null) {
            return null;
        }
        Iterator<T> it = listK.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((NetworkSettings) next).getProviderInstanceName().equals(instanceName)) {
                obj = next;
                break;
            }
        }
        return (NetworkSettings) obj;
    }

    public final void b(boolean z10) {
        this.f14424q = z10;
    }

    public final void a(int i10) {
        this.f14412e = i10;
    }

    public final void a(boolean z10) {
        this.f14414g = z10;
    }
}
