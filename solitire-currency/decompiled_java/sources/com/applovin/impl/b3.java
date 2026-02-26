package com.applovin.impl;

import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b3 extends n0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f4900e = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters", "ad_unit_signal_providers"};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f4901f = {"ads", "settings", "signal_providers", "ad_unit_signal_providers"};

    public static String a(com.applovin.impl.sdk.j jVar) {
        return n0.a((String) jVar.a(g3.f5253y6), "1.0/mediate", jVar);
    }

    public static String b(com.applovin.impl.sdk.j jVar) {
        return n0.a((String) jVar.a(g3.f5251x6), "1.0/mediate", jVar);
    }

    public static void d(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers")) {
            d5.a(jSONObject, jVar);
        }
    }

    public static void e(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (jSONObject.length() == 0) {
            return;
        }
        if (!JsonUtils.valueExists(jSONObject, "auto_init_adapters") && !JsonUtils.valueExists(jSONObject, "test_mode_auto_init_adapters")) {
            jVar.c(n4.C);
            return;
        }
        JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
        JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f4901f);
        jVar.b(n4.C, jSONObjectShallowCopy.toString());
    }

    public static void f(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "signal_providers")) {
            JSONObject jSONObjectShallowCopy = JsonUtils.shallowCopy(jSONObject);
            JsonUtils.removeObjectsForKeys(jSONObjectShallowCopy, f4900e);
            jVar.b(n4.B, jSONObjectShallowCopy.toString());
            d5.a(jSONObjectShallowCopy);
        }
    }

    public static void g(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        if (JsonUtils.valueExists(jSONObject, "ad_unit_signal_providers") && JsonUtils.valueExists(jSONObject, "signal_providers")) {
            try {
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    hashSet.add(JsonUtils.getString(jSONArray.getJSONObject(i10), "name", null));
                }
                HashSet hashSet2 = new HashSet();
                JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "ad_unit_signal_providers", (JSONObject) null);
                Iterator it = JsonUtils.toList(jSONObject2.names()).iterator();
                while (it.hasNext()) {
                    hashSet2.addAll(JsonUtils.getList(jSONObject2, (String) it.next(), null));
                }
                if (hashSet.equals(hashSet2)) {
                    return;
                }
                Set differenceSet = CollectionUtils.getDifferenceSet(hashSet, hashSet2);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"signal_providers\" contains extra network(s): " + differenceSet);
                Set differenceSet2 = CollectionUtils.getDifferenceSet(hashSet2, hashSet);
                com.applovin.impl.sdk.n.h("MediationConnectionUtils", "\"ad_unit_signal_providers\" contains extra network(s): " + differenceSet2);
                jVar.A().a(y1.f7814w0, "signalProvidersMismatch", CollectionUtils.hashMap("details", "extraSignalProviderNetworks=" + differenceSet + ",extraAdUnitSignalProviderNetworks=" + differenceSet2));
                e1.a("Networks within \"signal_providers\" and \"ad_unit_signal_providers\" do not match.", new Object[0]);
            } catch (JSONException e10) {
                com.applovin.impl.sdk.n.c("MediationConnectionUtils", "Failed to parse JSON", e10);
                jVar.A().a("MediationConnectionUtils", "verifyBidderNetworksMatchFromJson", e10);
                e1.a((Throwable) e10, "Failed to parse JSON in verifyBidderNetworksMatchFromJson", new Object[0]);
            }
        }
    }

    public static String h(com.applovin.impl.sdk.j jVar) {
        l4 l4Var = g3.E7;
        return n0.a((String) jVar.a(((Boolean) jVar.a(l4Var)).booleanValue() ? g3.D7 : g3.f5253y6), ((Boolean) jVar.a(l4Var)).booleanValue() ? "2.0/mediate_debug" : "1.0/mediate_debug", jVar);
    }

    public static String i(com.applovin.impl.sdk.j jVar) {
        l4 l4Var = g3.E7;
        return n0.a((String) jVar.a(((Boolean) jVar.a(l4Var)).booleanValue() ? g3.C7 : g3.f5251x6), ((Boolean) jVar.a(l4Var)).booleanValue() ? "2.0/mediate_debug" : "1.0/mediate_debug", jVar);
    }
}
