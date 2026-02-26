package com.applovin.impl;

import android.os.Bundle;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f4682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final JSONObject f4683b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JSONObject f4685d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f4687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final v4 f4688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final v4 f4689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f4690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f4691j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f4684c = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final Object f4686e = new Object();

    public a3(Map map, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (jSONObject2 == null) {
            throw new IllegalArgumentException("No full response specified");
        }
        if (jSONObject == null) {
            throw new IllegalArgumentException("No ad object specified");
        }
        this.f4682a = jVar;
        if (((Boolean) jVar.a(l4.Q5)).booleanValue()) {
            this.f4688g = new v4(jSONObject2);
            this.f4689h = new v4(jSONObject);
            this.f4683b = null;
            this.f4685d = null;
        } else {
            this.f4683b = jSONObject2;
            this.f4685d = jSONObject;
            this.f4688g = null;
            this.f4689h = null;
        }
        this.f4687f = map;
    }

    private int j() {
        return a("mute_state", b("mute_state", ((Integer) this.f4682a.a(g3.f5235k7)).intValue()));
    }

    protected JSONObject a() {
        JSONObject jSONObject;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a();
        }
        synchronized (this.f4686e) {
            jSONObject = this.f4685d;
        }
        return jSONObject;
    }

    protected Boolean b(String str, Boolean bool) {
        Boolean bool2;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str, bool);
        }
        synchronized (this.f4684c) {
            bool2 = JsonUtils.getBoolean(this.f4683b, str, bool);
        }
        return bool2;
    }

    protected boolean c(String str) {
        boolean zHas;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str);
        }
        synchronized (this.f4686e) {
            zHas = this.f4685d.has(str);
        }
        return zHas;
    }

    protected boolean d(String str) {
        boolean zHas;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str);
        }
        synchronized (this.f4684c) {
            zHas = this.f4683b.has(str);
        }
        return zHas;
    }

    protected Object e(String str) {
        Object objOpt;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.b(str);
        }
        synchronized (this.f4686e) {
            objOpt = this.f4685d.opt(str);
        }
        return objOpt;
    }

    public Bundle f() {
        return BundleUtils.getBundle("custom_parameters", new Bundle(), l());
    }

    public JSONObject g() {
        JSONObject jSONObject;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a();
        }
        synchronized (this.f4684c) {
            jSONObject = this.f4683b;
        }
        return jSONObject;
    }

    public String getAdUnitId() {
        return b("ad_unit_id", "");
    }

    public String getPlacement() {
        return this.f4690i;
    }

    public Map i() {
        return this.f4687f;
    }

    public String k() {
        return c().split("_")[0];
    }

    public Bundle l() {
        Bundle bundle;
        if (e("server_parameters") instanceof JSONObject) {
            v4 v4Var = this.f4689h;
            bundle = v4Var != null ? (Bundle) v4Var.a(new Function() { // from class: com.applovin.impl.g8
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return a3.a((v4) obj);
                }
            }) : JsonUtils.toBundle(a("server_parameters", (JSONObject) null));
        } else {
            bundle = new Bundle();
        }
        int iJ = j();
        if (iJ != -1) {
            if (iJ == 2) {
                bundle.putBoolean("is_muted", this.f4682a.g0().isMuted());
            } else {
                bundle.putBoolean("is_muted", iJ == 0);
            }
        }
        if (!bundle.containsKey(AppLovinEventParameters.REVENUE_AMOUNT)) {
            bundle.putLong(AppLovinEventParameters.REVENUE_AMOUNT, b(AppLovinEventParameters.REVENUE_AMOUNT, 0L));
        }
        if (!bundle.containsKey("currency")) {
            bundle.putString("currency", b("currency", ""));
        }
        return bundle;
    }

    public long m() {
        return a("adapter_timeout_ms", ((Long) this.f4682a.a(g3.F6)).longValue());
    }

    public Boolean n() {
        String str = this.f4682a.g0().getExtraParameters().get("huc");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("huc") ? a("huc", Boolean.FALSE) : b("huc", (Boolean) null);
    }

    public Boolean o() {
        String str = this.f4682a.g0().getExtraParameters().get("dns");
        return StringUtils.isValidString(str) ? Boolean.valueOf(str) : c("dns") ? a("dns", Boolean.FALSE) : b("dns", (Boolean) null);
    }

    public boolean p() {
        return a("is_testing", Boolean.FALSE).booleanValue();
    }

    public boolean q() {
        return a("reinitialize_if_init_fails", Boolean.FALSE).booleanValue();
    }

    public boolean r() {
        return a("run_on_ui_thread", Boolean.TRUE).booleanValue();
    }

    public boolean s() {
        return a("eagerly_initialize", Boolean.TRUE).booleanValue();
    }

    public String toString() {
        return "MediationAdapterSpec{adapterClass='" + b() + "', adapterName='" + c() + "', isTesting=" + p() + '}';
    }

    public void f(String str) {
        this.f4691j = str;
    }

    public long h() {
        return a("init_completion_delay_ms", -1L);
    }

    protected Boolean a(String str, Boolean bool) {
        Boolean bool2;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, bool);
        }
        synchronized (this.f4686e) {
            bool2 = JsonUtils.getBoolean(this.f4685d, str, bool);
        }
        return bool2;
    }

    protected int b(String str, int i10) {
        int i11;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str, i10);
        }
        synchronized (this.f4684c) {
            i11 = JsonUtils.getInt(this.f4683b, str, i10);
        }
        return i11;
    }

    protected void c(String str, int i10) {
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            v4Var.b(str, i10);
            return;
        }
        synchronized (this.f4686e) {
            JsonUtils.putInt(this.f4685d, str, i10);
        }
    }

    public String d() {
        if (c("consent_string")) {
            return a("consent_string", (String) null);
        }
        if (d("consent_string")) {
            return b("consent_string", (String) null);
        }
        return this.f4682a.k0().k();
    }

    public String e() {
        return this.f4691j;
    }

    public void g(String str) {
        this.f4690i = str;
    }

    protected float a(String str, float f10) {
        float f11;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, f10);
        }
        synchronized (this.f4686e) {
            f11 = JsonUtils.getFloat(this.f4685d, str, f10);
        }
        return f11;
    }

    protected JSONArray b(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str, jSONArray);
        }
        synchronized (this.f4684c) {
            jSONArray2 = JsonUtils.getJSONArray(this.f4683b, str, jSONArray);
        }
        return jSONArray2;
    }

    protected void c(String str, long j10) {
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            v4Var.b(str, j10);
            return;
        }
        synchronized (this.f4686e) {
            JsonUtils.putLong(this.f4685d, str, j10);
        }
    }

    protected int a(String str, int i10) {
        int i11;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, i10);
        }
        synchronized (this.f4686e) {
            i11 = JsonUtils.getInt(this.f4685d, str, i10);
        }
        return i11;
    }

    protected long b(String str, long j10) {
        long j11;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str, j10);
        }
        synchronized (this.f4684c) {
            j11 = JsonUtils.getLong(this.f4683b, str, j10);
        }
        return j11;
    }

    protected void c(String str, String str2) {
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            v4Var.b(str, str2);
            return;
        }
        synchronized (this.f4686e) {
            JsonUtils.putString(this.f4685d, str, str2);
        }
    }

    protected JSONArray a(String str, JSONArray jSONArray) {
        JSONArray jSONArray2;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, jSONArray);
        }
        synchronized (this.f4686e) {
            jSONArray2 = JsonUtils.getJSONArray(this.f4685d, str, jSONArray);
        }
        return jSONArray2;
    }

    protected String b(String str, String str2) {
        String string;
        v4 v4Var = this.f4688g;
        if (v4Var != null) {
            return v4Var.a(str, str2);
        }
        synchronized (this.f4684c) {
            string = JsonUtils.getString(this.f4683b, str, str2);
        }
        return string;
    }

    public String c() {
        return a("name", (String) null);
    }

    protected JSONObject a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, jSONObject);
        }
        synchronized (this.f4686e) {
            jSONObject2 = JsonUtils.getJSONObject(this.f4685d, str, jSONObject);
        }
        return jSONObject2;
    }

    public String b() {
        return a("class", (String) null);
    }

    public List b(String str) {
        List listOptList;
        List listOptList2;
        if (str != null) {
            v4 v4Var = this.f4688g;
            if (v4Var != null) {
                listOptList = v4Var.b(str, Collections.emptyList());
            } else {
                listOptList = JsonUtils.optList(b(str, new JSONArray()), Collections.emptyList());
            }
            v4 v4Var2 = this.f4689h;
            if (v4Var2 != null) {
                listOptList2 = v4Var2.b(str, Collections.emptyList());
            } else {
                listOptList2 = JsonUtils.optList(a(str, new JSONArray()), Collections.emptyList());
            }
            ArrayList arrayList = new ArrayList(listOptList.size() + listOptList2.size());
            arrayList.addAll(listOptList);
            arrayList.addAll(listOptList2);
            return arrayList;
        }
        throw new IllegalArgumentException("No key specified");
    }

    protected long a(String str, long j10) {
        long j11;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, j10);
        }
        synchronized (this.f4686e) {
            j11 = JsonUtils.getLong(this.f4685d, str, j10);
        }
        return j11;
    }

    protected String a(String str, String str2) {
        String string;
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            return v4Var.a(str, str2);
        }
        synchronized (this.f4686e) {
            string = JsonUtils.getString(this.f4685d, str, str2);
        }
        return string;
    }

    protected void a(String str, Object obj) {
        v4 v4Var = this.f4689h;
        if (v4Var != null) {
            v4Var.a(str, obj);
            return;
        }
        synchronized (this.f4686e) {
            JsonUtils.putObject(this.f4685d, str, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Bundle a(v4 v4Var) {
        return JsonUtils.toBundle(v4Var.a("server_parameters", (JSONObject) null));
    }

    public String a(String str) {
        String strA = a(str, "");
        return StringUtils.isValidString(strA) ? strA : b(str, "");
    }
}
