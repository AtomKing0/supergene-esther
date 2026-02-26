package com.ironsource;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class jl {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    public static final a f12749n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final int f12750o = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f12751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private a4 f12752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f12754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f12755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final ArrayList<ul> f12756f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private ul f12757g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12758h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private h5 f12759i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f12760j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f12761k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f12762l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f12763m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public jl(int i10, long j10, boolean z10, @NotNull a4 events, @NotNull h5 auctionSettings, int i11, boolean z11, long j11, boolean z12, boolean z13, boolean z14) {
        kotlin.jvm.internal.t.i(events, "events");
        kotlin.jvm.internal.t.i(auctionSettings, "auctionSettings");
        this.f12751a = z14;
        this.f12756f = new ArrayList<>();
        this.f12753c = i10;
        this.f12754d = j10;
        this.f12755e = z10;
        this.f12752b = events;
        this.f12758h = i11;
        this.f12759i = auctionSettings;
        this.f12760j = z11;
        this.f12761k = j11;
        this.f12762l = z12;
        this.f12763m = z13;
    }

    @Nullable
    public final ul a(@NotNull String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        for (ul ulVar : this.f12756f) {
            if (kotlin.jvm.internal.t.d(ulVar.getPlacementName(), placementName)) {
                return ulVar;
            }
        }
        return null;
    }

    public final int b() {
        return this.f12753c;
    }

    public final long c() {
        return this.f12754d;
    }

    @NotNull
    public final h5 d() {
        return this.f12759i;
    }

    @Nullable
    public final ul e() {
        for (ul ulVar : this.f12756f) {
            if (ulVar.isDefault()) {
                return ulVar;
            }
        }
        return this.f12757g;
    }

    public final int f() {
        return this.f12758h;
    }

    @NotNull
    public final a4 g() {
        return this.f12752b;
    }

    public final boolean h() {
        return this.f12760j;
    }

    public final long i() {
        return this.f12761k;
    }

    public final boolean j() {
        return this.f12762l;
    }

    public final boolean k() {
        return this.f12751a;
    }

    public final boolean l() {
        return this.f12763m;
    }

    @NotNull
    public String toString() {
        return "NativeAdConfigurations{parallelLoad=" + this.f12753c + ", bidderExclusive=" + this.f12755e + '}';
    }

    public final void a(int i10) {
        this.f12753c = i10;
    }

    public final void b(int i10) {
        this.f12758h = i10;
    }

    public final void c(boolean z10) {
        this.f12762l = z10;
    }

    public final void d(boolean z10) {
        this.f12763m = z10;
    }

    public final void a(long j10) {
        this.f12754d = j10;
    }

    public final void b(long j10) {
        this.f12761k = j10;
    }

    public final void a(@NotNull a4 a4Var) {
        kotlin.jvm.internal.t.i(a4Var, "<set-?>");
        this.f12752b = a4Var;
    }

    public final void b(boolean z10) {
        this.f12760j = z10;
    }

    public final void a(@NotNull h5 h5Var) {
        kotlin.jvm.internal.t.i(h5Var, "<set-?>");
        this.f12759i = h5Var;
    }

    public final void a(@Nullable ul ulVar) {
        if (ulVar != null) {
            this.f12756f.add(ulVar);
            if (this.f12757g == null || ulVar.getPlacementId() == 0) {
                this.f12757g = ulVar;
            }
        }
    }

    public final void a(boolean z10) {
        this.f12755e = z10;
    }

    public final boolean a() {
        return this.f12755e;
    }
}
