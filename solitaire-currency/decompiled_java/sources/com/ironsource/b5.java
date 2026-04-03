package com.ironsource;

import com.ironsource.mediationsdk.demandOnly.a;
import java.util.ArrayList;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class b5 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final b f11359h = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f11360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final com.ironsource.mediationsdk.demandOnly.a f11361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final f5 f11362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final JSONObject f11363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final JSONObject f11364e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final v4 f11365f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private final g5 f11366g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final JSONObject f11367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final String f11368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        private final String f11369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private final com.ironsource.mediationsdk.demandOnly.a f11370d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final f5 f11371e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        private final JSONObject f11372f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        private final JSONObject f11373g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private final v4 f11374h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        private final g5 f11375i;

        public a(@NotNull JSONObject auctionData, @NotNull String instanceId) {
            kotlin.jvm.internal.t.i(auctionData, "auctionData");
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            this.f11367a = auctionData;
            this.f11368b = instanceId;
            JSONObject jSONObjectA = a(auctionData);
            this.f11369c = auctionData.optString("auctionId");
            com.ironsource.mediationsdk.demandOnly.a aVarA = a(auctionData, jSONObjectA);
            this.f11370d = aVarA;
            this.f11371e = c(jSONObjectA);
            this.f11372f = d(jSONObjectA);
            this.f11373g = b(jSONObjectA);
            this.f11374h = a(aVarA, instanceId);
            this.f11375i = b(aVarA, instanceId);
        }

        private final g5 b(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            f5 f5VarA = aVar.a(str);
            if (f5VarA == null) {
                return null;
            }
            String strJ = f5VarA.j();
            kotlin.jvm.internal.t.h(strJ, "it.serverData");
            return new g5(strJ);
        }

        private final f5 c(JSONObject jSONObject) {
            return new f5(jSONObject);
        }

        private final JSONObject d(JSONObject jSONObject) {
            return jSONObject.optJSONObject("genericParams");
        }

        @NotNull
        public final b5 a() {
            return new b5(this.f11369c, this.f11370d, this.f11371e, this.f11372f, this.f11373g, this.f11374h, this.f11375i);
        }

        private final com.ironsource.mediationsdk.demandOnly.a a(JSONObject jSONObject, JSONObject jSONObject2) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject(com.ironsource.mediationsdk.d.f13323d);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.ironsource.mediationsdk.d.f13326g);
            if (jSONArrayOptJSONArray != null) {
                n9.i iVarU = n9.o.u(0, jSONArrayOptJSONArray.length());
                ArrayList arrayList2 = new ArrayList();
                Iterator<Integer> it = iVarU.iterator();
                while (it.hasNext()) {
                    int iNextInt = ((kotlin.collections.l0) it).nextInt();
                    f5 f5Var = new f5(jSONArrayOptJSONArray.getJSONObject(iNextInt), iNextInt, jSONObjectOptJSONObject);
                    if (!f5Var.l()) {
                        f5Var = null;
                    }
                    if (f5Var != null) {
                        arrayList2.add(f5Var);
                    }
                }
                arrayList.addAll(arrayList2);
            }
            return new a.C0259a(arrayList);
        }

        @NotNull
        public final JSONObject b() {
            return this.f11367a;
        }

        @NotNull
        public final String c() {
            return this.f11368b;
        }

        private final v4 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
            f5 f5VarA = aVar.a(str);
            if (f5VarA == null) {
                return null;
            }
            v4 v4Var = new v4();
            v4Var.a(f5VarA.b());
            v4Var.c(f5VarA.g());
            v4Var.b(f5VarA.f());
            return v4Var;
        }

        private final JSONObject b(JSONObject jSONObject) {
            return jSONObject.optJSONObject("configurations");
        }

        private final JSONObject a(JSONObject jSONObject) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
            return jSONObjectOptJSONObject == null ? new JSONObject() : jSONObjectOptJSONObject;
        }
    }

    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        private final Object a(b5 b5Var, String str) {
            ef efVar;
            String strB = b5Var.b();
            if (strB == null || strB.length() == 0) {
                t.a aVar = v8.t.f35208b;
                efVar = new ef(hb.f12462a.i());
            } else if (b5Var.i()) {
                t.a aVar2 = v8.t.f35208b;
                efVar = new ef(hb.f12462a.f());
            } else {
                f5 f5VarA = b5Var.a(str);
                if (f5VarA == null) {
                    t.a aVar3 = v8.t.f35208b;
                    efVar = new ef(hb.f12462a.j());
                } else {
                    String strJ = f5VarA.j();
                    if (!(strJ == null || strJ.length() == 0)) {
                        return v8.t.b(b5Var);
                    }
                    t.a aVar4 = v8.t.f35208b;
                    efVar = new ef(hb.f12462a.e());
                }
            }
            return v8.t.b(v8.u.a(efVar));
        }

        @NotNull
        public final Object a(@NotNull JSONObject auctionData, @NotNull String instanceId) {
            kotlin.jvm.internal.t.i(auctionData, "auctionData");
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            return a(new a(auctionData, instanceId).a(), instanceId);
        }
    }

    public b5(@Nullable String str, @NotNull com.ironsource.mediationsdk.demandOnly.a waterfall, @NotNull f5 genericNotifications, @Nullable JSONObject jSONObject, @Nullable JSONObject jSONObject2, @Nullable v4 v4Var, @Nullable g5 g5Var) {
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        kotlin.jvm.internal.t.i(genericNotifications, "genericNotifications");
        this.f11360a = str;
        this.f11361b = waterfall;
        this.f11362c = genericNotifications;
        this.f11363d = jSONObject;
        this.f11364e = jSONObject2;
        this.f11365f = v4Var;
        this.f11366g = g5Var;
    }

    private final f5 a(com.ironsource.mediationsdk.demandOnly.a aVar, String str) {
        return aVar.a(str);
    }

    @Nullable
    public final String b() {
        return this.f11360a;
    }

    @Nullable
    public final v4 c() {
        return this.f11365f;
    }

    @Nullable
    public final JSONObject d() {
        return this.f11364e;
    }

    @NotNull
    public final f5 e() {
        return this.f11362c;
    }

    @Nullable
    public final JSONObject f() {
        return this.f11363d;
    }

    @Nullable
    public final g5 g() {
        return this.f11366g;
    }

    @NotNull
    public final com.ironsource.mediationsdk.demandOnly.a h() {
        return this.f11361b;
    }

    public final boolean i() {
        return this.f11361b.isEmpty();
    }

    @Nullable
    public final f5 a(@NotNull String providerName) {
        kotlin.jvm.internal.t.i(providerName, "providerName");
        return a(this.f11361b, providerName);
    }

    @Nullable
    public final String a() {
        g5 g5Var = this.f11366g;
        if (g5Var != null) {
            return g5Var.d();
        }
        return null;
    }
}
