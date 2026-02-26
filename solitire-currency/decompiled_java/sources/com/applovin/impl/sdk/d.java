package com.applovin.impl.sdk;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import com.applovin.impl.f6;
import com.applovin.impl.l4;
import com.applovin.impl.n4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.c;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.w4;
import com.applovin.impl.y1;
import com.applovin.sdk.AppLovinAdType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c f7013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f7014c = Collections.synchronizedList(new ArrayList());

    public interface a {
        void a(com.applovin.impl.sdk.ad.b bVar);
    }

    public d(j jVar) {
        this.f7012a = jVar;
        this.f7013b = new c(jVar);
    }

    private void e() {
        String str = (String) this.f7012a.i0().a(n4.A);
        if (str == null) {
            return;
        }
        JSONArray jsonArray = JsonUtils.toJsonArray(str, new JSONArray());
        for (int length = jsonArray.length() - 1; length >= 0; length--) {
            c.a aVarA = c.a.a(JsonUtils.getJSONObject(jsonArray, length, new JSONObject()), this.f7012a);
            if (aVarA != null) {
                if (a(aVarA)) {
                    long jC = aVarA.c() - SystemClock.elapsedRealtime();
                    this.f7012a.g().d(y1.F, CollectionUtils.map("details", "ttl = " + jC + "ms"));
                } else {
                    this.f7014c.add(0, aVarA);
                }
            }
        }
    }

    private void f() {
        this.f7012a.j0().a((w4) new f6(this.f7012a, "loadPersistedAdFilesQueueAndCleanupAsync", new Runnable() { // from class: com.applovin.impl.sdk.e0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7027a.c();
            }
        }), r5.b.OTHER);
    }

    private void h() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f7014c) {
            Iterator it = this.f7014c.iterator();
            while (it.hasNext()) {
                arrayList.add(((c.a) it.next()).a());
            }
        }
        this.f7012a.i0().b(n4.A, new JSONArray((Collection) arrayList).toString());
    }

    public void g() {
        this.f7012a.j0().a((w4) new f6(this.f7012a, "resetManagerState", new Runnable() { // from class: com.applovin.impl.sdk.g0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7065a.d();
            }
        }), r5.b.OTHER);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(c.a aVar) {
        if (aVar == null) {
            this.f7012a.I();
            if (n.a()) {
                this.f7012a.I().a("AdPersistenceManager", "Ad failed to persist");
                return;
            }
            return;
        }
        this.f7014c.add(aVar);
        if (((Boolean) this.f7012a.a(l4.R0)).booleanValue()) {
            h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f7012a.i0().b(n4.A);
        this.f7013b.a();
    }

    public void a(final com.applovin.impl.s sVar, final a aVar) {
        if (aVar == null) {
            this.f7012a.I();
            if (n.a()) {
                this.f7012a.I().b("AdPersistenceManager", "Persisted ad could not be retrieved: listener is null");
            }
            com.applovin.impl.e1.a("Persisted ad could not be retrieved: listener is null", new Object[0]);
            return;
        }
        if (sVar == null) {
            a(aVar, null, null, "Persisted ad could not be retrieved: adZone is null");
            return;
        }
        this.f7012a.g().a(y1.C, sVar, (AppLovinError) null);
        final c.a aVarA = a(sVar.g());
        this.f7013b.a(aVarA, new c.InterfaceC0173c() { // from class: com.applovin.impl.sdk.d0
            @Override // com.applovin.impl.sdk.c.InterfaceC0173c
            public final void a(com.applovin.impl.sdk.ad.b bVar, String str) {
                this.f7015a.a(aVar, aVarA, sVar, bVar, str);
            }
        });
    }

    public void b() {
        f();
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    private void d(c.a aVar) {
        if (aVar != null && this.f7014c.remove(aVar)) {
            this.f7013b.b(aVar);
        }
    }

    public void b(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        this.f7012a.g().a(y1.f7818z, bVar);
        this.f7013b.b(bVar, new c.b() { // from class: com.applovin.impl.sdk.f0
            @Override // com.applovin.impl.sdk.c.b
            public final void a(c.a aVar) {
                this.f7037a.c(aVar);
            }
        });
    }

    private boolean b(c.a aVar) {
        long jB = aVar.b();
        return (jB == 0 || jB == j.m()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        e();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, c.a aVar2, com.applovin.impl.s sVar, com.applovin.impl.sdk.ad.b bVar, String str) {
        if (bVar != null && !StringUtils.isValidString(str)) {
            a(aVar, bVar, aVar2);
        } else {
            a(aVar, aVar2, sVar, str);
        }
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        if (bVar == null) {
            return;
        }
        d(c.a.a(bVar));
    }

    private c.a a(AppLovinAdType appLovinAdType) {
        c.a aVar;
        synchronized (this.f7014c) {
            Iterator it = this.f7014c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    aVar = null;
                    break;
                }
                aVar = (c.a) it.next();
                if (aVar.f().equals(appLovinAdType) && !a(aVar) && b(aVar)) {
                    break;
                }
            }
            this.f7014c.remove(aVar);
        }
        return aVar;
    }

    private void a(a aVar, c.a aVar2, com.applovin.impl.s sVar, String str) {
        if (aVar == null) {
            return;
        }
        this.f7012a.I();
        if (n.a()) {
            this.f7012a.I().a("AdPersistenceManager", str);
        }
        aVar.a(null);
        this.f7013b.b(aVar2);
        this.f7012a.g().a(y1.E, sVar, new AppLovinError(-1, str));
    }

    private void a(a aVar, com.applovin.impl.sdk.ad.b bVar, c.a aVar2) {
        if (aVar == null) {
            return;
        }
        this.f7012a.I();
        if (n.a()) {
            this.f7012a.I().a("AdPersistenceManager", "Loading persisted ad");
        }
        aVar.a(bVar);
        this.f7013b.b(aVar2);
        this.f7012a.g().a(y1.D, bVar);
    }

    private boolean a(c.a aVar) {
        return SystemClock.elapsedRealtime() + ((Long) this.f7012a.a(l4.T0)).longValue() >= aVar.c();
    }

    private void a() {
        synchronized (this.f7014c) {
            this.f7013b.a(new ArrayList(this.f7014c));
        }
    }
}
