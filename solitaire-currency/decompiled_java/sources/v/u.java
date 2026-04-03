package v;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j.e f34975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i f34976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x.b<?> f34977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Lifecycle f34978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final b2 f34979e;

    public u(@NotNull j.e eVar, @NotNull i iVar, @NotNull x.b<?> bVar, @NotNull Lifecycle lifecycle, @NotNull b2 b2Var) {
        super(null);
        this.f34975a = eVar;
        this.f34976b = iVar;
        this.f34977c = bVar;
        this.f34978d = lifecycle;
        this.f34979e = b2Var;
    }

    @Override // v.p
    public void a() {
        if (this.f34977c.getView().isAttachedToWindow()) {
            return;
        }
        a0.j.l(this.f34977c.getView()).c(this);
        throw new CancellationException("'ViewTarget.view' must be attached to a window.");
    }

    @Override // v.p
    public void c() {
        this.f34978d.addObserver(this);
        x.b<?> bVar = this.f34977c;
        if (bVar instanceof LifecycleObserver) {
            a0.g.b(this.f34978d, (LifecycleObserver) bVar);
        }
        a0.j.l(this.f34977c.getView()).c(this);
    }

    public void d() {
        b2.a.a(this.f34979e, null, 1, null);
        x.b<?> bVar = this.f34977c;
        if (bVar instanceof LifecycleObserver) {
            this.f34978d.removeObserver((LifecycleObserver) bVar);
        }
        this.f34978d.removeObserver(this);
    }

    @MainThread
    public final void e() {
        this.f34975a.c(this.f34976b);
    }

    @Override // v.p, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        a0.j.l(this.f34977c.getView()).a();
    }
}
