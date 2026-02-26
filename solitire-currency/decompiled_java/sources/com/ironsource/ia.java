package com.ironsource;

import android.text.TextUtils;
import com.ironsource.qf;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ia {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, ha> f12585a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, ha> f12586b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, ha> f12587c = new LinkedHashMap();

    private Map<String, ha> b(qf.e eVar) {
        if (eVar.name().equalsIgnoreCase(qf.e.RewardedVideo.name())) {
            return this.f12585a;
        }
        if (eVar.name().equalsIgnoreCase(qf.e.Interstitial.name())) {
            return this.f12586b;
        }
        if (eVar.name().equalsIgnoreCase(qf.e.Banner.name())) {
            return this.f12587c;
        }
        return null;
    }

    public ha a(qf.e eVar, mi miVar) {
        ha haVar = new ha(miVar);
        a(eVar, miVar.e(), haVar);
        return haVar;
    }

    public ha a(qf.e eVar, String str) {
        Map<String, ha> mapB;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null) {
            return null;
        }
        return mapB.get(str);
    }

    public void b(qf.e eVar, String str) {
        Map<String, ha> mapB;
        ha haVarRemove;
        if (TextUtils.isEmpty(str) || (mapB = b(eVar)) == null || (haVarRemove = mapB.remove(str)) == null) {
            return;
        }
        haVarRemove.a();
    }

    public ha a(qf.e eVar, String str, Map<String, String> map, an anVar) {
        ha haVar = new ha(str, str, map, anVar);
        a(eVar, str, haVar);
        return haVar;
    }

    public Collection<ha> a(qf.e eVar) {
        Map<String, ha> mapB = b(eVar);
        return mapB != null ? mapB.values() : new ArrayList();
    }

    private void a(qf.e eVar, String str, ha haVar) {
        Map<String, ha> mapB;
        if (TextUtils.isEmpty(str) || haVar == null || (mapB = b(eVar)) == null) {
            return;
        }
        mapB.put(str, haVar);
    }
}
