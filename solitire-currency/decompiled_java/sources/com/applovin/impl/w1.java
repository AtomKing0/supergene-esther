package com.applovin.impl;

import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f7668b = new HashMap();

    public w1(com.applovin.impl.sdk.j jVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f7667a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            this.f7667a.b(n4.f6404z, c().toString());
        } catch (Throwable th) {
            this.f7667a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7667a.I().a("GlobalStatsManager", "Unable to save stats", th);
            }
        }
    }

    private void f() {
        this.f7667a.j0().a(new Runnable() { // from class: com.applovin.impl.he
            @Override // java.lang.Runnable
            public final void run() {
                this.f5355a.d();
            }
        }, r5.b.OTHER);
    }

    public long b(v1 v1Var) {
        long jLongValue;
        synchronized (this.f7668b) {
            Long l10 = (Long) this.f7668b.get(v1Var.b());
            if (l10 == null) {
                l10 = 0L;
            }
            jLongValue = l10.longValue();
        }
        return jLongValue;
    }

    public long c(v1 v1Var) {
        return a(v1Var, 1L);
    }

    public void e() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f7667a.a(n4.f6404z, JsonUtils.EMPTY_JSON));
            synchronized (this.f7668b) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    try {
                        String next = itKeys.next();
                        this.f7668b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f7667a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f7667a.I().a("GlobalStatsManager", "Unable to load stats", th);
            }
        }
    }

    long a(v1 v1Var, long j10) {
        long jLongValue;
        synchronized (this.f7668b) {
            Long l10 = (Long) this.f7668b.get(v1Var.b());
            if (l10 == null) {
                l10 = 0L;
            }
            jLongValue = l10.longValue() + j10;
            this.f7668b.put(v1Var.b(), Long.valueOf(jLongValue));
        }
        f();
        return jLongValue;
    }

    public JSONObject c() {
        JSONObject jSONObject;
        synchronized (this.f7668b) {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.f7668b.entrySet()) {
                JsonUtils.putLong(jSONObject, (String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
        }
        return jSONObject;
    }

    public void b(v1 v1Var, long j10) {
        synchronized (this.f7668b) {
            this.f7668b.put(v1Var.b(), Long.valueOf(j10));
        }
        f();
    }

    public void a() {
        synchronized (this.f7668b) {
            this.f7668b.clear();
        }
        f();
    }

    public void b() {
        synchronized (this.f7668b) {
            Iterator it = v1.a().iterator();
            while (it.hasNext()) {
                this.f7668b.remove(((v1) it.next()).b());
            }
            f();
        }
    }

    public void a(v1 v1Var) {
        synchronized (this.f7668b) {
            this.f7668b.remove(v1Var.b());
        }
        f();
    }
}
