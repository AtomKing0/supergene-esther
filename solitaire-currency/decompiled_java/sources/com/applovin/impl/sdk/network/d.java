package com.applovin.impl.sdk.network;

import com.applovin.impl.i4;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f7281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7282b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f7283c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f7284d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map f7285e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map f7286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f7287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private i4.a f7288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f7289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7290j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f7291k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f7292l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f7293m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7294n;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f7295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f7296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7297c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f7298d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map f7299e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Map f7300f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Map f7301g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private i4.a f7302h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f7303i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f7304j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f7305k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private boolean f7306l;

        public b a(String str) {
            this.f7298d = str;
            return this;
        }

        public b b(String str) {
            this.f7295a = str;
            return this;
        }

        public b c(String str) {
            this.f7296b = str;
            return this;
        }

        public b d(String str) {
            this.f7297c = str;
            return this;
        }

        public b a(Map map) {
            this.f7300f = map;
            return this;
        }

        public b b(Map map) {
            this.f7299e = map;
            return this;
        }

        public b c(Map map) {
            this.f7301g = map;
            return this;
        }

        public b d(boolean z10) {
            this.f7305k = z10;
            return this;
        }

        public b a(i4.a aVar) {
            this.f7302h = aVar;
            return this;
        }

        public b b(boolean z10) {
            this.f7306l = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f7304j = z10;
            return this;
        }

        public b a(boolean z10) {
            this.f7303i = z10;
            return this;
        }

        public d a() {
            return new d(this);
        }
    }

    public static b b() {
        return new b();
    }

    void a() {
        Map map = CollectionUtils.map(this.f7285e);
        map.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f7285e = map;
    }

    int c() {
        return this.f7294n;
    }

    String d() {
        return this.f7284d;
    }

    String e() {
        return this.f7293m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f7281a.equals(((d) obj).f7281a);
    }

    i4.a f() {
        return this.f7288h;
    }

    Map g() {
        return this.f7286f;
    }

    String h() {
        return this.f7282b;
    }

    public int hashCode() {
        return this.f7281a.hashCode();
    }

    Map i() {
        return this.f7285e;
    }

    Map j() {
        return this.f7287g;
    }

    String k() {
        return this.f7283c;
    }

    void l() {
        this.f7294n++;
    }

    public boolean m() {
        return this.f7291k;
    }

    boolean n() {
        return this.f7289i;
    }

    boolean o() {
        return this.f7290j;
    }

    boolean p() {
        return this.f7292l;
    }

    JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f7281a);
        jSONObject.put("communicatorRequestId", this.f7293m);
        jSONObject.put("httpMethod", this.f7282b);
        jSONObject.put("targetUrl", this.f7283c);
        jSONObject.put("backupUrl", this.f7284d);
        jSONObject.put("encodingType", this.f7288h);
        jSONObject.put("isEncodingEnabled", this.f7289i);
        jSONObject.put("gzipBodyEncoding", this.f7290j);
        jSONObject.put("isAllowedPreInitEvent", this.f7291k);
        jSONObject.put("attemptNumber", this.f7294n);
        if (this.f7285e != null) {
            jSONObject.put("parameters", new JSONObject(this.f7285e));
        }
        if (this.f7286f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f7286f));
        }
        if (this.f7287g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f7287g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f7281a + "', communicatorRequestId='" + this.f7293m + "', httpMethod='" + this.f7282b + "', targetUrl='" + this.f7283c + "', backupUrl='" + this.f7284d + "', attemptNumber=" + this.f7294n + ", isEncodingEnabled=" + this.f7289i + ", isGzipBodyEncoding=" + this.f7290j + ", isAllowedPreInitEvent=" + this.f7291k + ", shouldFireInWebView=" + this.f7292l + '}';
    }

    d(JSONObject jSONObject, j jVar) throws JSONException {
        String string = JsonUtils.getString(jSONObject, "uniqueId", UUID.randomUUID().toString());
        String string2 = JsonUtils.getString(jSONObject, "communicatorRequestId", "");
        String string3 = JsonUtils.getString(jSONObject, "httpMethod", "");
        String string4 = jSONObject.getString("targetUrl");
        String string5 = JsonUtils.getString(jSONObject, "backupUrl", "");
        int i10 = jSONObject.getInt("attemptNumber");
        Map mapSynchronizedMap = JsonUtils.valueExists(jSONObject, "parameters") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("parameters"))) : new HashMap();
        Map mapSynchronizedMap2 = JsonUtils.valueExists(jSONObject, "httpHeaders") ? Collections.synchronizedMap(JsonUtils.toStringMap(jSONObject.getJSONObject("httpHeaders"))) : new HashMap();
        Map mapSynchronizedMap3 = JsonUtils.valueExists(jSONObject, "requestBody") ? Collections.synchronizedMap(JsonUtils.toStringObjectMap(jSONObject.getJSONObject("requestBody"))) : new HashMap();
        this.f7281a = string;
        this.f7282b = string3;
        this.f7293m = string2;
        this.f7283c = string4;
        this.f7284d = string5;
        this.f7285e = mapSynchronizedMap;
        this.f7286f = mapSynchronizedMap2;
        this.f7287g = mapSynchronizedMap3;
        this.f7288h = i4.a.a(jSONObject.optInt("encodingType", i4.a.DEFAULT.b()));
        this.f7289i = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f7290j = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f7291k = jSONObject.optBoolean("isAllowedPreInitEvent", false);
        this.f7292l = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f7294n = i10;
    }

    private d(b bVar) {
        this.f7281a = UUID.randomUUID().toString();
        this.f7282b = bVar.f7296b;
        this.f7283c = bVar.f7297c;
        this.f7284d = bVar.f7298d;
        this.f7285e = bVar.f7299e;
        this.f7286f = bVar.f7300f;
        this.f7287g = bVar.f7301g;
        this.f7288h = bVar.f7302h;
        this.f7289i = bVar.f7303i;
        this.f7290j = bVar.f7304j;
        this.f7291k = bVar.f7305k;
        this.f7292l = bVar.f7306l;
        this.f7293m = bVar.f7295a;
        this.f7294n = 0;
    }
}
