package com.applovin.impl.sdk.network;

import com.applovin.impl.i4;
import com.applovin.impl.l4;
import com.applovin.impl.sdk.j;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map f7233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f7234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final JSONObject f7235e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f7236f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f7237g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f7238h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7239i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f7240j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f7241k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final boolean f7242l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f7243m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f7244n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f7245o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final i4.a f7246p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f7247q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f7248r;

    /* JADX INFO: renamed from: com.applovin.impl.sdk.network.a$a, reason: collision with other inner class name */
    public static class C0175a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f7249a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f7250b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f7251c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Map f7253e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        JSONObject f7254f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        Object f7255g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f7257i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f7258j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f7259k;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f7261m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        boolean f7262n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        boolean f7263o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        boolean f7264p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        i4.a f7265q;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        int f7256h = 1;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f7260l = true;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Map f7252d = new HashMap();

        public C0175a(j jVar) {
            this.f7257i = ((Integer) jVar.a(l4.F2)).intValue();
            this.f7258j = ((Integer) jVar.a(l4.E2)).intValue();
            this.f7261m = ((Boolean) jVar.a(l4.f5610c3)).booleanValue();
            this.f7262n = ((Boolean) jVar.a(l4.F4)).booleanValue();
            this.f7265q = i4.a.a(((Integer) jVar.a(l4.G4)).intValue());
            this.f7264p = ((Boolean) jVar.a(l4.f5620d5)).booleanValue();
        }

        public C0175a a(Map map) {
            this.f7253e = map;
            return this;
        }

        public C0175a b(String str) {
            this.f7250b = str;
            return this;
        }

        public C0175a c(String str) {
            this.f7249a = str;
            return this;
        }

        public C0175a d(boolean z10) {
            this.f7260l = z10;
            return this;
        }

        public C0175a e(boolean z10) {
            this.f7261m = z10;
            return this;
        }

        public C0175a f(boolean z10) {
            this.f7263o = z10;
            return this;
        }

        public C0175a a(JSONObject jSONObject) {
            this.f7254f = jSONObject;
            return this;
        }

        public C0175a b(Map map) {
            this.f7252d = map;
            return this;
        }

        public C0175a c(int i10) {
            this.f7257i = i10;
            return this;
        }

        public C0175a a(String str) {
            this.f7251c = str;
            return this;
        }

        public C0175a b(int i10) {
            this.f7258j = i10;
            return this;
        }

        public C0175a c(boolean z10) {
            this.f7259k = z10;
            return this;
        }

        public C0175a a(Object obj) {
            this.f7255g = obj;
            return this;
        }

        public C0175a b(boolean z10) {
            this.f7264p = z10;
            return this;
        }

        public C0175a a(int i10) {
            this.f7256h = i10;
            return this;
        }

        public C0175a a(boolean z10) {
            this.f7262n = z10;
            return this;
        }

        public C0175a a(i4.a aVar) {
            this.f7265q = aVar;
            return this;
        }

        public a a() {
            return new a(this);
        }
    }

    protected a(C0175a c0175a) {
        this.f7231a = c0175a.f7250b;
        this.f7232b = c0175a.f7249a;
        this.f7233c = c0175a.f7252d;
        this.f7234d = c0175a.f7253e;
        this.f7235e = c0175a.f7254f;
        this.f7236f = c0175a.f7251c;
        this.f7237g = c0175a.f7255g;
        int i10 = c0175a.f7256h;
        this.f7238h = i10;
        this.f7239i = i10;
        this.f7240j = c0175a.f7257i;
        this.f7241k = c0175a.f7258j;
        this.f7242l = c0175a.f7259k;
        this.f7243m = c0175a.f7260l;
        this.f7244n = c0175a.f7261m;
        this.f7245o = c0175a.f7262n;
        this.f7246p = c0175a.f7265q;
        this.f7247q = c0175a.f7263o;
        this.f7248r = c0175a.f7264p;
    }

    public void a(String str) {
        this.f7231a = str;
    }

    public void b(String str) {
        this.f7232b = str;
    }

    public int c() {
        return this.f7238h - this.f7239i;
    }

    public Object d() {
        return this.f7237g;
    }

    public i4.a e() {
        return this.f7246p;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String str = this.f7231a;
        if (str == null ? aVar.f7231a != null : !str.equals(aVar.f7231a)) {
            return false;
        }
        Map map = this.f7233c;
        if (map == null ? aVar.f7233c != null : !map.equals(aVar.f7233c)) {
            return false;
        }
        Map map2 = this.f7234d;
        if (map2 == null ? aVar.f7234d != null : !map2.equals(aVar.f7234d)) {
            return false;
        }
        String str2 = this.f7236f;
        if (str2 == null ? aVar.f7236f != null : !str2.equals(aVar.f7236f)) {
            return false;
        }
        String str3 = this.f7232b;
        if (str3 == null ? aVar.f7232b != null : !str3.equals(aVar.f7232b)) {
            return false;
        }
        JSONObject jSONObject = this.f7235e;
        if (jSONObject == null ? aVar.f7235e != null : !jSONObject.equals(aVar.f7235e)) {
            return false;
        }
        Object obj2 = this.f7237g;
        if (obj2 == null ? aVar.f7237g == null : obj2.equals(aVar.f7237g)) {
            return this.f7238h == aVar.f7238h && this.f7239i == aVar.f7239i && this.f7240j == aVar.f7240j && this.f7241k == aVar.f7241k && this.f7242l == aVar.f7242l && this.f7243m == aVar.f7243m && this.f7244n == aVar.f7244n && this.f7245o == aVar.f7245o && this.f7246p == aVar.f7246p && this.f7247q == aVar.f7247q && this.f7248r == aVar.f7248r;
        }
        return false;
    }

    public String f() {
        return this.f7231a;
    }

    public Map g() {
        return this.f7234d;
    }

    public String h() {
        return this.f7232b;
    }

    public int hashCode() {
        int iHashCode = super.hashCode() * 31;
        String str = this.f7231a;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f7236f;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f7232b;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj = this.f7237g;
        int iHashCode5 = ((((((((((((((((((((((iHashCode4 + (obj != null ? obj.hashCode() : 0)) * 31) + this.f7238h) * 31) + this.f7239i) * 31) + this.f7240j) * 31) + this.f7241k) * 31) + (this.f7242l ? 1 : 0)) * 31) + (this.f7243m ? 1 : 0)) * 31) + (this.f7244n ? 1 : 0)) * 31) + (this.f7245o ? 1 : 0)) * 31) + this.f7246p.b()) * 31) + (this.f7247q ? 1 : 0)) * 31) + (this.f7248r ? 1 : 0);
        Map map = this.f7233c;
        if (map != null) {
            iHashCode5 = (iHashCode5 * 31) + map.hashCode();
        }
        Map map2 = this.f7234d;
        if (map2 != null) {
            iHashCode5 = (iHashCode5 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f7235e;
        if (jSONObject == null) {
            return iHashCode5;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (iHashCode5 * 31) + new String(charArray).hashCode();
    }

    public Map i() {
        return this.f7233c;
    }

    public int j() {
        return this.f7239i;
    }

    public int k() {
        return this.f7241k;
    }

    public int l() {
        return this.f7240j;
    }

    public boolean m() {
        return this.f7245o;
    }

    public boolean n() {
        return this.f7242l;
    }

    public boolean o() {
        return this.f7248r;
    }

    public boolean p() {
        return this.f7243m;
    }

    public boolean q() {
        return this.f7244n;
    }

    public boolean r() {
        return this.f7247q;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f7231a + ", backupEndpoint=" + this.f7236f + ", httpMethod=" + this.f7232b + ", httpHeaders=" + this.f7234d + ", body=" + this.f7235e + ", emptyResponse=" + this.f7237g + ", initialRetryAttempts=" + this.f7238h + ", retryAttemptsLeft=" + this.f7239i + ", timeoutMillis=" + this.f7240j + ", retryDelayMillis=" + this.f7241k + ", exponentialRetries=" + this.f7242l + ", retryOnAllErrors=" + this.f7243m + ", retryOnNoConnection=" + this.f7244n + ", encodingEnabled=" + this.f7245o + ", encodingType=" + this.f7246p + ", trackConnectionSpeed=" + this.f7247q + ", gzipBodyEncoding=" + this.f7248r + '}';
    }

    public String a() {
        return this.f7236f;
    }

    public JSONObject b() {
        return this.f7235e;
    }

    public void a(int i10) {
        this.f7239i = i10;
    }

    public static C0175a a(j jVar) {
        return new C0175a(jVar);
    }
}
