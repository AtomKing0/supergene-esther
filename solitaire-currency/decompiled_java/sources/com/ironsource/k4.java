package com.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class k4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x1 f12816a;

    public k4(x1 x1Var) {
        this.f12816a = x1Var;
    }

    public void a() {
        this.f12816a.a(u1.AUCTION_REQUEST, null);
    }

    public void b(String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f12816a.a(u1.AUCTION_REQUEST_WATERFALL, map);
    }

    public void c(String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f12816a.a(u1.AUCTION_RESULT_WATERFALL, map);
    }

    public void a(int i10, String str) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f12816a.a(u1.AUCTION_FAILED_NO_CANDIDATES, map);
    }

    public void a(long j10, int i10, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j10));
        map.put(IronSourceConstants.EVENTS_ERROR_CODE, Integer.valueOf(i10));
        if (!TextUtils.isEmpty(str)) {
            map.put("reason", str);
        }
        this.f12816a.a(u1.AUCTION_FAILED, map);
    }

    public void a(long j10, String str) {
        HashMap map = new HashMap();
        map.put("duration", Long.valueOf(j10));
        map.put(IronSourceConstants.EVENTS_EXT1, str);
        this.f12816a.a(u1.AUCTION_SUCCESS, map);
    }

    public void a(String str) {
        HashMap map = new HashMap();
        map.put("auctionId", str);
        this.f12816a.a(u1.AD_FORMAT_CAPPED, map);
    }
}
