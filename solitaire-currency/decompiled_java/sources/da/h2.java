package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class h2 extends l1<v8.i0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private short[] f24578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24579b;

    public /* synthetic */ h2(short[] sArr, kotlin.jvm.internal.k kVar) {
        this(sArr);
    }

    @Override // da.l1
    public /* bridge */ /* synthetic */ v8.i0 a() {
        return v8.i0.a(f());
    }

    @Override // da.l1
    public void b(int i10) {
        if (v8.i0.l(this.f24578a) < i10) {
            short[] sArr = this.f24578a;
            short[] sArrCopyOf = Arrays.copyOf(sArr, n9.o.e(i10, v8.i0.l(sArr) * 2));
            kotlin.jvm.internal.t.h(sArrCopyOf, "copyOf(this, newSize)");
            this.f24578a = v8.i0.e(sArrCopyOf);
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24579b;
    }

    public final void e(short s10) {
        l1.c(this, 0, 1, null);
        short[] sArr = this.f24578a;
        int iD = d();
        this.f24579b = iD + 1;
        v8.i0.p(sArr, iD, s10);
    }

    @NotNull
    public short[] f() {
        short[] sArrCopyOf = Arrays.copyOf(this.f24578a, d());
        kotlin.jvm.internal.t.h(sArrCopyOf, "copyOf(this, newSize)");
        return v8.i0.e(sArrCopyOf);
    }

    private h2(short[] sArr) {
        this.f24578a = sArr;
        this.f24579b = v8.i0.l(sArr);
        b(10);
    }
}
