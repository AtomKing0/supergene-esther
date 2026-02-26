package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.sdk.controller.f;
import java.util.Date;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class k0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f12796f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final String f12797g = "0";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final String f12798h = "0";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public static final String f12799i = "0";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final String f12800j = "0";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final mi f12801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private we f12802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private String f12803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private j1 f12804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f12805e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public k0(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        this.f12801a = adInstance;
        this.f12802b = we.UnknownProvider;
        this.f12803c = "0";
        this.f12804d = j1.LOAD_REQUEST;
        this.f12805e = new Date().getTime() / 1000.0d;
    }

    public static /* synthetic */ k0 a(k0 k0Var, mi miVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            miVar = k0Var.f12801a;
        }
        return k0Var.a(miVar);
    }

    @NotNull
    public final IronSource.AD_UNIT b() {
        return this.f12801a.i() ? IronSource.AD_UNIT.BANNER : this.f12801a.n() ? IronSource.AD_UNIT.REWARDED_VIDEO : IronSource.AD_UNIT.INTERSTITIAL;
    }

    @NotNull
    public final String c() {
        String strE = this.f12801a.e();
        kotlin.jvm.internal.t.h(strE, "adInstance.id");
        return strE;
    }

    @NotNull
    public final mi d() {
        return this.f12801a;
    }

    @NotNull
    public final we e() {
        return this.f12802b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k0)) {
            return false;
        }
        k0 k0Var = (k0) obj;
        return kotlin.jvm.internal.t.d(c(), k0Var.c()) && kotlin.jvm.internal.t.d(g(), k0Var.g()) && b() == k0Var.b() && kotlin.jvm.internal.t.d(i(), k0Var.i()) && this.f12802b == k0Var.f12802b && kotlin.jvm.internal.t.d(this.f12803c, k0Var.f12803c) && this.f12804d == k0Var.f12804d;
    }

    @NotNull
    public final j1 f() {
        return this.f12804d;
    }

    @NotNull
    public final String g() {
        String strC = this.f12801a.c();
        return strC == null ? "0" : strC;
    }

    @NotNull
    public final String h() {
        return this.f12803c;
    }

    public int hashCode() {
        return Objects.hash(c(), g(), b(), i(), this.f12802b, this.f12803c, this.f12804d, Double.valueOf(this.f12805e));
    }

    @NotNull
    public final String i() {
        String strG = this.f12801a.g();
        kotlin.jvm.internal.t.h(strG, "adInstance.name");
        return strG;
    }

    public final double j() {
        return this.f12805e;
    }

    @NotNull
    public String toString() {
        String string = new JSONObject().put(f.b.f15004c, c()).put("advertiserBundleId", this.f12803c).put("adProvider", this.f12802b.ordinal()).put("adStatus", this.f12804d.ordinal()).put("lastStatusUpdateTimeStamp", (long) this.f12805e).put("adUnitId", g()).put(ImpressionData.IMPRESSION_DATA_KEY_AD_FORMAT, b().toString()).put("instanceId", i()).toString();
        kotlin.jvm.internal.t.h(string, "JSONObject()\n        .pu…ceId)\n        .toString()");
        return string;
    }

    @NotNull
    public final k0 a(@NotNull mi adInstance) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        return new k0(adInstance);
    }

    @NotNull
    public final mi a() {
        return this.f12801a;
    }

    public final void a(double d10) {
        this.f12805e = d10;
    }

    public final void a(@NotNull j1 j1Var) {
        kotlin.jvm.internal.t.i(j1Var, "<set-?>");
        this.f12804d = j1Var;
    }

    public final void a(@NotNull we weVar) {
        kotlin.jvm.internal.t.i(weVar, "<set-?>");
        this.f12802b = weVar;
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f12803c = str;
    }
}
