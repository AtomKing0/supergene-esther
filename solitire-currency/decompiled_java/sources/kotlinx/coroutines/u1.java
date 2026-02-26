package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u1 implements v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final o2 f29986a;

    public u1(@NotNull o2 o2Var) {
        this.f29986a = o2Var;
    }

    @Override // kotlinx.coroutines.v1
    @NotNull
    public o2 b() {
        return this.f29986a;
    }

    @Override // kotlinx.coroutines.v1
    public boolean isActive() {
        return false;
    }

    @NotNull
    public String toString() {
        return super.toString();
    }
}
