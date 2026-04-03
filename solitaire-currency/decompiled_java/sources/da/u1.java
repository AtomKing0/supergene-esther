package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u1 extends l1<short[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private short[] f24631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24632b;

    public u1(@NotNull short[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24631a = bufferWithData;
        this.f24632b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        short[] sArr = this.f24631a;
        if (sArr.length < i10) {
            short[] sArrCopyOf = Arrays.copyOf(sArr, n9.o.e(i10, sArr.length * 2));
            kotlin.jvm.internal.t.h(sArrCopyOf, "copyOf(this, newSize)");
            this.f24631a = sArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24632b;
    }

    public final void e(short s10) {
        l1.c(this, 0, 1, null);
        short[] sArr = this.f24631a;
        int iD = d();
        this.f24632b = iD + 1;
        sArr[iD] = s10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public short[] a() {
        short[] sArrCopyOf = Arrays.copyOf(this.f24631a, d());
        kotlin.jvm.internal.t.h(sArrCopyOf, "copyOf(this, newSize)");
        return sArrCopyOf;
    }
}
