package bo.app;

import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class fb0 {
    public Long A;
    public long B;
    public long C;
    public long D;
    public Map E;
    public boolean F;
    public int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f2790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Set f2791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f2792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set f2793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f2798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f2799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2800k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f2801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f2802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f2803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f2804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public long f2805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f2806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f2807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f2808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f2809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f2810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f2811v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f2812w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f2813x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2814y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f2815z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ fb0() {
        this(0L, null, null, null, -1, -1, -1, false, false, false, -1L, false, false, -1, false, 86400L, true, 30, 30, false, -1L, ib0.b(), ib0.a(), 3, false, null, null, 0L, 0L, 0L, null, false, 0);
        int i10 = vb0.f4102e;
    }

    public final String a() {
        return this.f2815z;
    }

    public final boolean b() {
        return this.f2814y;
    }

    public final Long c() {
        return this.A;
    }

    public final long d() {
        return this.B;
    }

    public final long e() {
        return this.C;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fb0)) {
            return false;
        }
        fb0 fb0Var = (fb0) obj;
        return this.f2790a == fb0Var.f2790a && kotlin.jvm.internal.t.d(this.f2791b, fb0Var.f2791b) && kotlin.jvm.internal.t.d(this.f2792c, fb0Var.f2792c) && kotlin.jvm.internal.t.d(this.f2793d, fb0Var.f2793d) && this.f2794e == fb0Var.f2794e && this.f2795f == fb0Var.f2795f && this.f2796g == fb0Var.f2796g && this.f2797h == fb0Var.f2797h && this.f2798i == fb0Var.f2798i && this.f2799j == fb0Var.f2799j && this.f2800k == fb0Var.f2800k && this.f2801l == fb0Var.f2801l && this.f2802m == fb0Var.f2802m && this.f2803n == fb0Var.f2803n && this.f2804o == fb0Var.f2804o && this.f2805p == fb0Var.f2805p && this.f2806q == fb0Var.f2806q && this.f2807r == fb0Var.f2807r && this.f2808s == fb0Var.f2808s && this.f2809t == fb0Var.f2809t && this.f2810u == fb0Var.f2810u && this.f2811v == fb0Var.f2811v && this.f2812w == fb0Var.f2812w && this.f2813x == fb0Var.f2813x && this.f2814y == fb0Var.f2814y && kotlin.jvm.internal.t.d(this.f2815z, fb0Var.f2815z) && kotlin.jvm.internal.t.d(this.A, fb0Var.A) && this.B == fb0Var.B && this.C == fb0Var.C && this.D == fb0Var.D && kotlin.jvm.internal.t.d(this.E, fb0Var.E) && this.F == fb0Var.F && this.G == fb0Var.G;
    }

    public final long f() {
        return this.D;
    }

    public final void g(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("feature_flags");
        if (jSONObjectOptJSONObject != null) {
            try {
                this.f2802m = jSONObjectOptJSONObject.optBoolean("enabled");
                this.f2803n = jSONObjectOptJSONObject.getInt("refresh_rate_limit");
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) xa0.f4257a, 4, (Object) null);
                this.f2802m = false;
            }
        }
    }

    public final void h(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("geofences");
        if (jSONObjectOptJSONObject != null) {
            try {
                this.f2794e = jSONObjectOptJSONObject.getInt("min_time_since_last_request");
                this.f2795f = jSONObjectOptJSONObject.getInt("min_time_since_last_report");
                this.f2798i = jSONObjectOptJSONObject.getBoolean("enabled");
                this.f2797h = true;
                this.f2796g = jSONObjectOptJSONObject.optInt("max_num_to_register", 20);
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ya0.f4348a, 4, (Object) null);
                this.f2794e = -1;
                this.f2795f = -1;
                this.f2796g = -1;
                this.f2798i = false;
                this.f2797h = false;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [int] */
    /* JADX WARN: Type inference failed for: r0v15, types: [int] */
    /* JADX WARN: Type inference failed for: r0v17, types: [int] */
    /* JADX WARN: Type inference failed for: r0v26, types: [int] */
    /* JADX WARN: Type inference failed for: r0v56 */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v58 */
    /* JADX WARN: Type inference failed for: r0v59 */
    /* JADX WARN: Type inference failed for: r0v60 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v62 */
    /* JADX WARN: Type inference failed for: r0v63 */
    /* JADX WARN: Type inference failed for: r1v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v31, types: [int] */
    /* JADX WARN: Type inference failed for: r1v36, types: [int] */
    /* JADX WARN: Type inference failed for: r1v44, types: [int] */
    /* JADX WARN: Type inference failed for: r1v63 */
    /* JADX WARN: Type inference failed for: r1v64 */
    /* JADX WARN: Type inference failed for: r1v65 */
    /* JADX WARN: Type inference failed for: r1v66 */
    /* JADX WARN: Type inference failed for: r1v67 */
    /* JADX WARN: Type inference failed for: r1v71 */
    /* JADX WARN: Type inference failed for: r1v72 */
    /* JADX WARN: Type inference failed for: r1v73 */
    /* JADX WARN: Type inference failed for: r1v74 */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        int iA = androidx.compose.animation.a.a(this.f2790a) * 31;
        Set set = this.f2791b;
        int iHashCode = (iA + (set == null ? 0 : set.hashCode())) * 31;
        Set set2 = this.f2792c;
        int iHashCode2 = (iHashCode + (set2 == null ? 0 : set2.hashCode())) * 31;
        Set set3 = this.f2793d;
        int iHashCode3 = (this.f2796g + ((this.f2795f + ((this.f2794e + ((iHashCode2 + (set3 == null ? 0 : set3.hashCode())) * 31)) * 31)) * 31)) * 31;
        boolean z10 = this.f2797h;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = (iHashCode3 + r02) * 31;
        boolean z11 = this.f2798i;
        ?? r03 = z11;
        if (z11) {
            r03 = 1;
        }
        int i11 = (i10 + r03) * 31;
        boolean z12 = this.f2799j;
        ?? r04 = z12;
        if (z12) {
            r04 = 1;
        }
        int iA2 = (androidx.compose.animation.a.a(this.f2800k) + ((i11 + r04) * 31)) * 31;
        boolean z13 = this.f2801l;
        ?? r12 = z13;
        if (z13) {
            r12 = 1;
        }
        int i12 = (iA2 + r12) * 31;
        boolean z14 = this.f2802m;
        ?? r13 = z14;
        if (z14) {
            r13 = 1;
        }
        int i13 = (this.f2803n + ((i12 + r13) * 31)) * 31;
        boolean z15 = this.f2804o;
        ?? r05 = z15;
        if (z15) {
            r05 = 1;
        }
        int iA3 = (androidx.compose.animation.a.a(this.f2805p) + ((i13 + r05) * 31)) * 31;
        boolean z16 = this.f2806q;
        ?? r14 = z16;
        if (z16) {
            r14 = 1;
        }
        int i14 = (this.f2808s + ((this.f2807r + ((iA3 + r14) * 31)) * 31)) * 31;
        boolean z17 = this.f2809t;
        ?? r15 = z17;
        if (z17) {
            r15 = 1;
        }
        int iA4 = (this.f2813x + ((this.f2812w + ((this.f2811v + ((androidx.compose.animation.a.a(this.f2810u) + ((i14 + r15) * 31)) * 31)) * 31)) * 31)) * 31;
        boolean z18 = this.f2814y;
        ?? r16 = z18;
        if (z18) {
            r16 = 1;
        }
        int i15 = (iA4 + r16) * 31;
        String str = this.f2815z;
        int iHashCode4 = (i15 + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.A;
        int iA5 = (androidx.compose.animation.a.a(this.D) + ((androidx.compose.animation.a.a(this.C) + ((androidx.compose.animation.a.a(this.B) + ((iHashCode4 + (l10 == null ? 0 : l10.hashCode())) * 31)) * 31)) * 31)) * 31;
        Map map = this.E;
        int iHashCode5 = (iA5 + (map != null ? map.hashCode() : 0)) * 31;
        boolean z19 = this.F;
        return this.G + ((iHashCode5 + (z19 ? 1 : z19)) * 31);
    }

    public final void i(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("endpoint_overrides");
        if (jSONObjectOptJSONObject != null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
            kotlin.jvm.internal.t.h(itKeys, "endpointOverrides.keys()");
            while (itKeys.hasNext()) {
                String destinationSuffix = itKeys.next();
                j00 j00Var = k00.f3188b;
                kotlin.jvm.internal.t.h(destinationSuffix, "endpointSuffixPath");
                kotlin.jvm.internal.t.i(destinationSuffix, "destinationSuffix");
                k00 k00Var = (k00) k00.f3189c.get(destinationSuffix);
                if (k00Var != null) {
                    JSONObject jSONObject2 = jSONObjectOptJSONObject.getJSONObject(destinationSuffix);
                    int i10 = jSONObject2.getInt("capacity");
                    int i11 = jSONObject2.getInt("refill_rate");
                    if (i10 > 0 && i11 > 0) {
                        linkedHashMap.put(k00Var, new ra0(i10, i11));
                    }
                }
            }
            if (!linkedHashMap.isEmpty()) {
                this.E = linkedHashMap;
            }
        }
    }

    public final void j(JSONObject jSONObject) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("global_request_rate_limit");
            if (jSONObjectOptJSONObject != null) {
                if (!jSONObjectOptJSONObject.getBoolean("enabled")) {
                    this.f2806q = false;
                    return;
                }
                int i10 = jSONObjectOptJSONObject.getInt("refill_rate");
                int i11 = jSONObjectOptJSONObject.getInt("capacity");
                if (i11 < 10) {
                    this.f2806q = false;
                } else {
                    if (i10 <= 0) {
                        return;
                    }
                    this.f2806q = true;
                    this.f2808s = i11;
                    this.f2807r = i10;
                    i(jSONObjectOptJSONObject);
                }
            }
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) za0.f4420a, 4, (Object) null);
            this.f2806q = false;
            this.E = null;
        }
    }

    public final void k(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("push_max");
        if (jSONObjectOptJSONObject != null) {
            try {
                this.f2804o = jSONObjectOptJSONObject.optBoolean("enabled");
                this.f2805p = jSONObjectOptJSONObject.optLong("redeliver_buffer", 86400L);
                this.f2810u = jSONObjectOptJSONObject.optLong("redeliver_dedupe_buffer", -1L);
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ab0.f2366a, 4, (Object) null);
                this.f2804o = false;
                this.f2805p = 0L;
                this.f2810u = -1L;
            }
        }
    }

    public final void l(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("sdk_debugger");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        try {
            r90 r90VarA = w90.f4175k.a(jSONObjectOptJSONObject, false);
            if (r90VarA.f3752a) {
                this.f2814y = true;
                this.f2815z = r90VarA.f3754c;
                Long l10 = r90VarA.f3753b;
                if (l10 != null) {
                    this.A = Long.valueOf(l10.longValue());
                }
                this.B = r90VarA.f3755d;
                this.C = r90VarA.f3756e;
                this.D = r90VarA.f3757f;
            }
            String str = this.f2815z;
            if (str != null && !p9.q.z(str) && this.B > 0 && this.C > 0 && this.D > 0) {
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new bb0(jSONObjectOptJSONObject), 7, (Object) null);
        } catch (JSONException e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) cb0.f2498a, 4, (Object) null);
        }
        this.f2814y = false;
        this.f2815z = null;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
    }

    public final String toString() {
        return "ServerConfig(configTime=" + this.f2790a + ", blocklistedEvents=" + this.f2791b + ", blocklistedAttributes=" + this.f2792c + ", blocklistedPurchases=" + this.f2793d + ", minTimeSinceLastRequest=" + this.f2794e + ", minTimeSinceLastReport=" + this.f2795f + ", maxNumToRegister=" + this.f2796g + ", geofencesEnabledSet=" + this.f2797h + ", geofencesEnabled=" + this.f2798i + ", isContentCardsFeatureEnabled=" + this.f2799j + ", messagingSessionTimeout=" + this.f2800k + ", ephemeralEventsEnabled=" + this.f2801l + ", featureFlagsEnabled=" + this.f2802m + ", featureFlagsRefreshRateLimit=" + this.f2803n + ", pushMaxEnabled=" + this.f2804o + ", pushMaxRedeliverBuffer=" + this.f2805p + ", globalRequestRateLimitEnabled=" + this.f2806q + ", globalRequestRateLimitBucketRefillRate=" + this.f2807r + ", globalRequestRateLimitBucketCapacity=" + this.f2808s + ", isDustFeatureEnabled=" + this.f2809t + ", pushMaxRedeliverDedupeBuffer=" + this.f2810u + ", defaultBackoffMinSleepMs=" + this.f2811v + ", defaultBackoffMaxSleepMs=" + this.f2812w + ", defaultBackoffScaleFactor=" + this.f2813x + ", sdkDebuggerEnabled=" + this.f2814y + ", sdkDebuggerAuthCode=" + this.f2815z + ", sdkDebuggerExpirationTime=" + this.A + ", sdkDebuggerFlushIntervalBytes=" + this.B + ", sdkDebuggerFlushIntervalSeconds=" + this.C + ", sdkDebuggerMaxPayloadBytes=" + this.D + ", globalRequestRateLimitOverrides=" + this.E + ", bannersEnabled=" + this.F + ", maxBannerPlacements=" + this.G + ')';
    }

    public final void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("banners");
        if (jSONObjectOptJSONObject != null) {
            try {
                this.F = jSONObjectOptJSONObject.getBoolean("enabled");
                int i10 = jSONObjectOptJSONObject.getInt("max_placements");
                this.G = i10;
                if (!this.F || i10 > 0) {
                    return;
                } else {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new sa0(this), 7, (Object) null);
                }
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ta0.f3907a, 4, (Object) null);
            }
            this.F = false;
            this.G = 0;
        }
    }

    public final void b(JSONObject jSONObject) {
        this.f2791b = a("events_blacklist", jSONObject);
        this.f2792c = a("attributes_blacklist", jSONObject);
        this.f2793d = a("purchases_blacklist", jSONObject);
    }

    public final void c(JSONObject jSONObject) {
        boolean z10;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("content_cards");
        if (jSONObjectOptJSONObject != null) {
            try {
                z10 = jSONObjectOptJSONObject.getBoolean("enabled");
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) ua0.f4003a, 4, (Object) null);
                z10 = false;
            }
            this.f2799j = z10;
        }
    }

    public final void d(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("request_backoff");
        if (jSONObjectOptJSONObject != null) {
            this.f2811v = jSONObjectOptJSONObject.optInt("min_sleep_duration_ms", this.f2811v);
            this.f2812w = jSONObjectOptJSONObject.optInt("max_sleep_duration_ms", this.f2812w);
            this.f2813x = jSONObjectOptJSONObject.optInt("scale_factor", this.f2813x);
        }
    }

    public final void e(JSONObject jSONObject) {
        boolean z10;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("dust");
        if (jSONObjectOptJSONObject != null) {
            try {
                z10 = jSONObjectOptJSONObject.getBoolean("enabled");
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) va0.f4100a, 4, (Object) null);
                z10 = false;
            }
            this.f2809t = z10;
        }
    }

    public final void f(JSONObject jSONObject) {
        boolean z10;
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("ephemeral_events");
        if (jSONObjectOptJSONObject != null) {
            try {
                z10 = jSONObjectOptJSONObject.getBoolean("enabled");
            } catch (JSONException e10) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) wa0.f4187a, 4, (Object) null);
                z10 = false;
            }
            this.f2801l = z10;
        }
    }

    public fb0(long j10, Set set, Set set2, Set set3, int i10, int i11, int i12, boolean z10, boolean z11, boolean z12, long j11, boolean z13, boolean z14, int i13, boolean z15, long j12, boolean z16, int i14, int i15, boolean z17, long j13, int i16, int i17, int i18, boolean z18, String str, Long l10, long j14, long j15, long j16, Map map, boolean z19, int i19) {
        this.f2790a = j10;
        this.f2791b = set;
        this.f2792c = set2;
        this.f2793d = set3;
        this.f2794e = i10;
        this.f2795f = i11;
        this.f2796g = i12;
        this.f2797h = z10;
        this.f2798i = z11;
        this.f2799j = z12;
        this.f2800k = j11;
        this.f2801l = z13;
        this.f2802m = z14;
        this.f2803n = i13;
        this.f2804o = z15;
        this.f2805p = j12;
        this.f2806q = z16;
        this.f2807r = i14;
        this.f2808s = i15;
        this.f2809t = z17;
        this.f2810u = j13;
        this.f2811v = i16;
        this.f2812w = i17;
        this.f2813x = i18;
        this.f2814y = z18;
        this.f2815z = str;
        this.A = l10;
        this.B = j14;
        this.C = j15;
        this.D = j16;
        this.E = map;
        this.F = z19;
        this.G = i19;
    }

    public static HashSet a(String str, JSONObject jSONObject) {
        Iterator it;
        HashSet hashSet = new HashSet();
        if (jSONObject.has(str)) {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                it = kotlin.collections.v.l().iterator();
            } else {
                it = o9.o.s(o9.o.k(kotlin.collections.d0.a0(n9.o.u(0, jSONArrayOptJSONArray.length())), new db0(jSONArrayOptJSONArray)), new eb0(jSONArrayOptJSONArray)).iterator();
            }
            while (it.hasNext()) {
                hashSet.add((String) it.next());
            }
        }
        return hashSet;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fb0(JSONObject configJson) {
        this();
        kotlin.jvm.internal.t.i(configJson, "configJson");
        this.f2790a = configJson.optLong("time", 0L);
        this.f2800k = configJson.optLong("messaging_session_timeout", -1L);
        b(configJson);
        c(configJson);
        h(configJson);
        f(configJson);
        g(configJson);
        k(configJson);
        j(configJson);
        e(configJson);
        d(configJson);
        l(configJson);
        a(configJson);
    }
}
