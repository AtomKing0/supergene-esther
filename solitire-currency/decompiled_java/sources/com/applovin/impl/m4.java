package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f5872a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f5873b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final SharedPreferences f5874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f5875d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f5876e = new Object();

    public m4(com.applovin.impl.sdk.j jVar) {
        this.f5872a = jVar;
        Context contextN = com.applovin.impl.sdk.j.n();
        this.f5873b = contextN;
        this.f5874c = contextN.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(l4.class.getName());
            Class.forName(g3.class.getName());
        } catch (Throwable unused) {
        }
        d();
    }

    public Object a(l4 l4Var) {
        if (l4Var == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.f5876e) {
            Object obj = this.f5875d.get(l4Var.b());
            if (obj == null) {
                return l4Var.a();
            }
            return l4Var.a(obj);
        }
    }

    public List b(l4 l4Var) {
        ArrayList arrayList = new ArrayList(6);
        Iterator it = c(l4Var).iterator();
        while (it.hasNext()) {
            arrayList.add(MaxAdFormat.formatFromString((String) it.next()));
        }
        return arrayList;
    }

    public List c(l4 l4Var) {
        return CollectionUtils.explode((String) a(l4Var));
    }

    public void d() {
        String strB = b();
        synchronized (this.f5876e) {
            for (l4 l4Var : l4.c()) {
                try {
                    Object objA = this.f5872a.a(strB + l4Var.b(), null, l4Var.a().getClass(), this.f5874c);
                    if (objA != null) {
                        this.f5875d.put(l4Var.b(), objA);
                    }
                } catch (Throwable th) {
                    com.applovin.impl.sdk.n.c("SettingsManager", "Unable to load \"" + l4Var.b() + "\"", th);
                    this.f5872a.A().a("SettingsManager", "initSettings", th);
                }
            }
        }
    }

    public void e() {
        String strB = b();
        synchronized (this.f5876e) {
            SharedPreferences.Editor editorEdit = this.f5874c.edit();
            for (l4 l4Var : l4.c()) {
                Object obj = this.f5875d.get(l4Var.b());
                if (obj != null) {
                    this.f5872a.a(strB + l4Var.b(), obj, editorEdit);
                }
            }
            if (((Boolean) this.f5872a.a(l4.T5)).booleanValue()) {
                o4.a(editorEdit);
            } else {
                editorEdit.apply();
            }
        }
    }

    public boolean c() {
        return this.f5872a.g0().isVerboseLoggingEnabled() || ((Boolean) a(l4.f5670k)).booleanValue();
    }

    private String b() {
        return "com.applovin.sdk." + z6.f(this.f5872a.b0()) + ".";
    }

    public void a(l4 l4Var, Object obj) {
        if (l4Var == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj != null) {
            synchronized (this.f5876e) {
                this.f5875d.put(l4Var.b(), obj);
            }
            return;
        }
        throw new IllegalArgumentException("No new value specified");
    }

    public void a(JSONObject jSONObject) {
        synchronized (this.f5876e) {
            boolean zBooleanValue = JsonUtils.getBoolean(jSONObject, l4.f5757v.b(), Boolean.FALSE).booleanValue();
            HashMap map = zBooleanValue ? new HashMap() : null;
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (next != null && next.length() > 0) {
                    try {
                        try {
                            l4 l4VarA = a(next, (l4) null);
                            if (l4VarA != null) {
                                Object objA = zBooleanValue ? a(l4VarA) : null;
                                Object objA2 = a(next, jSONObject, l4VarA.a());
                                this.f5875d.put(l4VarA.b(), objA2);
                                if (l4VarA == l4.f5597a5) {
                                    this.f5875d.put(l4.f5604b5.b(), Long.valueOf(System.currentTimeMillis()));
                                }
                                if (zBooleanValue && !objA2.equals(objA)) {
                                    map.put(l4VarA, objA);
                                }
                            }
                        } catch (Throwable th) {
                            com.applovin.impl.sdk.n.c("SettingsManager", "Unable to convert setting object ", th);
                            this.f5872a.A().a("SettingsManager", "loadSettingsThrowable", th);
                        }
                    } catch (JSONException e10) {
                        com.applovin.impl.sdk.n.c("SettingsManager", "Unable to parse JSON settingsValues array", e10);
                        this.f5872a.A().a("SettingsManager", "loadSettingsException", e10);
                    }
                }
            }
            if (zBooleanValue && map.size() > 0) {
                n2 n2Var = new n2();
                n2Var.a("========== UPDATED SETTINGS ==========");
                for (l4 l4Var : map.keySet()) {
                    n2Var.a(l4Var.b(), a(l4Var) + " (" + map.get(l4Var) + ")");
                }
                n2Var.a("========== END ==========");
                this.f5872a.I();
                if (com.applovin.impl.sdk.n.a()) {
                    this.f5872a.I().a("SettingsManager", n2Var.toString());
                }
            }
        }
    }

    public void a() {
        synchronized (this.f5876e) {
            this.f5875d.clear();
        }
        this.f5872a.a(this.f5874c);
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Double) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }

    public l4 a(String str, l4 l4Var) {
        synchronized (this.f5876e) {
            for (l4 l4Var2 : l4.c()) {
                if (l4Var2.b().equals(str)) {
                    return l4Var2;
                }
            }
            return l4Var;
        }
    }
}
