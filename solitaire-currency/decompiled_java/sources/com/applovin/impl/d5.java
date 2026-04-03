package com.applovin.impl;

import android.content.Context;
import com.applovin.impl.q4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d5 extends w4 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static JSONObject f5014l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final Object f5015m = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final Map f5016n = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MaxAdFormat f5018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f5019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f5020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final b f5021k;

    public interface b {
        void a(JSONArray jSONArray);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements q4.a, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f5022a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f5023b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5024c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AtomicBoolean f5025d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Collection f5026e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f5027f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final com.applovin.impl.sdk.n f5028g;

        @Override // java.lang.Runnable
        public void run() {
            if (this.f5025d.compareAndSet(false, true)) {
                a();
            }
        }

        private c(int i10, b bVar, com.applovin.impl.sdk.j jVar) {
            this.f5024c = i10;
            this.f5022a = bVar;
            this.f5027f = jVar;
            this.f5028g = jVar.I();
            this.f5023b = new Object();
            this.f5026e = new ArrayList(i10);
            this.f5025d = new AtomicBoolean();
        }

        @Override // com.applovin.impl.q4.a
        public void a(q4 q4Var) {
            boolean z10;
            synchronized (this.f5023b) {
                this.f5026e.add(q4Var);
                int i10 = this.f5024c - 1;
                this.f5024c = i10;
                z10 = i10 < 1;
            }
            if (z10 && this.f5025d.compareAndSet(false, true)) {
                if (z6.h() && ((Boolean) this.f5027f.a(l4.N)).booleanValue()) {
                    this.f5027f.j0().a((w4) new f6(this.f5027f, "handleSignalCollectionCompleted", new Runnable() { // from class: com.applovin.impl.e9
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f5153a.a();
                        }
                    }), r5.b.MEDIATION);
                } else {
                    a();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            ArrayList<q4> arrayList;
            synchronized (this.f5023b) {
                arrayList = new ArrayList(this.f5026e);
            }
            JSONArray jSONArray = new JSONArray();
            for (q4 q4Var : arrayList) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    r4 r4VarF = q4Var.f();
                    jSONObject.put("name", r4VarF.c());
                    jSONObject.put("class", r4VarF.b());
                    jSONObject.put("adapter_version", q4Var.a());
                    jSONObject.put("sdk_version", q4Var.d());
                    JSONObject jSONObject2 = new JSONObject();
                    MaxError maxErrorC = q4Var.c();
                    if (maxErrorC != null) {
                        jSONObject2.put("error_message", maxErrorC.getMessage());
                    } else {
                        jSONObject2.put("signal", q4Var.e());
                    }
                    jSONObject2.put("signal_collection_time_ms", q4Var.b());
                    jSONObject2.put("is_cached", q4Var.g());
                    jSONObject.put("data", jSONObject2);
                    jSONArray.put(jSONObject);
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f5028g.a("TaskCollectSignals", "Collected signal from " + r4VarF);
                    }
                } catch (JSONException e10) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f5028g.a("TaskCollectSignals", "Failed to create signal data", e10);
                    }
                    this.f5027f.A().a("TaskCollectSignals", "createSignalsData", e10);
                }
            }
            a(jSONArray);
        }

        private void a(JSONArray jSONArray) {
            b bVar = this.f5022a;
            if (bVar != null) {
                bVar.a(jSONArray);
            }
        }
    }

    public d5(String str, MaxAdFormat maxAdFormat, Map map, Context context, com.applovin.impl.sdk.j jVar, b bVar) {
        super("TaskCollectSignals", jVar);
        this.f5017g = str;
        this.f5018h = maxAdFormat;
        this.f5019i = map;
        this.f5020j = context;
        this.f5021k = bVar;
    }

    private void a(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        c cVar = new c(jSONArray.length(), this.f5021k, this.f7677a);
        this.f7677a.j0().a(new f6(this.f7677a, "timeoutCollectSignal", cVar), r5.b.TIMEOUT, ((Long) this.f7677a.a(g3.E6)).longValue());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            a(new r4(this.f5019i, jSONArray.getJSONObject(i10), jSONObject, this.f7677a), cVar);
        }
    }

    private void b(JSONArray jSONArray, JSONObject jSONObject) throws JSONException {
        Set set = (Set) f5016n.get(this.f5017g);
        if (set == null || set.isEmpty()) {
            a("No signal providers found for ad unit: " + this.f5017g, (Throwable) null);
            return;
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
            if (set.contains(JsonUtils.getString(jSONObject2, "name", null))) {
                jSONArray2.put(jSONObject2);
            }
        }
        a(jSONArray2, jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        JSONArray jSONArray;
        try {
            synchronized (f5015m) {
                jSONArray = JsonUtils.getJSONArray(f5014l, "signal_providers", null);
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                if (f5016n.size() > 0) {
                    b(jSONArray, f5014l);
                    return;
                } else {
                    a(jSONArray, f5014l);
                    return;
                }
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.k(this.f7678b, "Unable to find cached signal providers, fetching signal providers from SharedPreferences.");
            }
            JSONObject jSONObject = new JSONObject((String) this.f7677a.a(n4.B, JsonUtils.EMPTY_JSON));
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            if (jSONArray2 != null && jSONArray2.length() != 0) {
                if (f5016n.size() > 0) {
                    b(jSONArray2, jSONObject);
                    return;
                } else {
                    a(jSONArray2, jSONObject);
                    return;
                }
            }
            a("No signal providers found", (Throwable) null);
        } catch (InterruptedException e10) {
            a("Failed to wait for signals", e10);
            this.f7677a.A().a("TaskCollectSignals", "waitForSignals", e10);
        } catch (JSONException e11) {
            a("Failed to parse signals JSON", e11);
            this.f7677a.A().a("TaskCollectSignals", "parseSignalsJSON", e11);
        } catch (Throwable th) {
            a("Failed to collect signals", th);
            this.f7677a.A().a("TaskCollectSignals", "collectSignals", th);
        }
    }

    private void a(final r4 r4Var, final q4.a aVar) {
        if (r4Var.r()) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.d9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5041a.b(r4Var, aVar);
                }
            });
        } else {
            this.f7677a.Q().collectSignal(this.f5017g, this.f5018h, r4Var, this.f5020j, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(r4 r4Var, q4.a aVar) {
        this.f7677a.Q().collectSignal(this.f5017g, this.f5018h, r4Var, this.f5020j, aVar);
    }

    private void a(String str, Throwable th) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f7679c.a(this.f7678b, "No signals collected: " + str, th);
        }
        b bVar = this.f5021k;
        if (bVar != null) {
            bVar.a(new JSONArray());
        }
    }

    public static void a(JSONObject jSONObject) {
        synchronized (f5015m) {
            f5014l = jSONObject;
        }
    }

    public static void a(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        try {
            JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
            if (jSONObject2 != null) {
                for (String str : JsonUtils.toList(jSONObject2.names())) {
                    f5016n.put(str, new HashSet(JsonUtils.getList(jSONObject2, str, null)));
                }
            }
        } catch (JSONException e10) {
            com.applovin.impl.sdk.n.c("TaskCollectSignals", "Failed to parse ad unit signal providers for JSON object: " + jSONObject, e10);
            jVar.A().a("TaskCollectSignals", "parseAdUnitSignalProvidersJSON", e10);
        }
    }
}
