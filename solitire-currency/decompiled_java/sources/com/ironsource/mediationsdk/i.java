package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.y4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f13591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ArrayList<y4> f13592b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13593c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private String f13594d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13595e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private Map<String, Object> f13596f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private List<String> f13597g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13598h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private h f13599i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private IronSourceSegment f13600j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private String f13601k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private ISBannerSize f13602l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f13603m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13604n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f13605o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private String f13606p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private String f13607q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private Boolean f13608r;

    public i(@NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        this.f13591a = adUnit;
        this.f13592b = new ArrayList<>();
        this.f13594d = "";
        this.f13596f = new HashMap();
        this.f13597g = new ArrayList();
        this.f13598h = -1;
        this.f13601k = "";
    }

    @NotNull
    public final IronSource.AD_UNIT a() {
        return this.f13591a;
    }

    @Nullable
    public final String b() {
        return this.f13607q;
    }

    @NotNull
    public final IronSource.AD_UNIT c() {
        return this.f13591a;
    }

    @Nullable
    public final String d() {
        return this.f13606p;
    }

    @Nullable
    public final h e() {
        return this.f13599i;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof i) && this.f13591a == ((i) obj).f13591a;
    }

    @Nullable
    public final ISBannerSize f() {
        return this.f13602l;
    }

    @NotNull
    public final Map<String, Object> g() {
        return this.f13596f;
    }

    public int hashCode() {
        return this.f13591a.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f13594d;
    }

    @NotNull
    public final ArrayList<y4> j() {
        return this.f13592b;
    }

    @NotNull
    public final List<String> k() {
        return this.f13597g;
    }

    @Nullable
    public final IronSourceSegment m() {
        return this.f13600j;
    }

    public final int n() {
        return this.f13598h;
    }

    public final boolean o() {
        return this.f13604n;
    }

    public final boolean p() {
        return this.f13605o;
    }

    @NotNull
    public final String q() {
        return this.f13601k;
    }

    public final boolean r() {
        return this.f13603m;
    }

    public final boolean s() {
        return this.f13595e;
    }

    @Nullable
    public final Boolean t() {
        return this.f13608r;
    }

    @NotNull
    public String toString() {
        return "AuctionRequestParams(adUnit=" + this.f13591a + ')';
    }

    public final boolean u() {
        return this.f13593c;
    }

    @NotNull
    public final i a(@NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        return new i(adUnit);
    }

    public final void b(@Nullable String str) {
        this.f13606p = str;
    }

    public final void c(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f13594d = str;
    }

    public final void d(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f13601k = str;
    }

    public final void e(boolean z10) {
        this.f13605o = z10;
    }

    public static /* synthetic */ i a(i iVar, IronSource.AD_UNIT ad_unit, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            ad_unit = iVar.f13591a;
        }
        return iVar.a(ad_unit);
    }

    public final void b(boolean z10) {
        this.f13595e = z10;
    }

    public final void c(boolean z10) {
        this.f13593c = z10;
    }

    public final void d(boolean z10) {
        this.f13604n = z10;
    }

    public final void a(int i10) {
        this.f13598h = i10;
    }

    public final void a(@Nullable ISBannerSize iSBannerSize) {
        this.f13602l = iSBannerSize;
    }

    public final void a(@Nullable IronSourceSegment ironSourceSegment) {
        this.f13600j = ironSourceSegment;
    }

    public final void a(@Nullable h hVar) {
        this.f13599i = hVar;
    }

    public final void a(@NotNull y4 instanceInfo) {
        kotlin.jvm.internal.t.i(instanceInfo, "instanceInfo");
        this.f13592b.add(instanceInfo);
    }

    public final void a(@Nullable Boolean bool) {
        this.f13608r = bool;
    }

    public final void a(@Nullable String str) {
        this.f13607q = str;
    }

    public final void a(@NotNull List<String> list) {
        kotlin.jvm.internal.t.i(list, "<set-?>");
        this.f13597g = list;
    }

    public final void a(@NotNull Map<String, Object> map) {
        kotlin.jvm.internal.t.i(map, "<set-?>");
        this.f13596f = map;
    }

    public final void a(boolean z10) {
        this.f13603m = z10;
    }

    public static /* synthetic */ void h() {
    }

    public static /* synthetic */ void l() {
    }
}
