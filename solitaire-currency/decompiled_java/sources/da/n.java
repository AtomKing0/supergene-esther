package da;

import java.util.Arrays;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PrimitiveArraysSerializers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends l1<char[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private char[] f24598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24599b;

    public n(@NotNull char[] bufferWithData) {
        kotlin.jvm.internal.t.i(bufferWithData, "bufferWithData");
        this.f24598a = bufferWithData;
        this.f24599b = bufferWithData.length;
        b(10);
    }

    @Override // da.l1
    public void b(int i10) {
        char[] cArr = this.f24598a;
        if (cArr.length < i10) {
            char[] cArrCopyOf = Arrays.copyOf(cArr, n9.o.e(i10, cArr.length * 2));
            kotlin.jvm.internal.t.h(cArrCopyOf, "copyOf(this, newSize)");
            this.f24598a = cArrCopyOf;
        }
    }

    @Override // da.l1
    public int d() {
        return this.f24599b;
    }

    public final void e(char c10) {
        l1.c(this, 0, 1, null);
        char[] cArr = this.f24598a;
        int iD = d();
        this.f24599b = iD + 1;
        cArr[iD] = c10;
    }

    @Override // da.l1
    @NotNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public char[] a() {
        char[] cArrCopyOf = Arrays.copyOf(this.f24598a, d());
        kotlin.jvm.internal.t.h(cArrCopyOf, "copyOf(this, newSize)");
        return cArrCopyOf;
    }
}
