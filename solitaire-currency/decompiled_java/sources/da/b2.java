package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class b2 extends l1<v8.b0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private byte[] f24546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24547b;

    public /* synthetic */ b2(byte[] bArr, kotlin.jvm.internal.k kVar) {
        this(bArr);
    }

    @Override // da.l1
    public /* bridge */ /* synthetic */ v8.b0 a() {
        return v8.b0.a(f());
    }

    @Override // da.l1
    public void b(int i10) {
        if (v8.b0.l(this.f24546a) < i10) {
            byte[] bArr = this.f24546a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, n9.o.e(i10, v8.b0.l(bArr) * 2));
            kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, newSize)");
            this.f24546a = v8.b0.e(bArrCopyOf);
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24547b;
    }

    public final void e(byte b10) {
        l1.c(this, 0, 1, null);
        byte[] bArr = this.f24546a;
        int iD = d();
        this.f24547b = iD + 1;
        v8.b0.p(bArr, iD, b10);
    }

    @NotNull
    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f24546a, d());
        kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, newSize)");
        return v8.b0.e(bArrCopyOf);
    }

    private b2(byte[] bArr) {
        this.f24546a = bArr;
        this.f24547b = v8.b0.l(bArr);
        b(10);
    }
}
