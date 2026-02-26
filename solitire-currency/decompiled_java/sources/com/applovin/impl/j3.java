package com.applovin.impl;

import com.applovin.impl.h3;
import com.applovin.impl.i3;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class j3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap f5471b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap f5472c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap f5473d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f5474a;

    public j3(com.applovin.impl.sdk.j jVar) {
        this.f5474a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l10, Long l11) {
        return l10;
    }

    private void b(h3 h3Var, i3 i3Var, h3.a aVar) {
        HashMap map;
        if (a(h3Var, i3Var, aVar)) {
            String strB = i3Var.b();
            HashMap mapA = a(i3Var.a());
            synchronized (mapA) {
                if (mapA.containsKey(strB)) {
                    map = (HashMap) mapA.get(strB);
                } else {
                    HashMap map2 = new HashMap();
                    mapA.put(strB, map2);
                    map = map2;
                }
                map.put(h3Var, aVar.a(map.get(h3Var)));
            }
        }
    }

    public void a(h3 h3Var, i3 i3Var) {
        b(h3Var, i3Var, new h3.a() { // from class: com.applovin.impl.ba
            @Override // com.applovin.impl.h3.a
            public final Object a(Object obj) {
                return j3.a((Long) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l10) {
        return Long.valueOf(l10 != null ? 1 + l10.longValue() : 1L);
    }

    public void a(h3 h3Var, i3 i3Var, final Long l10) {
        b(h3Var, i3Var, new h3.a() { // from class: com.applovin.impl.ca
            @Override // com.applovin.impl.h3.a
            public final Object a(Object obj) {
                return j3.a(l10, (Long) obj);
            }
        });
    }

    public Map a(h3 h3Var, i3.a aVar) {
        HashMap mapA = a(aVar);
        HashMap map = new HashMap();
        synchronized (mapA) {
            for (String str : mapA.keySet()) {
                map.put(str, ((HashMap) mapA.get(str)).get(h3Var));
            }
        }
        return map;
    }

    private HashMap a(i3.a aVar) {
        if (aVar == i3.a.AD_UNIT_ID) {
            return f5471b;
        }
        if (aVar == i3.a.AD_FORMAT) {
            return f5472c;
        }
        return f5473d;
    }

    private boolean a(h3 h3Var, i3 i3Var, h3.a aVar) {
        if (h3Var == null) {
            this.f5474a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5474a.I().b("MediationStatsManager", "Failed to update stat, no stat provided");
            }
            return false;
        }
        if (i3Var == null) {
            this.f5474a.I();
            if (com.applovin.impl.sdk.n.a()) {
                this.f5474a.I().b("MediationStatsManager", "Failed to update stat, no dimension key provided");
            }
            return false;
        }
        if (aVar != null) {
            return true;
        }
        this.f5474a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5474a.I().b("MediationStatsManager", "Failed to update stat, no stat updater provided");
        }
        return false;
    }
}
