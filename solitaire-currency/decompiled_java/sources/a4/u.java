package a4;

import java.util.Arrays;

/* JADX INFO: compiled from: LongArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f250b;

    public u() {
        this(32);
    }

    public void a(long j10) {
        int i10 = this.f249a;
        long[] jArr = this.f250b;
        if (i10 == jArr.length) {
            this.f250b = Arrays.copyOf(jArr, i10 * 2);
        }
        long[] jArr2 = this.f250b;
        int i11 = this.f249a;
        this.f249a = i11 + 1;
        jArr2[i11] = j10;
    }

    public long b(int i10) {
        if (i10 >= 0 && i10 < this.f249a) {
            return this.f250b[i10];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i10 + ", size is " + this.f249a);
    }

    public int c() {
        return this.f249a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f250b, this.f249a);
    }

    public u(int i10) {
        this.f250b = new long[i10];
    }
}
