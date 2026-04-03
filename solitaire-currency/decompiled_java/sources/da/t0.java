package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t0 extends l1<long[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private long[] f24625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24626b;

    public t0(@NotNull long[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24625a = bufferWithData;
        this.f24626b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        long[] jArr = this.f24625a;
        if (jArr.length < i10) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, n9.o.e(i10, jArr.length * 2));
            kotlin.jvm.internal.t.h(jArrCopyOf, "copyOf(this, newSize)");
            this.f24625a = jArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24626b;
    }

    public final void e(long j10) {
        l1.c(this, 0, 1, null);
        long[] jArr = this.f24625a;
        int iD = d();
        this.f24626b = iD + 1;
        jArr[iD] = j10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public long[] a() {
        long[] jArrCopyOf = Arrays.copyOf(this.f24625a, d());
        kotlin.jvm.internal.t.h(jArrCopyOf, "copyOf(this, newSize)");
        return jArrCopyOf;
    }
}
