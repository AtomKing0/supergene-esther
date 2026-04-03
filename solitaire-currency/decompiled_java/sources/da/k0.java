package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k0 extends l1<int[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private int[] f24591a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24592b;

    public k0(@NotNull int[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24591a = bufferWithData;
        this.f24592b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        int[] iArr = this.f24591a;
        if (iArr.length < i10) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, n9.o.e(i10, iArr.length * 2));
            kotlin.jvm.internal.t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.f24591a = iArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24592b;
    }

    public final void e(int i10) {
        l1.c(this, 0, 1, null);
        int[] iArr = this.f24591a;
        int iD = d();
        this.f24592b = iD + 1;
        iArr[iD] = i10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int[] a() {
        int[] iArrCopyOf = Arrays.copyOf(this.f24591a, d());
        kotlin.jvm.internal.t.h(iArrCopyOf, "copyOf(this, newSize)");
        return iArrCopyOf;
    }
}
