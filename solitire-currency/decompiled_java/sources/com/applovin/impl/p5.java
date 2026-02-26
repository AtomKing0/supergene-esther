package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p5 extends w4 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f6556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f6557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final a3 f6558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f6559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map f6560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Map f6561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MaxError f6562m;

    public p5(String str, List list, Map map, Map map2, MaxError maxError, a3 a3Var, com.applovin.impl.sdk.j jVar, boolean z10) {
        super("TaskFireMediationPostbacks", jVar);
        this.f6556g = str + "_urls";
        this.f6557h = list;
        this.f6559j = z6.a(map, jVar);
        this.f6560k = map2 == null ? new HashMap() : map2;
        this.f6562m = maxError != null ? maxError : new MaxErrorImpl(-1);
        this.f6558i = a3Var;
        HashMap map3 = new HashMap(7);
        map3.put("AppLovin-Event-Type", str);
        if (z10 && a3Var != null) {
            map3.put("AppLovin-Ad-Network-Name", a3Var.c());
        }
        if (a3Var instanceof q2) {
            q2 q2Var = (q2) a3Var;
            map3.put("AppLovin-Ad-Unit-Id", q2Var.getAdUnitId());
            map3.put("AppLovin-Ad-Format", q2Var.getFormat().getLabel());
            if (z10) {
                map3.put("AppLovin-Third-Party-Ad-Placement-Id", q2Var.O());
            }
        }
        if (maxError != null) {
            map3.put("AppLovin-Error-Code", String.valueOf(maxError.getCode()));
            map3.put("AppLovin-Error-Message", maxError.getMessage());
        }
        this.f6561l = map3;
    }

    private void a(String str, Map map) {
        b().X().e(com.applovin.impl.sdk.network.d.b().d(str).c("POST").a(this.f6561l).a(false).c(map).c(((Boolean) this.f7677a.a(g3.B7)).booleanValue()).a());
    }

    private String b(String str, Map map) {
        for (String str2 : map.keySet()) {
            str = str.replace(str2, StringUtils.emptyIfNull((String) map.get(str2)));
        }
        return str;
    }

    private Map e() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) this.f7677a.a(g3.D6)));
        } catch (JSONException unused) {
            return Collections.EMPTY_MAP;
        }
    }

    private List f() {
        List list = this.f6557h;
        if (list != null) {
            return list;
        }
        a3 a3Var = this.f6558i;
        if (a3Var != null) {
            return a3Var.b(this.f6556g);
        }
        return null;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listF = f();
        if (CollectionUtils.isEmpty(listF)) {
            return;
        }
        Map mapE = e();
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            Uri uri = Uri.parse(a(b((String) it.next(), this.f6559j), this.f6562m));
            Uri.Builder builderClearQuery = uri.buildUpon().clearQuery();
            HashMap map = new HashMap(this.f6560k);
            for (String str : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(str);
                if (mapE.containsKey(queryParameter)) {
                    a3 a3Var = this.f6558i;
                    if (a3Var != null) {
                        map.put(str, a3Var.a((String) mapE.get(queryParameter)));
                    }
                } else {
                    builderClearQuery.appendQueryParameter(str, queryParameter);
                }
            }
            map.putAll(this.f7677a.y().e());
            a(builderClearQuery.build().toString(), map);
        }
    }

    private String a(String str, MaxError maxError) {
        int mediatedNetworkErrorCode;
        String mediatedNetworkErrorMessage;
        if (maxError instanceof MaxAdapterError) {
            MaxAdapterError maxAdapterError = (MaxAdapterError) maxError;
            mediatedNetworkErrorCode = maxAdapterError.getMediatedNetworkErrorCode();
            mediatedNetworkErrorMessage = maxAdapterError.getMediatedNetworkErrorMessage();
        } else {
            mediatedNetworkErrorCode = 0;
            mediatedNetworkErrorMessage = "";
        }
        return str.replace("{ERROR_CODE}", String.valueOf(maxError.getCode())).replace("{ERROR_MESSAGE}", StringUtils.encodeUriString(maxError.getMessage())).replace("{THIRD_PARTY_SDK_ERROR_CODE}", String.valueOf(mediatedNetworkErrorCode)).replace("{THIRD_PARTY_SDK_ERROR_MESSAGE}", StringUtils.encodeUriString(mediatedNetworkErrorMessage));
    }
}
