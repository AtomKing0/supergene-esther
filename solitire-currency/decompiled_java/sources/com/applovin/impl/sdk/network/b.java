package com.applovin.impl.sdk.network;

import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.applovin.impl.f6;
import com.applovin.impl.l2;
import com.applovin.impl.l4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import com.applovin.impl.sdk.j;
import com.applovin.impl.sdk.n;
import com.applovin.impl.w4;
import com.applovin.impl.z6;
import com.applovin.sdk.AppLovinPostbackListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final n f7267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f7268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f7269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f7270e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f7271f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Set f7272g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final List f7273h;

    class a implements AppLovinPostbackListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f7274a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinPostbackListener f7275b;

        a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
            this.f7274a = dVar;
            this.f7275b = appLovinPostbackListener;
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackFailure(String str, int i10) {
            n unused = b.this.f7267b;
            if (n.a()) {
                b.this.f7267b.d("PersistentPostbackManager", "Failed to submit postback: " + this.f7274a + " with error code: " + i10 + "; will retry later...");
            }
            b.this.d(this.f7274a);
            l2.a(this.f7275b, str, i10);
            if (this.f7274a.c() == 1) {
                b.this.f7266a.A().a("dispatchPostback", str, i10, (String) null);
            }
        }

        @Override // com.applovin.sdk.AppLovinPostbackListener
        public void onPostbackSuccess(String str) {
            b.this.a(this.f7274a);
            n unused = b.this.f7267b;
            if (n.a()) {
                b.this.f7267b.a("PersistentPostbackManager", "Successfully submit postback: " + this.f7274a);
            }
            b.this.c();
            l2.a(this.f7275b, str);
        }
    }

    public b(j jVar) {
        ArrayList arrayList = new ArrayList();
        this.f7271f = arrayList;
        this.f7272g = new HashSet();
        this.f7273h = new ArrayList();
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f7266a = jVar;
        this.f7267b = jVar.I();
        int iIntValue = ((Integer) jVar.a(l4.f5774x2)).intValue();
        this.f7268c = iIntValue;
        if (!((Boolean) jVar.a(l4.A2)).booleanValue()) {
            this.f7269d = null;
            return;
        }
        c cVar = new c(this, jVar);
        this.f7269d = cVar;
        arrayList.addAll(cVar.a(iIntValue));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
    }

    public void e(d dVar) {
        a(dVar, true);
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        this.f7266a.j0().a((w4) this.f7269d, r5.b.OTHER);
    }

    private void c(d dVar) {
        synchronized (this.f7270e) {
            while (this.f7271f.size() > this.f7268c) {
                this.f7271f.remove(0);
            }
            this.f7271f.add(dVar);
        }
        if (n.a()) {
            this.f7267b.a("PersistentPostbackManager", "Enqueued postback: " + dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        synchronized (this.f7270e) {
            Iterator it = new ArrayList(this.f7271f).iterator();
            while (it.hasNext()) {
                b((d) it.next());
            }
        }
    }

    protected List d() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f7270e) {
            if (((Boolean) this.f7266a.a(l4.f5788z2)).booleanValue()) {
                arrayList.ensureCapacity(this.f7273h.size());
                arrayList.addAll(this.f7273h);
            } else {
                arrayList.ensureCapacity(this.f7271f.size());
                arrayList.addAll(this.f7271f);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        synchronized (this.f7270e) {
            c(dVar);
            a(dVar, appLovinPostbackListener);
        }
    }

    public void a(d dVar, boolean z10) {
        a(dVar, z10, (AppLovinPostbackListener) null);
    }

    public void a(final d dVar, boolean z10, final AppLovinPostbackListener appLovinPostbackListener) {
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f7267b.b("PersistentPostbackManager", "Requested a postback dispatch for empty URL; nothing to do...");
            }
        } else {
            if (z10) {
                dVar.a();
            }
            a(new Runnable() { // from class: com.applovin.impl.sdk.network.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7311a.b(dVar, appLovinPostbackListener);
                }
            }, z6.h(), dVar.m());
        }
    }

    public void b() {
        a(new Runnable() { // from class: com.applovin.impl.sdk.network.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f7314a.e();
            }
        }, true, false);
    }

    private void b(d dVar) {
        a(dVar, (AppLovinPostbackListener) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        synchronized (this.f7270e) {
            Iterator it = this.f7273h.iterator();
            while (it.hasNext()) {
                b((d) it.next());
            }
            this.f7273h.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(d dVar) {
        synchronized (this.f7270e) {
            this.f7272g.remove(dVar);
            this.f7273h.add(dVar);
        }
    }

    public void a() {
        synchronized (this.f7270e) {
            this.f7271f.clear();
            this.f7273h.clear();
        }
        this.f7266a.j0().a((w4) this.f7269d, r5.b.OTHER);
    }

    private void a(d dVar, AppLovinPostbackListener appLovinPostbackListener) {
        if (n.a()) {
            this.f7267b.a("PersistentPostbackManager", "Preparing to submit postback: " + dVar);
        }
        if (this.f7266a.x0() && !dVar.m()) {
            if (n.a()) {
                this.f7267b.a("PersistentPostbackManager", "Skipping postback dispatch because SDK is still initializing - postback will be dispatched afterwards");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(dVar.k())) {
            if (n.a()) {
                this.f7267b.b("PersistentPostbackManager", "Skipping empty postback dispatch...");
                return;
            }
            return;
        }
        synchronized (this.f7270e) {
            if (this.f7272g.contains(dVar)) {
                if (n.a()) {
                    this.f7267b.a("PersistentPostbackManager", "Skipping in progress postback: " + dVar.k());
                }
                return;
            }
            dVar.l();
            Integer num = (Integer) this.f7266a.a(l4.f5767w2);
            if (dVar.c() > num.intValue()) {
                if (n.a()) {
                    this.f7267b.k("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + num + ". Dequeuing postback: " + dVar);
                }
                a(dVar);
                return;
            }
            synchronized (this.f7270e) {
                this.f7272g.add(dVar);
            }
            e eVarB = e.b(this.f7266a).b(dVar.k()).a(dVar.d()).b(dVar.i()).c(dVar.h()).a(dVar.g()).a(dVar.j() != null ? new JSONObject(dVar.j()) : null).b(dVar.o()).a(dVar.n()).a(dVar.f()).h(dVar.p()).e(dVar.e()).a();
            if (n.a()) {
                this.f7267b.a("PersistentPostbackManager", "Submitting postback: " + dVar);
            }
            this.f7266a.Y().dispatchPostbackRequest(eVarB, new a(dVar, appLovinPostbackListener));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar) {
        synchronized (this.f7270e) {
            this.f7272g.remove(dVar);
            this.f7271f.remove(dVar);
        }
        if (n.a()) {
            this.f7267b.a("PersistentPostbackManager", "Dequeued postback: " + dVar);
        }
    }

    private void a(Runnable runnable, boolean z10, boolean z11) {
        if (z10) {
            this.f7266a.j0().a((w4) new f6(this.f7266a, z11, "runPostbackTask", runnable), r5.b.OTHER);
        } else {
            runnable.run();
        }
    }
}
