package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class vb0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f4102e = (int) TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f4103f = (int) TimeUnit.MINUTES.toMillis(5);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f4104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f4105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y9.a f4106c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public fb0 f4107d;

    public vb0(Context context, String apiKey) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(apiKey, "apiKey");
        SharedPreferences sharedPreferences = context.getSharedPreferences(ib0.a(apiKey), 0);
        this.f4104a = sharedPreferences;
        this.f4105b = new ReentrantLock();
        this.f4106c = y9.c.b(false, 1, null);
        String string = sharedPreferences.getString("last_accessed_sdk_version", "");
        if (!kotlin.jvm.internal.t.d("32.1.0", string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new hb0(string), 6, (Object) null);
            sharedPreferences.edit().putLong("config_time", 0L).putString("last_accessed_sdk_version", "32.1.0").apply();
        }
        F();
    }

    public final boolean A() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2798i : this.f4104a.getBoolean("geofences_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean B() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2797h : this.f4104a.getBoolean("geofences_enabled_set", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean C() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2806q : this.f4104a.getBoolean("global_req_rate_limit_enabled", true);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean D() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2804o : this.f4104a.getBoolean("push_max_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean E() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2814y : this.f4104a.getBoolean("sdk_debugger_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void F() {
        Map mapQ;
        fb0 fb0Var = new fb0();
        fb0Var.f2792c = a();
        fb0Var.f2791b = b();
        fb0Var.f2793d = c();
        fb0Var.f2790a = d();
        fb0Var.f2800k = l();
        fb0Var.f2794e = n();
        fb0Var.f2795f = m();
        fb0Var.f2796g = k();
        fb0Var.f2798i = A();
        fb0Var.f2797h = B();
        fb0Var.f2799j = w();
        fb0Var.f2801l = y();
        fb0Var.f2802m = z();
        fb0Var.f2803n = h();
        fb0Var.f2804o = D();
        fb0Var.f2805p = o();
        fb0Var.f2809t = x();
        fb0Var.f2806q = C();
        fb0Var.f2807r = j();
        fb0Var.f2808s = i();
        fb0Var.f2810u = p();
        fb0Var.f2813x = g();
        fb0Var.f2811v = f();
        fb0Var.f2812w = e();
        fb0Var.f2814y = E();
        fb0Var.f2815z = r();
        fb0Var.B = t();
        fb0Var.C = u();
        fb0Var.D = v();
        fb0Var.A = Long.valueOf(s());
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var2 = this.f4107d;
            if (fb0Var2 == null || (mapQ = fb0Var2.E) == null) {
                mapQ = q();
            }
            reentrantLock.unlock();
            fb0Var.E = mapQ;
            reentrantLock = this.f4105b;
            reentrantLock.lock();
            try {
                fb0 fb0Var3 = this.f4107d;
                boolean z10 = fb0Var3 != null ? fb0Var3.F : this.f4104a.getBoolean("banners_enabled", false);
                reentrantLock.unlock();
                fb0Var.F = z10;
                reentrantLock = this.f4105b;
                reentrantLock.lock();
                try {
                    fb0 fb0Var4 = this.f4107d;
                    int i10 = fb0Var4 != null ? fb0Var4.G : this.f4104a.getInt("max_banner_placements", 0);
                    reentrantLock.unlock();
                    fb0Var.G = i10;
                    this.f4105b.lock();
                    try {
                        this.f4107d = fb0Var;
                        v8.k0 k0Var = v8.k0.f35197a;
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } finally {
        }
    }

    public final Set a() {
        Set setA;
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            if (fb0Var == null || (setA = fb0Var.f2792c) == null) {
                setA = a("blacklisted_attributes");
            }
            return setA;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set b() {
        Set setA;
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            if (fb0Var == null || (setA = fb0Var.f2791b) == null) {
                setA = a("blacklisted_events");
            }
            return setA;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set c() {
        Set setA;
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            if (fb0Var == null || (setA = fb0Var.f2793d) == null) {
                setA = a("blacklisted_purchases");
            }
            return setA;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long d() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2790a : this.f4104a.getLong("config_time", 0L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int e() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2812w : this.f4104a.getInt("default_backoff_max_sleep_duration_ms", f4103f);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int f() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2811v : this.f4104a.getInt("default_backoff_min_sleep_duration__ms", f4102e);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int g() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2813x : this.f4104a.getInt("default_backoff_scale_factor", 3);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int h() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2803n : this.f4104a.getInt("feature_flags_refresh_rate_limit", -1);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int i() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2808s : this.f4104a.getInt("global_req_rate_capacity", 30);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int j() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2807r : this.f4104a.getInt("global_req_rate_refill_rate", 30);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int k() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2796g : this.f4104a.getInt("geofences_max_num_to_register", -1);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long l() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2800k : this.f4104a.getLong("messaging_session_timeout", -1L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int m() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2795f : this.f4104a.getInt("geofences_min_time_since_last_report", -1);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int n() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2794e : this.f4104a.getInt("geofences_min_time_since_last_request", -1);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long o() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2805p : this.f4104a.getLong("push_max_redeliver_buffer", 86400L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long p() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2810u : this.f4104a.getLong("push_max_redeliver_dedupe_buffer", -1L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final LinkedHashMap q() {
        String string;
        k00 k00VarValueOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            string = this.f4104a.getString("global_req_rate_limit_endpoint_overrides", "");
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ob0.f3554a, 4, (Object) null);
        }
        if (string != null && string.length() != 0) {
            JSONObject jSONObject = new JSONObject(string);
            Iterator<String> itKeys = jSONObject.keys();
            kotlin.jvm.internal.t.h(itKeys, "json.keys()");
            while (itKeys.hasNext()) {
                String name = itKeys.next();
                j00 j00Var = k00.f3188b;
                kotlin.jvm.internal.t.h(name, "destKey");
                kotlin.jvm.internal.t.i(name, "name");
                try {
                    k00VarValueOf = k00.valueOf(name);
                } catch (Exception e11) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) j00Var, BrazeLogger.Priority.E, (Throwable) e11, false, (h9.a) new i00(name), 4, (Object) null);
                    k00VarValueOf = null;
                }
                if (k00VarValueOf != null) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(name);
                    linkedHashMap.put(k00VarValueOf, new ra0(jSONObject2.getInt("capacity"), jSONObject2.getInt("refill")));
                }
            }
            return linkedHashMap;
        }
        return linkedHashMap;
    }

    public final String r() {
        String string;
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            if (fb0Var == null || (string = fb0Var.f2815z) == null) {
                string = this.f4104a.getString("sdk_debugger_authorization_code", null);
            }
            return string;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long s() {
        Long l10;
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return (fb0Var == null || (l10 = fb0Var.A) == null) ? this.f4104a.getLong("sdk_debugger_expiration_time", -1L) : l10.longValue();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long t() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.B : this.f4104a.getLong("sdk_debugger_flush_interval_bytes", 0L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long u() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.C : this.f4104a.getLong("sdk_debugger_flush_interval_seconds", 0L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long v() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.D : this.f4104a.getLong("sdk_debugger_max_payload_bytes", 0L);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean w() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2799j : this.f4104a.getBoolean("content_cards_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean x() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2809t : this.f4104a.getBoolean("dust_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean y() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2801l : this.f4104a.getBoolean("ephemeral_events_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean z() {
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            return fb0Var != null ? fb0Var.f2802m : this.f4104a.getBoolean("feature_flags_enabled", false);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final HashSet a(String str) {
        try {
            String string = this.f4104a.getString(str, "");
            HashSet hashSet = new HashSet();
            if (string != null && !p9.q.z(string)) {
                JSONArray jSONArray = new JSONArray(string);
                Iterator it = o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, jSONArray.length())), new lb0(jSONArray)), new mb0(jSONArray)).iterator();
                while (it.hasNext()) {
                    hashSet.add((String) it.next());
                }
                return hashSet;
            }
            return hashSet;
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) nb0.f3478a, 4, (Object) null);
            return new HashSet();
        }
    }

    public final void a(r90 sdkDebugConfig) {
        kotlin.jvm.internal.t.i(sdkDebugConfig, "sdkDebugConfig");
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            fb0 fb0Var = this.f4107d;
            if (fb0Var != null) {
                fb0Var.f2814y = sdkDebugConfig.f3752a;
            }
            if (fb0Var != null) {
                fb0Var.B = sdkDebugConfig.f3755d;
            }
            if (fb0Var != null) {
                fb0Var.C = sdkDebugConfig.f3756e;
            }
            if (fb0Var != null) {
                fb0Var.D = sdkDebugConfig.f3757f;
            }
            String str = sdkDebugConfig.f3754c;
            if (str != null && fb0Var != null) {
                fb0Var.f2815z = str;
            }
            Long l10 = sdkDebugConfig.f3753b;
            if (l10 != null) {
                long jLongValue = l10.longValue();
                fb0 fb0Var2 = this.f4107d;
                if (fb0Var2 != null) {
                    fb0Var2.A = Long.valueOf(jLongValue);
                }
                v8.k0 k0Var = v8.k0.f35197a;
            }
            try {
                fb0 fb0Var3 = this.f4107d;
                if (fb0Var3 != null) {
                    SharedPreferences.Editor editorEdit = this.f4104a.edit();
                    editorEdit.putBoolean("sdk_debugger_enabled", fb0Var3.f2814y).putString("sdk_debugger_authorization_code", fb0Var3.f2815z).putLong("sdk_debugger_flush_interval_bytes", fb0Var3.B).putLong("sdk_debugger_flush_interval_seconds", fb0Var3.C).putLong("sdk_debugger_max_payload_bytes", fb0Var3.D);
                    Long l11 = fb0Var3.A;
                    if (l11 != null) {
                        editorEdit.putLong("sdk_debugger_expiration_time", l11.longValue());
                    }
                    editorEdit.apply();
                }
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) rb0.f3762a, 4, (Object) null);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new sb0(this), 6, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(fb0 serverConfig) {
        kotlin.jvm.internal.t.i(serverConfig, "serverConfig");
        ReentrantLock reentrantLock = this.f4105b;
        reentrantLock.lock();
        try {
            this.f4107d = serverConfig;
            v8.k0 k0Var = v8.k0.f35197a;
            try {
                SharedPreferences.Editor editorEdit = this.f4104a.edit();
                if (serverConfig.f2791b != null) {
                    editorEdit.putString("blacklisted_events", new JSONArray((Collection) serverConfig.f2791b).toString());
                }
                if (serverConfig.f2792c != null) {
                    editorEdit.putString("blacklisted_attributes", new JSONArray((Collection) serverConfig.f2792c).toString());
                }
                if (serverConfig.f2793d != null) {
                    editorEdit.putString("blacklisted_purchases", new JSONArray((Collection) serverConfig.f2793d).toString());
                }
                Map map = serverConfig.E;
                if (map != null) {
                    JSONObject jSONObject = new JSONObject();
                    for (k00 k00Var : map.keySet()) {
                        ra0 ra0Var = (ra0) map.get(k00Var);
                        if (ra0Var != null) {
                            jSONObject.put(k00Var.name(), new JSONObject().put("refill", ra0Var.f3760b).put("capacity", ra0Var.f3759a));
                        }
                    }
                    editorEdit.putString("global_req_rate_limit_endpoint_overrides", jSONObject.toString());
                }
                editorEdit.putLong("config_time", serverConfig.f2790a).putInt("geofences_min_time_since_last_request", serverConfig.f2794e).putInt("geofences_min_time_since_last_report", serverConfig.f2795f).putInt("geofences_max_num_to_register", serverConfig.f2796g).putBoolean("geofences_enabled", serverConfig.f2798i).putBoolean("geofences_enabled_set", serverConfig.f2797h).putLong("messaging_session_timeout", serverConfig.f2800k).putBoolean("ephemeral_events_enabled", serverConfig.f2801l).putBoolean("feature_flags_enabled", serverConfig.f2802m).putInt("feature_flags_refresh_rate_limit", serverConfig.f2803n).putBoolean("content_cards_enabled", serverConfig.f2799j).putBoolean("push_max_enabled", serverConfig.f2804o).putLong("push_max_redeliver_buffer", serverConfig.f2805p).putBoolean("dust_enabled", serverConfig.f2809t).putBoolean("global_req_rate_limit_enabled", serverConfig.f2806q).putInt("global_req_rate_capacity", serverConfig.f2808s).putInt("global_req_rate_refill_rate", serverConfig.f2807r).putLong("push_max_redeliver_dedupe_buffer", serverConfig.f2810u).putInt("default_backoff_scale_factor", serverConfig.f2813x).putInt("default_backoff_min_sleep_duration__ms", serverConfig.f2811v).putInt("default_backoff_max_sleep_duration_ms", serverConfig.f2812w).putBoolean("sdk_debugger_enabled", serverConfig.f2814y).putString("sdk_debugger_authorization_code", serverConfig.f2815z).putLong("sdk_debugger_flush_interval_bytes", serverConfig.B).putLong("sdk_debugger_flush_interval_seconds", serverConfig.C).putLong("sdk_debugger_max_payload_bytes", serverConfig.D).putBoolean("banners_enabled", serverConfig.F).putInt("max_banner_placements", serverConfig.G);
                Long l10 = serverConfig.A;
                if (l10 != null) {
                    editorEdit.putLong("sdk_debugger_expiration_time", l10.longValue());
                }
                editorEdit.apply();
            } catch (Exception e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) tb0.f3909a, 4, (Object) null);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new ub0(serverConfig), 6, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
