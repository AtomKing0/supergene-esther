package com.ironsource;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.webkit.WebView;
import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class dg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f11815a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f11816b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f11817c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final String f11818d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final Drawable f11819e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private final WebView f11820f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final View f11821g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final sg f11822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final u2 f11823b;

        public a(@NotNull sg imageLoader, @NotNull u2 adViewManagement) {
            kotlin.jvm.internal.t.i(imageLoader, "imageLoader");
            kotlin.jvm.internal.t.i(adViewManagement, "adViewManagement");
            this.f11822a = imageLoader;
            this.f11823b = adViewManagement;
        }

        private final v8.t<Drawable> b(String str) {
            if (str == null) {
                return null;
            }
            return v8.t.a(this.f11822a.a(str));
        }

        @NotNull
        public final b a(@NotNull Context activityContext, @NotNull JSONObject json) {
            kotlin.jvm.internal.t.i(activityContext, "activityContext");
            kotlin.jvm.internal.t.i(json, "json");
            JSONObject jSONObjectOptJSONObject = json.optJSONObject("title");
            String strB = jSONObjectOptJSONObject != null ? eg.b(jSONObjectOptJSONObject, "text") : null;
            JSONObject jSONObjectOptJSONObject2 = json.optJSONObject(v8.h.F0);
            String strB2 = jSONObjectOptJSONObject2 != null ? eg.b(jSONObjectOptJSONObject2, "text") : null;
            JSONObject jSONObjectOptJSONObject3 = json.optJSONObject("body");
            String strB3 = jSONObjectOptJSONObject3 != null ? eg.b(jSONObjectOptJSONObject3, "text") : null;
            JSONObject jSONObjectOptJSONObject4 = json.optJSONObject("cta");
            String strB4 = jSONObjectOptJSONObject4 != null ? eg.b(jSONObjectOptJSONObject4, "text") : null;
            JSONObject jSONObjectOptJSONObject5 = json.optJSONObject(v8.h.H0);
            String strB5 = jSONObjectOptJSONObject5 != null ? eg.b(jSONObjectOptJSONObject5, "url") : null;
            JSONObject jSONObjectOptJSONObject6 = json.optJSONObject(v8.h.I0);
            String strB6 = jSONObjectOptJSONObject6 != null ? eg.b(jSONObjectOptJSONObject6, "adViewId") : null;
            JSONObject jSONObjectOptJSONObject7 = json.optJSONObject(v8.h.J0);
            return new b(new b.a(strB, strB2, strB3, strB4, b(strB5), a(strB6), lo.f13059a.a(activityContext, jSONObjectOptJSONObject7 != null ? eg.b(jSONObjectOptJSONObject7, "url") : null, this.f11822a)));
        }

        private final v8.t<WebView> a(String str) {
            Object objB;
            if (str == null) {
                return null;
            }
            hg hgVarA = this.f11823b.a(str);
            WebView presentingView = hgVarA != null ? hgVarA.getPresentingView() : null;
            if (presentingView == null) {
                t.a aVar = v8.t.f35208b;
                objB = v8.t.b(v8.u.a(new Exception("missing adview for id: '" + str + '\'')));
            } else {
                objB = v8.t.b(presentingView);
            }
            return v8.t.a(objB);
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final a f11824a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @Nullable
            private final String f11825a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @Nullable
            private final String f11826b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            @Nullable
            private final String f11827c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            @Nullable
            private final String f11828d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @Nullable
            private final v8.t<Drawable> f11829e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            @Nullable
            private final v8.t<WebView> f11830f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            @NotNull
            private final View f11831g;

            /* JADX WARN: Multi-variable type inference failed */
            public a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable v8.t<? extends Drawable> tVar, @Nullable v8.t<? extends WebView> tVar2, @NotNull View privacyIcon) {
                kotlin.jvm.internal.t.i(privacyIcon, "privacyIcon");
                this.f11825a = str;
                this.f11826b = str2;
                this.f11827c = str3;
                this.f11828d = str4;
                this.f11829e = tVar;
                this.f11830f = tVar2;
                this.f11831g = privacyIcon;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ a a(a aVar, String str, String str2, String str3, String str4, v8.t tVar, v8.t tVar2, View view, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = aVar.f11825a;
                }
                if ((i10 & 2) != 0) {
                    str2 = aVar.f11826b;
                }
                String str5 = str2;
                if ((i10 & 4) != 0) {
                    str3 = aVar.f11827c;
                }
                String str6 = str3;
                if ((i10 & 8) != 0) {
                    str4 = aVar.f11828d;
                }
                String str7 = str4;
                if ((i10 & 16) != 0) {
                    tVar = aVar.f11829e;
                }
                v8.t tVar3 = tVar;
                if ((i10 & 32) != 0) {
                    tVar2 = aVar.f11830f;
                }
                v8.t tVar4 = tVar2;
                if ((i10 & 64) != 0) {
                    view = aVar.f11831g;
                }
                return aVar.a(str, str5, str6, str7, tVar3, tVar4, view);
            }

            @Nullable
            public final String b() {
                return this.f11826b;
            }

            @Nullable
            public final String c() {
                return this.f11827c;
            }

            @Nullable
            public final String d() {
                return this.f11828d;
            }

            @Nullable
            public final v8.t<Drawable> e() {
                return this.f11829e;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return kotlin.jvm.internal.t.d(this.f11825a, aVar.f11825a) && kotlin.jvm.internal.t.d(this.f11826b, aVar.f11826b) && kotlin.jvm.internal.t.d(this.f11827c, aVar.f11827c) && kotlin.jvm.internal.t.d(this.f11828d, aVar.f11828d) && kotlin.jvm.internal.t.d(this.f11829e, aVar.f11829e) && kotlin.jvm.internal.t.d(this.f11830f, aVar.f11830f) && kotlin.jvm.internal.t.d(this.f11831g, aVar.f11831g);
            }

            @Nullable
            public final v8.t<WebView> f() {
                return this.f11830f;
            }

            @NotNull
            public final View g() {
                return this.f11831g;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v0, types: [android.webkit.WebView] */
            @NotNull
            public final dg h() {
                Drawable drawable;
                String str = this.f11825a;
                String str2 = this.f11826b;
                String str3 = this.f11827c;
                String str4 = this.f11828d;
                v8.t<Drawable> tVar = this.f11829e;
                if (tVar != null) {
                    Object objJ = tVar.j();
                    if (v8.t.g(objJ)) {
                        objJ = null;
                    }
                    drawable = (Drawable) objJ;
                } else {
                    drawable = null;
                }
                v8.t<WebView> tVar2 = this.f11830f;
                if (tVar2 != null) {
                    Object objJ2 = tVar2.j();
                    obj = (WebView) (v8.t.g(objJ2) ? null : objJ2);
                }
                return new dg(str, str2, str3, str4, drawable, obj, this.f11831g);
            }

            public int hashCode() {
                String str = this.f11825a;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.f11826b;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.f11827c;
                int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
                String str4 = this.f11828d;
                int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
                v8.t<Drawable> tVar = this.f11829e;
                int iF = (iHashCode4 + (tVar == null ? 0 : v8.t.f(tVar.j()))) * 31;
                v8.t<WebView> tVar2 = this.f11830f;
                return ((iF + (tVar2 != null ? v8.t.f(tVar2.j()) : 0)) * 31) + this.f11831g.hashCode();
            }

            @Nullable
            public final String i() {
                return this.f11826b;
            }

            @Nullable
            public final String j() {
                return this.f11827c;
            }

            @Nullable
            public final String k() {
                return this.f11828d;
            }

            @Nullable
            public final v8.t<Drawable> l() {
                return this.f11829e;
            }

            @Nullable
            public final v8.t<WebView> m() {
                return this.f11830f;
            }

            @NotNull
            public final View n() {
                return this.f11831g;
            }

            @Nullable
            public final String o() {
                return this.f11825a;
            }

            @NotNull
            public String toString() {
                return "Data(title=" + this.f11825a + ", advertiser=" + this.f11826b + ", body=" + this.f11827c + ", cta=" + this.f11828d + ", icon=" + this.f11829e + ", media=" + this.f11830f + ", privacyIcon=" + this.f11831g + ')';
            }

            @NotNull
            public final a a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable v8.t<? extends Drawable> tVar, @Nullable v8.t<? extends WebView> tVar2, @NotNull View privacyIcon) {
                kotlin.jvm.internal.t.i(privacyIcon, "privacyIcon");
                return new a(str, str2, str3, str4, tVar, tVar2, privacyIcon);
            }

            @Nullable
            public final String a() {
                return this.f11825a;
            }
        }

        public b(@NotNull a data) {
            kotlin.jvm.internal.t.i(data, "data");
            this.f11824a = data;
        }

        @NotNull
        public final a a() {
            return this.f11824a;
        }

        @NotNull
        public final JSONObject b() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            if (this.f11824a.o() != null) {
                a(jSONObject, "title");
            }
            if (this.f11824a.i() != null) {
                a(jSONObject, v8.h.F0);
            }
            if (this.f11824a.j() != null) {
                a(jSONObject, "body");
            }
            if (this.f11824a.k() != null) {
                a(jSONObject, "cta");
            }
            v8.t<Drawable> tVarL = this.f11824a.l();
            if (tVarL != null) {
                a(jSONObject, v8.h.H0, tVarL.j());
            }
            v8.t<WebView> tVarM = this.f11824a.m();
            if (tVarM != null) {
                a(jSONObject, v8.h.I0, tVarM.j());
            }
            return jSONObject;
        }

        private static final void a(JSONObject jSONObject, String str) throws JSONException {
            jSONObject.put(str, new JSONObject().put("success", true));
        }

        private static final <T> void a(JSONObject jSONObject, String str, Object obj) throws JSONException {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("success", v8.t.h(obj));
            Throwable thE = v8.t.e(obj);
            if (thE != null) {
                String message = thE.getMessage();
                if (message == null) {
                    message = "unknown reason";
                }
                jSONObject2.put("reason", message);
            }
            v8.k0 k0Var = v8.k0.f35197a;
            jSONObject.put(str, jSONObject2);
        }
    }

    public dg(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Drawable drawable, @Nullable WebView webView, @NotNull View privacyIcon) {
        kotlin.jvm.internal.t.i(privacyIcon, "privacyIcon");
        this.f11815a = str;
        this.f11816b = str2;
        this.f11817c = str3;
        this.f11818d = str4;
        this.f11819e = drawable;
        this.f11820f = webView;
        this.f11821g = privacyIcon;
    }

    public static /* synthetic */ dg a(dg dgVar, String str, String str2, String str3, String str4, Drawable drawable, WebView webView, View view, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = dgVar.f11815a;
        }
        if ((i10 & 2) != 0) {
            str2 = dgVar.f11816b;
        }
        String str5 = str2;
        if ((i10 & 4) != 0) {
            str3 = dgVar.f11817c;
        }
        String str6 = str3;
        if ((i10 & 8) != 0) {
            str4 = dgVar.f11818d;
        }
        String str7 = str4;
        if ((i10 & 16) != 0) {
            drawable = dgVar.f11819e;
        }
        Drawable drawable2 = drawable;
        if ((i10 & 32) != 0) {
            webView = dgVar.f11820f;
        }
        WebView webView2 = webView;
        if ((i10 & 64) != 0) {
            view = dgVar.f11821g;
        }
        return dgVar.a(str, str5, str6, str7, drawable2, webView2, view);
    }

    @Nullable
    public final String b() {
        return this.f11816b;
    }

    @Nullable
    public final String c() {
        return this.f11817c;
    }

    @Nullable
    public final String d() {
        return this.f11818d;
    }

    @Nullable
    public final Drawable e() {
        return this.f11819e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dg)) {
            return false;
        }
        dg dgVar = (dg) obj;
        return kotlin.jvm.internal.t.d(this.f11815a, dgVar.f11815a) && kotlin.jvm.internal.t.d(this.f11816b, dgVar.f11816b) && kotlin.jvm.internal.t.d(this.f11817c, dgVar.f11817c) && kotlin.jvm.internal.t.d(this.f11818d, dgVar.f11818d) && kotlin.jvm.internal.t.d(this.f11819e, dgVar.f11819e) && kotlin.jvm.internal.t.d(this.f11820f, dgVar.f11820f) && kotlin.jvm.internal.t.d(this.f11821g, dgVar.f11821g);
    }

    @Nullable
    public final WebView f() {
        return this.f11820f;
    }

    @NotNull
    public final View g() {
        return this.f11821g;
    }

    @Nullable
    public final String h() {
        return this.f11816b;
    }

    public int hashCode() {
        String str = this.f11815a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f11816b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f11817c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f11818d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Drawable drawable = this.f11819e;
        int iHashCode5 = (iHashCode4 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        WebView webView = this.f11820f;
        return ((iHashCode5 + (webView != null ? webView.hashCode() : 0)) * 31) + this.f11821g.hashCode();
    }

    @Nullable
    public final String i() {
        return this.f11817c;
    }

    @Nullable
    public final String j() {
        return this.f11818d;
    }

    @Nullable
    public final Drawable k() {
        return this.f11819e;
    }

    @Nullable
    public final WebView l() {
        return this.f11820f;
    }

    @NotNull
    public final View m() {
        return this.f11821g;
    }

    @Nullable
    public final String n() {
        return this.f11815a;
    }

    @NotNull
    public String toString() {
        return "ISNNativeAdData(title=" + this.f11815a + ", advertiser=" + this.f11816b + ", body=" + this.f11817c + ", cta=" + this.f11818d + ", icon=" + this.f11819e + ", mediaView=" + this.f11820f + ", privacyIcon=" + this.f11821g + ')';
    }

    @NotNull
    public final dg a(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Drawable drawable, @Nullable WebView webView, @NotNull View privacyIcon) {
        kotlin.jvm.internal.t.i(privacyIcon, "privacyIcon");
        return new dg(str, str2, str3, str4, drawable, webView, privacyIcon);
    }

    @Nullable
    public final String a() {
        return this.f11815a;
    }
}
