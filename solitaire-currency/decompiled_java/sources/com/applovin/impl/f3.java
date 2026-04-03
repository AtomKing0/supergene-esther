package com.applovin.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import com.applovin.impl.m0;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.v2;
import com.applovin.mediation.MaxDebuggerActivity;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f3 implements m0.e {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static WeakReference f5170l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final AtomicBoolean f5171m = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f5173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f5174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final e3 f5175d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f5178g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f5180i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Map f5181j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final a0 f5182k;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f5176e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f5177f = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f5179h = 2;

    class a extends b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Started mediation debugger");
                if (!f3.this.c() || f3.f5170l.get() != activity) {
                    MaxDebuggerActivity maxDebuggerActivity = (MaxDebuggerActivity) activity;
                    WeakReference unused = f3.f5170l = new WeakReference(maxDebuggerActivity);
                    maxDebuggerActivity.setListAdapter(f3.this.f5175d, f3.this.f5172a.e());
                }
                f3.f5171m.set(false);
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxDebuggerActivity) {
                com.applovin.impl.sdk.n.g("AppLovinSdk", "Mediation debugger destroyed");
                WeakReference unused = f3.f5170l = null;
            }
        }
    }

    public f3(com.applovin.impl.sdk.j jVar) {
        this.f5172a = jVar;
        this.f5173b = jVar.I();
        Context contextN = com.applovin.impl.sdk.j.n();
        this.f5174c = contextN;
        e3 e3Var = new e3(contextN);
        this.f5175d = e3Var;
        this.f5182k = new a0(jVar, e3Var);
    }

    private void f() {
        this.f5172a.e().a(new a());
    }

    public void e() {
        if (this.f5177f.compareAndSet(false, true)) {
            this.f5172a.j0().a((w4) new k5(this, this.f5172a), r5.b.OTHER);
        }
    }

    public boolean g() {
        return this.f5178g;
    }

    public void h() {
        a((Map) null);
    }

    public String toString() {
        return "MediationDebuggerService{, listAdapter=" + this.f5175d + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        WeakReference weakReference = f5170l;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        Activity activityN0 = this.f5172a.n0();
        if (activityN0 == null || activityN0.isFinishing()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "MAX Mediation Debugger has flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this log will only be shown in your development builds. Live apps will not be affected.");
        } else {
            new AlertDialog.Builder(activityN0).setTitle("Review Integration Errors").setMessage("Looks like MAX Mediation Debugger flagged several errors in your build. Make sure to resolve these before you go live.\n\nNote that this prompt will only be shown in your development builds. Live apps will not be affected.").setPositiveButton("Show Mediation Debugger", new DialogInterface.OnClickListener() { // from class: com.applovin.impl.k9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    this.f5555a.a(dialogInterface, i10);
                }
            }).setNegativeButton("DISMISS", (DialogInterface.OnClickListener) null).create().show();
        }
    }

    public void a(boolean z10, int i10) {
        this.f5178g = z10;
        this.f5179h = i10;
    }

    public void a(Map map) {
        this.f5181j = map;
        e();
        if (!c() && f5171m.compareAndSet(false, true)) {
            if (!this.f5180i) {
                f();
                this.f5180i = true;
            }
            Intent intent = new Intent(this.f5174c, (Class<?>) MaxDebuggerActivity.class);
            intent.setFlags(268435456);
            com.applovin.impl.sdk.n.g("AppLovinSdk", "Starting mediation debugger...");
            this.f5174c.startActivity(intent);
            return;
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Mediation debugger is already showing");
    }

    public List a(String str) {
        Map map = this.f5181j;
        if (map == null || map.isEmpty()) {
            return null;
        }
        return (List) this.f5181j.get(str);
    }

    private void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            v2 v2Var = (v2) it.next();
            if (v2Var.A() && v2Var.q() == v2.a.INVALID_INTEGRATION) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.i9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f5399a.d();
                    }
                }, TimeUnit.SECONDS.toMillis(2L));
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(DialogInterface dialogInterface, int i10) {
        h();
    }

    private List a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "networks", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null) {
                v2 v2Var = new v2(jSONObject2, jVar);
                arrayList.add(v2Var);
                this.f5176e.put(v2Var.b(), v2Var);
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(JSONObject jSONObject, List list, com.applovin.impl.sdk.j jVar) {
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "ad_units", new JSONArray());
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null);
            if (jSONObject2 != null) {
                arrayList.add(new l(jSONObject2, this.f5176e, jVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private List a(List list, com.applovin.impl.sdk.j jVar) {
        List<String> adUnitIds = jVar.G() != null ? jVar.G().getAdUnitIds() : null;
        if (adUnitIds != null && !adUnitIds.isEmpty()) {
            ArrayList arrayList = new ArrayList(adUnitIds.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l lVar = (l) it.next();
                if (adUnitIds.contains(lVar.c())) {
                    arrayList.add(lVar);
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    private List a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        for (String str : JsonUtils.getList(jSONObject, "required_app_ads_txt_entries", new ArrayList())) {
            z zVar = new z(str);
            if (zVar.h()) {
                arrayList.add(zVar);
            } else if (com.applovin.impl.sdk.n.a()) {
                this.f5173b.b("MediationDebuggerService", "app-ads.txt entry passed down for validation is misformatted: " + str);
            }
        }
        return arrayList;
    }

    @Override // com.applovin.impl.m0.e
    public void a(String str, JSONObject jSONObject, int i10) {
        List listA = a(jSONObject, this.f5172a);
        List listA2 = a(jSONObject, listA, this.f5172a);
        List listA3 = a(listA2, this.f5172a);
        List listA4 = a(jSONObject);
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "alert", (JSONObject) null);
        this.f5175d.a(listA, listA2, listA3, listA4, JsonUtils.getString(jSONObject2, "title", null), JsonUtils.getString(jSONObject2, "message", null), JsonUtils.getString(jSONObject, "account_id", null), JsonUtils.getBoolean(jSONObject, "complies_with_google_families_policy", null), JsonUtils.getBoolean(jSONObject, "should_display_cmp_details", Boolean.TRUE).booleanValue(), this.f5172a);
        if (!listA4.isEmpty()) {
            this.f5182k.a();
        }
        if (g()) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.j9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5496a.h();
                }
            }, TimeUnit.SECONDS.toMillis(this.f5179h));
        } else {
            a(listA);
        }
    }

    @Override // com.applovin.impl.m0.e
    public void a(String str, int i10, String str2, JSONObject jSONObject) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f5173b.b("MediationDebuggerService", "Unable to fetch mediation debugger info: server returned " + i10);
        }
        com.applovin.impl.sdk.n.h("AppLovinSdk", "Unable to show mediation debugger.");
        this.f5175d.a(null, null, null, null, null, null, null, null, false, this.f5172a);
        this.f5177f.set(false);
    }
}
