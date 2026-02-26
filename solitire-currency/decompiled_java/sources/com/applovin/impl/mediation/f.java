package com.applovin.impl.mediation;

import android.text.TextUtils;
import com.applovin.impl.a3;
import com.applovin.impl.q2;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.sdk.AppLovinSdk;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6197b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6198c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f6196a = Collections.synchronizedMap(new HashMap(16));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f6199d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f6200e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set f6201f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f6202g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f6203h = new HashSet();

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f6204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final MaxAdFormat f6206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final JSONObject f6207d;

        a(String str, String str2, q2 q2Var, com.applovin.impl.sdk.j jVar) {
            this.f6204a = str;
            this.f6205b = str2;
            JSONObject jSONObject = new JSONObject();
            this.f6207d = jSONObject;
            JsonUtils.putString(jSONObject, "class", str);
            JsonUtils.putString(jSONObject, "operation", str2);
            if (q2Var == null) {
                this.f6206c = null;
            } else {
                this.f6206c = q2Var.getFormat();
                JsonUtils.putString(jSONObject, "format", q2Var.getFormat().getLabel());
            }
        }

        JSONObject a() {
            return this.f6207d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.f6204a.equals(aVar.f6204a) || !this.f6205b.equals(aVar.f6205b)) {
                return false;
            }
            MaxAdFormat maxAdFormat = this.f6206c;
            MaxAdFormat maxAdFormat2 = aVar.f6206c;
            return maxAdFormat == null ? maxAdFormat2 == null : maxAdFormat.equals(maxAdFormat2);
        }

        public int hashCode() {
            int iHashCode = ((this.f6204a.hashCode() * 31) + this.f6205b.hashCode()) * 31;
            MaxAdFormat maxAdFormat = this.f6206c;
            return iHashCode + (maxAdFormat != null ? maxAdFormat.hashCode() : 0);
        }

        public String toString() {
            return "DisabledAdapterInfo{className='" + this.f6204a + "', operationTag='" + this.f6205b + "', format=" + this.f6206c + '}';
        }
    }

    public f(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f6197b = jVar;
        this.f6198c = jVar.I();
    }

    public Collection a() {
        ArrayList arrayList;
        synchronized (this.f6202g) {
            arrayList = new ArrayList(this.f6203h.size());
            Iterator it = this.f6203h.iterator();
            while (it.hasNext()) {
                arrayList.add(((a) it.next()).a());
            }
        }
        return arrayList;
    }

    public Collection b() {
        Set setUnmodifiableSet;
        synchronized (this.f6199d) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f6201f);
        }
        return setUnmodifiableSet;
    }

    public Collection c() {
        Set setUnmodifiableSet;
        synchronized (this.f6199d) {
            HashSet hashSet = new HashSet(this.f6200e.size());
            Iterator it = this.f6200e.values().iterator();
            while (it.hasNext()) {
                hashSet.add(((Class) it.next()).getName());
            }
            setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        }
        return setUnmodifiableSet;
    }

    g a(a3 a3Var) {
        return a(a3Var, false);
    }

    g a(a3 a3Var, boolean z10) {
        Class clsA;
        g gVar;
        if (a3Var != null) {
            String strC = a3Var.c();
            String strB = a3Var.b();
            if (TextUtils.isEmpty(strC)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6198c.b("MediationAdapterManager", "No adapter name provided for " + strB + ", not loading the adapter ");
                }
                return null;
            }
            if (TextUtils.isEmpty(strB)) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6198c.b("MediationAdapterManager", "Unable to find default className for '" + strC + "'");
                }
                return null;
            }
            if (z10 && (gVar = (g) this.f6196a.get(strB)) != null) {
                return gVar;
            }
            synchronized (this.f6199d) {
                if (!this.f6201f.contains(strB)) {
                    if (this.f6200e.containsKey(strB)) {
                        clsA = (Class) this.f6200e.get(strB);
                    } else {
                        clsA = a(strB);
                        if (clsA == null) {
                            if (com.applovin.impl.sdk.n.a()) {
                                this.f6198c.k("MediationAdapterManager", "Adapter " + strC + " could not be loaded, class " + strB + " not found");
                            }
                            this.f6201f.add(strB);
                            return null;
                        }
                    }
                    g gVarA = a(a3Var, clsA, z10);
                    if (gVarA != null) {
                        if (com.applovin.impl.sdk.n.a()) {
                            this.f6198c.a("MediationAdapterManager", "Loaded " + strC);
                        }
                        this.f6200e.put(strB, clsA);
                        if (z10) {
                            this.f6196a.put(a3Var.b(), gVarA);
                        }
                        return gVarA;
                    }
                    if (com.applovin.impl.sdk.n.a()) {
                        this.f6198c.b("MediationAdapterManager", "Failed to load " + strC);
                    }
                    this.f6201f.add(strB);
                    return null;
                }
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6198c.a("MediationAdapterManager", "Not attempting to load " + strC + " due to prior errors");
                }
                return null;
            }
        }
        throw new IllegalArgumentException("No adapter spec specified");
    }

    public void a(String str, String str2, q2 q2Var) {
        synchronized (this.f6202g) {
            this.f6197b.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6197b.I().b("MediationAdapterManager", "Adding " + str + " to list of disabled adapters.");
            }
            this.f6203h.add(new a(str, str2, q2Var, this.f6197b));
        }
    }

    private g a(a3 a3Var, Class cls, boolean z10) {
        try {
            return new g(a3Var, (MediationAdapterBase) cls.getConstructor(AppLovinSdk.class).newInstance(this.f6197b.r0()), z10, this.f6197b);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterManager", "Failed to load adapter: " + a3Var, th);
            return null;
        }
    }

    private Class a(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (MaxAdapter.class.isAssignableFrom(cls)) {
                return cls.asSubclass(MaxAdapter.class);
            }
            com.applovin.impl.sdk.n.h("MediationAdapterManager", str + " error: not an instance of '" + MaxAdapter.class.getName() + "'.");
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
