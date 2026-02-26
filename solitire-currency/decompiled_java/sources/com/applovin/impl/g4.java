package com.applovin.impl;

import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class g4 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f5257h = new Executor() { // from class: com.applovin.impl.n9
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            AppLovinSdkUtils.runOnUiThread(runnable);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Executor f5258i = new androidx.media3.exoplayer.dash.offline.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5260b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile Object f5264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile Object f5265g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f5259a = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f5261c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f5262d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile boolean f5263e = false;

    public interface a {
        void a(Object obj);
    }

    public interface b {
        void a(boolean z10, Object obj, Object obj2);
    }

    public g4(String str) {
        this.f5260b = str;
    }

    public String toString() {
        String str;
        if (!this.f5262d) {
            str = "Waiting";
        } else if (this.f5263e) {
            str = "Success -> " + this.f5264f;
        } else {
            str = "Failed -> " + this.f5265g;
        }
        return "Promise(" + b() + ": " + str + ")";
    }

    public static g4 a(String str, Object obj) {
        return new g4(str).b(obj);
    }

    public g4 b(Object obj) {
        a(true, obj, (Object) null);
        return this;
    }

    public boolean c() {
        return this.f5262d;
    }

    public boolean d() {
        return this.f5262d && !this.f5263e;
    }

    private Runnable c(final Executor executor, final b bVar) {
        return new Runnable() { // from class: com.applovin.impl.m9
            @Override // java.lang.Runnable
            public final void run() {
                this.f5895a.b(executor, bVar);
            }
        };
    }

    public g4 a(Object obj) {
        a(false, (Object) null, obj);
        return this;
    }

    public String b() {
        String str = this.f5260b;
        return str != null ? str : super.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Executor executor, final b bVar) {
        try {
            executor.execute(new Runnable() { // from class: com.applovin.impl.l9
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5825a.a(bVar);
                }
            });
        } catch (Throwable th) {
            a(th);
        }
    }

    public void a(Executor executor, final Runnable runnable) {
        a(executor, new b() { // from class: com.applovin.impl.o9
            @Override // com.applovin.impl.g4.b
            public final void a(boolean z10, Object obj, Object obj2) {
                g4.a(runnable, z10, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(Runnable runnable, boolean z10, Object obj, Object obj2) {
        if (z10) {
            runnable.run();
        }
    }

    public void a(Executor executor, final a aVar) {
        a(executor, new b() { // from class: com.applovin.impl.p9
            @Override // com.applovin.impl.g4.b
            public final void a(boolean z10, Object obj, Object obj2) {
                g4.a(aVar, z10, obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, boolean z10, Object obj, Object obj2) {
        if (z10) {
            return;
        }
        aVar.a(obj2);
    }

    public void a(Executor executor, b bVar) {
        Runnable runnableC = c(executor, bVar);
        synchronized (this.f5259a) {
            if (!this.f5262d) {
                this.f5261c.add(runnableC);
            } else {
                runnableC.run();
            }
        }
    }

    public Object a() {
        e1.a(d());
        return this.f5265g;
    }

    private void a(boolean z10, Object obj, Object obj2) {
        synchronized (this.f5259a) {
            if (this.f5262d) {
                return;
            }
            this.f5264f = obj;
            this.f5265g = obj2;
            this.f5263e = z10;
            this.f5262d = true;
            Iterator it = this.f5261c.iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.f5261c.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(b bVar) {
        try {
            bVar.a(this.f5263e, this.f5264f, this.f5265g);
        } catch (Throwable th) {
            a(th);
        }
    }

    private void a(Throwable th) {
        e1.a(th);
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        if (jVar != null) {
            jVar.A().a("Promise", "PromiseCallback: " + b(), th);
        }
    }
}
