package com.applovin.impl.sdk;

import com.applovin.impl.l3;
import com.applovin.impl.l4;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class m {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a f7170j = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7171a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7173c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7176f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f7177g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicBoolean f7172b = new AtomicBoolean();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f7174d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f7175e = new AtomicBoolean();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map f7178h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Object f7179i = new Object();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f7180a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f7181b;

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public long b() {
            return this.f7180a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.a((Object) this) && b() == aVar.b() && a() == aVar.a();
        }

        public int hashCode() {
            long jB = b();
            return ((((int) (jB ^ (jB >>> 32))) + 59) * 59) + a();
        }

        public String toString() {
            return "FullScreenAdTracker.LostShowAttemptsData(lastAttemptedTimeMillis=" + b() + ", attemptCount=" + a() + ")";
        }

        static /* synthetic */ int a(a aVar) {
            int i10 = aVar.f7181b;
            aVar.f7181b = i10 + 1;
            return i10;
        }

        public int a() {
            return this.f7181b;
        }
    }

    m(j jVar) {
        this.f7171a = jVar;
    }

    public boolean c() {
        return this.f7172b.get();
    }

    public boolean d() {
        return this.f7175e.get();
    }

    public void a(boolean z10) {
        synchronized (this.f7174d) {
            this.f7175e.set(z10);
            if (z10) {
                this.f7176f = System.currentTimeMillis();
                this.f7171a.I();
                if (n.a()) {
                    this.f7171a.I().a("FullScreenAdTracker", "Setting fullscreen ad pending display: " + this.f7176f);
                }
                final Long l10 = (Long) this.f7171a.a(l4.A1);
                if (l10.longValue() >= 0) {
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.c1
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f7010a.a(l10);
                        }
                    }, l10.longValue());
                }
            } else {
                this.f7176f = 0L;
                this.f7171a.I();
                if (n.a()) {
                    this.f7171a.I().a("FullScreenAdTracker", "Setting fullscreen ad not pending display: " + System.currentTimeMillis());
                }
            }
        }
    }

    public long b() {
        return this.f7173c;
    }

    public void c(String str) {
        synchronized (this.f7179i) {
            a aVar = (a) this.f7178h.get(str);
            if (aVar == null) {
                aVar = new a();
                this.f7178h.put(str, aVar);
            }
            aVar.f7180a = System.currentTimeMillis();
            a.a(aVar);
        }
    }

    public void b(Object obj) {
        if (!l3.a(obj) && this.f7172b.compareAndSet(true, false)) {
            this.f7177g = null;
            this.f7171a.I();
            if (n.a()) {
                this.f7171a.I().a("FullScreenAdTracker", "Setting fullscreen ad hidden: " + System.currentTimeMillis());
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_hidden", obj);
        }
    }

    public a b(String str) {
        a aVar;
        synchronized (this.f7179i) {
            aVar = (a) this.f7178h.get(str);
            if (aVar == null) {
                aVar = f7170j;
            }
        }
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l10) {
        if (d() && System.currentTimeMillis() - this.f7176f >= l10.longValue()) {
            this.f7171a.I();
            if (n.a()) {
                this.f7171a.I().a("FullScreenAdTracker", "Resetting \"pending display\" state...");
            }
            this.f7175e.set(false);
        }
    }

    public Object a() {
        return this.f7177g;
    }

    public void a(final Object obj) {
        if (!l3.a(obj) && this.f7172b.compareAndSet(false, true)) {
            this.f7177g = obj;
            this.f7173c = System.currentTimeMillis();
            this.f7171a.I();
            if (n.a()) {
                this.f7171a.I().a("FullScreenAdTracker", "Setting fullscreen ad displayed: " + this.f7173c);
            }
            AppLovinBroadcastManager.sendBroadcastWithAdObject("com.applovin.fullscreen_ad_displayed", obj);
            final Long l10 = (Long) this.f7171a.a(l4.B1);
            if (l10.longValue() >= 0) {
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.b1
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6997a.a(l10, obj);
                    }
                }, l10.longValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Long l10, Object obj) {
        if (this.f7172b.get() && System.currentTimeMillis() - this.f7173c >= l10.longValue()) {
            this.f7171a.I();
            if (n.a()) {
                this.f7171a.I().a("FullScreenAdTracker", "Resetting \"display\" state...");
            }
            b(obj);
        }
    }

    public void a(String str) {
        synchronized (this.f7179i) {
            this.f7178h.remove(str);
        }
    }
}
