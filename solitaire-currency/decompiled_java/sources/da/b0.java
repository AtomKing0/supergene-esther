package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 extends l1<float[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private float[] f24542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24543b;

    public b0(@NotNull float[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24542a = bufferWithData;
        this.f24543b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        float[] fArr = this.f24542a;
        if (fArr.length < i10) {
            float[] fArrCopyOf = Arrays.copyOf(fArr, n9.o.e(i10, fArr.length * 2));
            kotlin.jvm.internal.t.h(fArrCopyOf, "copyOf(this, newSize)");
            this.f24542a = fArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24543b;
    }

    public final void e(float f10) {
        l1.c(this, 0, 1, null);
        float[] fArr = this.f24542a;
        int iD = d();
        this.f24543b = iD + 1;
        fArr[iD] = f10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public float[] a() {
        float[] fArrCopyOf = Arrays.copyOf(this.f24542a, d());
        kotlin.jvm.internal.t.h(fArrCopyOf, "copyOf(this, newSize)");
        return fArrCopyOf;
    }
}
