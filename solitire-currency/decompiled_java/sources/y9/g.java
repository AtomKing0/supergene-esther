package y9;

import java.util.concurrent.atomic.AtomicReferenceArray;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes5.dex */
final class g extends e0<g> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f36933e;

    public g(long j10, @Nullable g gVar, int i10) {
        super(j10, gVar, i10);
        this.f36933e = new AtomicReferenceArray(f.f36932f);
    }

    @Override // u9.e0
    public int n() {
        return f.f36932f;
    }

    @Override // u9.e0
    public void o(int i10, @Nullable Throwable th, @NotNull z8.g gVar) {
        r().set(i10, f.f36931e);
        p();
    }

    @NotNull
    public final AtomicReferenceArray r() {
        return this.f36933e;
    }

    @NotNull
    public String toString() {
        return "SemaphoreSegment[id=" + this.f34654c + ", hashCode=" + hashCode() + ']';
    }
}
