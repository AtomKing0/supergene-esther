package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends l1<double[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private double[] f24633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24634b;

    public v(@NotNull double[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24633a = bufferWithData;
        this.f24634b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        double[] dArr = this.f24633a;
        if (dArr.length < i10) {
            double[] dArrCopyOf = Arrays.copyOf(dArr, n9.o.e(i10, dArr.length * 2));
            kotlin.jvm.internal.t.h(dArrCopyOf, "copyOf(this, newSize)");
            this.f24633a = dArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24634b;
    }

    public final void e(double d10) {
        l1.c(this, 0, 1, null);
        double[] dArr = this.f24633a;
        int iD = d();
        this.f24634b = iD + 1;
        dArr[iD] = d10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public double[] a() {
        double[] dArrCopyOf = Arrays.copyOf(this.f24633a, d());
        kotlin.jvm.internal.t.h(dArrCopyOf, "copyOf(this, newSize)");
        return dArrCopyOf;
    }
}
