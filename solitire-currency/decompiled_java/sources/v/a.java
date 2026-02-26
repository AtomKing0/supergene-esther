package v;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Lifecycle f34841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b2 f34842b;

    public a(@NotNull Lifecycle lifecycle, @NotNull b2 b2Var) {
        super(null);
        this.f34841a = lifecycle;
        this.f34842b = b2Var;
    }

    @Override // v.p
    public void b() {
        this.f34841a.removeObserver(this);
    }

    @Override // v.p
    public void c() {
        this.f34841a.addObserver(this);
    }

    public void d() {
        b2.a.a(this.f34842b, null, 1, null);
    }

    @Override // v.p, androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(@NotNull LifecycleOwner lifecycleOwner) {
        d();
    }
}
