package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Job.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class q2 implements g1, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final q2 f29976a = new q2();

    private q2() {
    }

    @Override // kotlinx.coroutines.u
    public boolean a(@NotNull Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.u
    @Nullable
    public b2 getParent() {
        return null;
    }

    @NotNull
    public String toString() {
        return "NonDisposableHandle";
    }

    @Override // kotlinx.coroutines.g1
    public void dispose() {
    }
}
