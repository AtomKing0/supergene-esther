package a0;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import u.e;
import v8.k0;

/* JADX INFO: compiled from: SystemCallbacks.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class t implements ComponentCallbacks2, e.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public static final a f63f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f64a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final WeakReference<j.h> f65b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final u.e f66c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f67d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f68e;

    /* JADX INFO: compiled from: SystemCallbacks.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public t(@NotNull j.h hVar, @NotNull Context context, boolean z10) {
        u.e cVar;
        this.f64a = context;
        this.f65b = new WeakReference<>(hVar);
        if (z10) {
            hVar.h();
            cVar = u.f.a(context, this, null);
        } else {
            cVar = new u.c();
        }
        this.f66c = cVar;
        this.f67d = cVar.a();
        this.f68e = new AtomicBoolean(false);
    }

    @Override // u.e.a
    public void a(boolean z10) {
        k0 k0Var;
        j.h hVar = this.f65b.get();
        if (hVar != null) {
            hVar.h();
            this.f67d = z10;
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            d();
        }
    }

    public final boolean b() {
        return this.f67d;
    }

    public final void c() {
        this.f64a.registerComponentCallbacks(this);
    }

    public final void d() {
        if (this.f68e.getAndSet(true)) {
            return;
        }
        this.f64a.unregisterComponentCallbacks(this);
        this.f66c.shutdown();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration configuration) {
        if (this.f65b.get() == null) {
            d();
            k0 k0Var = k0.f35197a;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        k0 k0Var;
        j.h hVar = this.f65b.get();
        if (hVar != null) {
            hVar.h();
            hVar.l(i10);
            k0Var = k0.f35197a;
        } else {
            k0Var = null;
        }
        if (k0Var == null) {
            d();
        }
    }
}
