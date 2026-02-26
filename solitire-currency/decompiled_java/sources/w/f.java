package w;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RealSizeResolver.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f35267a;

    public f(@NotNull i iVar) {
        this.f35267a = iVar;
    }

    @Override // w.j
    @Nullable
    public Object a(@NotNull z8.d<? super i> dVar) {
        return this.f35267a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && t.d(this.f35267a, ((f) obj).f35267a);
    }

    public int hashCode() {
        return this.f35267a.hashCode();
    }
}
