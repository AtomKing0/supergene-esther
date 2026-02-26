package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends l1<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private byte[] f24580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24581b;

    public i(@NotNull byte[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24580a = bufferWithData;
        this.f24581b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        byte[] bArr = this.f24580a;
        if (bArr.length < i10) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, n9.o.e(i10, bArr.length * 2));
            kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, newSize)");
            this.f24580a = bArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24581b;
    }

    public final void e(byte b10) {
        l1.c(this, 0, 1, null);
        byte[] bArr = this.f24580a;
        int iD = d();
        this.f24581b = iD + 1;
        bArr[iD] = b10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f24580a, d());
        kotlin.jvm.internal.t.h(bArrCopyOf, "copyOf(this, newSize)");
        return bArrCopyOf;
    }
}
