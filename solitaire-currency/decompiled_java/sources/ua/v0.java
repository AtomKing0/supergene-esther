package ua;

import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final v0 f34833a = new v0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f34834b = 65536;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final u0 f34835c = new u0(new byte[0], 0, 0, false, false);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f34836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReference<u0>[] f34837e;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f34836d = iHighestOneBit;
        AtomicReference<u0>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i10 = 0; i10 < iHighestOneBit; i10++) {
            atomicReferenceArr[i10] = new AtomicReference<>();
        }
        f34837e = atomicReferenceArr;
    }

    private v0() {
    }

    private final AtomicReference<u0> a() {
        return f34837e[(int) (Thread.currentThread().getId() & (((long) f34836d) - 1))];
    }

    public static final void b(@NotNull u0 segment) {
        AtomicReference<u0> atomicReferenceA;
        u0 u0Var;
        kotlin.jvm.internal.t.i(segment, "segment");
        if (!(segment.f34831f == null && segment.f34832g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.f34829d || (u0Var = (atomicReferenceA = f34833a.a()).get()) == f34835c) {
            return;
        }
        int i10 = u0Var != null ? u0Var.f34828c : 0;
        if (i10 >= f34834b) {
            return;
        }
        segment.f34831f = u0Var;
        segment.f34827b = 0;
        segment.f34828c = i10 + 8192;
        if (androidx.compose.animation.core.d.a(atomicReferenceA, u0Var, segment)) {
            return;
        }
        segment.f34831f = null;
    }

    @NotNull
    public static final u0 c() {
        AtomicReference<u0> atomicReferenceA = f34833a.a();
        u0 u0Var = f34835c;
        u0 andSet = atomicReferenceA.getAndSet(u0Var);
        if (andSet == u0Var) {
            return new u0();
        }
        if (andSet == null) {
            atomicReferenceA.set(null);
            return new u0();
        }
        atomicReferenceA.set(andSet.f34831f);
        andSet.f34831f = null;
        andSet.f34828c = 0;
        return andSet;
    }
}
