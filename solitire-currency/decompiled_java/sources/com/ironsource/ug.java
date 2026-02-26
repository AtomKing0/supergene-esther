package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x1 f15589a;

    public ug(x1 x1Var) {
        this.f15589a = x1Var;
    }

    public void a() {
        this.f15589a.a(u1.INIT_SUCCESS, null);
    }

    public void a(int i10, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        map.put("reason", str);
        this.f15589a.a(u1.INIT_FAILED, map);
    }

    public void a(long j10) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j10));
        this.f15589a.a(u1.INIT_ENDED, map);
    }

    public void a(String str, String str2) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str + "|" + str2);
        this.f15589a.a(u1.INIT_STARTED, map);
    }
}
