package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlayAdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ut {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x1 f15621a;

    public ut(x1 x1Var) {
        this.f15621a = x1Var;
    }

    private String a(long j10, long j11, long j12) {
        return "interval: " + j10 + ", remainingTime: " + j11 + ", timePassed: " + j12;
    }

    public void b() {
        this.f15621a.a(u1.TROUBLESHOOT_LOAD_SUCCESS, null);
    }

    public void c() {
        this.f15621a.a(u1.TROUBLESHOOT_SHOW, null);
    }

    public void d() {
        this.f15621a.a(u1.TROUBLESHOOT_SHOW_SUCCESS, null);
    }

    public void e(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_RESUME, map);
    }

    public void f(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_INTERNAL_ERROR, map);
    }

    public void g(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_PROVIDER_SETTINGS_MISSING, map);
    }

    public void h(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_FAILED, map);
    }

    public void i(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_AUCTION_SUCCESS, map);
    }

    public void j(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_CLOSED, map);
    }

    public void k(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_INIT_FAILED, map);
    }

    public void l(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_INIT_SUCCESS, map);
    }

    public void m(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_LOAD_FAILED, map);
    }

    public void n(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_LOAD_SUCCESS, map);
    }

    public void o(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_OPENED, map);
    }

    public void p(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_RELOAD_FAILED, map);
    }

    public void q(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_RELOAD_SUCCESS, map);
    }

    public void r(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_SHOW_FAILED, map);
    }

    public void s(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_UNEXPECTED_TIMEOUT, map);
    }

    public void t(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_WATERFALL_OVERHEAD, map);
    }

    public void a() {
        this.f15621a.a(u1.TROUBLESHOOT_LOAD, null);
    }

    public void b(int i10, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_LOAD_FAILED, map);
    }

    public void c(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_BN_RELOAD_EXCEPTION, map);
    }

    public void d(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_BANNER_REFRESH_TRIGGER_PAUSE, map);
    }

    public void a(int i10, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_AUCTION_SUCCESSFUL_RECOVERY_ERROR, map);
    }

    public void b(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_IMPRESSION_TIMEOUT, map);
    }

    public void a(int i10, String str, String str2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        map.put("reason", str);
        map.put(IronSourceConstants.EVENTS_EXT1, str2);
        this.f15621a.a(u1.TROUBLESHOOT_NOTIFICATION_ERROR, map);
    }

    public void b(String str, long j10, long j11, long j12) {
        HashMap map = new HashMap();
        map.put("reason", str);
        map.put(IronSourceConstants.EVENTS_EXT1, a(j10, j11, j12));
        this.f15621a.a(u1.TROUBLESHOOT_BANNER_REFRESH_RESUMED, map);
    }

    public void a(LevelPlayAdError levelPlayAdError) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(levelPlayAdError.getErrorCode()));
        map.put("reason", levelPlayAdError.getErrorMessage());
        this.f15621a.a(u1.TROUBLESHOOT_SHOW_FAILED, map);
    }

    public void a(Long l10, long j10, boolean z10) {
        HashMap map = new HashMap();
        map.put("duration", l10);
        map.put(IronSourceConstants.EVENTS_EXT1, "config:" + j10 + ", newLoad:" + (z10 ? 1 : 0));
        this.f15621a.a(u1.TROUBLESHOOT_LOAD_WHILE_LOADED, map);
    }

    public void a(String str) {
        HashMap map = new HashMap();
        map.put("reason", str);
        this.f15621a.a(u1.TROUBLESHOOT_AD_EXPIRED, map);
    }

    public void a(String str, long j10, long j11, long j12) {
        HashMap map = new HashMap();
        map.put("reason", str);
        map.put(IronSourceConstants.EVENTS_EXT1, a(j10, j11, j12));
        this.f15621a.a(u1.TROUBLESHOOT_BANNER_REFRESH_PAUSED, map);
    }

    public void a(Map<String, Object> map, String str) {
        HashMap map2 = new HashMap();
        map2.put("reason", str);
        if (map != null && !map.isEmpty()) {
            map2.putAll(map);
        }
        this.f15621a.a(u1.TROUBLESHOOT_BIDDING_DATA_MISSING, map2);
    }
}
