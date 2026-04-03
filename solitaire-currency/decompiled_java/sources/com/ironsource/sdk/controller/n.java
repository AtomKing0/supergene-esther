package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import com.ironsource.ha;
import com.ironsource.i9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.n9;
import com.ironsource.o9;
import com.ironsource.p9;
import com.ironsource.qf;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.ve;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class n implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ve f15049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f15050b;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f15051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f15052b;

        a(l.a aVar, f.c cVar) {
            this.f15051a = aVar;
            this.f15052b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (this.f15051a == null) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", false);
                jSONObject.put("reason", n.this.f15050b);
                this.f15051a.a(new f.a(this.f15052b.f(), jSONObject));
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p9 f15054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ha f15055b;

        b(p9 p9Var, ha haVar) {
            this.f15054a = p9Var;
            this.f15055b = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15054a.a(qf.e.RewardedVideo, this.f15055b.h(), n.this.f15050b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p9 f15057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f15058b;

        c(p9 p9Var, JSONObject jSONObject) {
            this.f15057a = p9Var;
            this.f15058b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15057a.d(this.f15058b.optString("demandSourceName"), n.this.f15050b);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o9 f15060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ha f15061b;

        d(o9 o9Var, ha haVar) {
            this.f15060a = o9Var;
            this.f15061b = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15060a.a(qf.e.Interstitial, this.f15061b.h(), n.this.f15050b);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o9 f15063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f15064b;

        e(o9 o9Var, String str) {
            this.f15063a = o9Var;
            this.f15064b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15063a.c(this.f15064b, n.this.f15050b);
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o9 f15066a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ha f15067b;

        f(o9 o9Var, ha haVar) {
            this.f15066a = o9Var;
            this.f15067b = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15066a.c(this.f15067b.h(), n.this.f15050b);
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o9 f15069a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f15070b;

        g(o9 o9Var, JSONObject jSONObject) {
            this.f15069a = o9Var;
            this.f15070b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15069a.b(this.f15070b.optString("demandSourceName"), n.this.f15050b);
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ o9 f15072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ha f15073b;

        h(o9 o9Var, ha haVar) {
            this.f15072a = o9Var;
            this.f15073b = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15072a.b(this.f15073b.h(), n.this.f15050b);
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n9 f15075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f15076b;

        i(n9 n9Var, Map map) {
            this.f15075a = n9Var;
            this.f15076b = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15075a.a((String) this.f15076b.get("demandSourceName"), n.this.f15050b);
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ n9 f15078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f15079b;

        j(n9 n9Var, JSONObject jSONObject) {
            this.f15078a = n9Var;
            this.f15079b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15078a.a(this.f15079b.optString("demandSourceName"), n.this.f15050b);
        }
    }

    n(String str, ve veVar) {
        this.f15049a = veVar;
        this.f15050b = str;
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public qf.c g() {
        return qf.c.Native;
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar, Map<String, String> map, o9 o9Var) {
        if (o9Var != null) {
            a(new f(o9Var, haVar));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, n9 n9Var) {
        if (n9Var != null) {
            a(new i(n9Var, map));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, o9 o9Var) {
        if (o9Var != null) {
            a(new h(o9Var, haVar));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, @Nullable l.a aVar) {
        a(new a(aVar, cVar));
    }

    void a(Runnable runnable) {
        ve veVar = this.f15049a;
        if (veVar != null) {
            veVar.c(runnable);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, o9 o9Var) {
        if (o9Var != null) {
            a(new e(o9Var, str));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, n9 n9Var) {
        if (n9Var != null) {
            n9Var.a(qf.e.Banner, haVar.h(), this.f15050b);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, o9 o9Var) {
        if (o9Var != null) {
            a(new d(o9Var, haVar));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, p9 p9Var) {
        if (p9Var != null) {
            a(new b(p9Var, haVar));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, n9 n9Var) {
        if (n9Var != null) {
            a(new j(n9Var, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, o9 o9Var) {
        if (o9Var != null) {
            a(new g(o9Var, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void d() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void destroy() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void e() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, p9 p9Var) {
        if (p9Var != null) {
            a(new c(p9Var, jSONObject));
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        return false;
    }
}
