package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SharedFlow.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f0 extends t9.d<d0<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f33683a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public z8.d<? super v8.k0> f33684b;

    @Override // t9.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NotNull d0<?> d0Var) {
        if (this.f33683a >= 0) {
            return false;
        }
        this.f33683a = d0Var.X();
        return true;
    }

    @Override // t9.d
    @NotNull
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public z8.d<v8.k0>[] b(@NotNull d0<?> d0Var) {
        long j10 = this.f33683a;
        this.f33683a = -1L;
        this.f33684b = null;
        return d0Var.W(j10);
    }
}
