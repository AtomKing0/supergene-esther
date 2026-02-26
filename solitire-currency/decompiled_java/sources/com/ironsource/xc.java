package com.ironsource;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class xc {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16183b = "userId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f16184c = "appKey";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static xc f16185d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f16186a = new JSONObject();

    private xc() {
    }

    public static synchronized xc a() {
        if (f16185d == null) {
            f16185d = new xc();
        }
        return f16185d;
    }

    public synchronized JSONObject b() {
        return this.f16186a;
    }

    public synchronized String a(String str) {
        return this.f16186a.optString(str);
    }

    public synchronized void a(String str, Object obj) {
        try {
            this.f16186a.put(str, obj);
        } catch (Exception e10) {
            i9.d().a(e10);
        }
    }

    public synchronized void a(Map<String, Object> map) {
        if (map != null) {
            for (String str : map.keySet()) {
                a(str, map.get(str));
            }
        }
    }
}
