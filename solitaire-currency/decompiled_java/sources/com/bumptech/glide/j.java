package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h1.c;
import h1.n;
import h1.o;
import h1.q;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements ComponentCallbacks2, h1.i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final k1.f f8225m = k1.f.h0(Bitmap.class).L();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final k1.f f8226n = k1.f.h0(f1.c.class).L();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final k1.f f8227o = k1.f.j0(u0.j.f34323c).S(f.LOW).a0(true);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.bumptech.glide.b f8228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final Context f8229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h1.h f8230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy("this")
    private final o f8231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy("this")
    private final n f8232e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy("this")
    private final q f8233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Runnable f8234g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Handler f8235h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final h1.c f8236i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList<k1.e<Object>> f8237j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy("this")
    private k1.f f8238k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8239l;

    /* JADX INFO: compiled from: RequestManager.java */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j jVar = j.this;
            jVar.f8230c.b(jVar);
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        private final o f8241a;

        b(@NonNull o oVar) {
            this.f8241a = oVar;
        }

        @Override // h1.c.a
        public void a(boolean z10) {
            if (z10) {
                synchronized (j.this) {
                    this.f8241a.e();
                }
            }
        }
    }

    public j(@NonNull com.bumptech.glide.b bVar, @NonNull h1.h hVar, @NonNull n nVar, @NonNull Context context) {
        this(bVar, hVar, nVar, new o(), bVar.g(), context);
    }

    private void x(@NonNull l1.h<?> hVar) {
        boolean zW = w(hVar);
        k1.c request = hVar.getRequest();
        if (zW || this.f8228a.p(hVar) || request == null) {
            return;
        }
        hVar.a(null);
        request.clear();
    }

    @NonNull
    @CheckResult
    public <ResourceType> i<ResourceType> h(@NonNull Class<ResourceType> cls) {
        return new i<>(this.f8228a, this, cls, this.f8229b);
    }

    @NonNull
    @CheckResult
    public i<Bitmap> i() {
        return h(Bitmap.class).b(f8225m);
    }

    @NonNull
    @CheckResult
    public i<Drawable> j() {
        return h(Drawable.class);
    }

    @NonNull
    @CheckResult
    public i<f1.c> k() {
        return h(f1.c.class).b(f8226n);
    }

    public void l(@Nullable l1.h<?> hVar) {
        if (hVar == null) {
            return;
        }
        x(hVar);
    }

    List<k1.e<Object>> m() {
        return this.f8237j;
    }

    synchronized k1.f n() {
        return this.f8238k;
    }

    @NonNull
    <T> k<?, T> o(Class<T> cls) {
        return this.f8228a.i().e(cls);
    }

    @Override // h1.i
    public synchronized void onDestroy() {
        this.f8233f.onDestroy();
        Iterator<l1.h<?>> it = this.f8233f.i().iterator();
        while (it.hasNext()) {
            l(it.next());
        }
        this.f8233f.h();
        this.f8231d.b();
        this.f8230c.a(this);
        this.f8230c.a(this.f8236i);
        this.f8235h.removeCallbacks(this.f8234g);
        this.f8228a.s(this);
    }

    @Override // h1.i
    public synchronized void onStart() {
        t();
        this.f8233f.onStart();
    }

    @Override // h1.i
    public synchronized void onStop() {
        s();
        this.f8233f.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        if (i10 == 60 && this.f8239l) {
            r();
        }
    }

    @NonNull
    @CheckResult
    public i<Drawable> p(@Nullable String str) {
        return j().x0(str);
    }

    public synchronized void q() {
        this.f8231d.c();
    }

    public synchronized void r() {
        q();
        Iterator<j> it = this.f8232e.a().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public synchronized void s() {
        this.f8231d.d();
    }

    public synchronized void t() {
        this.f8231d.f();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f8231d + ", treeNode=" + this.f8232e + "}";
    }

    protected synchronized void u(@NonNull k1.f fVar) {
        this.f8238k = fVar.d().c();
    }

    synchronized void v(@NonNull l1.h<?> hVar, @NonNull k1.c cVar) {
        this.f8233f.j(hVar);
        this.f8231d.g(cVar);
    }

    synchronized boolean w(@NonNull l1.h<?> hVar) {
        k1.c request = hVar.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.f8231d.a(request)) {
            return false;
        }
        this.f8233f.k(hVar);
        hVar.a(null);
        return true;
    }

    j(com.bumptech.glide.b bVar, h1.h hVar, n nVar, o oVar, h1.d dVar, Context context) {
        this.f8233f = new q();
        a aVar = new a();
        this.f8234g = aVar;
        Handler handler = new Handler(Looper.getMainLooper());
        this.f8235h = handler;
        this.f8228a = bVar;
        this.f8230c = hVar;
        this.f8232e = nVar;
        this.f8231d = oVar;
        this.f8229b = context;
        h1.c cVarA = dVar.a(context.getApplicationContext(), new b(oVar));
        this.f8236i = cVarA;
        if (o1.k.o()) {
            handler.post(aVar);
        } else {
            hVar.b(this);
        }
        hVar.b(cVarA);
        this.f8237j = new CopyOnWriteArrayList<>(bVar.i().c());
        u(bVar.i().d());
        bVar.o(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}
