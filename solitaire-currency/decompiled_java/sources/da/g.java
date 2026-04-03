package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends l1<boolean[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private boolean[] f24570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24571b;

    public g(@NotNull boolean[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24570a = bufferWithData;
        this.f24571b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        boolean[] zArr = this.f24570a;
        if (zArr.length < i10) {
            boolean[] zArrCopyOf = Arrays.copyOf(zArr, n9.o.e(i10, zArr.length * 2));
            kotlin.jvm.internal.t.h(zArrCopyOf, "copyOf(this, newSize)");
            this.f24570a = zArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24571b;
    }

    public final void e(boolean z10) {
        l1.c(this, 0, 1, null);
        boolean[] zArr = this.f24570a;
        int iD = d();
        this.f24571b = iD + 1;
        zArr[iD] = z10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean[] a() {
        boolean[] zArrCopyOf = Arrays.copyOf(this.f24570a, d());
        kotlin.jvm.internal.t.h(zArrCopyOf, "copyOf(this, newSize)");
        return zArrCopyOf;
    }
}
