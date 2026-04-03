package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
final class j1 implements v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f29912a;

    public j1(boolean z10) {
        this.f29912a = z10;
    }

    @Override // kotlinx.coroutines.v1
    @Nullable
    public o2 b() {
        return null;
    }

    @Override // kotlinx.coroutines.v1
    public boolean isActive() {
        return this.f29912a;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
