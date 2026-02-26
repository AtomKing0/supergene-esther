package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.ij;
import com.ironsource.jj;
import com.ironsource.lifecycle.a;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class b implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final b f13025m = new b();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static AtomicBoolean f13026n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final long f13027o = 700;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f13028a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13029b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f13030c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f13031d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private jj f13032e = jj.NONE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<ij> f13033f = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f13034g = new Runnable() { // from class: com.ironsource.lifecycle.c
        @Override // java.lang.Runnable
        public final void run() {
            this.f13041a.f();
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Runnable f13035h = new Runnable() { // from class: com.ironsource.lifecycle.d
        @Override // java.lang.Runnable
        public final void run() {
            this.f13042a.g();
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Runnable f13036i = new Runnable() { // from class: com.ironsource.lifecycle.e
        @Override // java.lang.Runnable
        public final void run() {
            this.f13043a.h();
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Runnable f13037j = new Runnable() { // from class: com.ironsource.lifecycle.f
        @Override // java.lang.Runnable
        public final void run() {
            this.f13044a.i();
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Runnable f13038k = new Runnable() { // from class: com.ironsource.lifecycle.g
        @Override // java.lang.Runnable
        public final void run() {
            this.f13045a.j();
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final a.InterfaceC0258a f13039l = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        a();
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        Iterator<ij> it = this.f13033f.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        Iterator<ij> it = this.f13033f.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        Iterator<ij> it = this.f13033f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        Iterator<ij> it = this.f13033f.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        com.ironsource.lifecycle.a.b(activity);
        com.ironsource.lifecycle.a aVarA = com.ironsource.lifecycle.a.a(activity);
        if (aVarA != null) {
            aVarA.d(this.f13039l);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        d(activity);
    }

    private void a() {
        if (this.f13029b == 0) {
            this.f13030c = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f13035h);
            this.f13032e = jj.PAUSED;
        }
    }

    private void b() {
        if (this.f13028a == 0 && this.f13030c) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f13036i);
            this.f13031d = true;
            this.f13032e = jj.STOPPED;
        }
    }

    public static b d() {
        return f13025m;
    }

    public jj c() {
        return this.f13032e;
    }

    public boolean e() {
        return this.f13032e == jj.STOPPED;
    }

    void a(Activity activity) {
        int i10 = this.f13029b - 1;
        this.f13029b = i10;
        if (i10 == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.f13034g, 700L);
        }
    }

    void b(Activity activity) {
        int i10 = this.f13029b + 1;
        this.f13029b = i10;
        if (i10 == 1) {
            if (!this.f13030c) {
                IronSourceThreadManager.INSTANCE.removeUiThreadTask(this.f13034g);
                return;
            }
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f13037j);
            this.f13030c = false;
            this.f13032e = jj.RESUMED;
        }
    }

    void c(Activity activity) {
        int i10 = this.f13028a + 1;
        this.f13028a = i10;
        if (i10 == 1 && this.f13031d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.f13038k);
            this.f13031d = false;
            this.f13032e = jj.STARTED;
        }
    }

    void d(Activity activity) {
        this.f13028a--;
        b();
    }

    void a(Context context) {
        Application application;
        if (!f13026n.compareAndSet(false, true) || (application = (Application) context.getApplicationContext()) == null) {
            return;
        }
        application.registerActivityLifecycleCallbacks(this);
    }

    public void b(ij ijVar) {
        if (this.f13033f.contains(ijVar)) {
            this.f13033f.remove(ijVar);
        }
    }

    public void a(ij ijVar) {
        if (!IronsourceLifecycleProvider.a() || ijVar == null || this.f13033f.contains(ijVar)) {
            return;
        }
        this.f13033f.add(ijVar);
    }

    class a implements a.InterfaceC0258a {
        a() {
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0258a
        public void a(Activity activity) {
            b.this.c(activity);
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0258a
        public void onResume(Activity activity) {
            b.this.b(activity);
        }

        @Override // com.ironsource.lifecycle.a.InterfaceC0258a
        public void b(Activity activity) {
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
