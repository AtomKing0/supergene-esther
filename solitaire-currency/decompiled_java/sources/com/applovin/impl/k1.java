package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.y1;
import io.sentry.protocol.TransactionInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k1 extends z1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private JSONObject f5531i;

    public k1(com.applovin.impl.sdk.j jVar) {
        super(jVar, y1.b.ERROR);
    }

    public void a(String str, Throwable th) {
        a(str, th, new HashMap());
    }

    public void b() {
        this.f5531i = JsonUtils.deserialize((String) this.f7884a.a(l4.I));
    }

    public void a(String str, String str2, Throwable th) {
        a(str, str2, th, new HashMap());
    }

    public void a(String str, String str2, Throwable th, Map map) {
        a(str + ":" + str2, th, map);
    }

    public void a(String str, Throwable th, Map map) {
        map.put(TransactionInfo.JsonKeys.SOURCE, str);
        map.put("top_main_method", th.toString());
        ArrayList arrayList = new ArrayList();
        arrayList.add(map);
        for (Throwable th2 : th.getSuppressed()) {
            HashMap map2 = new HashMap();
            CollectionUtils.putStringIfValid(TransactionInfo.JsonKeys.SOURCE, str, map2);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), map2);
            CollectionUtils.putStringIfValid("suppressed_throwable", th2.toString(), map2);
            arrayList.add(map2);
        }
        a(y1.f7790k0, arrayList, 0L);
    }

    public void a(String str, String str2, com.applovin.impl.sdk.ad.b bVar) {
        HashMap map = new HashMap();
        map.put(TransactionInfo.JsonKeys.SOURCE, str);
        map.put("error_message", str2);
        if (bVar != null) {
            map.putAll(a2.b(bVar));
            map.putAll(a2.a(bVar));
            boolean zH0 = bVar.H0();
            map.put("is_video_stream", String.valueOf(zH0));
            if (zH0 && (bVar instanceof com.applovin.impl.sdk.ad.a)) {
                CollectionUtils.putStringIfValid("video_url", ((com.applovin.impl.sdk.ad.a) bVar).h1(), map);
            } else {
                CollectionUtils.putStringIfValid("video_url", bVar.N(), map);
            }
        }
        d(y1.f7800p0, map);
    }

    public void a(String str, String str2, int i10, String str3) {
        List listA = a(str2);
        boolean z10 = listA != null;
        if (z10 && listA.contains(Integer.valueOf(i10))) {
            return;
        }
        if (z10 || i10 >= 400) {
            HashMap map = new HashMap(4);
            map.put(TransactionInfo.JsonKeys.SOURCE, str);
            map.put("url", StringUtils.emptyIfNull(str2));
            map.put("code", String.valueOf(i10));
            map.put("error_message", a2.a(str3));
            d(y1.f7806s0, map);
        }
    }

    private List a(String str) {
        List<Integer> integerList = JsonUtils.getIntegerList(this.f5531i, StringUtils.getHost(str), null);
        return integerList == null ? JsonUtils.getIntegerList(this.f5531i, "default", null) : integerList;
    }
}
