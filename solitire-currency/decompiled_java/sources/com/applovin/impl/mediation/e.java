package com.applovin.impl.mediation;

import android.app.Activity;
import com.applovin.impl.a2;
import com.applovin.impl.a3;
import com.applovin.impl.e1;
import com.applovin.impl.g3;
import com.applovin.impl.g4;
import com.applovin.impl.n4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w5;
import com.applovin.impl.y1;
import com.applovin.impl.y4;
import com.applovin.mediation.adapter.MaxAdapter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f6182c = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f6183d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6184e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JSONArray f6185f = new JSONArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LinkedHashMap f6186g = new LinkedHashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Object f6187h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map f6188i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f6189j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Object f6190k = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f6191l;

    public e(com.applovin.impl.sdk.j jVar) {
        this.f6180a = jVar;
        this.f6181b = jVar.I();
    }

    public void a(Activity activity) {
        if (this.f6182c.compareAndSet(false, true)) {
            String str = (String) this.f6180a.a(n4.C);
            if (StringUtils.isValidString(str)) {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    List<a3> listA = a(JsonUtils.getJSONArray(jSONObject, this.f6180a.l0().c() ? "test_mode_auto_init_adapters" : "auto_init_adapters", new JSONArray()), jSONObject);
                    this.f6191l = listA;
                    for (a3 a3Var : listA) {
                        this.f6188i.put(a3Var.b(), a3Var);
                    }
                    long j10 = StringUtils.parseLong(this.f6180a.g0().getExtraParameters().get("adapter_initialization_delay_ms"), -1L);
                    y4 y4Var = new y4(listA, activity, this.f6180a);
                    if (j10 > 0) {
                        this.f6180a.j0().a(y4Var, r5.b.MEDIATION, j10);
                    } else {
                        this.f6180a.j0().a(y4Var);
                    }
                } catch (JSONException e10) {
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6181b.a("MediationAdapterInitializationManager", "Failed to parse auto-init adapters JSON", e10);
                    }
                    e1.a((Throwable) e10);
                }
            }
        }
    }

    public boolean c() {
        return this.f6182c.get();
    }

    private void c(a3 a3Var) {
        String strB = a3Var.b();
        synchronized (this.f6184e) {
            if (this.f6183d.contains(strB)) {
                return;
            }
            this.f6183d.add(strB);
            this.f6180a.J().d(y1.G, a2.a(a3Var));
        }
    }

    public JSONArray b() {
        JSONArray jSONArrayShallowCopy;
        synchronized (this.f6187h) {
            jSONArrayShallowCopy = JsonUtils.shallowCopy(this.f6185f);
        }
        return jSONArrayShallowCopy;
    }

    boolean b(a3 a3Var) {
        boolean zContainsKey;
        synchronized (this.f6187h) {
            zContainsKey = this.f6186g.containsKey(a3Var.b());
        }
        return zContainsKey;
    }

    public g4 a(a3 a3Var, Activity activity) {
        a3 a3VarA = a(a3Var);
        if (a3VarA == null) {
            return g4.a("AdapterInitialization:" + a3Var.c(), MaxAdapter.InitializationStatus.DOES_NOT_APPLY);
        }
        String strB = a3Var.b();
        synchronized (this.f6190k) {
            g4 g4Var = (g4) this.f6189j.get(strB);
            if (g4Var != null && (!g4Var.d() || !a3VarA.q())) {
                return g4Var;
            }
            final g4 g4Var2 = new g4("AdapterInitialization:" + a3Var.c());
            this.f6189j.put(strB, g4Var2);
            g gVarA = this.f6180a.M().a(a3VarA);
            if (gVarA == null) {
                g4Var2.a("Adapter implementation not found");
                return g4Var2;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f6181b.d("MediationAdapterInitializationManager", "Initializing adapter " + a3VarA);
            }
            c(a3VarA);
            gVarA.a(MaxAdapterParametersImpl.a(a3VarA), activity, new MaxAdapter.OnCompletionListener() { // from class: com.applovin.impl.mediation.t
                @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
                public final void onCompletion(MaxAdapter.InitializationStatus initializationStatus, String str) {
                    e.a(g4Var2, initializationStatus, str);
                }
            });
            w5.a(a3VarA.m(), g4Var2, "The adapter (" + a3Var.c() + ") timed out initializing", "MediationAdapterInitializationManager", this.f6180a);
            return g4Var2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(g4 g4Var, MaxAdapter.InitializationStatus initializationStatus, String str) {
        if (initializationStatus != null && initializationStatus != MaxAdapter.InitializationStatus.INITIALIZING) {
            if (initializationStatus == MaxAdapter.InitializationStatus.INITIALIZED_FAILURE) {
                g4Var.a(str);
                return;
            } else {
                g4Var.b(initializationStatus);
                return;
            }
        }
        e1.a("Adapters should never report a null or INITIALIZING status.", new Object[0]);
        g4Var.a("Adapter reported INITIALIZING");
    }

    private a3 a(a3 a3Var) {
        List<a3> list;
        if (((Boolean) this.f6180a.a(g3.f5252x7)).booleanValue()) {
            a3 a3Var2 = (a3) this.f6188i.get(a3Var.b());
            return a3Var2 != null ? a3Var2 : a3Var;
        }
        if (!this.f6180a.l0().c() || (list = this.f6191l) == null) {
            return a3Var;
        }
        for (a3 a3Var3 : list) {
            if (a3Var3.b().equals(a3Var.b())) {
                return a3Var3;
            }
        }
        return null;
    }

    public Integer a(String str) {
        Integer num;
        synchronized (this.f6187h) {
            num = (Integer) this.f6186g.get(str);
        }
        return num;
    }

    public Set a() {
        HashSet hashSet;
        synchronized (this.f6187h) {
            hashSet = new HashSet(this.f6186g.keySet());
        }
        return hashSet;
    }

    void a(a3 a3Var, long j10, MaxAdapter.InitializationStatus initializationStatus, String str) {
        boolean z10;
        if (initializationStatus == null || initializationStatus == MaxAdapter.InitializationStatus.INITIALIZING) {
            return;
        }
        synchronized (this.f6187h) {
            z10 = !b(a3Var);
            if (z10) {
                this.f6186g.put(a3Var.b(), Integer.valueOf(initializationStatus.getCode()));
                JSONObject jSONObject = new JSONObject();
                JsonUtils.putString(jSONObject, "class", a3Var.b());
                JsonUtils.putString(jSONObject, "init_status", String.valueOf(initializationStatus.getCode()));
                JsonUtils.putLong(jSONObject, "init_time_ms", j10);
                JsonUtils.putString(jSONObject, "error_message", JSONObject.quote(str));
                this.f6185f.put(jSONObject);
            }
        }
        if (z10) {
            this.f6180a.a(a3Var);
            this.f6180a.Q().processAdapterInitializationPostback(a3Var, j10, initializationStatus, str);
            this.f6180a.r().a(initializationStatus, a3Var.b());
        }
    }

    private List a(JSONArray jSONArray, JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            arrayList.add(new a3(Collections.EMPTY_MAP, JsonUtils.getJSONObject(jSONArray, i10, (JSONObject) null), jSONObject, this.f6180a));
        }
        return arrayList;
    }

    public void a(MaxAdapter.InitializationStatus initializationStatus) {
        synchronized (this.f6187h) {
            this.f6186g.put("com.applovin.mediation.adapters.AppLovinMediationAdapter", Integer.valueOf(initializationStatus.getCode()));
        }
        this.f6180a.r().a(initializationStatus, "com.applovin.mediation.adapters.AppLovinMediationAdapter");
    }
}
