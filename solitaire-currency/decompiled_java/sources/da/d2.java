package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d2 extends l1<v8.d0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private int[] f24561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24562b;

    public /* synthetic */ d2(int[] iArr, kotlin.jvm.internal.k kVar) {
        this(iArr);
    }

    @Override // da.l1
    public /* bridge */ /* synthetic */ v8.d0 a() {
        return v8.d0.a(f());
    }

    @Override // da.l1
    public void b(int i10) {
        if (v8.d0.l(this.f24561a) < i10) {
            int[] iArr = this.f24561a;
            int[] iArrCopyOf = Arrays.copyOf(iArr, n9.o.e(i10, v8.d0.l(iArr) * 2));
            kotlin.jvm.internal.t.h(iArrCopyOf, "copyOf(this, newSize)");
            this.f24561a = v8.d0.e(iArrCopyOf);
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24562b;
    }

    public final void e(int i10) {
        l1.c(this, 0, 1, null);
        int[] iArr = this.f24561a;
        int iD = d();
        this.f24562b = iD + 1;
        v8.d0.p(iArr, iD, i10);
    }

    @NotNull
    public int[] f() {
        int[] iArrCopyOf = Arrays.copyOf(this.f24561a, d());
        kotlin.jvm.internal.t.h(iArrCopyOf, "copyOf(this, newSize)");
        return v8.d0.e(iArrCopyOf);
    }

    private d2(int[] iArr) {
        this.f24561a = iArr;
        this.f24562b = v8.d0.l(iArr);
        b(10);
    }
}
