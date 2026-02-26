package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f2 extends l1<v8.f0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private long[] f24568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24569b;

    public /* synthetic */ f2(long[] jArr, kotlin.jvm.internal.k kVar) {
        this(jArr);
    }

    @Override // da.l1
    public /* bridge */ /* synthetic */ v8.f0 a() {
        return v8.f0.a(f());
    }

    @Override // da.l1
    public void b(int i10) {
        if (v8.f0.l(this.f24568a) < i10) {
            long[] jArr = this.f24568a;
            long[] jArrCopyOf = Arrays.copyOf(jArr, n9.o.e(i10, v8.f0.l(jArr) * 2));
            kotlin.jvm.internal.t.h(jArrCopyOf, "copyOf(this, newSize)");
            this.f24568a = v8.f0.e(jArrCopyOf);
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24569b;
    }

    public final void e(long j10) {
        l1.c(this, 0, 1, null);
        long[] jArr = this.f24568a;
        int iD = d();
        this.f24569b = iD + 1;
        v8.f0.p(jArr, iD, j10);
    }

    @NotNull
    public long[] f() {
        long[] jArrCopyOf = Arrays.copyOf(this.f24568a, d());
        kotlin.jvm.internal.t.h(jArrCopyOf, "copyOf(this, newSize)");
        return v8.f0.e(jArrCopyOf);
    }

    private f2(long[] jArr) {
        this.f24568a = jArr;
        this.f24569b = v8.f0.l(jArr);
        b(10);
    }
}
