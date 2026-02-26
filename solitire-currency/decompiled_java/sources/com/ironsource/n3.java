package com.ironsource;

import com.ironsource.qf;
import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface n3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f14058a = b.f14074a;

    public interface a extends n3 {

        /* JADX INFO: renamed from: com.ironsource.n3$a$a, reason: collision with other inner class name */
        public static final class C0261a implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final String f14059b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NotNull
            private final String f14060c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @NotNull
            private final qf.e f14061d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @NotNull
            private final String f14062e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @NotNull
            private final String f14063f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @NotNull
            private final C0262a f14064g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final int f14065h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final int f14066i;

            /* JADX INFO: renamed from: com.ironsource.n3$a$a$a, reason: collision with other inner class name */
            public static final class C0262a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final int f14067a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final int f14068b;

                public C0262a(int i10, int i11) {
                    this.f14067a = i10;
                    this.f14068b = i11;
                }

                public final int a() {
                    return this.f14067a;
                }

                public final int b() {
                    return this.f14068b;
                }

                public final int c() {
                    return this.f14067a;
                }

                public final int d() {
                    return this.f14068b;
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof C0262a)) {
                        return false;
                    }
                    C0262a c0262a = (C0262a) obj;
                    return this.f14067a == c0262a.f14067a && this.f14068b == c0262a.f14068b;
                }

                public int hashCode() {
                    return (this.f14067a * 31) + this.f14068b;
                }

                @NotNull
                public String toString() {
                    return "Coordinates(x=" + this.f14067a + ", y=" + this.f14068b + ')';
                }

                @NotNull
                public final C0262a a(int i10, int i11) {
                    return new C0262a(i10, i11);
                }

                public static /* synthetic */ C0262a a(C0262a c0262a, int i10, int i11, int i12, Object obj) {
                    if ((i12 & 1) != 0) {
                        i10 = c0262a.f14067a;
                    }
                    if ((i12 & 2) != 0) {
                        i11 = c0262a.f14068b;
                    }
                    return c0262a.a(i10, i11);
                }
            }

            public C0261a(@NotNull String successCallback, @NotNull String failCallback, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull String url, @NotNull C0262a coordinates, int i10, int i11) {
                kotlin.jvm.internal.t.i(successCallback, "successCallback");
                kotlin.jvm.internal.t.i(failCallback, "failCallback");
                kotlin.jvm.internal.t.i(productType, "productType");
                kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.t.i(url, "url");
                kotlin.jvm.internal.t.i(coordinates, "coordinates");
                this.f14059b = successCallback;
                this.f14060c = failCallback;
                this.f14061d = productType;
                this.f14062e = demandSourceName;
                this.f14063f = url;
                this.f14064g = coordinates;
                this.f14065h = i10;
                this.f14066i = i11;
            }

            @Override // com.ironsource.n3
            @NotNull
            public qf.e b() {
                return this.f14061d;
            }

            @Override // com.ironsource.n3
            @NotNull
            public String c() {
                return this.f14059b;
            }

            @Override // com.ironsource.n3
            @NotNull
            public String d() {
                return this.f14062e;
            }

            @NotNull
            public final String e() {
                return c();
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0261a)) {
                    return false;
                }
                C0261a c0261a = (C0261a) obj;
                return kotlin.jvm.internal.t.d(c(), c0261a.c()) && kotlin.jvm.internal.t.d(a(), c0261a.a()) && b() == c0261a.b() && kotlin.jvm.internal.t.d(d(), c0261a.d()) && kotlin.jvm.internal.t.d(getUrl(), c0261a.getUrl()) && kotlin.jvm.internal.t.d(this.f14064g, c0261a.f14064g) && this.f14065h == c0261a.f14065h && this.f14066i == c0261a.f14066i;
            }

            @NotNull
            public final String f() {
                return a();
            }

            @NotNull
            public final qf.e g() {
                return b();
            }

            @Override // com.ironsource.n3.a
            @NotNull
            public String getUrl() {
                return this.f14063f;
            }

            @NotNull
            public final String h() {
                return d();
            }

            public int hashCode() {
                return (((((((((((((c().hashCode() * 31) + a().hashCode()) * 31) + b().hashCode()) * 31) + d().hashCode()) * 31) + getUrl().hashCode()) * 31) + this.f14064g.hashCode()) * 31) + this.f14065h) * 31) + this.f14066i;
            }

            @NotNull
            public final String i() {
                return getUrl();
            }

            @NotNull
            public final C0262a j() {
                return this.f14064g;
            }

            public final int k() {
                return this.f14065h;
            }

            public final int l() {
                return this.f14066i;
            }

            public final int m() {
                return this.f14065h;
            }

            @NotNull
            public final C0262a n() {
                return this.f14064g;
            }

            public final int o() {
                return this.f14066i;
            }

            @NotNull
            public String toString() {
                return "Click(successCallback=" + c() + ", failCallback=" + a() + ", productType=" + b() + ", demandSourceName=" + d() + ", url=" + getUrl() + ", coordinates=" + this.f14064g + ", action=" + this.f14065h + ", metaState=" + this.f14066i + ')';
            }

            @NotNull
            public final C0261a a(@NotNull String successCallback, @NotNull String failCallback, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull String url, @NotNull C0262a coordinates, int i10, int i11) {
                kotlin.jvm.internal.t.i(successCallback, "successCallback");
                kotlin.jvm.internal.t.i(failCallback, "failCallback");
                kotlin.jvm.internal.t.i(productType, "productType");
                kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.t.i(url, "url");
                kotlin.jvm.internal.t.i(coordinates, "coordinates");
                return new C0261a(successCallback, failCallback, productType, demandSourceName, url, coordinates, i10, i11);
            }

            @Override // com.ironsource.n3
            @NotNull
            public String a() {
                return this.f14060c;
            }
        }

        public static final class b implements a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @NotNull
            private final String f14069b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @NotNull
            private final String f14070c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @NotNull
            private final qf.e f14071d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @NotNull
            private final String f14072e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @NotNull
            private final String f14073f;

            public b(@NotNull String successCallback, @NotNull String failCallback, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull String url) {
                kotlin.jvm.internal.t.i(successCallback, "successCallback");
                kotlin.jvm.internal.t.i(failCallback, "failCallback");
                kotlin.jvm.internal.t.i(productType, "productType");
                kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.t.i(url, "url");
                this.f14069b = successCallback;
                this.f14070c = failCallback;
                this.f14071d = productType;
                this.f14072e = demandSourceName;
                this.f14073f = url;
            }

            public static /* synthetic */ b a(b bVar, String str, String str2, qf.e eVar, String str3, String str4, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = bVar.c();
                }
                if ((i10 & 2) != 0) {
                    str2 = bVar.a();
                }
                String str5 = str2;
                if ((i10 & 4) != 0) {
                    eVar = bVar.b();
                }
                qf.e eVar2 = eVar;
                if ((i10 & 8) != 0) {
                    str3 = bVar.d();
                }
                String str6 = str3;
                if ((i10 & 16) != 0) {
                    str4 = bVar.getUrl();
                }
                return bVar.a(str, str5, eVar2, str6, str4);
            }

            @Override // com.ironsource.n3
            @NotNull
            public qf.e b() {
                return this.f14071d;
            }

            @Override // com.ironsource.n3
            @NotNull
            public String c() {
                return this.f14069b;
            }

            @Override // com.ironsource.n3
            @NotNull
            public String d() {
                return this.f14072e;
            }

            @NotNull
            public final String e() {
                return c();
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                return kotlin.jvm.internal.t.d(c(), bVar.c()) && kotlin.jvm.internal.t.d(a(), bVar.a()) && b() == bVar.b() && kotlin.jvm.internal.t.d(d(), bVar.d()) && kotlin.jvm.internal.t.d(getUrl(), bVar.getUrl());
            }

            @NotNull
            public final String f() {
                return a();
            }

            @NotNull
            public final qf.e g() {
                return b();
            }

            @Override // com.ironsource.n3.a
            @NotNull
            public String getUrl() {
                return this.f14073f;
            }

            @NotNull
            public final String h() {
                return d();
            }

            public int hashCode() {
                return (((((((c().hashCode() * 31) + a().hashCode()) * 31) + b().hashCode()) * 31) + d().hashCode()) * 31) + getUrl().hashCode();
            }

            @NotNull
            public final String i() {
                return getUrl();
            }

            @NotNull
            public String toString() {
                return "Impression(successCallback=" + c() + ", failCallback=" + a() + ", productType=" + b() + ", demandSourceName=" + d() + ", url=" + getUrl() + ')';
            }

            @NotNull
            public final b a(@NotNull String successCallback, @NotNull String failCallback, @NotNull qf.e productType, @NotNull String demandSourceName, @NotNull String url) {
                kotlin.jvm.internal.t.i(successCallback, "successCallback");
                kotlin.jvm.internal.t.i(failCallback, "failCallback");
                kotlin.jvm.internal.t.i(productType, "productType");
                kotlin.jvm.internal.t.i(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.t.i(url, "url");
                return new b(successCallback, failCallback, productType, demandSourceName, url);
            }

            @Override // com.ironsource.n3
            @NotNull
            public String a() {
                return this.f14070c;
            }
        }

        @NotNull
        String getUrl();
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ b f14074a = new b();

        private b() {
        }

        private final a a(JSONObject jSONObject) throws JSONException {
            String successCallback = jSONObject.getString("success");
            String failCallback = jSONObject.getString(v8.f.f15748e);
            String demandSourceName = jSONObject.getString("demandSourceName");
            String string = jSONObject.getString(v8.h.f15803m);
            kotlin.jvm.internal.t.h(string, "json.getString(ParametersKeys.PRODUCT_TYPE)");
            qf.e eVarValueOf = qf.e.valueOf(string);
            JSONObject jSONObject2 = jSONObject.getJSONObject("params");
            String url = jSONObject2.getString("url");
            String strOptString = jSONObject2.optString("type");
            if (kotlin.jvm.internal.t.d(strOptString, w8.f16021d)) {
                JSONObject jSONObject3 = jSONObject2.getJSONObject(w8.f16023f);
                int i10 = jSONObject3.getInt(w8.f16024g);
                int i11 = jSONObject3.getInt(w8.f16025h);
                int iOptInt = jSONObject2.optInt("action", 0);
                int iOptInt2 = jSONObject2.optInt(w8.f16027j, 0);
                kotlin.jvm.internal.t.h(successCallback, "successCallback");
                kotlin.jvm.internal.t.h(failCallback, "failCallback");
                kotlin.jvm.internal.t.h(demandSourceName, "demandSourceName");
                kotlin.jvm.internal.t.h(url, "url");
                return new a.C0261a(successCallback, failCallback, eVarValueOf, demandSourceName, url, new a.C0261a.C0262a(i10, i11), iOptInt, iOptInt2);
            }
            if (!kotlin.jvm.internal.t.d(strOptString, "impression")) {
                throw new IllegalArgumentException("JSON does not contain valid type: " + jSONObject2.optString("type"));
            }
            kotlin.jvm.internal.t.h(successCallback, "successCallback");
            kotlin.jvm.internal.t.h(failCallback, "failCallback");
            kotlin.jvm.internal.t.h(demandSourceName, "demandSourceName");
            kotlin.jvm.internal.t.h(url, "url");
            return new a.b(successCallback, failCallback, eVarValueOf, demandSourceName, url);
        }

        @NotNull
        public final n3 a(@NotNull String jsonString) {
            kotlin.jvm.internal.t.i(jsonString, "jsonString");
            JSONObject jSONObject = new JSONObject(jsonString);
            String strOptString = jSONObject.optString("type", "none");
            if (kotlin.jvm.internal.t.d(strOptString, w8.f16020c)) {
                return a(jSONObject);
            }
            throw new IllegalArgumentException("unsupported message type: " + strOptString);
        }
    }

    @NotNull
    String a();

    @NotNull
    qf.e b();

    @NotNull
    String c();

    @NotNull
    String d();
}
